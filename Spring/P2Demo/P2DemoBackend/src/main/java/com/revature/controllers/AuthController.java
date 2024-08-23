package com.revature.controllers;

import com.revature.models.DTOs.LoginDTO;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.utils.JwtTokenUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//set crossorigin to allow origin from our publicly deployed front end, and allow credentials
@CrossOrigin(origins={"http://p1demofrontend.s3-website-us-east-1.amazonaws.com/", "http://localhost:3000"}, allowCredentials = "true")
public class AuthController {


    //autowire auth service, JwtTokenUtil, AuthenticationManager, and PasswordEncoder
    private AuthService as;
    private AuthenticationManager authManager;
    private JwtTokenUtil jwtUtil;

    @Autowired
    public AuthController(AuthService as, AuthenticationManager authManager, JwtTokenUtil jwtUtil) {
        this.as = as;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    //NOTE: Spring Security Login Method!
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO lDTO) {

        //attempt to login (notice no direct calls of the service/DAO)
        try {

            //this is what authenticates the incoming username/password
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(lDTO.getUsername(), lDTO.getPassword())
            );

            //build up the user based on the validation
            User user = (User) auth.getPrincipal();

            //if the user is found/valid, generate a JWT!
            String accessToken = jwtUtil.generateAccessToken(user);

            //create our OutgoingUserDTO to send back (which will include, ID, Username, and JWT)
            OutgoingUserDTO outUser = new OutgoingUserDTO(user.getUserId(), user.getUsername(), user.getRole(), accessToken);

            System.out.println(outUser);

            //finally we sent the OutgoingUserDTO back to the client
            return ResponseEntity.ok(outUser);

        } catch (Exception e) {
            System.out.println("uh oh");
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
