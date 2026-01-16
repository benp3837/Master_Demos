from typing import List, Dict, Any

from langchain_chroma import Chroma
from langchain_ollama import OllamaEmbeddings
from langchain_core.documents import Document

PERSIST_DIR = "app/chroma_store"
COLLECTION = "evil_items"

_vectorstore: Chroma | None = None

# Initialize the vectorstore (Chroma) with an Ollama text embedding model
def init_vectorstore():
    global _vectorstore
    if _vectorstore is None:
        embeddings = OllamaEmbeddings(model="nomic-embed-text")
        _vectorstore = Chroma(
            collection_name=COLLECTION,
            persist_directory=PERSIST_DIR,
            embedding_function=embeddings,
        )

# Gets the vectorstore instance
def get_vectorstore() -> Chroma:
    return _vectorstore

# Ingests items into the vectorstore
def ingest_items(items: List[Dict[str, Any]]) -> int:
    vs = get_vectorstore()

    docs = [
        Document(page_content=i["text"], metadata=i.get("metadata", {}))
        for i in items
    ]
    ids = [i["id"] for i in items]

    vs.add_documents(docs, ids=ids)
    return len(items)

# Searches the vectorstore for similar items based on a query
def search(query: str, k: int = 3) -> List[Dict[str, Any]]:
    vs = get_vectorstore()
    results = vs.similarity_search(query, k=k)

    return [
        {
            "text": doc.page_content,
            "metadata": doc.metadata,
        }
        for doc in results
    ]
