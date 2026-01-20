from typing import Dict, Any, List

from fastapi import APIRouter
from pydantic import BaseModel

from app.services.chain_service import get_chain
from app.services.vectordb_service import ingest_items, search, ingest_boss_plans

router = APIRouter(
    prefix="/vectors",
    tags=["vectors"],
)

class IngestItem(BaseModel):
    id: str
    text: str
    metadata: Dict[str, Any] | None = None

class SearchRequest(BaseModel):
    query: str
    k: int = 3

class IngestTextRequest(BaseModel):
    text: str

chain = get_chain()

@router.post("/ingest-text")
def ingest_text(req: IngestTextRequest):
    count = ingest_boss_plans(req.text)
    return {"chunks_ingested": count}

@router.post("/ingest-json")
def ingest_json(items: List[IngestItem]):
    count = ingest_items([i.model_dump() for i in items])
    return {"inserted": count}

@router.post("/search-items")
def search_items(req: SearchRequest):
    return search(req.query, req.k)

# This chat-based endpoint takes queries about our boss's current plans
# And the LLM receives relevant documents from the vector DB to help it
@router.post("/search-boss-plans")
def search_boss_plans(req: SearchRequest):

    # Search the vector DB, specifically in the "boss_plans" collection
    results = search(req.query, req.k, "boss_plans")

    # Extract just the text content from the results
    # This is returned as a list of (Document, score) tuples
    # relevant_texts = [doc.page_content for doc, score in results]
    #
    # # Combine the relevant texts into a single string to send to the LLM
    # combined_relevant_text = "\n\n".join(relevant_texts)

    # Create a prompt that includes the relevant context
    prompt = (
        f"Based on the following information about my boss's plans:\n"
        f"{results}\n\n"
        f"Answer the following question:\n{req.query}"
    )

    # Invoke the chain with the constructed prompt
    return chain.invoke({"input": prompt})
