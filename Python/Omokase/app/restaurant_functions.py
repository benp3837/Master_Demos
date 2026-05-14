# Dictionary that stores the meals the user has eaten
# The keys are strings, and the values are lists that hold each food
eaten_foods = {
    "appetizers": [],
    "main_courses": [],
    "desserts": []
}

# Tracks the amount the user owes based on the meals they eat
bill = 0

# Function to get the user's fav foods as list, and return the list
def generate_menu():

    print("What are 3 foods you like?")
    favorite_foods = []

    for i in range(3):
        food = input(f"Food {i + 1}: ")
        favorite_foods.append(food)

    return favorite_foods

# Function to serve the user, save meals in the eaten_foods dictionary, update the bill
def serve_user(menu):

    print("*||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||*")
    print(f"Your appetizer: {menu[0]} Bisque")
    print(f"Your main course: {menu[1]} Wellington")
    print(f"Your dessert: Frozen {menu[2]}")
    print("*||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||*")

    eaten_foods["appetizers"].append(menu[0] + " Bisque")
    eaten_foods["main_courses"].append(menu[1] + " Wellington")
    eaten_foods["desserts"].append(menu[2] + " Ice Cream")

    global bill  # Declare 'bill' as global so we can modify the global variable

    # For simplicity, let's say each course costs $10
    bill += 30