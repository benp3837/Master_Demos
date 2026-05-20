import numpy as np
import time

"""Here's our first look at "Why NumPy?" - SPEED!
NumPy performs operations on entire datasets at once, without loops.
This superpower is called "vectorization"

This cleans up your code, and makes your operations significantly faster.
The bigger the dataset, the more dramatic the difference.

Also, we're importing the time module to measure how long our operations take
"""

plain_list = list(range(1_000_000))
numpy_array = np.array(plain_list)

# Plain Python loop
start = time.time()
result = [x * 2 for x in plain_list]
python_time = time.time() - start

# NumPy vectorized
start = time.time()
result = numpy_array * 2
numpy_time = time.time() - start

print(f"\n--- Speed Comparison (1 million elements) ---")
print(f"Plain Python list: {python_time:.4f} seconds")
print(f"NumPy array:       {numpy_time:.4f} seconds")
print(f"NumPy was {python_time / numpy_time:.1f}x faster!")


# More "real-world" example ----------------------

# Defining two months of daily sales figures (PASTE THIS IN FOR THEM PLS LOL)

january_sales = np.array([
    120, 135, 98, 142, 167, 88, 95,
    201, 178, 156, 134, 189, 145, 112,
    167, 198, 223, 145, 167, 134, 189,
    201, 178, 156, 134, 189, 145, 112,
    167, 198, 223
])

# Vectorization: math on entire arrays at once, no loops needed!

# We expect business to boom 15% this January. Let's see what a 15% increase would look like.
# With a plain Python list you'd need a loop. But NumPy just does it :)
boosted_january = january_sales * 1.15
print("Original January sales (first 7 days):", january_sales[:7])
print("Boosted January sales (first 7 days): ", boosted_january[:7].astype(int))


# DESCRIPTIVE STATS - super simple with NumPy's built-in functions

print("\n--- January Sales Stats ---")
print(f"Total sales:      {np.sum(january_sales)}")
print(f"Average daily:    {np.mean(january_sales):.1f}")
print(f"Best day:         {np.max(january_sales)}")
print(f"Worst day:        {np.min(january_sales)}")
print(f"Std deviation:    {np.std(january_sales):.1f}")
# std deviation tells you how spread out the numbers are
# high std = sales are inconsistent, low std = sales are steady


# We can also filter the list without loops using BOOLEAN INDEXING

# Which days in January had sales above average?
jan_avg = np.mean(january_sales)
above_average = january_sales[january_sales > jan_avg]
print(f"\nDays above average in January: {len(above_average)} out of {len(january_sales)}")
print(f"Days above average with 15% boost: "
      f"{len(boosted_january[boosted_january > jan_avg])} out of {len(boosted_january)}")