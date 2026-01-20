import hashlib
from typing import List, Dict, Any

from langchain_chroma import Chroma
from langchain_ollama import OllamaEmbeddings
from langchain_core.documents import Document
from langchain_text_splitters import RecursiveCharacterTextSplitter

PERSIST_DIR = "app/chroma_store"
COLLECTION = "evil_items"
EMBEDDING = OllamaEmbeddings(model="nomic-embed-text")

# The vector stores dictionary will hold multiple Chroma instances
# This allows us to manage multiple collections
_vector_stores: dict[str, Chroma] = {}

# Initialize the vectorstore (Chroma) with an Ollama text embedding model
# def init_vectorstore():
#     global _vectorstore
#     if _vectorstore is None:
#         embeddings = OllamaEmbeddings(model="nomic-embed-text")
#         _vectorstore = Chroma(
#             collection_name=COLLECTION,
#             persist_directory=PERSIST_DIR,
#             embedding_function=embeddings,
#         )

# Gets the vectorstore instance.
# Takes in the collection name to use, or defaults to the COLLECTION constant "evil_items"
def get_vectorstore(collection:str = COLLECTION) -> Chroma:
    # Get (or create) the vectorstore instance
    # If creating, define the collection name, persist directory, and embedding function
    if collection not in _vector_stores:
        _vector_stores[collection] = Chroma(
            collection_name=collection,
            persist_directory=PERSIST_DIR,
            embedding_function=EMBEDDING
        )

    return _vector_stores[collection]

# Ingests items into the given vectorstore collection (or the default)
def ingest_items(items: List[Dict[str, Any]], collection:str = COLLECTION) -> int:
    vs = get_vectorstore(collection)

    docs = [
        Document(page_content=i["text"], metadata=i.get("metadata", {}))
        for i in items
    ]
    ids = [i["id"] for i in items]

    vs.add_documents(docs, ids=ids)
    return len(items)

# This function ingests raw text into the vectorstore collection
def ingest_boss_plans(text: str) -> int:

    # strip leading/trailing whitespace
    text = text.strip()
    if not text:
        return 0

    # Chunk the raw text - turn into smaller pieces for embedding
    # Using a LangChain Transformer (a text splitter)
    splitter = RecursiveCharacterTextSplitter(
        chunk_size=800, # max size of each chunk (this is about 2-3 paragraphs)
        chunk_overlap=150, # how much overlap between chunks (helps retain context)
        separators=["\n\n", "\n", " ", ""], # preferred split points
        # (double newline, newline, space, then any character)
    )

    # get our chunks as a list[str] so we can iterate over them
    chunks = splitter.split_text(text)

    # Convert chunks → list[dict], then ingest using ingest_items()
    items = []
    # what's enumerate? gives us a (index, value) pair when iterating
    for index, chunk in enumerate(chunks):
        chunk = chunk.strip()

        # Stable-ish ID so re-ingesting same content doesn't make duplicates
        # hashlib.md5 give us a consistent hash for the same input
        content_hash = hashlib.md5(chunk.encode("utf-8")).hexdigest()[:12]
        chunk_id = f"{"boss"}:{content_hash}"
        # This ^ will look like "boss:1a2b3c4d5e6f"

        items.append({
            "id": chunk_id,
            "text": chunk,
            "metadata": {
                "source": "boss",
                "chunk_index": index,
            }
        })

    # Finally, call ingest() - insert the boss's plan into a collection called "boss_plans"
    return ingest_items(items, collection="boss_plans")

# Searches the given vectorstore collection (or the default) for semantic matches
def search(query: str, k: int = 3, collection:str = COLLECTION) -> List[Dict[str, Any]]:
    vs = get_vectorstore(collection)
    results = vs.similarity_search(query, k=k)

    return [
        {
            "text": doc.page_content,
            "metadata": doc.metadata,
        }
        for doc in results
    ]
