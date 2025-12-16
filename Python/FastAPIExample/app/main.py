import fastapi.exceptions
from starlette.responses import JSONResponse

from fastapi import FastAPI, Request, HTTPException
from pydantic import BaseModel, constr


class User(BaseModel):
    username: str
    password: str
    #constr - a Pydantic type for strings with constraints. Slick way to add validation!
    #the "pattern" arg is a regex for basic email validation
    email: constr(strip_whitespace=True, min_length=5, pattern=r"^\S+@\S+\.\S+$")

app = FastAPI()

@app.get("/")
async def read_root():
    return "Hello, FastAPI!"

@app.get("/json")
async def read_root_json():
    print("test", flush=True)
    return {"message": "Hello, FastAPI!"}


@app.post("/")
async def send_post(data: str):
    # basic input validation - raise an HTTPException if data is blank
    if not data:
        raise HTTPException(status_code=400, detail="Input cannot be blank!")
    else:
        return {"message": f"Received string: {data}"}


@app.post("/user/")
async def create_user(user: User):

    # another example of input validation
    if not user.username:
        raise HTTPException(status_code=400, detail="Username cannot be blank!")
    else:
        return {"message": f"User {user.username} created successfully!!!"}

# Adding an EXCEPTION HANDLER, to customize and standardize our error responses
@app.exception_handler(HTTPException)
async def http_exception_handler(request: Request, exc: HTTPException):
    return JSONResponse(
        status_code=400,
        content={"message": f"Oops! {exc.detail} from {request.url}"},
    )