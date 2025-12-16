# Defines a user, gets passed in and out of services

# Built off of Pydantic BaseModel for fastAPI compatibility (validation, serialization)
from pydantic import BaseModel

class User(BaseModel):
    username: str
    password: str
    email: str