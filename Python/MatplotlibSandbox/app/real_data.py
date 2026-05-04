import pandas as pd
import matplotlib.pyplot as plt

# Ok we had lots of fun playing around with hardcoded data
# Now let's use some real data from a CSV file
    # I'll be using Pandas just cuz it's relevant and easy

# GOAL: Visualize monthly sales trends by product
# TODO SUBGOAL: Visualize something of your choice with any of the other columns
# TODO STYLEPOINTS: Use something other than a line chart

# Load the CSV file into a DataFrame
df = pd.read_csv("app/data/sales_data.csv") # BTW this only works if you run from project root!
# Peek at what we loaded
print(df.head())
print(df.shape)  # (rows, columns)

# Right now each row is one product/region/month combo
# We want total units sold per product per month across all regions
# groupby() groups rows together, sum() adds up the values in each group
monthly_product_sales = df.groupby(["month", "product"])["units_sold"].sum().reset_index()

# Filter the dataframe to get one series per product
laptops = monthly_product_sales[monthly_product_sales["product"] == "Laptop"]
headphones = monthly_product_sales[monthly_product_sales["product"] == "Headphones"]
keyboards = monthly_product_sales[monthly_product_sales["product"] == "Keyboard"]

print(monthly_product_sales)

# PLOT IT! Going a little harder here just for fun and realism
plt.figure(figsize=(10, 6))

plt.plot(laptops["month"], laptops["units_sold"],
         label="Laptop", marker="o", color="steelblue", linewidth=2)

plt.plot(headphones["month"], headphones["units_sold"],
         label="Headphones", marker="s", color="coral", linewidth=2)

plt.plot(keyboards["month"], keyboards["units_sold"],
         label="Keyboard", marker="^", color="seagreen", linewidth=2)

plt.title("Units Sold Per Product Over 6 Months")
plt.xlabel("Month")
plt.ylabel("Units Sold")
plt.legend()
plt.grid(True, alpha=0.3)
plt.tight_layout()
plt.show()