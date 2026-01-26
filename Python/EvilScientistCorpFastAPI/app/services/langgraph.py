# ----------------------------
# LANGGRAPH DEMO: Route to one of two vector collections
# ----------------------------

from typing import TypedDict, List, Dict, Any, Annotated

from langgraph.checkpoint.memory import MemorySaver
from langgraph.graph import StateGraph, END

from app.services.vectordb_service import search
from app.services.chain_service import llm  # <-- adjust to your file name

# ----------------------------
# 1) Define the shape of the STATE that flows through the graph
# ----------------------------
# Think of "state" like a container for global data. It tracks the "state" of things in the app
# Each node can read from it and add/update the fields on it.
class GraphState(TypedDict, total=False):
    # The user's question from the API request
    query: str

    # The routing decision we make ("items", "plans", or "chat")
    route: str

    # Retrieved documents/chunks from the vector DB (as dicts)
    docs: List[Dict[str, Any]]

    # The final answer produced by the LLM
    answer: str

    # A counter for the number of user interactions (just for demo purposes)
    interaction_count: int

    # This field stores conversation history with a reducer to keep it manageable
    # message_memory: Annotated[list]


# ----------------------------
# 2) Define NODES (each node is a simple function)
# ----------------------------
def route_node(state: GraphState) -> GraphState:
    """
    Decide which path to take:
    - "plans" -> search boss_plans collection
    - "items" -> search evil_items collection
    - "chat"  -> skip vector DB and just chat normally

    This is a VERY simple heuristic router based on keywords.
    It's good for a first demo because students can understand it immediately.
    """

    query = state["query"].lower()

    # TODO: For now, just some keyword matching to determine what process to invoke next
    # TODO: Try to get the LLM to decide the route instead of matching keywords!!!!!!!

    # If the question sounds like "internal plans / boss schemes"
    if any(word in query for word in ["plan", "plans", "scheme", "boss", "boss's", "operation"]):
        return {"route": "plans"}

    # If the question sounds like "products/items"
    if any(word in query for word in ["item", "items", "product", "recommend", "buy", "similar", "price"]):
        return {"route": "items"}

    # Otherwise just do normal chat
    return {"route": "chat"}


def retrieve_plans_node(state: GraphState) -> GraphState:
    """
    Retrieve relevant chunks from the 'boss_plans' vector collection.
    This node does NOT talk to the LLM.
    It just fetches context.
    """
    query = state["query"]
    results = search(query, k=5, collection="boss_plans")
    return {"docs": results}


def retrieve_items_node(state: GraphState) -> GraphState:
    """
    Retrieve relevant chunks from the 'evil_items' vector collection.
    """
    query = state["query"]
    results = search(query, k=5, collection="evil_items")
    return {"docs": results}


def answer_with_context_node(state: GraphState) -> GraphState:
    """
    Build a prompt that includes retrieved context, then ask the LLM to answer.
    This is the "RAG" step:
      Retrieval (vector DB) + Augmented prompt + Generation (LLM)
    """
    query = state["query"]
    docs = state.get("docs", [])

    # Turn docs into a single big "context" string the LLM can read.
    # Each entry has a little source tag so you can show citations.
    # context = "\n\n".join(
    #     f"[source={d.get('metadata', {}).get('source','?')} "
    #     f"chunk={d.get('metadata', {}).get('chunk_index','?')}] "
    #     f"{d.get('text','')}"
    #     for d in docs
    # )
    context = "\n\n".join(doc.get("text", "") for doc in docs)

    # Prompt rule: answer ONLY from context.
    # If missing, say you don't know.
    prompt = (
        "You are an internal assistant at the Evil Scientist Corp.\n"
        "You are fairly evil yourself."
        "Answer the user's question using ONLY the context below.\n"
        "If the answer is not contained in the context, say:\n"
        "\"I don't know based on the provided data.\"\n"
        "Be concise and feel free to insult the user.\n\n"
        f"Context:\n{context}\n\n"
        f"Question:\n{query}\n\n"
        "Answer:"
    )

    # Call the LLM, return the response
    response_text = llm.invoke(prompt)

    # Different LangChain wrappers return different shapes;
    # Chat models usually return an object with `.content`.
    # answer_text = resp.content if hasattr(resp, "content") else str(resp)

    return {"answer": response_text}


def general_chat_node(state: GraphState) -> GraphState:

    # Define the prompt
    prompt = (
        f"""You are an internal assistant at the Evil Scientist Corp.
        You are pretty evil yourself, but still helpful.
        You have context from the previous interaction: \n{state.get('answer', 'query')}
        Answer the User's Query to the best of your ability.
        User Query:\n{state.get('query','')}
        Answer: """
    )

    # Invoke the LLM and return the response (which adds it to state too)
    return {"answer":llm.invoke(prompt).content}


# ----------------------------
# 3) Build the GRAPH (connect nodes with edges)
# ----------------------------
"""
This is the "overall flow" of the application logic.
We initialize the graph with state, add the nodes with routing logic, 
then connect the nodes with edges. Finally, we compile and return the graph.
"""
def build_graph():

    # First, define the graph builder with our State defined at the top of the file
    builder = StateGraph(GraphState)

    # Register each node under a name
    builder.add_node("route", route_node)
    builder.add_node("retrieve_plans", retrieve_plans_node)
    builder.add_node("retrieve_items", retrieve_items_node)
    builder.add_node("answer", answer_with_context_node)
    builder.add_node("chat", general_chat_node)

    # The first node that runs
    builder.set_entry_point("route")

    # After "route" runs, choose the next node based on value in state["route"]
    builder.add_conditional_edges(
        "route",
        # This function returns the key we use to choose an edge
        # Spelling it out, it means: look at state["route"] to decide what path to take
        lambda state: state["route"],
        # How does it know "state"? Because we defined GraphState as the state type!

        # Map that key to the next node name
        {
            "plans": "retrieve_plans",
            "items": "retrieve_items",
            "chat": "chat",
        }
    )

    # After either retrieval node runs, go to the answer node
    builder.add_edge("retrieve_plans", "answer")
    builder.add_edge("retrieve_items", "answer")

    # After answer or chat, we are done
    builder.add_edge("answer", END)
    builder.add_edge("chat", END)

    # Finally, add a memory checkpointer to store interactions in memory
    checkpointer = MemorySaver()

    # NOTE: we'll hardcode the thread ID in the endpoint for demo simplicity.
        # This means every user's request will share the same memory. Maybe not great.

    # Compile creates the runnable graph object - now with the checkpointer
    return builder.compile(checkpointer=checkpointer)


# Create one graph instance (like a singleton)
graph = build_graph()
