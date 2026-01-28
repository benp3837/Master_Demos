from sqlalchemy import Column, Integer, String
from app.db.db import Base

from pydantic import BaseModel, Field, EmailStr

class User(Base):
    __tablename__ = "users"

    id = Column(Integer, primary_key=True, index=True)
    username = Column(String(50), unique=True, index=True, nullable=False)
    password = Column(String(128), nullable=False)
    email = Column(String(120), unique=True, index=True, nullable=False)

# ...and here are some Pydantic models that will help this play nice in our router

# User with no ID (good for inserts)
class UserCreate(BaseModel):
    username: str = Field(min_length=1, max_length=50)
    email: str = Field(..., max_length=120)
    password: str = Field(min_length=8, max_length=128)

# Subclass of UserCreate that adds an id field
class UserRead(UserCreate):
    id: int
