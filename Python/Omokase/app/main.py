# Gotta import the functions from their own file to use them here!
import restaurant_functions as rf

""" An Omokase is a Japanese dining experience
where the chef selects and prepares a series of dishes for the customer.
The word "omakase" translates to "I'll leave it up to you".

We'll be creating an Omokase Command Line Interface (CLI) app that demonstrates:
1. User input and output
2. Data structures (lists, dictionaries)
3. Control flow (review in a more realistic setting)
4. Functions (to organize our code and make it reusable)
"""

# TODO: an assignment for them: add a functionality for _______
# TODO: (or make them come up with their own extra functionality!)

print(""" 
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*
                   Welcome to the Omokase CLI App!
We will be creating a personalized 3-course meal based on your preferences!
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*

First, what is your name?""")
name = input(">>> ")

print(f"Great to meet you, {name}")

# This boolean will trigger the while loop below
# Once the user is full, we'll set it to False and exit the loop
hungry = True

# While loop that generates the menu and feeds the user until they're full
while hungry:
    # Generate a menu based on user preferences
    generated_menu = rf.generate_menu()

    # Print the generated menu items
    rf.serve_user(generated_menu)

    # Ask the user if they're still hungry after eating
    print("Are you still hungry? (yes/no)")
    still_hungry = input(">>> ").lower()

    # Either break the loop, serve the user again, or ask them to repeat their answer
    if still_hungry == "no":
        hungry = False # THIS WILL BREAK THE LOOP!
        print(f"""Thanks for dining with us, {name}! Here's a summary of the meals you ate:")
        -Apps: {rf.eaten_foods['appetizers']}
        -Mains: {rf.eaten_foods['main_courses']}
        -Desserts: {rf.eaten_foods['desserts']}
        That will be ${rf.bill} dollars. Have a great day!""")
    else:
        print("Great! Let's prepare another meal for you!")
