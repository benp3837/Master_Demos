package com.revature.controllers;

import com.revature.models.Taco;
import com.revature.services.AuthService;
import com.revature.services.TacoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RestController makes the class a bean and sends responses back as JSON
    //@Controller - the bean maker
    //@ResponseBody - the JSON response maker
@RequestMapping("/taco") //All requests with /taco will get routed here
public class TacoController {

    //Inject AuthService to use its methods
    private final TacoService tacoService;

    @Autowired
    public TacoController(TacoService tacoService) {
        this.tacoService = tacoService;
    }


    @GetMapping
    public ResponseEntity<String> getTaco(HttpSession session){

        //Look how easy it is to get data out of the session!
        //Casting to Integer since session attributes are objects
        Integer userId = (Integer)session.getAttribute("userId");

        if(userId == null){
            return ResponseEntity.status(401).body("Not Logged In!");
        }

        //If we get here, User is logged in
        return ResponseEntity.ok().body("Here's your taco");
    }


    //Insert taco
    @PostMapping
    public ResponseEntity<Taco> insertTaco(@RequestBody Taco taco, HttpSession session){

        //Get the User Id from the session - could also TODO a login check here
        Integer userId = (Integer) session.getAttribute("userId");

        Taco newTaco = tacoService.insertTaco(taco, userId);

        return ResponseEntity.status(201).body(newTaco);

    }



    //TODO: This would be cleaner to call instead of checking session info every time!
    public boolean isLoggedIn(){
        //check if Session Id is null, send back false if so.

        //controller methods can take this and clean up their log in check syntax

        return false;
    }

}
