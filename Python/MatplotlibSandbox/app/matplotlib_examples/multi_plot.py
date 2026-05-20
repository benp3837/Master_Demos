# Showing multiple lines in one chart
# Easy as calling multiple plot() functions before show()

import matplotlib.pyplot as plt

months = ['Jan', 'Feb', 'Mar', 'Apr', 'May']
product_a = [10, 20, 30, 40, 50]
product_b = [15, 50, 10, 45, 10] # mixed bag
product_c = [100, 90, 50, 20, 1] # downtrending one

plt.plot(months, product_a, marker='o', linestyle='-', color='blue', label='Product A')
plt.plot(months, product_b, marker='s', linestyle='--', color='orange', label='Product B')
plt.plot(months, product_c, marker='^', linestyle='-.', color='green', label='Product C')

plt.title('Monthly Sales Comparison', fontsize=16, fontweight='bold')
plt.xlabel('Month')
plt.ylabel('Units Sold')
plt.legend()
plt.grid(True, alpha=0.5)
plt.show()