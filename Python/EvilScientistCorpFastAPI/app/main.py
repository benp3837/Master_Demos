from fastapi import FastAPI, HTTPException
from starlette.requests import Request
from starlette.responses import JSONResponse

from app.routers import users, items, chat

# Set up FastAPI. We'll use this "app" variable to do FastAPI stuff below.
app = FastAPI()

# Custom exception handler for HTTPException
@app.exception_handler(HTTPException)
async def custom_http_exception_handler(request: Request, exception: HTTPException):
    return JSONResponse(
        status_code=exception.status_code, #Grab the status code
        content={"msg": exception.detail},  # Use "msg" instead of "detail"
    )

# What CORS origins are allowed to make requests to this API?
origins = [
    "http://localhost:3000", # You'd use post 3000 for a React app probably
]

# Import the routers here. Keeps main.py way cleaner than writing HTTP endpoints here :)
app.include_router(users.router)
app.include_router(items.router)
app.include_router(chat.router)

# Generic sample endpoint - just returns a message when a GET request is made to "/"
@app.get("/")
async def read_root():
    return {"message": "Hello, FastAPI!"}

# Go to /docs in your browser to see and call your endpoints from the browser!


# DB connection test
# @app.on_event("startup")
# async def test_db_connection():
#     try:
#         async with engine.begin() as conn:
#             print("Database connection successful!")
#             await conn.run_sync(Base.metadata.create_all)
#     except Exception as e:
#         print(f"Database connection failed: {e}")