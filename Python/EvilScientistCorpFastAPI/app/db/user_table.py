from sqlalchemy import Column, Integer, String

from app.db.db import Base

class UserTable(Base):
    __tablename__ = "users"  # Table name in the database
    __table_args__ = {"schema": "fastapi"} # Schema to create this table in

    id = Column(Integer, primary_key=True, index=True, autoincrement=True)
    username = Column(String, unique=True, nullable=False)
    password = Column(String, nullable=False)
    email = Column(String, unique=True, index=True, nullable=False)