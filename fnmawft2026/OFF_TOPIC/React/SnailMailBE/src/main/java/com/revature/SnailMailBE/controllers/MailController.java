package com.revature.SnailMailBE.controllers;

import com.revature.SnailMailBE.models.Mail;
import com.revature.SnailMailBE.services.MailService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Remember the 3 annotations that we include for a Spring MVC Controller:
@RestController //Makes the Class a Bean, and turns response data into JSON
@RequestMapping("/mail") //Sets the base URL to reach this controller (it'll be http://localhost:8080/mail)
@CrossOrigin //Allows requests from any origin (this will let our FE/BE communicate)
public class MailController {

    //Because the MailController depends on the Service, we must inject it
    //We do this so we can use its methods
    private MailService mailService;

    //Constructor Injection - best practice for autowiring
    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    //This method sends a user's inbox back to them (a List of Mail objects)
    @GetMapping
    public ResponseEntity<List<Mail>> getInbox(){

        //Send a request to the service layer to get the inbox
        List<Mail> inbox = mailService.getInbox();

        //Easily configure and return an HTTP response thanks to ResponseEntity
        //200 level status code, or 204 status code if inbox is empty
        if(inbox == null){
            return ResponseEntity.noContent().build(); //204 status code
        } else {
            return ResponseEntity.ok().body(inbox); //200 status code
        }

    }

    //This method will take in a Mail object and send a (fake) email
    @PostMapping
    public ResponseEntity<Mail> sendMail(@RequestBody Mail mail) {

        //Send the mail to the service to be processed, and return the result.

        //Note that I'm doing this in a one-liner. You don't HAVE to
        return ResponseEntity.ok().body(mailService.sendMail(mail));

    }


    //Spring MVC ExceptionHandler - super generic one to help with responses/tests
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> handleException(Exception e){
        //Return the Exception in the response body with a 400 so the FE can handle it
        System.out.println(e.getMessage());
        return ResponseEntity.badRequest().body(e); //400 status code
    }

}