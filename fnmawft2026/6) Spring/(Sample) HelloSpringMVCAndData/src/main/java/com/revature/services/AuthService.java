package com.revature.services;

//Just remember Service classes are for business logic - data formatting, input validation, etc
//They're largely unchanged in spring, but there are a couple setup steps

import com.revature.DAOs.UserDAO;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //1 of the 4 steretype annotations - makes this Class a bean
public class AuthService {

    //We can't instantiate Interfaces... Luckily, we only need to CONSTRUCTOR INJECT it.
    private final UserDAO userDAO;

    @Autowired //Constructor Inject here!!! Now AuthService can use UserDAO
    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //Insert a new User into the DB (uses the save() method we inherited)
    public User register(User newUser){

        //make sure usernames are unique (findByUsername, which we had to write, sort of)
        if(userDAO.findByUsername(newUser.getUsername()) != null){
            throw new IllegalArgumentException("Username already exists!");
        }

        //TODO: other checks

        //Make sure username and password aren't blank
        if(newUser.getUsername().isBlank() || newUser.getPassword().isBlank()){
            //Exception Handler in the Controller will handle this!
            throw new IllegalArgumentException("Username and Password can't be empty!");
        }

        //After checks, insert the User!

        //save() is the JPA method for inserting data. Also used for updates!
        //It also returns the saved object, so we can just return the method call!
        return userDAO.save(newUser);

    }

    public User login(LoginDTO loginDTO){

        //TODO: input validation

        //Try to get a user by username and password
        //We wrote this abstract method with a property expression in the DAO
        User loggedInUser = userDAO.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        //We could have made findByUAndP return an Optional so we could use .orElseThrow()... but I didn't
        if(loggedInUser == null){
            throw new IllegalArgumentException("Username or Password Invalid!");
        }

        return loggedInUser;

    }


}
