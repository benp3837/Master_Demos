import tensorflow as tf
import numpy as np
import datetime
import os

# =====================
# LOAD AND PREPARE MNIST
# =====================
# MNIST is a dataset of 70,000 handwritten digit images (0-9)
# 60,000 training images, 10,000 test images
# Each image is 28x28 pixels, grayscale

mnist = tf.keras.datasets.mnist
(X_train, y_train), (X_test, y_test) = mnist.load_data()

# Normalize pixel values from 0-255 to 0-1
# Same reason we used StandardScaler before — neural networks train better
# on small, consistent values
X_train = X_train / 255.0
X_test = X_test / 255.0

# Flatten 28x28 images into 784-element vectors
# Our dense layers expect 1D input, not 2D images
X_train = X_train.reshape(-1, 784)
X_test = X_test.reshape(-1, 784)

# Convert labels to one-hot encoding
# Instead of label "3", we get [0,0,0,1,0,0,0,0,0,0]
# One neuron per possible digit in the output layer
y_train = tf.keras.utils.to_categorical(y_train, 10)
y_test = tf.keras.utils.to_categorical(y_test, 10)

print("Training samples:", len(X_train))
print("Image shape (flattened):", X_train.shape[1])
print("Output classes:", y_train.shape[1])

# =====================
# BUILD THE MODEL — FUNCTIONAL COMPOSITION
# =====================
# Previously we used Sequential — layers stacked in a straight line
# Functional lets us branch, merge, and share layers
# Think of it like the difference between a straight pipeline
# and a more complex workflow with multiple paths

# STEP 1: Define the input layer explicitly
# With functional API we always start here
inputs = tf.keras.Input(shape=(784,), name="input_layer")

# STEP 2: Build a SHARED base — both branches will use this
# This is what makes functional composition powerful
# The same learned representations feed into multiple outputs
shared = tf.keras.layers.Dense(128, activation="relu", name="shared_layer_1")(inputs)
shared = tf.keras.layers.Dense(64, activation="relu", name="shared_layer_2")(shared)

# STEP 3: Branch 1 — Digit Classification (what digit is this?)
# This is the main task — predict which of 10 digits the image shows
branch_1 = tf.keras.layers.Dense(32, activation="relu", name="digit_branch")(shared)
digit_output = tf.keras.layers.Dense(10, activation="softmax", name="digit_output")(branch_1)
# softmax: converts raw scores into probabilities that sum to 1
# "I'm 94% sure this is a 3, 4% sure it's an 8, etc."

# STEP 4: Branch 2 — High/Low Classification (is this digit >= 5?)
# A second task running off the same shared base
# Shows functional composition — one input, two outputs
branch_2 = tf.keras.layers.Dense(16, activation="relu", name="high_low_branch")(shared)
high_low_output = tf.keras.layers.Dense(1, activation="sigmoid", name="high_low_output")(branch_2)
# sigmoid: outputs a value between 0 and 1
# "I'm 87% sure this digit is 5 or higher"

# STEP 5: Assemble the model
# One input, two outputs — this is impossible with Sequential!
model = tf.keras.Model(
    inputs=inputs,
    outputs=[digit_output, high_low_output],
    name="MNIST_Functional_Model"
)

model.summary()

# =====================
# PREPARE HIGH/LOW LABELS
# =====================
# Convert digit labels to binary (0 = digits 0-4, 1 = digits 5-9)
y_train_digits = tf.keras.utils.to_categorical(
    np.argmax(y_train, axis=1), 10
)
y_train_high_low = (np.argmax(y_train, axis=1) >= 5).astype(float)

y_test_digits = tf.keras.utils.to_categorical(
    np.argmax(y_test, axis=1), 10
)
y_test_high_low = (np.argmax(y_test, axis=1) >= 5).astype(float)

# =====================
# COMPILE THE MODEL
# =====================
# With multiple outputs we need to specify loss for each one
model.compile(
    optimizer="adam",
    loss={
        "digit_output": "categorical_crossentropy",  # multi-class classification
        "high_low_output": "binary_crossentropy"     # binary classification
    },
    metrics={
        "digit_output": "accuracy",
        "high_low_output": "accuracy"
    }
)

# =====================
# TENSORBOARD SETUP
# =====================
log_dir = os.path.join("logs", datetime.datetime.now().strftime("%Y%m%d-%H%M%S"))

tensorboard_callback = tf.keras.callbacks.TensorBoard(
    log_dir=log_dir,
    histogram_freq=1  # log weight histograms every epoch
)

print(f"\nTensorBoard logs saving to: {log_dir}")
print("Launch with: tensorboard --logdir logs\n")

# ==================== Train The Model =====================
history = model.fit(
    X_train,
    {
        "digit_output": y_train_digits,
        "high_low_output": y_train_high_low
    },
    epochs=10,
    validation_split=0.1,
    callbacks=[tensorboard_callback],
    verbose=1
)

# ==================== Evaluate The Model =====================
results = model.evaluate(
    X_test,
    {
        "digit_output": y_test_digits,
        "high_low_output": y_test_high_low
    },
    verbose=0
)

print(f"\nDigit Classification Accuracy: {results[3]*100:.1f}%")
print(f"High/Low Classification Accuracy: {results[4]*100:.1f}%")

# ==================== Make A Prediction =====================
# Grab one test image and see what both branches predict
sample = X_test[0].reshape(1, -1)
actual_digit = np.argmax(y_test_digits[0])
actual_high_low = "High (5-9)" if y_test_high_low[0] == 1 else "Low (0-4)"

digit_pred, high_low_pred = model.predict(sample, verbose=0)

predicted_digit = np.argmax(digit_pred[0])
predicted_high_low = "High (5-9)" if high_low_pred[0][0] >= 0.5 else "Low (0-4)"

print(f"\nActual digit:      {actual_digit}")
print(f"Predicted digit:   {predicted_digit}")
print(f"\nActual High/Low:   {actual_high_low}")
print(f"Predicted High/Low: {predicted_high_low}")