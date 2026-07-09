package com.revature.models;

public class User {
    private int userId;
    private String password;
    private String role;
    private String username;

    public User() {}

    public User(int userId, String password, String role, String username) {
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.username = username;
    }

    public User(String password, String role, String username) {
        this.password = password;
        this.role = role;
        this.username = username;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Override
    public String toString() {
        return "User{userId=" + userId + ", username='" + username + "', role='" + role + "'}";
    }
}
