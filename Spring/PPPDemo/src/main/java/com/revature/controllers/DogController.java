package com.revature.controllers;

import com.revature.models.Dog;
import com.revature.services.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
@ResponseBody
public class DogController {

    private DogService dogService;
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    //don't show this one
    @GetMapping()
    public ResponseEntity<List<Dog>> getAllDogs() {
       return ResponseEntity.ok(dogService.getAllDogs());
    }

    @PostMapping()
    public ResponseEntity<Dog> addDog(@RequestBody Dog dog) {
        return ResponseEntity.ok(dogService.addDog(dog));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable int id) {
        return ResponseEntity.ok(dogService.getDogById(id));
    }

    //I've already given you the keys to add and get by id
    //you'll be responsible for get all and the operation of your choice

    //too easy? it should be for now :)

}
