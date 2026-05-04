# Basic Matplotlib master demo
import matplotlib.pyplot as plt

x = [1, 2, 3, 4, 5]
y = [10, 20, 30, 10, 10]

plt.plot(x, y,
         marker='o',  # Add markers to the data points
         linestyle='--',  # Dashed line style
         color='forestgreen',  # Line color
         label='Data Points')  # Label for the legend (see below)
plt.title("'Hello World' Chart", fontsize=16, fontweight='bold')
plt.xlabel('Month')
plt.ylabel('Revenue')
plt.legend() # Add a legend to the plot ONLY IF the data has labels (see above)
plt.grid(True, alpha=0.5) # Add a grid to the plot. Alpha adjusts transparency
plt.show()

"""
Remember this ^ could be as basic as:
plt.plot(x, y)
plt.show()

But I just wanted to show some bells and whistles
"""