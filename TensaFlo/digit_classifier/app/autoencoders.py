import tensorflow as tf
import numpy as np
import matplotlib.pyplot as plt

# =====================
# LOAD MNIST DATA
# =====================
# Same dataset as the digit classifier — students already know it!
# For an autoencoder we don't need labels at all — purely unsupervised
(X_train, _), (X_test, y_test) = tf.keras.datasets.mnist.load_data()

# Normalize pixel values to 0-1
X_train = X_train.astype("float32") / 255.0
X_test = X_test.astype("float32") / 255.0

# Flatten 28x28 images into 784-element vectors
X_train = X_train.reshape(-1, 784)
X_test = X_test.reshape(-1, 784)

print("Training samples:", len(X_train))
print("Image shape (flattened):", X_train.shape[1])

# =====================
# BUILD THE AUTOENCODER — FUNCTIONAL COMPOSITION
# =====================
# We're using functional composition here because we want to be able to
# extract JUST the encoder later to inspect the bottleneck representations
# This would be harder with Sequential

# INPUT
inputs = tf.keras.Input(shape=(784,), name="input")

# ENCODER — compress the input down to a bottleneck
# 784 → 128 → 64 → 32
x = tf.keras.layers.Dense(128, activation="relu", name="encoder_1")(inputs)
x = tf.keras.layers.Dense(64, activation="relu", name="encoder_2")(x)
bottleneck = tf.keras.layers.Dense(32, activation="relu", name="bottleneck")(x)
# At this point we've compressed 784 values down to just 32!

# DECODER — reconstruct the input from the bottleneck
# 32 → 64 → 128 → 784 (mirror of the encoder)
x = tf.keras.layers.Dense(64, activation="relu", name="decoder_1")(bottleneck)
x = tf.keras.layers.Dense(128, activation="relu", name="decoder_2")(x)
reconstruction = tf.keras.layers.Dense(784, activation="sigmoid", name="reconstruction")(x)
# sigmoid keeps output between 0-1, matching our normalized pixel values

# =====================
# ASSEMBLE TWO MODELS
# =====================

# Model 1 — the full autoencoder (encoder + decoder)
# Input: image → Output: reconstructed image
autoencoder = tf.keras.Model(inputs, reconstruction, name="Autoencoder")
autoencoder.summary()

# Model 2 — just the encoder half
# Input: image → Output: compressed bottleneck representation
# We can use this to inspect what the model learned to compress down to
encoder = tf.keras.Model(inputs, bottleneck, name="Encoder")

# =====================
# COMPILE AND TRAIN
# =====================
autoencoder.compile(
    optimizer="adam",
    loss="mse"  # Mean Squared Error — measures reconstruction quality
    # How different is the output from the original input?
)

# KEY MOMENT: X_train is BOTH the input AND the target!
# "Given this image, reconstruct this same image"
# That's what makes it an autoencoder
history = autoencoder.fit(
    X_train, X_train,  # <-- same data for input and output!
    epochs=20,
    batch_size=256,
    validation_data=(X_test, X_test),  # same here
    verbose=1
)

# =====================
# VISUALIZE RECONSTRUCTIONS
# =====================
# This is the payoff — show original vs reconstructed images
# Students can see what the model learned to preserve through the bottleneck

n_images = 10
test_samples = X_test[:n_images]
reconstructed = autoencoder.predict(test_samples, verbose=0)

fig, axes = plt.subplots(2, n_images, figsize=(20, 4))

for i in range(n_images):
    # Top row — original images
    axes[0, i].imshow(test_samples[i].reshape(28, 28), cmap="gray")
    axes[0, i].axis("off")
    if i == 0:
        axes[0, i].set_title("Original", fontsize=12)

    # Bottom row — reconstructed images
    axes[1, i].imshow(reconstructed[i].reshape(28, 28), cmap="gray")
    axes[1, i].axis("off")
    if i == 0:
        axes[1, i].set_title("Reconstructed", fontsize=12)

plt.suptitle("Autoencoder: Original vs Reconstructed Digits", fontsize=14)
plt.tight_layout()
plt.show()

# =====================
# VISUALIZE THE BOTTLENECK
# =====================
# Extract the compressed representations from the encoder
# These 32 numbers are all the model has to reconstruct the image from
compressed = encoder.predict(X_test[:5], verbose=0)

print("\nOriginal image size:         784 values")
print("Compressed representation:    32 values")
print(f"Compression ratio:           {784//32}x smaller!")
print("\nSample compressed representation (first test image):")
print(np.round(compressed[0], 3))

# =====================
# VISUALIZE LOSS CURVE
# =====================
# Show reconstruction loss decreasing over epochs
# Lower loss = better reconstructions
plt.figure(figsize=(10, 4))
plt.plot(history.history["loss"], label="Training Loss")
plt.plot(history.history["val_loss"], label="Validation Loss")
plt.title("Autoencoder Reconstruction Loss Over Epochs")
plt.xlabel("Epoch")
plt.ylabel("Loss (MSE)")
plt.legend()
plt.tight_layout()
plt.show()

# =====================
# ANOMALY DETECTION DEMO
# =====================
# Train on digits 0-4 only, then test on digits 5-9
# The model should reconstruct familiar digits well
# and unfamiliar digits poorly — high reconstruction error = anomaly!

print("\n--- Anomaly Detection Demo ---")
print("Training on digits 0-4 only, then testing on 5-9...")

# Reload full dataset with labels for this demo
(X_train_full, y_train_full), (X_test_full, y_test_full) = tf.keras.datasets.mnist.load_data()
X_train_full = X_train_full.astype("float32") / 255.0
X_test_full = X_test_full.astype("float32") / 255.0
X_train_full = X_train_full.reshape(-1, 784)
X_test_full = X_test_full.reshape(-1, 784)

# Filter to only digits 0-4 for training
low_digits_mask = y_train_full < 5
X_train_low = X_train_full[low_digits_mask]

# Build and train a fresh autoencoder on just digits 0-4
anomaly_autoencoder = tf.keras.Model(inputs, reconstruction, name="Anomaly_Autoencoder")
anomaly_autoencoder.compile(optimizer="adam", loss="mse")
anomaly_autoencoder.fit(
    X_train_low, X_train_low,
    epochs=10,
    batch_size=256,
    verbose=0  # quiet training for this part
)

# Test reconstruction error on low digits (0-4) vs high digits (5-9)
X_test_low = X_test_full[y_test_full < 5][:100]
X_test_high = X_test_full[y_test_full >= 5][:100]

recon_low = anomaly_autoencoder.predict(X_test_low, verbose=0)
recon_high = anomaly_autoencoder.predict(X_test_high, verbose=0)

error_low = np.mean(np.square(X_test_low - recon_low), axis=1).mean()
error_high = np.mean(np.square(X_test_high - recon_high), axis=1).mean()

print(f"\nAvg reconstruction error for digits 0-4 (familiar):   {error_low:.4f}")
print(f"Avg reconstruction error for digits 5-9 (unfamiliar): {error_high:.4f}")
print(f"\nUnfamiliar digits have {error_high/error_low:.1f}x higher reconstruction error!")
print("Higher error = model flags these as anomalies")