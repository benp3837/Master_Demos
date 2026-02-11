import boto3
from fastapi import APIRouter
from langchain_classic.chains.question_answering.map_reduce_prompt import messages
from pydantic import BaseModel

router = APIRouter(
    prefix="/bedrock",
    tags=["bedrock"],
)

# Just to get user input in the request body instead of a query param
# Yes, this could have been a model, but we're taking a shortcut :)
class ChatRequest(BaseModel):
    input: str

# Setting up the boto3 client for testing that Bedrock works in the GET request
testerClient = boto3.client("bedrock", region_name="us-east-1")

# Now we'll set up the main Bedrock client for use in the POST request
client = boto3.client("bedrock-runtime", region_name="us-east-1")

# Quick tester to make sure we can access bedrock
@router.get("/model-list")
async def get_model_list():
    response = testerClient.list_foundation_models()
    return "Model list: ", response

# I'm gonna do all the setup in thie endpoint,
# but we could definitely have a service that contains the function to call the LLM
@router.post("/")
async def chat(chat: ChatRequest):
    model_id = "amazon.nova-micro-v1:0"

    # Call the Bedrock API to generate a response
    response = client.converse(
        modelId=model_id,
        messages=[{
            "role": "user",
            "content": [{"text": chat.input}]
        }]
    )

    # Extract the generated text from the response
    # generated_text = response["output"]["message"]["content"][0]["text"]

    return {"response": response}


