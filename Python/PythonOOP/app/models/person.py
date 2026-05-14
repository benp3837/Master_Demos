"""This 'person' class is used to MODEL a generic person. (Hence 'models' folder)
It has a name and an age, and a method to say hello.
It is meant to be inherited by the other class in the models folder (superclass/subclass).
    But it can be used on its own too!"""

class Person:
    # This is the "constructor method". It defines the attributes of the class (name and age).
    # It is called to create a new instance of the class (see main.py).
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def eat_food(self):
        return f"{self.name} is munching"

    def say_hello(self):
        return f"Hello, my name is {self.name} and I am {self.age} years old."