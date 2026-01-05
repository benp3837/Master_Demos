from pydantic import BaseModel, constr, conint

class UserModel(BaseModel):
    id: conint(gt=0) = None  # Default "None" lets us leave the id out when creating users
    username: constr(strip_whitespace=True, min_length=3, max_length=15)
    password: constr(strip_whitespace=True, min_length=8)
    #constr - a Pydantic type for strings with constraints. Slick way to add validation!
    #the "pattern" arg is a regex for basic email validation
    email: constr(strip_whitespace=True, min_length=5, pattern=r"^\S+@\S+\.\S+$")
