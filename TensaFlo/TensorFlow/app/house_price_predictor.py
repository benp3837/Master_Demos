from sklearn.datasets import fetch_california_housing
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
import pandas as pd
import tensorflow as tf

# ============ Loading and Cleaning the Data ====================

# We'll grab the same housing data from forever ago through scikit-learn
# We'll also frame the features and scale up $100k to make the number more readable
housing = fetch_california_housing()
data = pd.DataFrame(housing.data, columns=housing.feature_names)
data["median_house_value"] = housing.target * 100000

print("Initial data sample: ", data.head())

# Separate features and target value
# Axis - the dimension to drop (1 for columns)
x = data.drop("median_house_value", axis=1)
y = data["median_house_value"].values

# Use a built-in scaler to normalize the feature values (makes training easier)
scaler = StandardScaler()
X_scaled = scaler.fit_transform(x)

# Split the data into training and testing sets (80% train, 20% test)
# Testing as in actually running predictions to evaluate performance
X_train, X_test, y_train, y_test = train_test_split(
    X_scaled, y, test_size=0.2, random_state=42
)

print("Training Samples: ", len(X_train))
print("Features per Sample: ", X_train.shape[1])
print("First 25 rows: ", X_scaled[:25]) # Scaled! Not as readable to us humans


# ============ Building the Model ====================

# This is a big chunk of what SageMaker was hiding from us!
# We're explicitly defining each layer of the neural network

# We're making a sequential model - data flows in order
# Note the use of the keras API, which is neural network builder.
model = tf.keras.Sequential([
    # Input layer — one neuron per feature
    tf.keras.layers.Input(shape=(X_train.shape[1],)),

    # Hidden layer 1 — 64 neurons, ReLU activation (stands for Rectified Linear Unit)
    # ReLU: "if the value is negative, make it 0. Otherwise keep it."
    tf.keras.layers.Dense(64, activation="relu"),

    # Hidden layer 2 — 32 neurons to capture more complex relationships
    tf.keras.layers.Dense(32, activation="relu"),

    # Output layer — 1 neuron because we're predicting one value (house price)
    # No activation function = linear output, which is what we want for regression
    tf.keras.layers.Dense(1)
])

# Print a summary of the model architecture (layers and parameter counts)
model.summary()


# ============ Compiling and Training the Model ====================

# Tell TensorFlow HOW to train the Model I'll we built

model.compile(
    optimizer="adam", # This training algo adjusts the model's parameters mid-training
    loss="mse", # Mean Squared Error - how "wrong" the prediction is
    metrics=["mae"] # Mean Absolute Error - avg diff between predicted and actual values
)
# The model adujsts based on loss
# The metrics are more for us to evaluate performance.

# Training with model.fit() which runs through the training X amount of times (epochs)
history = model.fit(
    X_train, y_train,
    epochs=50,
    validation_split=0.2, # use 20% of training data to validate the model
    verbose=1 # print out training progess
)

# =========== Evaluating and Using the Model =====================

test_loss, test_mae = model.evaluate(X_test, y_test, verbose=0)
print(f"\nTest MAE: ${test_mae:,.0f}")
print(f"On average our predictions are off by ${test_mae:,.0f}")

# Time to predict! Grab one sample from the test set to run a prediction on.
sample = X_test[0].reshape(1, -1)
actual = y_test[0]
predicted = model.predict(sample)[0][0]

print(f"\nActual price:    ${actual:,.0f}")
print(f"Predicted price: ${predicted:,.0f}")
print(f"Difference:      ${abs(actual - predicted):,.0f}")