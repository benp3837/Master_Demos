package com.revature.services;

import com.revature.controllers.AuthController;
import com.revature.daos.AuthDAO;
import com.revature.models.DTOs.LoginDTO;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    //autowire AuthDAO
    AuthDAO aDAO;

    @Autowired
    public AuthService(AuthDAO aDAO) {
        this.aDAO = aDAO;
    }

    public OutgoingUserDTO login(LoginDTO lDTO, HttpSession ses) {

        //use the DTO data to find a User in the database
        User u = aDAO.findByUsernameAndPassword(lDTO.getUsername(), lDTO.getPassword());

        //if no User is found, throw an exception
        if(u == null) {
            //TODO: custom no user found exception? no time for that now
            throw new IllegalArgumentException("No user found with those credentials");
        }

        //if we get here the User isn't null (login was successful)------

        //Initialize the HttpSession sent in AuthController
        AuthController.session = ses;

        //Store the user info in the session
        ses.setAttribute("userId", u.getUserId());
        ses.setAttribute("username", u.getUsername());
        ses.setAttribute("role", u.getRole());
        //WHY STORE INFO SESSION ATTRIBUTES?? plenty of reasons:

        //-uniquely identify the user in the backend logic and HTTP responses
            //ex: use the stored userId in "findBy" methods to clean up the URL
        //-verify a user's role before allowing them access to certain methods

        System.out.println(ses.getAttribute("username") + " has logged in");

        //Process the User into an OutgoingUser (to remove password) and send it back
        OutgoingUserDTO outUser = new OutgoingUserDTO(u.getUserId(), u.getUsername(), u.getRole());

        return outUser;



    }


}