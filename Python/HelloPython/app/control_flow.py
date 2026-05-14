# We're going to create some hypothetical scenarios where control flow is necessary

print("=============================(If/Elif/Else)")
# Allows us to execute different blocks of code based on conditions
# We'll do a slightly more complex one since there's a simple one in hello.py

# Let's make a list of strings and pick a random one (using the "random" module)
vibes = ["otherworldly", "chill", "lowkey off"]

import random
the_vibe = random.choice(vibes) # Super simple! Thanks, random module
print(f"The vibe is: {the_vibe}")

if the_vibe == "otherworldly":
    print("I am experiencing otherworldly vibes")
elif the_vibe == "chill":
    print("I'm am enjoying myself nonchalantly")
elif the_vibe == "lowkey off":
    print("...I gotta go")

print("=============================(While Loops)")
# A while loop repeatedly executes a block of code as long as a condition is true

meatballs_eaten = 0

while meatballs_eaten < 5:
    print(f"I've eaten {meatballs_eaten} meatballs. I can eat more!")
    meatballs_eaten += 1 # Increment the count of meatballs eaten

# Once meatballs eaten is no longer less than 5... the while loop breaks!
print(f"I've eaten {meatballs_eaten} meatballs. I'm full now!")

print("=============================(For Loops)")

# A for loop iterates over a sequence (like a list)...
# and executes a block of code for each item in the sequence

# We can make for loops with the "range" function (which is zero indexed!)
for i in range(5): # This will loop 5 times, with i taking values from 0 to 4
    print(f"This is loop iteration number {i}")

# We can also use for loops to iterate over items in a list (or other sequences like tuples)
dogs = ["Sophie", "Sparky", "Mister"]

for dog in dogs:
    print(f"petting {dog}...")
    print(f"{dog} is a good dog!")
