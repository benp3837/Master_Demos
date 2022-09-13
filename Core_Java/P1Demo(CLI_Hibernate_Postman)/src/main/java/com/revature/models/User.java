package com.revature.models;

//Having this User Class ALMOST defeats the purpose of a LoginDTO...
//but in your projects, Users will have way more fields than just username/password
public class User {

    private int user_id;
    private String username;
    private String passsword;


    public User(int user_id, String username, String passsword) {
        super();
        this.user_id = user_id;
        this.username = username;
        this.passsword = passsword;
    }


    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", username=" + username + ", passsword=" + passsword + "]";
    }


    public int getUser_id() {
        return user_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPasssword() {
        return passsword;
    }


    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }


}
