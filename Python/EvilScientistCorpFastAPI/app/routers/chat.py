from fastapi import APIRouter
from pydantic import BaseModel

from app.services.chain_service import get_chain

router = APIRouter(
    prefix="/chat",
    tags=["chat"],
)

# Just to get user_input in the request body instead of a query param
class ChatRequest(BaseModel):
    user_input: str

# grab an instance of our chain from our service (clean + portable behavior!)
chain = get_chain()

@router.post("/")
async def general_chat(chat: ChatRequest):
    response = chain.invoke({"user_input": chat.user_input})
    return response

@router.get("/recs")
async def get_evil_item_recommendations():
    response = chain.invoke({"Share some of the most popular evil items on the market today."
                             "Format it like this:"
                             "Item Name: <name>"
                             "Description: <brief description>"
                             "Price: <price>"
                             "...and so on, for 3 items."
                             "Provide nothing else but the list of items"})
    return response