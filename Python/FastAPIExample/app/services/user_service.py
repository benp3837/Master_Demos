from app.models.user import User

def create_account(user:User):
    validate_user(user)


def validate_user(user:User):
    print(f"Validating user: {user.username}")