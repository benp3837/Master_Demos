"""
The Service Layer is for BUSINESS LOGIC. It is the layer that contains the logic of the application. It is the layer that is responsible for the business logic of the application. It is the layer that is responsible for the communication between the presentation layer and the data access layer. It is the layer that is responsible for the validation of the data. It is the layer that is responsible for the error handling. It is the layer that is responsible for the logging. It is the layer that is responsible for the security. It is the layer that is responsible for the performance. It is the layer that is responsible for the scalability. It is the layer that is responsible for the maintainability. It is the layer that is responsible for the testability. It is the layer that is responsible for the reusability. It is the layer that is responsible for the flexibility. It is the layer that is responsible for the extensibility. It is the layer that is responsible for the modularity. It is the layer that is responsible for the separation of concerns. It is the layer that is responsible for the single responsibility principle. It is the layer that is responsible for the open/closed principle. It is the layer that is responsible for the Liskov substitution principle. It is the layer that is responsible for the interface segregation principle.
Business Logic is anything that needs to happen between the user and the database

-User input validation (did the user enter valid information)
-User authentication (is the user logged in, and are they allowed to do this thing?)
-Data transformation (turn this data into a different format before sending it off)
-General Error handling (if something goes wrong, how do we handle it?)

It's also just good practice to have a separation of concerns.
Throwing all this logic into other layers will bloat your code and make it harder to test.
"""

import VG_repository_fake as repo

def get_all_videogames():
    # Ok, not too much to validate here. Just gets all games from the DB...

    games = repo.get_all_videogames()

    # Here's a common piece of business logic though - Custom message for "no data found"
    if not games:
        raise Exception("No games found in the database!")

    # TODO: format the data somehow?
    # Just send the user "title (year)"
    formatted_game_data = []

    for game in games:

        title_and_year = f"{game['title']} ({game['release_year']})"
        formatted_game_data.append(title_and_year)

    # Return the FORMATTED data to the user
    return formatted_game_data

# Now let's see a function that actually takes some user input
def get_videogame_by_id(id):
    # Validate that the ID is a positive integer
    if not isinstance(id, int) or id <= 0:
        raise TypeError("ID must be a positive integer!")

    # Get the game from the DB
    game = repo.get_videogame_by_id(id)

    # If the game doesn't exist, raise an exception
    if not game:
        raise ValueError(f"No game found with ID {id}!")

    # Return the game to the user
    return game