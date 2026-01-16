from typing import Dict, Any, List

from fastapi import APIRouter
from pydantic import BaseModel

from app.services.vectordb_service import ingest_items, search

router = APIRouter(
    prefix="/vectors",
    tags=["vectors"],
)

class IngestItem(BaseModel):
    id: str
    text: str
    metadata: Dict[str, Any] | None = None


@router.post("/ingest")
def ingest(items: List[IngestItem]):
    count = ingest_items([i.model_dump() for i in items])
    return {"inserted": count}


class SearchRequest(BaseModel):
    query: str
    k: int = 3


@router.post("/search")
def search_vectors(req: SearchRequest):
    return search(req.query, req.k)