package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*What is the Service layer?? It's also known as the "Business Logic Layer" because...

    -This is where we do any data processing/error handling that DOESN'T have to do with the DB or HTTP
        -DAO handles DB operations
        -Controller handles HTTP requests/responses
    -EVERYTHING in between should live in the Service layer! */

@Service //1 of the 4 stereotype annotations. It registers this Class as a Spring Bean
public class UserService {

    //We can't instantiate Interfaces like Classes... how do we get access to our DAO methods?
    //DEPENDENCY INJECTION! With the @Autowired dependency
    private UserDAO userDAO;

    //This is CONSTRUCTOR INJECTION (not setter injection, not field injection)
    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //This method inserts new Users into the DB
    public User register(User newUser){

        //TODO: Check that the username is unique (get user by username, see if it's null)
        //User u = findByUsername(newUser.getUsername());
        //If u is not null, throw an exception because the username already exists

        //Make sure the username is present in the new User (TODO: password too)
        if(newUser.getUsername() == null || newUser.getUsername().isBlank()){
            //It will be the Controller's job to handle this
            throw new IllegalArgumentException("Username cannot be empty!");
        }

        //.save() is the JPA method to insert data into the DB. We can also use this for updates
        //It also returns the saved object, so we can just return the method call. Convenient!
        return userDAO.save(newUser);
    }


    //This method gets all users from the DB
    public List<OutgoingUserDTO> getAllUsers(){
        //findAll() is a JPA method that returns all records in a table
        List<User> users = userDAO.findAll();

        //Empty List of OutUserDTOs to be filled by the processing below
        List<OutgoingUserDTO> outUsers = new ArrayList<OutgoingUserDTO>();

        //loop through the users and add to the outUsers
        for(User user : users){
            //we're just taking each User and creating OutUsers from it
            outUsers.add(
                new OutgoingUserDTO(user.getUserId(), user.getUsername(), user.getRole())
            );
        }

        //return our new list of outgoing user DTOs!
        return outUsers;

        //Not much error handling in a get all... maybe checking to see if it's empty?
    }


    //This method gets a user by username
    public User getUserByUsername(String username){

        //a little error handling
        if(username == null || username.isBlank()){
            throw new IllegalArgumentException("Please search for a valid username!");
        }

        //TODO: we could check if the returned user is null and throw an exception
        //if(userDAO.findByUsername(username) == null){throw Exp}

        //findByUsername is a method WE DEFINED in the UserDAO (but didn't have to implement!)
        return userDAO.findByUsername(username);
    }

    //This method updates a user's role in the DB (need to supply user id and new role)
    public User updateUserRole(int userId, String newRole){

        //TODO: error handling - make sure the role is valid (non-empty, and either "user" or "admin")

        //get the user by ID - if it exists, update the role, otherwise IllegalArgException

        //orElseThrow() will either return the value or throw NoSuchElementException
        //We'll handle the IllegalArgumentException in the controller
        User u = userDAO.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("No user found with id: " + userId));

        //If we reach this point, we know the user exists. Update the role!
        u.setRole(newRole);

        //Save the updated user (this will go in as an update, since this user id already exists)
        userDAO.save(u);

        //The newest version of the user object! Send it to the controller
        return u;

    }

    //This method deletes a User from the DB
    public User deleteUserById(int userId){

        //TODO: error handling - make sure the user id is > 0

        //Find the user ID - if it exists, delete it, otherwise IllegalArgException
        //Remember, this Exception will be handled in the Controller
        User userToDelete = userDAO.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("No user found with id: " + userId));

        userDAO.deleteById(userId); //Inherited from JpaRepository

        return userToDelete;

    }

}
