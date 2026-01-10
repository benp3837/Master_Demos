# A model class for inventory items with id, name, quantity, price, and description
from pydantic import BaseModel, constr, conint

class ItemModel(BaseModel):
    id: conint(gt=0)
    item_name: constr(strip_whitespace=True, min_length=1, max_length=50)
    item_quantity: conint(ge=0)
    price: float
    description: constr(strip_whitespace=True, max_length=200)