package com.ben.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //a subset of the @Controller stereotype annotation. makes a class a bean, plus MVC stuff!
@RequestMapping("/hi") //every request to 5000/p1/employee will go to this Class
@CrossOrigin() //Configuring this annotation allows us to take in HTTP requests from different origins (FE?)
public class RandomController {

    @GetMapping
    public ResponseEntity<String> hi() {
        return ResponseEntity.ok("hi");
    }

}
