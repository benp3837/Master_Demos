package com.revature.controllers;

import com.revature.models.Reservation;
import com.revature.services.ReservationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(value = {"my-s3-bucket", "my-localhost-app"})
public class ReservationController {

    //Autowire the service
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> makeReservation(@RequestBody Reservation reservation, HttpSession session){

        //Extract User Id from the session
        Integer userId = (Integer) session.getAttribute("userId");

        //Call the service, sending it the new Res and the ID of the logged in User
        Reservation newRes = reservationService.makeReservation(reservation, userId);

        return ResponseEntity.status(201).body(newRes);

    }

    @PutMapping("/{resId}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable int resId, @RequestBody Reservation newRes){

        //TODO: login verification (probably just try to get logged In ID and see if it exists)
        //More robust checks would make sure the updated rez info is valid

        Reservation updatedRes = reservationService.updateReservation(resId, newRes);

        return ResponseEntity.ok().body(updatedRes);

    }


    //error handling-----------
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<String> handleNotLoggedIn(Exception e){
        return ResponseEntity.badRequest().body("Must log in to do this!");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e){
        //Return a bad request (400) with the Exception message
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
