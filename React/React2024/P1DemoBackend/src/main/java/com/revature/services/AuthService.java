package com.revature.services;

import com.revature.DAOs.AuthDAO;
import com.revature.models.DTOs.LoginRegisterDTO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    //autowire authdao
    private AuthDAO authDAO;

    @Autowired
    public AuthService(AuthDAO authDAO) {
        this.authDAO = authDAO;
    }

    //register user
    public User registerUser(LoginRegisterDTO dto) {

        //two checks to make sure username and password are not empty

        //we could also check for usernames that already exist, vulgar names, etc

        if(dto.getUsername() == null || dto.getUsername().trim().equals("")) {
            throw new IllegalArgumentException("Invalid username!");
        }

        if(dto.getPassword() == null || dto.getPassword().trim().equals("")) {
            throw new IllegalArgumentException("Invalid password!");
        }

        //if all checks pass, create a new user object and send it to the DAO
        User newUser = new User(dto.getUsername(), dto.getPassword());

        return authDAO.save(newUser);
    }

    //login user
    public User loginUser(LoginRegisterDTO dto) {

        //two checks to make sure username and password are not empty

        //we could also check for usernames that already exist, vulgar names, etc

        if(dto.getUsername() == null || dto.getUsername().trim().equals("")) {
            throw new IllegalArgumentException("Invalid username!");
        }

        if(dto.getPassword() == null || dto.getPassword().trim().equals("")) {
            throw new IllegalArgumentException("Invalid password!");
        }

        //if all checks pass, return a user OR NULL and send it to the DAO
        //user gets returned if the username/password match. Null if they don't.
        return authDAO.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
    }

    //TODO: get all users
    public List<User> getAllUsers() {
        return authDAO.findAll();
    }

    //delete user
    public void deleteUser(int userId) {
        authDAO.deleteById(userId);
    }

}
