""" This Class will contain some attributes and methods related to a Ship and its controls

We'll see Encapsulation
(We can restrict access to the attributes and methods of the class)

And talk about Abstraction
(We don't need to know HOW the methods work to use them in main.py)"""

class Ship:
    def __init__(self, name, speed):
        # Public, can be accessed/changed from outside the class
        self.name = name
        # __Private, can only be accessed/changed in this class, or through getters/setters
        self.__speed = speed

    # Getter for the private speed attribute (Lets us access it
    def get_speed(self):
        return self.__speed

    # Setter for the private speed attribute
    def set_speed(self, new_speed):
        self.__speed = new_speed

    # Method to sail the ship. Assume it's super complicated code lol.
    # We don't NEED to know HOW the ship sails to use the sail method in main.py
    # That's abstraction!
    def sail(self):
        print(f"{self.name} is sailing at {self.__speed} knots!")

""" Pretty much any time we call a method that does something, 
We don't need to know how it works to use it. So we're always using abstraction.
This includes the methods in Person and Pirate, and any other methods we've used
Zooming even further out, we're running this app with the command "python main.py", right?
It just works! That command abstracts a TON of stuff away from us and runs the app."""