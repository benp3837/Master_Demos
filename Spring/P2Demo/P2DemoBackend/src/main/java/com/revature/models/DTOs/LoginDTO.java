package com.revature.models.DTOs;

//When logging in a user, we only need username and password
//We can use this (very commonly used) DTO to transfer those login credentials
public class LoginDTO {

    private String username;
    private String password;

    //boilerplate code------------------- no args, all args, getter/setter, toString

    public LoginDTO() {
    }

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

    //mostly nice for debugs, easy way to analyze the values of the object's variables
    @Override
    public String toString() {
        return "LoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
