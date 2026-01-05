from unittest.mock import patch

from fastapi.testclient import TestClient
from app.main import app  # Import your FastAPI app

# Create a TestClient for the FastAPI app
client = TestClient(app)

# This test file will have one green test and one red test for an idea of test structure
# Green test: function behaves as expected when things go right (valid new user input)
# Red test: function raises expected error when things go wrong (invalid new user input)

# Here's the green test
def test_create_user_success():

    # Test creating a new user - here's the POST request
    response = client.post(
        "/users/",
        json={
            "username": "testuser",
            "password": "securepassword",
            "email": "testuser@example.com"
        }
    )

    # Make sure we got the expected status code
    assert response.status_code == 201

    # Parse the JSON response data so we can test it
    data = response.json()

    # Assert the returned data matches what we sent
    assert data["username"] == "testuser"
    assert data["email"] == "testuser@example.com"

    # This assertion makes sure a value was added to the "database" (id gets autogenned)
    assert "id" in data

# Here's one of many possible red tests (duplicate username)
def test_create_user_duplicate_username():
    # Test creating a user with a duplicate username
    client.post(
        "/users/",
        json={
            "username": "duplicateuser",
            "password": "password123",
            "email": "unique@example.com"
        }
    )
    response = client.post(
        "/users/",
        json={
            "username": "duplicateuser",
            "password": "password456",
            "email": "anotherunique@example.com"
        }
    )
    assert response.status_code == 409
    assert response.json()["msg"] == "Username already exists"


# NOTE ON MOCKING:
# In a real-world scenario, you'd want to mock the database interactions to avoid side effects
# We don't always want to hit a real database or send a real HTTP requests in your tests
# Libraries like unittest.mock or pytest-mock can help with this

# Mocked test for create_user
def test_create_user_with_mock():
    # Mock the user_database dictionary
    with patch("app.routers.users.user_database", new_callable=dict) as mock_db:
        # Simulate the POST request
        response = client.post(
            "/users/",
            json={
                "username": "mockuser",
                "password": "mockpassword",
                "email": "mockuser@example.com"
            }
        )

        # Assertions
        assert response.status_code == 201
        data = response.json()
        assert data["username"] == "mockuser"
        assert data["email"] == "mockuser@example.com"
        assert "id" in data

        # Verify the user was added to the mocked database
        assert len(mock_db) == 1
        assert mock_db[1].username == "mockuser"