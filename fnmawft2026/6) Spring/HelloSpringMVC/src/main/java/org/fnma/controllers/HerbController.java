package org.fnma.controllers;

import org.fnma.models.Herb;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller //This class is now a bean (1 of the 4 stereotype annotations)
@RequestMapping(value="herb") //All requests to "localhost:8080/herbs" go here
@ResponseBody //All HTTP response bodies get converted to JSON for us
public class HerbController {


    @GetMapping //All GET requests to localhost:8080/herb go here
    public ResponseEntity<ArrayList<Herb>> getHerbs(){

        //imagine we got these from the DB
        ArrayList<Herb> herbs = new ArrayList<>();

        herbs.add(new Herb(1, "Thyme", "Mediterranean"));
        herbs.add(new Herb(2, "Lavender", "Mediterranean"));
        herbs.add(new Herb(3, "Mint", "Moderate"));

        //Status Code 200, herbs in the body of the response
        return ResponseEntity.ok(herbs);

    }


    //This method takes in a {path variable} and it can return any (?) type of object
    @GetMapping("/{herbId}")
    public ResponseEntity<?> getHerbById(@PathVariable("herbId") int herbId){

        //Validation will be pretty similar, and exception handling can be global too
        if(herbId <= 0){
            throw new IllegalArgumentException("Invalid ID!");
        }

        //Assume we got this from the DB
        Herb h = new Herb(1, "Rosemary", "Mediterranean");
        //Herb h = null;

        //Different response if null (204 NO CONTENT)
        if(h == null){
            //.build() is how we specific NO RESPONSE BODY
            return ResponseEntity.noContent().build();
        }


        //200 OK, with the Herb object
        return ResponseEntity.ok(h);

    }

    //POST requests to localhost:8080/herb go here
    @PostMapping
    public ResponseEntity<Herb> insertHerb(@RequestBody Herb herb){

        //Validations before going to the hypothetical Service/DAO
        if(herb.getName() == null || herb.getClimate() == null ||
                herb.getName().isBlank() || herb.getClimate().isBlank()) {
            throw new IllegalArgumentException("All text fields must be present");
        }

        //202 ACCEPTED, and just pass the same object back
        return ResponseEntity.accepted().body(herb);

    }

    /* Note about put, patch, delete

     -PUT will look very similar to POST (@PutMapping and @RequestBody)
     -DELETE will look very similar to GET BY ID (@PathVariable, and @PutMapping/@DeleteMapping)
     */

    //Exception Handlers---------------------------

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArg(Exception e){

        //400 BAD REQUEST with Exception message as the body
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    //COOL - Hooking into the Exception that Spring MVC would have handled on its own
    //If we didn't do this, postman just gets a 400 if the request body is bad
    //But we took control to send back a 400 AND a meaningful message
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleNotReadable(Exception e){

        //400 BAD REQUEST with Exception message as the body
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
