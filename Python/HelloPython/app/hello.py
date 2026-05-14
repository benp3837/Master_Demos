# This is a comment. They don't affect the script!

# Here's a print statement. It "PRINTS" the provided text to the console below
# The "console" is what displays the output of your code
print("Hello Python :^)")

""" Here's a 'multi-line comment'

We're going to run this script using the terminal.
Open the terminal using the ">_" icon on the bottom left 
Or hit "view -> tool windows -> terminal" on the top menu bar
Navigate to the directory holding this file (cd app)
then simply run: python hello.py
"""

# ================ Datatypes =========================
# (We'll see some of the more niche types later, or just via the notes)

# string: A sequence of characters. Can be defined using single or double quotes.
my_name = "John Pork"

# number: Can be integers (whole numbers) or floats (decimal numbers)
my_age = 20

# boolean: Represents True or False values
is_student = True
# Booleans are also the result of comparisons (ex: 5 > 6 would store a False value)

# Let's tie these first 3 variables together with an "if statement" which we'll see again later
if is_student:
    print(f"I'm {my_name}, I'm {my_age}, and I'm a student!")
else:
    print(f"I'm {my_name}, I'm {my_age}, and I'm NOT a student!")

# Note the use of the f-string, which lets us print {variables} directly within the string!


# list: An collection of data (can be any datatype). They're ordered and mutable (changeable).
my_favorite_foods = ["Pizza", "Sushi", "Ice Cream"]

# tuple: Similar to lists, but they're immutable (can't be changed after creation).
my_coordinates = (40.7128, -74.0060)  # Latitude and Longitude for New York City - won't change

# dictionary: A collection of key-value pairs, where each key is unique
my_profile = {
    "name": "John Pork",
    "age": 20,
    "is_student": True
}

# we can access values in a dictionary using their keys
print(f"The name in the dictionary is: {my_profile["name"]}")  # Output: John Pork
