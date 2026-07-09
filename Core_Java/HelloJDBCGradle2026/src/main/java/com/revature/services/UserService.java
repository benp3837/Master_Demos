package com.revature.services;

import com.revature.DAOs.UserDAOImpl;
import com.revature.models.User;

import java.util.List;

public class UserService {

    private final UserDAOImpl userDAO = new UserDAOImpl();

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(int userId) {
        // Validation: ID must be positive
        if (userId <= 0) {
            System.out.println("Invalid user ID");
            return null;
        }
        return userDAO.getUserById(userId);
    }

    public User insertUser(User user) {
        // Validation: username can't be blank
        if (user.getUsername() == null || user.getUsername().isBlank()) {
            System.out.println("Username cannot be blank");
            return null;
        }
        return userDAO.insertUser(user);
    }

    public User updateUser(User user) {
        // Validation: must have a valid ID to know which record to update
        if (user.getUserId() <= 0) {
            System.out.println("Cannot update user without a valid ID");
            return null;
        }
        return userDAO.updateUser(user);
    }
}