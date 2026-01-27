from fastapi import APIRouter
from pydantic import BaseModel

from app.services.agentic_langgraph_service import agentic_graph
from app.services.langgraph import graph

router = APIRouter(prefix="/langgraph", tags=["langgraph"])

class AskRequest(BaseModel):
    question: str

@router.post("/ask")
def ask(req: AskRequest):
    # We start the graph by giving it the initial state.
    # The only thing we MUST provide is the user's query (stored in State.query)
    result = graph.invoke(
        {"query": req.question},
        config={
            "configurable":{
                "thread_id":"hardcoded_thread_id" # hardcoded for simplicity
                # realistically, this could be a logged-in user's ID or session ID
            }
        }
    )

    # result now contains the accumulated state:
    # - route chosen
    # - docs (if retrieval happened)
    # - answer
    return {
        "route": result.get("route"),
        "answer": result.get("answer"),
        "sources": result.get("docs", []),  # optional, but great for teaching
        "message_memory": result.get("message_memory", [])  # optional, for transparency
    }


@router.post("/ask-agent")
def ask_agent(req: AskRequest):
    result = agentic_graph.invoke(
        {"query": req.question},
        config={
            "configurable":{
                "thread_id":"hardcoded_agent_thread_id"
            }
        }
    )

    return {
        "route": result.get("route"),
        "answer": result.get("answer"),
        "sources": result.get("docs", []),
        "message_memory": result.get("message_memory", [])
    }