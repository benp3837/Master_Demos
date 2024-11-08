package com.revature.controllers;

import com.revature.models.DTOs.IncomingPetDTO;
import com.revature.models.Pet;
import com.revature.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Combines @Controller and @ResponseBody
@RequestMapping("/pets") //any HTTP request with "/pets" will go here
@CrossOrigin
public class PetController {

    //Autowire a PetService (with Constructor Injection) to use its method
    private PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    //A method that inserts a new Pet into the DB
    @PostMapping //POST requests to /pets will come here
    public ResponseEntity<Pet> insertPet(@RequestBody IncomingPetDTO petDTO){

        //send the Pet data to the service, and save the result in a Pet object
        Pet p = petService.addPet(petDTO);

        //send the new Pet data back to the client with 201 - CREATED
        return ResponseEntity.status(201).body(p);

    }

    //A method that gets all Pets from the DB
    @GetMapping //GET requests to /pets will come here
    public ResponseEntity<List<Pet>> getAllPets(){

        //Let's return the Pets all in one line
        return ResponseEntity.ok(petService.getAllPets());

    }

    //A method that gets all Pets by UserId
    @GetMapping("/user/{userId}") //GET requests to /pets/user/{userId} will come here
    public ResponseEntity<List<Pet>> getPetsByUserId(@PathVariable int userId){

        //Another one liner
        return ResponseEntity.ok(petService.getPetsByUserId(userId));

    }

    //Exception Handler (stole this from the UserController)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e){
        //Return a 400 (BAD REQUEST) status code with the exception message
        return ResponseEntity.status(400).body(e.getMessage());
    }

}
