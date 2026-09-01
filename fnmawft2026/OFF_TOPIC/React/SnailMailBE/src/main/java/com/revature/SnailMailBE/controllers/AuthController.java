package com.revature.SnailMailBE.controllers;

import com.revature.SnailMailBE.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //makes the class a bean, turns response data into JSON
@RequestMapping("/auth") //Any request ending in /auth will come to this controller
@CrossOrigin //allow requests from any origin
public class AuthController {

    //Login - POST request to /auth/login
    //ResponseEntity<?> means we can send any type of data back
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User incomingUser, HttpSession session){

        //NOTE the HttpSession object in the param.
        //We can initialize it and store user info in it after successful login

        //try to log in (HARDCODED)
        if(incomingUser.getUsername().equals("username")
        && incomingUser.getPassword().equals("password")){

            //Imagine we checked the DB and found this user
            //Create a new session, and store user info in it for easy access
            User loggedInUser = new User("username",
                    "email@snailmail.com",
                    "password",
                    "user");

            //Store the user info in the session
            session.setAttribute("username", loggedInUser.getUsername());
            session.setAttribute("email", loggedInUser.getEmail());
            session.setAttribute("role", loggedInUser.getRole());
            //Note: we didn't save the password in the session. No reason to!

            //It's really easy to extract this session info
            System.out.println("Session ID: " + session.getId());
            System.out.println("Session Username: " + session.getAttribute("username"));

            //Return the user info to the client (the frontend)
            return ResponseEntity.ok().body(loggedInUser);

        } else {
            //If login fails, we can throw a 401 (unauthorized) and an error message
            return ResponseEntity.status(401).body("Invalid username or password");
        }

    }

}
