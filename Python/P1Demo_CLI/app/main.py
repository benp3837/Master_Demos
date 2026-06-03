# TODO: You know how to make a CLI right? (See Omakase from Week 1)
# TODO: For now, we're just gonna call service functions directly

import VG_service as service

# Janky Exception handling in this - would be way cleaner with an API library like FastAPI

# Get all games
print(service.get_all_videogames())

# Get game by invalid ID
try:
    print(service.get_videogame_by_id(-1))
except Exception as e:
    print(e)

# Get game by valid but nonexistent ID
try:
    print(service.get_videogame_by_id(999))
except Exception as e:
    print(e)

# Get game by ID (successful - not formatted, just raw data)
print(service.get_videogame_by_id(1))

