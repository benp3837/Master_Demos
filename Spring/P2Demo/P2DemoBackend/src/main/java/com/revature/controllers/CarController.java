package com.revature.controllers;

import com.revature.DAOs.UserDAO;
import com.revature.models.Car;
import com.revature.models.DTOs.IncomingCarDTO;
import com.revature.models.User;
import com.revature.services.CarService;
import com.revature.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController //makes the class bean, turns all HTTP Response data into JSON
@RequestMapping("/cars") //all HTTP Requests ending in /cars will come to this Controller
@CrossOrigin //allow http from ALL ORIGINS (otherwise you'll get CORS error)
public class CarController {

    //autowire a CarService and a UserDAO (we need methods from both)
    private CarService cs;
    private UserService us;

    @Autowired
    public CarController(CarService cs, UserService us) {
        this.cs = cs;
        this.us = us;
    }

    //This method takes in Car data and sends it to the CarService
    //NOTE: ResponseEntity<Object> so we can send any type of object back in the response
    @PostMapping
    public ResponseEntity<Object> addCar(@RequestBody IncomingCarDTO newCar){

        //NOTE: moved the extra processing to the service layer

        //send the Car data to the service, saving the result to a variable
        Car c = cs.addCar(newCar);

        if(c == null){
            //if the User is not present, send back an error message (400)
            return ResponseEntity.status(400).body("Couldn't find User with ID: " + newCar.getUserId());
        }

        //otherwise, send a 201 (Created) and the Car data!
        return ResponseEntity.status(201).body(c); //send the car back in the response

    }

    //This method will return all cars in the HTTP Response
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        //let's make this a one liner just because we can
        return ResponseEntity.ok(cs.getAllCars());
    }

    //This method will delete a Car by its ID
    @DeleteMapping("/{carId}")
    public ResponseEntity<Object> deleteCarById(@PathVariable UUID carId){

        //TODO: probably wrapped in a try/catch assuming the service throws exceptions

        //delete the car thru the service
        cs.deleteCarById(carId);

        //return 200 and confirmation message
        return ResponseEntity.ok("Car with ID: " + carId + " was deleted");

    }

    //This method will return all Cars associates with a User ID
    @GetMapping("/{userId}")
    public ResponseEntity<List<Car>> getCarsByUserId(@PathVariable UUID userId){

        return ResponseEntity.ok(cs.getCarsByUserId(userId));

    }

}
