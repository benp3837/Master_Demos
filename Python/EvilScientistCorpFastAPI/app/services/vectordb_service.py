from langchain_chroma import Chroma
from langchain_ollama import OllamaEmbeddings

embeddings = OllamaEmbeddings(model="nomic-embed-text")

vectorstore = Chroma(
    collection_name="evil_items",
    persist_directory="app/chroma_store",
    embedding_function=embeddings,
)

from langchain_core.documents import Document

docs = [
    Document(page_content="Invisibility Cloak: bends light to hide the wearer.", metadata={"category": "stealth"}),
    Document(page_content="Shrink Ray: reduces target size for easy transport.", metadata={"category": "weapons"}),
]

vectorstore.add_documents(docs, ids=["cloak-1", "shrink-1"])
vectorstore.persist()
