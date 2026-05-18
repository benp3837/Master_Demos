"""
 Here lies the TEST SUITE for the AirFryer class
 Tests are meant to check that our code is working as expected,
 and catch any issues BEFORE your erroneous code is unleashed on the world.

 "Why WOULDN'T my code work??? I wrote it..."
 First off, it's a good way to ensure that your code truly does everything it's supposed to.
 Also, your code will change as you develop. You might break something that was working before.

 Companies will have you ensure company code is covered by some percentage of tests
 "I want 80% test coverage on the new AirFryer class before we can deploy it"

 Intellij and pytest let us see test coverage by ____________

"""
import pytest

from app.models.airfryer import AirFryer

# NOTE: You run the tests in this file by running the command "pytest"

# This is a "fixture", giving us a reusable object (AirFryer), cleaning up our tests!
# Otherwise, we'd instantiate a new AirFryer in each test. Duplication is bad practice!
@pytest.fixture(scope="module")
def fryer():
    return AirFryer()


# Test functions must start with "test_" for pytest to recognize them as tests
def test_fry(fryer):
    result = fryer.fry()
    assert result == "food is getting fried!"  # Assert that the result is what we expect

# GREEN TEST - Tests that the function works as expected when given valid input
def test_set_temperature_valid(fryer):
    result = fryer.set_temperature(350)
    assert result == "The fryer is set to 350 degrees."

# RED TEST - Tests that the function behaves as expected when given INVALID input.
def test_set_temperature_invalid(fryer):
    with pytest.raises(ValueError) as exc_info:
        fryer.set_temperature(50)
        assert str(exc_info.value) == "Temperature must be at least 100 degrees."

# TODO: you could make them write this one------------
# TODO: write a green test, ensuring the tip is calculated correctly
# TODO: include a second assertion making sure calculate_tip returns a float
# TODO: Yes, you can have multiple assertions in one test!
def test_tip_amount(fryer):

    result = fryer.calculate_tip(10)

    assert isinstance(result, float)  # Check that the result is a float

    # Check that the tip amount is correct (18% rounded to 2 decimal places)
    assert result == round(10 * .18, 2)

