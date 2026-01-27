# ----------------------------
# LANGGRAPH DEMO: Route to one of two vector collections
# ----------------------------

from typing import TypedDict, List, Dict, Any, Annotated

from langchain_core.messages import BaseMessage, HumanMessage, AIMessage, SystemMessage
from langchain_core.tools import tool
from langchain_ollama import ChatOllama
from langgraph.checkpoint.memory import MemorySaver
from langgraph.graph import StateGraph, END, add_messages

from app.services.vectordb_service import search

llm = ChatOllama(
    model="llama3.2:3b",
    temperature=0.2
)

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
    message_memory: Annotated[list[BaseMessage], add_messages]


# TOOLS ================== (The agentic_router below will use one of these per user query)

""" Major differences from non-agentic service:
The @tool decorator - making these functions tools the agent can call
The args and return types - since the agent calls these, they don't use state directly 
IMPORTANT: tools need '''docstrings''' that describe what they do for the agent
"""
@tool
def retrieve_plans(query:str) -> list[dict[str, Any]]:
    """Retrieve relevant boss plans/schemes from the boss_plans collection."""
    return search(query, k=10, collection="boss_plans")

@tool
def retrieve_items(query:str) -> list[dict[str, Any]]:
    """Retrieve relevant evil items/products from the evil_items collection."""
    return search(query, k=5, collection="evil_items")

# List of available tools for the map below
TOOLS = [retrieve_items, retrieve_plans]

# Map tool names to tool functions... in a scalable way!
# We need this to call the tools by name in the agent router node
TOOL_MAP = {tool.name: tool for tool in TOOLS}

# Get a version of the LLM that is aware of its toolbox
llm_with_tools = llm.bind_tools(TOOLS)

# NODES=====================================================

# First, the AGENT that decides whether to get items, get plans, or just chat
def agent_router_node(state: GraphState) -> GraphState:

    query = state.get("query", "")

    # I just wanna try this prompt structure for chat models
    # Feel free to just use a simple string prompt like we've been doing
    messages = [
        SystemMessage(content=(
            "You are an internal assistant.\n"
            "Decide whether retrieval is needed.\n\n"
            "If the user is asking about internal boss plans/schemes/operations, call retrieve_plans_node.\n"
            "If the user is asking about products/items/recommendations/prices, call retrieve_items_node.\n"
            "If neither applies, it's a general chat. DO NOT call a tool.\n\n"
            "If you call a tool, call EXACTLY ONE tool.\n"
        )),
        HumanMessage(content=query),
    ]

    # First LLM call decides which tool to call
    agentic_response = llm_with_tools.invoke(messages)

    # if there was no tool call, route to general chat
    tool_calls = getattr(agentic_response, "tool_calls", None) or []
    if not tool_calls:
        return {"route": "chat"}

    # If a tool WAS called, invoke it and store results in state
    tool_call = tool_calls[0] # should be only one tool called
    tool_name = tool_call["name"] # should match one of TOOL_MAP's keys
    # tool_args = tool_call.get("args", {})  # get the args dict from the tool call

    # # Ollama wraps arguments in a {"value": ...} dict. Thanks. We need to unwrap it
    # query = tool_args.get("query", "")
    # if isinstance(query, dict) and "value" in query:
    #     tool_args["query"] = query["value"]

    # Finally, invoke the tool and get the results (evil items or boss plans)
    results = TOOL_MAP[tool_name].invoke({"query":query})

    # Automatically set the route to the answer_with_context node
    # ...and Store the retrieved docs in state
    return {
        "route": "answer",
        "docs": results,
    }

# This one stays the same :) just a regular node.
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

    return {"answer": response_text,
            "message_memory": [
                HumanMessage(content=state.get('query','')),
                AIMessage(content=response_text.content)]
            }

# This one also stays the same - general chat fallback node
def general_chat_node(state: GraphState) -> GraphState:

    # Define the prompt
    prompt = (
        f"""You are an internal assistant at the Evil Scientist Corp.
        You are pretty evil yourself, but still helpful.
        You have context from the previous interaction: \n{state.get('message_memory')}
        Answer the User's Query to the best of your ability.
        User Query:\n{state.get('query','')}
        Answer: """
    )

    # Storing the LLM response up here since we'll use it twice below
    answer_text = llm.invoke(prompt).content

    # NOTE: in our return, we'll give the LLM access to the message_memory stored in State

    # Invoke the LLM and return the response (which adds it to state too)
    return {"answer":answer_text,
            "message_memory": [
                HumanMessage(content=state.get('query','')),
                AIMessage(content=answer_text)]
            }

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
    builder.add_node("route", agent_router_node)
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

        # If the route is answer or chat, go to that respective node
        {
            "answer": "answer",
            "chat": "chat",
        }
    )

    # After answer or chat, we are done
    builder.add_edge("answer", END)
    builder.add_edge("chat", END)

    # Finally, add a memory checkpointer to store interactions in memory, and
    # Compile creates the runnable graph object - now with the checkpointer
    return builder.compile(checkpointer=MemorySaver())

    # NOTE: we'll hardcode the thread ID in the endpoint for demo simplicity.
    # This means every user's request will share the same memory. Maybe not great.

# Create one graph instance (like a singleton)
agentic_graph = build_graph()
