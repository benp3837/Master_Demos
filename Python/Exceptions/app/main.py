# Let's start by raising some Exceptions/Errors to cause problems on purpose (for science)

# Let's raise an Exception.
# result = 10 / 0 # <------- ZeroDivisionError: division by zero
def print_money(amount):
    if type(amount) != int:
        raise ValueError("Must print more than $0!")
    print(f"You have ${amount}!")

# How do we HANDLE this exception so our code doesn't crash?---------------------------

# A try/except block!
# We TRY to run some code, and divert to the EXCEPT block if an exception is raised.
try:
    result = 10 / 0
except ZeroDivisionError:
    print("You can't divide by zero! Please try again with a different number.")
finally:
    print("This will print at the end no matter what!")

# TODO: In intellij, make sure to ctrl + click on ZeroDivisonError to see more builtins
# TODO: Note how all built in exceptions INHERIT from Exception.
# TODO: Choose another one to show them below!! Doesn't have to be TypeError

# Throwing the TypeError Exception just for fun:
try:
    result = "10" + 10
except TypeError:
    print("You can't add a string and an int together!")

# Note that we can CHAIN try/except blocks. Let's try a deeper example

def divide(num1, num2):
    try:
        print(num1 / num2)
    except ArithmeticError:
        print("Something went wrong mathematically... IDK what though...")
    except ZeroDivisionError:
        print("You can't divide by zero! Please try again with a different number.")
    except Exception:
        print("I could have caught any Exception!")

""" 
Remember to put the most specific exceptions at the top!!!!
Wouldn't it make more sense for the ZeroDivisionError to be caught in this case?

Instead, the ArithmeticError gets caught (which is the parent class of ZeroDivError)
Our error message is more vague than it needs to be. Bad!
"""

# Using our custom exception --------------------------------------

from cookie_eating_monster import CookieEatingMonster, NotACookieError

cookie_monster = CookieEatingMonster()

# Using eat_cookie() by passing it a valid value (a cookie)
cookie_monster.eat_cookie("cookie")

# Now let's try to raise our custom exception by passing a bad value -----
try:
    cookie_monster.eat_cookie("broccoli")
except NotACookieError as e:
    print(e.message)

# NOTE that we're catching the error and saving it into the variable "e"
# This lets us access its attributes like the all-important "message" attribute

