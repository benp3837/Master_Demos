"""
We'll have two different classes in this app -

1) AirFryer - Has basic to somewhat complex methods that we'll use to:
    -See some modules in action (math, logging, regex)
    -write some tests with the Pytest module
    -TODO: If possible, time permitting, we'll use the JSON and pylint modules as well
    -TODO: maybe have them try to use pylint themselves and report their findings
2) AirFryerTests - A Test Suite where we'll write the tests for AirFryer's methods

We can call the AirFryer methods below if we have time, and just for fun (also shows logging)
"""

from models.airfryer import AirFryer

fryer = AirFryer()

print(fryer.fry())
print(fryer.set_temperature(350))
print(fryer.register_user("Chef123"))

# Raise the exceptions too

try:
    print(fryer.register_user("JavaScriptLover"))
except ValueError as e:
    print(f"Caught an error: {e}")

try:
    print(fryer.set_temperature(50))
except ValueError as e:
    print(f"Caught an error: {e}")

# tip calc
print(fryer.calculate_tip(10))