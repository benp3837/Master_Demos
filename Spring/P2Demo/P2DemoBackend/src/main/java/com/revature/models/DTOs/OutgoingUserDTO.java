package com.revature.models.DTOs;

import java.util.UUID;

//Here's another common DTO - send a user back to the front end without any:
// -sensitive data (password)
// -redundant data (List of Cars)
public class OutgoingUserDTO {

    private UUID userId;
    private String username;
    private String role;

    private String JWT;


    //boilerplate--------------/

    public OutgoingUserDTO() {
    }

    public OutgoingUserDTO(UUID userId, String username, String role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
    }

    public OutgoingUserDTO(UUID userId, String username, String role, String JWT) {
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.JWT = JWT;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJWT() {
        return JWT;
    }

    public void setJWT(String JWT) {
        this.JWT = JWT;
    }

    @Override
    public String toString() {
        return "OutgoingUserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", JWT='" + JWT + '\'' +
                '}';
    }
}