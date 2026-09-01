package com.revature.controllers;

import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    //Inject the UserService with Constructor Injection
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //Register User
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser){

        //Send the newUser to the Service to get processed and persisted

        User createdUser = authService.register(newUser);

        return ResponseEntity.status(201).body(createdUser);

        //No error handling here! Check the @ExceptionHandler at the bottom of this file

    }

    //no longer hardcoded login!
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO, HttpSession session){

        User loggedInUser = authService.login(loginDTO);

        //Set session attributes - no need to manually start up the session
        session.setAttribute("userId", loggedInUser.getUserId());
        session.setAttribute("username", loggedInUser.getUsername());

        return ResponseEntity.ok().body(loggedInUser);

    }

    //Exception Handlers---------------------------------------------

    //No more error handling bloat in our controller methods!
    //Our controller methods can now focus solely on success states

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e){
        //Return a bad request (400) with the Exception message
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
