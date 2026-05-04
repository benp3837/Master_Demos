# subplots - multiple charts in one figure

import matplotlib.pyplot as plt

months = ['Jan', 'Feb', 'Mar', 'Apr', 'May']
sales = [10, 20, 30, 40, 50]
returns = [1, 2, 3, 4, 5]

# Create a figure with 1 row and 2 columns of charts
fig, (ax1, ax2) = plt.subplots(1, 2, figsize=(12, 5))

# Each ax (axis) is a separate chart
ax1.plot(months, sales, marker='o', linestyle='-', color='blue')
ax1.set_title('Monthly Sales', fontsize=16, fontweight='bold')
ax1.set_xlabel('Month')
ax1.set_ylabel('Units Sold')
ax1.grid(True, alpha=0.5)

ax2.plot(months, returns, marker='s', linestyle='--', color='red')
ax2.set_title('Monthly Returns', fontsize=16, fontweight='bold')
ax2.set_xlabel('Month')
ax2.set_ylabel('Units Returned')
ax2.grid(True, alpha=0.5)

plt.tight_layout() # Adjust spacing between subplots (prevents overlap)
plt.show()