package com.revature.controllers;

//Remember, the Controller is where all of our SpringMVC logic sits to handle HTTP requests

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController //Makes this class a bean and turns HTTP Response data into JSON (@Controller, @ResponseBody)
@RequestMapping("/users") //All HTTP Requests ending in /users will go to this controller
@CrossOrigin //Allows HTTP requests from anywhere
public class UserController {

    private UserService us;
    private PasswordEncoder passwordEncoder; //SPRING SECURITY - lets us encode our passwords

    //UserController depends on UserService (it needs its methods). So let's constructor inject the Service
    @Autowired
    public UserController(UserService us, PasswordEncoder passwordEncoder) {
        this.us = us;
        this.passwordEncoder = passwordEncoder;
    }

    //A method that inserts a new User into the DB
    @PostMapping //HTTP POST Requests ending in /users will hit this method
    public ResponseEntity<User> registerUser(@RequestBody User newUser){

        //TODO: try/catch based on service method exception throws

        //encode the password before sending the new user to the DB
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        User u = us.registerUser(newUser);

        return ResponseEntity.status(201).body(u); //send back 201 (Created) and the new User's data

    }

    //A method that returns all Users in the DB
    @GetMapping //HTTP GET Requests ending in /users will hit this method
    public ResponseEntity<List<User>> getAllUsers() {

        //TODO: have this send back an outgoingUserDTO instead, so password isn't sent.

        //not much error handling needed, no variables, nothing crazy that can go wrong
        List<User> users = us.getAllUsers();

        return ResponseEntity.ok(users); //send back 200 (OK) and the Users

    }

    //A method that returns a User by their username
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        //One liner for now, might be able to polish this with error handling
        return ResponseEntity.ok(us.getUserByUsername(username));
    }

    //A Method that updates a User's username
    @PatchMapping("/{userId}")
    public ResponseEntity<?> updateUsername(@RequestBody String username, @PathVariable UUID userId){

        //using our rudimentary error handling thanks to Optional in the Service

        //if the Service returns null, we know the user wasn't found by ID
        User updatedUser = us.updateUser(username, userId);

        if(updatedUser == null){
            return ResponseEntity.status(400).body("User not found with ID: " + userId);
        } else {
            return ResponseEntity.ok(updatedUser);
        }

    }

}
