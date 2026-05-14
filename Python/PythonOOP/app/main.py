"""
This demo will be your reference for the 4 Pillars of OOP in a real code example -

We'll see Inheritance and Polymorphism in our Person and Pirate Classes
Then we'll explore Encapsulation and Abstraction with our Ship Class
"""

# We'll play around with our objects here, and see how they differ
from models.person import Person
from models.pirate import Pirate

print("=================(Person - The SuperClass)")

# Create a new person object (instance of the Person class)
person1 = Person("Gumby", 95)

# Call the methods of the person object
print(person1.say_hello())
print(person1.eat_food())

# Remember, we can make as many objects as we want!
# This is why I say Classes are good for "reusable modeling of data"
person2 = Person("Pokey", 90)
print(person2.say_hello())
print(person2.eat_food())

print("==================(Pirate - The SubClass)")

# Messing around with the subclass of Person

# Note that it has each of the attributes and methods as the Person class...
# But we changed what say_hello() does, and added a method unique to Pirate!

pirate1 = Pirate("Jack Sparrow", 50, "Very salty")
print(pirate1.say_hello())
print(pirate1.eat_food())

