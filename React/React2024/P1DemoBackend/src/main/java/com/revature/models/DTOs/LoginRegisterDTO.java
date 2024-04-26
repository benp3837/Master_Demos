package com.revature.models.DTOs;

//What is a DTO? A Data Transfer Object!
//We don't want to have to specify user ID for login/registration
//This DTO will store ONLY the relevant information for user login/registration
public class LoginRegisterDTO {

    private String username;
    private String password;

    public LoginRegisterDTO() {
        super();
    }

    public LoginRegisterDTO(String username, String password) {
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
        return "LoginRegisterDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
