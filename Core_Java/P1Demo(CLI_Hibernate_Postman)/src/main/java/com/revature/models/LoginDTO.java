package com.revature.models;

//What the heck is a DTO??? Data Transfer Object. a DTO is meant to model some data coming in from the Front End
//An HTTP Handler will take in a JSON object sent in by the user, containing their username and password.
//This HTTP Request data gets sent to the controller, to get turned into a Java object using GSON.
//the username and password the user sends in will be put into this DTO as variables, which we'll check in the authService
//You NEVER store a DTO in the database. It's purely for DATA TRANSFER...

//Two Main DTO Uses Cases:
//1: When you don't want to send or use an entire object (we just need a username/password here)
//2: When you don't intend for the incoming data to be stored in the database
public class LoginDTO {

    //the loginDTO models ONLY the username/password sent in by the user
    private String username;
    private String password;

    //we just need one all-args constructor - the user will never just send a username or password or neither
    public LoginDTO(String username, String password) {
        super();
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

}
