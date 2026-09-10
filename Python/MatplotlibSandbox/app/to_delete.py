import pandas as pd

# Load a CSV in one line
df = pd.read_csv("sales_data.csv")

# Total units sold per product across all months and regions
summary = df.groupby("product")["units_sold"].sum()

print(summary)
# Headphones    2722
# Keyboard      1628
# Laptop        1388