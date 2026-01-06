# Set this module up as a FastAPI "router". We'll import and call it in main.py.
from fastapi import APIRouter, HTTPException

from app.models.item_model import ItemModel

router = APIRouter(
    prefix="/items",
    tags=["items"],
)

# Fake in-memory "database" - just a Python dictionary. This time, pre-populated with items.
item_database = {
    1: ItemModel(
        id=1,
        item_name="Moon Vaporizer",
        item_quantity=10,
        price=500,
        description="Vaporizes moons"
    ),
    2: ItemModel(
        id=2,
        item_name="Embarrassing Moment Rememberizer",
        item_quantity=25,
        price=200,
        description="Reminds the victim of the incident"
    ),
    3: ItemModel(
        id=3,
        item_name="Evil Calculator",
        item_quantity=15,
        price=200,
        description="Lets you divide by zero"
    )
}

@router.get("/{item_name}")
async def get_item_by_name(item_name: str):

    # Kind of an inverted version of the validation we did in users.py create users
    for item in item_database.values():
        if item.item_name == item_name:
            return item
    else:
        raise HTTPException(status_code=404, detail="Item not found")

# method to update price
@router.patch("/{item_name}/price/{new_price}")
async def update_item_price(item_name: str, new_price: int):
    for item in item_database.values():
        if item.item_name == item_name:
            item.price = new_price
            return item
    else:
        raise HTTPException(status_code=404, detail="Item not found")

# method to subtract from quantity (which is also a patch update)
@router.patch("/{item_name}/quantity/{subtract_quantity}")
async def subtract_item_quantity(item_name: str, subtract_quantity: int):
    for item in item_database.values():
        if item.item_name == item_name:
            if item.item_quantity - subtract_quantity < 0:
                raise HTTPException(status_code=400, detail="Insufficient item quantity")
            else:
                item.item_quantity -= subtract_quantity
            return item
        else:
            raise HTTPException(status_code=404, detail="Item not found")

# example with query params
@router.get("/items")
async def get_list_of_items(amount: int = 5):
    # 5 items by default if no query param provided
    return list(item_database.values())[:amount]