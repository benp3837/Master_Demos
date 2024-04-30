package com.revature.controllers;

import com.revature.models.DTOs.LoggedInUserDTO;
import com.revature.models.DTOs.LoginRegisterDTO;
import com.revature.models.User;
import com.revature.services.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3001", allowCredentials = "true")
public class AuthController {

    //autowire authservice
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //PostMapping for Registering a new user
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody LoginRegisterDTO dto) {
        try{
            User u = authService.registerUser(dto);
            return ResponseEntity.ok("Registered " + u.getUsername());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //Log a user in to the application
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRegisterDTO dto, HttpSession session) {

        User u = authService.loginUser(dto);

        //if login is successful, create a new Http Session and store the user ID
        //This user ID will be used throughout the session to identify the user!!!
            //check the PokemonController methods for examples of how to use this
        if (u != null) {
            // set user ID in session
            session.setAttribute("userId", u.getUserId());

            System.out.println(session.getAttribute("userId"));

            //upon successful login, send the outgoingUserDTO to the front end
            return ResponseEntity.ok(new LoggedInUserDTO(u.getUserId(), u.getUsername()));
        } else {
            return ResponseEntity.status(401).body("Invalid credentials! Try again.");
        }

    }

}
