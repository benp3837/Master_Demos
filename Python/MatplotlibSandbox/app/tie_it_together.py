import pandas as pd
import matplotlib.pyplot as plt

"""
Ok we had lots of fun playing around with hardcoded data 

But let's use a "real" .csv dataset and use all 3 technologies we've learned

We'll start by finally using a Pandas dataframe to load and manipulate the real data
Then use Numpy to do some calculations
And visualize the data with Matplotlib!
"""

# GOAL: Visualize monthly sales trends by product
# TODO SUBGOAL: Visualize something of your choice with any of the other columns
# TODO STYLEPOINTS: Use something other than a line chart

# Load the CSV file into a DataFrame
df = pd.read_csv("app/data/sales_data.csv") # BTW this only works if you run from project root!
# Peek at what we loaded
print(df.head()) # See the first 5 rows
print(df.shape)  # (rows, columns)
print(df.columns) # list column names
print(df.dtypes) # Datatypes per column
print(df.describe()) # Summary stats for numeric columns

""" PANDAS - Data Cleaning
We need to clean up the data!! 
-One record has a null value for its product name
-A few records have negative values for units sold (let's assume that's wrong)
"""

# Filter the dataframe to only include rows where "product" is not null
#TODO

# Fill negative values in "units_sold" with 0 (assuming negative values no sales)
# TODO: can you think of a replacement value other than 0?
# TODO: (I'm looking for someone to say "average units sold for that product")
df["units_sold"] = df["units_sold"].fillna(0)


""" PANDAS - Data Manipulation
Right now each row is one product/region/month combo
We want total units sold per product per month across all regions
groupby() groups rows together, sum() adds up the values in each group
"""
monthly_product_sales = df.groupby(["month", "product"])["units_sold"].sum().reset_index()

# Filter the dataframe to get one series per product
laptops = monthly_product_sales[monthly_product_sales["product"] == "Laptop"]
headphones = monthly_product_sales[monthly_product_sales["product"] == "Headphones"]
keyboards = monthly_product_sales[monthly_product_sales["product"] == "Keyboard"]

print("Monthly Product Sales:")
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