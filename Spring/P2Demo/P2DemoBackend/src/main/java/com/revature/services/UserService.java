package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service //1 of the 4 stereotype annotations. Makes this Class a Bean
public class UserService {

    //define (but not initialize) a UserDAO object
    private UserDAO userDAO;

    //How can we get access to the methods of our UserDAO? DEPENDENCY INJECTION!!
    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //A method that takes in a User object from the controller, and sends it to the DAO
    public User registerUser(User newUser){

        //TODO: error handling and other business logic!

        //.save() lets us insert data into the DB. We can also use this for updates.
        //It also returns the user in question, so we can save it to a variable
        User u = userDAO.save(newUser);

        return u; //send back to the Controller

        //NOTE: You can definitely just return the method call, I just like to spell it out a bit

    }

    //This method gets all users from the UserDAO, and sends it back to the Controller
    public List<User> getAllUsers(){
        return userDAO.findAll();
    }

    //This method gets a user by their username
    public User getUserByUsername(String username){

        //TODO: error handling for user not found, username blank, etc.

        return userDAO.findByUsername(username);

    }

    //This method lets us update a user's username
    public User updateUser(String newUsername, UUID userId){

        //TODO: error handling, check for valid inputs

        //get the User by id (remember this returns an OPTIONAL!)
        Optional<User> existingUser = userDAO.findById(userId);

        //Remember, .isPresent() checks the optional to see if there's data or if it's null
        if(existingUser.isPresent()) {

            //If the User is present, extract it so we can update it
            User u = existingUser.get();

            //update the existing username with the new username
            u.setUsername(newUsername);

            //save it back to the DB thru the DAO, send back the updated User
            return userDAO.save(u);

            //NOTE: the .save() method is used for inserts AND updates
            //How does Spring know to insert vs update? It's based on whether the ID exists or not

        } else {
            //TODO: probably throw an exception
            return null;
        }

    }

}
