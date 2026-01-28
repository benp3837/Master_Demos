from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from sqlalchemy import or_

from app.db.db import get_db
from app.models.user_db_model import User, UserRead, UserCreate
from app.models.user_model import UserModel
from app.services.chain_service import get_chain

router = APIRouter(prefix="/user_db", tags=["user-db"])

@router.post("", response_model=UserRead)
async def create_user(payload: UserCreate, db: Session = Depends(get_db)):
    # basic uniqueness checks
    # exists = db.query(User).filter(
    #     or_(User.username == payload.username, User.email == payload.email)
    # ).first()
    # if exists:
    #     raise HTTPException(status_code=409, detail="Username or email already exists")

    user = User(**payload.model_dump())
    db.add(user)
    db.commit()
    db.refresh(user)
    return user

@router.get("/", response_model=list[UserRead])
async def list_users(db: Session = Depends(get_db)):
    return db.query(User).order_by(User.id.desc()).all()

@router.get("/by_id/{user_id}", response_model=UserRead)
async def get_user(user_id: int, db: Session = Depends(get_db)):
    user = db.query(User).get(user_id)
    if not user:
        raise HTTPException(status_code=404, detail="User not found")
    return user

# Route that gets all users then lets you ask the LLM a question about them
@router.get("/chat")
async def users_chat(db: Session = Depends(get_db)):
    users = db.query(User).all()

    # get the usernames as a list
    usernames = [u.username for u in users]

    # Using our general chain from week 2 (just the quickest one to use)
    chain = get_chain()

    # invoke the chain with a prompt about the users
    response = chain.invoke({
        "input": f"""Here is a list of users: {usernames}. 
                 Comment on each user's username using ONLY the provided users.
                 Don't specify passwords, and don't make anything up."""
    })

    return {"response":response, "users": usernames}

# @router.put("/{user_id}", response_model=UserRead)
# def update_user(user_id: int, payload: UserCreate, db: Session = Depends(get_db)):
#     user = db.query(User).get(user_id)
#     if not user:
#         raise HTTPException(status_code=404, detail="User not found")
#
#     # optional: prevent updating into an existing username/email
#     clash = db.query(User).filter(
#         User.id != user_id,
#         or_(User.username == payload.username, User.email == payload.email)
#     ).first()
#     if clash:
#         raise HTTPException(status_code=409, detail="Username or email already exists")
#
#     for k, v in payload.model_dump().items():
#         setattr(user, k, v)
#
#     db.commit()
#     db.refresh(user)
#     return user
#
# @router.delete("/{user_id}")
# def delete_user(user_id: int, db: Session = Depends(get_db)):
#     user = db.query(User).get(user_id)
#     if not user:
#         raise HTTPException(status_code=404, detail="User not found")
#     db.delete(user)
#     db.commit()
#     return {"deleted": True, "id": user_id}
