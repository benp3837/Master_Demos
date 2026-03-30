import tflearn
import tflearn.datasets.mnist as mnist
import numpy as np

# =====================
# LOAD MNIST DATA
# =====================
# TFLearn has MNIST built in — no sklearn or manual download needed!
# one_hot=True converts labels to [0,0,1,0...] format automatically
X_train, y_train, X_test, y_test = mnist.load_data(one_hot=True)

print("Training samples:", len(X_train))
print("Image shape (flattened):", X_train.shape[1])


# ======== Build a Sequential Composition Model (just for a change) =====================
# Compare this to the Keras version; same architecture/goal, much less setup!
# TFLearn handles normalizing, flattening, and splitting

# Input layer — 784 neurons (one per pixel)
net = tflearn.input_data(shape=[None, 784])

# Hidden layers — same 64 → 32 pattern as our Keras model
net = tflearn.fully_connected(net, 64, activation="relu")
net = tflearn.fully_connected(net, 32, activation="relu")

# Output layer — 10 neurons, one per digit
# softmax converts raw scores to probabilities
net = tflearn.fully_connected(net, 10, activation="softmax")

# Define the loss function and optimizer
# This replaces model.compile() from Keras
net = tflearn.regression(
    net,
    optimizer="adam",
    loss="categorical_crossentropy",
    learning_rate=0.001
)

# =====================
# WRAP IN A MODEL AND TRAIN
# =====================
# DNN = Deep Neural Network — TFLearn's model wrapper
# This replaces tf.keras.Model() from Keras
model = tflearn.DNN(
    net,
    tensorboard_verbose=3  # hook up TensorBoard automatically!
)

# Train — notice show_metric=True gives us live accuracy during training
# This replaces model.fit() from Keras
model.fit(
    X_train, y_train,
    n_epoch=10,
    validation_set=0.1,
    batch_size=128,
    show_metric=True,
    run_id="mnist_sequential"  # labels this run in TensorBoard
)

# ==================== Evaluate and Predict =====================

score = model.evaluate(X_test, y_test)
print(f"\nTest Accuracy: {score[0]*100:.1f}%") # Eval

sample = X_test[0].reshape(1, -1)
actual = np.argmax(y_test[0])
prediction = model.predict(sample)
predicted = np.argmax(prediction[0])

print(f"\nActual digit:    {actual}")
print(f"Predicted digit: {predicted}")