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

# Insert new game (missing title)
new_game_data = {"title": "",
                 "genre": "Adventure",
                 "release_year": 2024,
                 "sales": 1}

try:
    print(service.insert_videogame(new_game_data))
except Exception as e:
    print(e)

# update game
updated_game_data = {"sales": -100}
try:
    print(service.update_videogame(1, updated_game_data))
except Exception as e:
    print(e)

# now successfully
updated_game_data = {"sales": 2000000}
print(service.update_videogame(1, updated_game_data))

# CLI MENU

# visiting_zoo = True
#
# while(visiting_zoo):
#
#     print("Welcome, Zoo Manager! What would you like to do?")
#     print("1 - See all animals")
#     print("2 - See an animal by ID")
#     print("3 - Add a new animal")
#     print("4 - Update an animal by ID")
#     print("5 - Remove an animal by ID")
#     print("6 -Exit")
#
#     choice = input("Enter your choice: ")
#
#     if choice == "1":
#         # See all animals
#         print(service.get_all_animals())
#     elif choice == "2":
#         # See an animal by ID
#         id_input = input("Enter the ID of the animal you want to see: ")
#         try:
#             id = int(id_input)
#             print(service.get_animal_by_id(id))
#         except Exception as e:
#             print(e)
#     elif choice == "3":
#         # Add a new animal
#         name = input("Enter the name of the animal: ")
#         species = input("Enter the species of the animal: ")
#         age_input = input("Enter the age of the animal: ")
#         try:
#             age = int(age_input)
#             new_animal_data = {"name": name, "species": species, "age": age}
#             new_animal = service.add_new_animal(new_animal_data)
#             print(f"New animal added with ID {new_animal['id']}")
#         except Exception as e:
#             print(e)
#     elif choice == "4":
#         # Exit
#         visiting_zoo = False
#         print("Thanks for visiting the zoo!")
#     else:
#         print("Invalid choice, please try again.")
#
#
#
