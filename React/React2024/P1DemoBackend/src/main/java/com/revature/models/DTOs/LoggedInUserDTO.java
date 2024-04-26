package com.revature.models.DTOs;

//We don't want to send a user's password to the front end...
//But we DO need to send their usernames and id so we can properly identify them
//Sounds like we need a new DTO.
public class LoggedInUserDTO {

    private int userId;
    private String username;

    public LoggedInUserDTO() {
        super();
    }

    public LoggedInUserDTO(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoggedInUserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
