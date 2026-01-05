from fastapi import APIRouter, HTTPException, Depends

from app.models.user_model import UserModel

# Set this module up as a FastAPI "router". We'll import and call it in main.py.
router = APIRouter(
    prefix="/users", # HTTP requests to /users will be handled by this router
    tags=["users"], # This groups all /users endpoints in the /docs UI
)

# Fake in-memory "database" - just a Python dictionary
user_database = {}

@router.post("/", status_code=201)
async def create_user(user: UserModel):
    # Make sure username and email are unique
    for existing_user in user_database.values():
        if existing_user.username == user.username:
            raise HTTPException(status_code=409, detail="Username already exists")
        if existing_user.email == user.email:
            raise HTTPException(status_code=409, detail="Email already exists")
    # Give the user an ID (fake auto-increment)
    user.id = len(user_database) + 1
    # Store the user (fake DB) — IN REALITY you'd hash first
    user_database[user.id] = user
    return user

@router.get('/', status_code=200)
async def get_all_users():
    if not user_database:
        raise HTTPException(status_code=404, detail="No users found")
    else:
        return user_database

# update entire user (not ID though)
@router.put('/{username}', status_code=200)
async def update_user(username: str, updated_user: UserModel):
    for existing_user in user_database.values():
        if existing_user.username == username:
            # Update fields except ID
            existing_user.username = updated_user.username
            existing_user.password = updated_user.password
            existing_user.email = updated_user.email
            return existing_user
    else:
        raise HTTPException(status_code=404, detail="User not found")

@router.delete('/{username}', status_code=200)
async def delete_user(username: str):
    for existing_user in user_database.values():
        if existing_user.username == username:
            del user_database[existing_user.id]
            return {"msg": f"User {username} deleted!"}
        else:
            raise HTTPException(status_code=404, detail="User not found")
