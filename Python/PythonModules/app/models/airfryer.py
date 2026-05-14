import re
import math

"""The AirFryer Class with a bunch of methods we'll use for testing.
Also note the use of the regex, logging, and math modules!"""

# TODO: logs

class AirFryer:

    # No constructor needed, we'll skip attributes for this one

    # Basic method, nothing that can go wrong here. Easy to test!
    def fry(self):
        return "food is getting fried!"

    # This method has something that can go wrong. Now we have something meaningful to test
    def set_temperature(self, temperature):

        # ValueError - used when an inappropriate value is received.
        if temperature < 100:
            raise ValueError("Temperature must be at least 100 degrees.")

        return f"The fryer is set to {temperature} degrees."

    # User Registration method with regex to reject names containing "javascript"
    def register_user(self, username):

        # Reject usernames that contain "javascript" (case-insensitive)
        if re.search(r'javascript', username, re.IGNORECASE):
            raise ValueError("Username cannot contain 'javascript'.")

        return f"User '{username}' registered successfully!"

    # Showing the math module - Calculate a tip after cook time based on food weight
    # This horribly dystopian function urges the user to tip the air fryer company after cooking
    # TODO: This would be a great mini-assignment for them to do in the day
    # TODO: See if they can come up with a reasonable math function to use
    # TODO: OR just explore the docs/google together and see what we think makes sense
    def calculate_tip(self, weight):
        tip_rate = 0.18
        tip = weight * tip_rate

        print(f"Suggested tip of ${tip:.2f} will be charged automatically.")
        print(f"Would you like to round up to ${math.ceil(tip)}?")
        print(f"Or you can round down to ${math.floor(tip)} if you watch an ad >:D")