package com.revature.controllers;

import com.revature.models.DTOs.LoginDTO;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.services.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    AuthService authservice;

    @Autowired
    public AuthController(AuthService authservice) {
        this.authservice = authservice;
    }

    //filled upon successful login
    public static HttpSession session;

    //NOTE: our HTTP Session is coming in via parameters this time (to be sent to the Service)
    @PostMapping()
    public ResponseEntity<OutgoingUserDTO> login(@RequestBody LoginDTO lDTO, HttpSession session) {

        //get the user from the service
        OutgoingUserDTO uDTO = authservice.login(lDTO, session);

        //The session gets initialized and filled with user data in the service ^

        //if we get here, the login and session creation was successful
        return ResponseEntity.ok(uDTO);

    }


    //Exception Handler for IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }

}
