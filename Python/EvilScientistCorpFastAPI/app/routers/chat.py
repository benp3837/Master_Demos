import csv
from typing import List

from fastapi import APIRouter, HTTPException, UploadFile
from langchain_classic.agents.structured_chat.output_parser import StructuredChatOutputParser
from langchain_classic.output_parsers import StructuredOutputParser, ResponseSchema
from langchain_community.document_loaders import TextLoader, PyPDFLoader
from langchain_core.output_parsers import CommaSeparatedListOutputParser, PydanticOutputParser
from pydantic import BaseModel

from app.models.item_model import ItemModel
from app.services.chain_service import get_chain, get_simple_sequential_chain, get_math_chain

router = APIRouter(
    prefix="/chat",
    tags=["chat"],
)

# Just to get user input in the request body instead of a query param
# Yes, this could have been a model, but we're taking a shortcut :)
class ChatRequest(BaseModel):
    input: str

# This will help us format lists of ItemModel objects
class ItemList(BaseModel):
    items: List[ItemModel]

# grab an instance of our chain from our service (clean + portable behavior!)
chain = get_chain()
simple_sequential_chain = get_simple_sequential_chain()
math_chain = get_math_chain()

@router.post("/")
async def general_chat(chat: ChatRequest):
    response = chain.invoke({"input": chat.input})
    return response

@router.get("/recs")
async def get_evil_item_recommendations(amount: int = 3):

    # Define the base prompt
    base_prompt = f"""
    Share {amount} of the most popular evil items on the market today.
    Format the item like this into a list of JSON called "items" so I can parse into pydantic
    id: conint(gt=0)
    item_name: constr(strip_whitespace=True, min_length=1, max_length=50)
    item_quantity: conint(ge=0)
    price: conint(gt=0)
    description: constr(strip_whitespace=True, max_length=200)
    Return ONLY valid JSON that matches this schema exactly.
    """

    # Pydantic has its own output parser! How convenient.
    parser = PydanticOutputParser(pydantic_object=ItemList)
    response = chain.invoke({"input": base_prompt})

    # Parse the response into our list of Pydantic ItemModel objects and return it
    parsed_output = parser.parse(response)
    return parsed_output.items

# This endpoint loads the evil_plans_from_boss.txt in the app directory
# and summarizes the evil plans using the LLM chain
@router.get("/plans")
async def load_and_summarize_evil_plans():
    try:
        # Load the text file using LangChain's TextLoader
        loader = TextLoader("app/files_to_load/evil_plans_from_boss.txt")
        documents = loader.load()

        # Extract the content of the document
        evil_plans_text = documents[0].page_content

        # Pass the content to the chain for summarization
        response = chain.invoke({"input": f"Concisely summarize the following evil plans from my boss in a concise manner:\n{evil_plans_text}"})
        return response
    except FileNotFoundError:
        raise HTTPException(status_code=404, detail="The evil plans file was not found.")
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"An error occurred: {str(e)}")

@router.post("/sales")
async def analyze_csv(chat: ChatRequest):
    try:
        # Load the CSV file
        with open("app/files_to_load/q1sales.csv", "r", encoding="utf-8") as file:
            reader = csv.DictReader(file)
            csv_text = ", ".join(reader.fieldnames) + "\n"  # Add headers
            csv_text += "\n".join([", ".join(row.values()) for row in reader]) # Add rows

        # A grounding prompt so the LLM doesn't hallucinate
        prompt = f"""
        You are analyzing sales data. Use the following data to answer the user's question.
        Only use the data provided below. If the answer cannot be determined from the data, respond with "I don't know."
        Data:
        {csv_text}
        Question:
        {chat.input}
        """

        response = chain.invoke({"input": prompt})
        return response
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"An error occurred: {str(e)}")

@router.post("/support")
async def customer_support_reply(chat: ChatRequest):
    response = simple_sequential_chain.invoke({"input": chat.input})
    return response.content

