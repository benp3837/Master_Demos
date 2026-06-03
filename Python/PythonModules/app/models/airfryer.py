import re
import math
import logging

"""The AirFryer Class with a bunch of methods we'll use for testing.
Also note the use of the regex, logging, and math modules!"""

# Configuring the logger
logging.basicConfig(
    level=logging.INFO, # Allow all levels of logs to be captured (INFO, WARNING, ERROR, etc.)
    format='%(asctime)s - %(levelname)s - %(message)s', # Defining what our logs look like
    handlers=[
        logging.FileHandler("airfryer.log"),  # writes to a file
        logging.StreamHandler()               # also prints to console
    ]
    )

class AirFryer:

    # No constructor needed, we'll skip attributes for this one

    # Basic method, nothing that can go wrong here. Easy to test!
    def fry(self):

        # INFO log - used to report general information about the program's execution.
        logging.info("The frying process has started.")

        return "food is getting fried!"

    # This method has something that can go wrong. Now we have something meaningful to test
    def set_temperature(self, temperature):

        # ValueError - used when an inappropriate value is received.
        if temperature < 100:

            # ERROR log - used to report a problem that has occurred in the program.
            logging.error(f"Attempted to set temperature to {temperature} - too low.")

            raise ValueError("Temperature must be at least 100 degrees.")

        return f"The fryer is set to {temperature} degrees."

    # User Registration method with regex to reject names containing "javascript"
    def register_user(self, username):

        # Reject usernames that contain "javascript" (case-insensitive)
        if re.search(r'javascript', username, re.IGNORECASE):

            # WARNING log - used to indicate a potential issue that isn't necessarily an error but should be noted.
            logging.warning(f"Attempted to register username '{username}' - contains 'javascript'.")

            raise ValueError("Username cannot contain 'javascript'.")

        return f"User '{username}' registered successfully!"

    # Showing the math module - Calculate a tip after cook time based on food weight
    # This horribly dystopian function urges the user to tip the air fryer company after cooking
    # TODO: This could be a great, semi tricky mini-assignment for them to do in the day
    # TODO: See if they can come up with a reasonable math function to use
    # TODO: OR just explore the docs/google together and see what we think makes sense
    def calculate_tip(self, weight):
        # Heavier meal = exponentially larger tip. dystopia babyyyy
        tip = math.pow(weight, 1.2) * .18

        #.2f formats the number to 2 decimal places!
        print(f"Suggested tip of ${tip:.2f} will be charged automatically.")
        print(f"You may round up to ${math.ceil(tip)} for no extra benefit.")
        print(f"You may round down to ${math.floor(tip)} if you watch an ad >:D")

        # Return tip as a float rounded to 2 decimal places
        return round(tip, 2)
