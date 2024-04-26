package com.revature.controllers;

import com.revature.models.DTOs.LoginRegisterDTO;
import com.revature.models.User;
import com.revature.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
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

}
