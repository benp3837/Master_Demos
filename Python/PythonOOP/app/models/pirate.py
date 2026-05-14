# This is a SUBCLASS of Person - It inherits all the attributes and methods of Person.
# BUT we can change the methods to do something different, and add new stuff too!
# OOP CONCEPTS - INHERITANCE AND POLYMORPHISM
from .person import Person

class Pirate(Person):
    # We can change the constructor method to add new attributes
    def __init__(self, name, age, saltiness):
        super().__init__(name, age) # This calls the constructor method from Person
        self.saltiness = saltiness # New attribute

    # We can change the say_hello method to do something different
    def say_hello(self):
        return f"Ahoy! I am {self.name} arrRrRRRrRRrr"

    # We can add new methods that are unique to Pirate
    def plunder(self):
        return f"{self.name} is plundering! Respectfully."