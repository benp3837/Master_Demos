package com.revature.models;

/*What is a DTO?? Data Transfer Object. It's meant to model some data that doesn't match a DB table
 In this case, we need a Class that can hold the user-inputted username/password when they login
 The username/password that the user enters will get stored in a LoginDTO object.
 You NEVER store a DTO in the database. It's strictly for data transfer from frontend/backend

 Two main DTO use cases:
 1) When you don't want to send or use an entire object (you just need username/password to login)
 2) When you don't intend to store incoming data in the DB (meant just for the Java logic)
 */
public class LoginDTO {

    //variables that will hold the username and password
    private String username;
    private String password;

    //we tend to only need an all args constructor in a DTO
    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
