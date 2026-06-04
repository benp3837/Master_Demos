"""
"Fake" database, which is just a dict of videogames
Python Dictionaries ARE fairly similar to real SQL databases...
In your real Project 1, these functions would be calls to a real DB
"""

videogames = {
    1: {"id": 1,
        "title": "Bonk",
        "genre": "Action",
        "release_year": 2017,
        "sales": 1_000_000},
    2: {"id": 2,
        "title": "Glorp",
        "genre": "Platformer",
        "release_year": 2017,
        "sales": 500_000},
    3: {"id": 3,
        "title": "Burnt Bread Redemption 2",
        "genre": "Action-adventure",
        "release_year": 2018,
        "sales": 1_000_000},
    4: {"id": 4,
        "title": "Pong",
        "genre": "Sports",
        "release_year": 1972,
        "sales": 100_000_000},
}


def get_all_videogames():
    """Returns a list of all videogames in the "database" (the dict)"""
    return list(videogames.values())

def get_videogame_by_id(id):
    """Returns a videogame with the given id, or None if it doesn't exist"""
    return videogames.get(id)

# insert new game
def insert_videogame(game_data):
    """Inserts a new videogame into the "database" (the dict) and returns the new game with its assigned ID"""
    new_id = len(videogames) + 1  # Get the next available ID
    videogames[new_id] = game_data  # Insert the new game into the "database"
    return videogames[new_id]  # Return the newly inserted game

# update record
def update_videogame(id, updated_data):
    """Updates an existing videogame with the given id using the provided updated data. Returns the updated game or None if the game doesn't exist."""
    if id in videogames:
        videogames[id].update(updated_data)  # Update the existing game with the new data
        return videogames[id]  # Return the updated game
    else:
        return None  # Return None if the game with the given ID doesn't exist


# TODO: YOU can figure out how to delete.