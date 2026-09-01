package com.revature.services;

import com.revature.DAOs.ReservationDAO;
import com.revature.DAOs.UserDAO;
import com.revature.DAOs.UserReservationDAO;
import com.revature.models.Reservation;
import com.revature.models.User;
import com.revature.models.UserReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    //Autowire the 3 DAOs we need to make a reservation
    private UserDAO userDAO;
    private ReservationDAO reservationDAO;
    private UserReservationDAO userReservationDAO;

    @Autowired
    public ReservationService(UserDAO userDAO, ReservationDAO reservationDAO, UserReservationDAO userReservationDAO) {
        this.userDAO = userDAO;
        this.reservationDAO = reservationDAO;
        this.userReservationDAO = userReservationDAO;
    }

    //Inserting a new reservation needs to:
        //-Make sure the UserId exists
        //-Insert into reservations
        //-Insert into user-reservations
    public Reservation makeReservation(Reservation reservation, Integer userId){

        //TODO: user input validation

        //Make sure the User exists - OR ELSE throw an exception
        User loggedInUser = userDAO.findById(userId).orElseThrow(() ->
            new IllegalArgumentException("You must be logged in to make a reservation!"));

        //Insert the Reservation and save it to a variable (cuz we need it for the UR)
        Reservation newRes = reservationDAO.save(reservation);

        //Use the User and Reservation to make a new UserReservation for the DB
        UserReservation newUserRes = new UserReservation(loggedInUser, newRes);
        userReservationDAO.save(newUserRes);

        //Return the new Reservation object (that's the most relevant thing to the user imo)
        return newRes;
    }


    //TODO: Add a User to an existing reservation---------------
    //The brute force way would be just make a new record in user-reservations with:
        //The id of the res to add a user to
        //the id of the user to add


    //update Reservation - this uses save() just like n insert, so how does Spring Data know to update?
    public Reservation updateReservation(int resId, Reservation newRes){

        //TODO: input validation

        //First, we need to get the Reservation in question from the DB
        Reservation existingRes = reservationDAO.findById(resId).orElseThrow(() ->
                new IllegalArgumentException("This Reservation Doesn't Exist!"));

        //This Reservation object is still TIED TO THE DB! Which is very convenient for us
        //Because we can just use the setters to change values, then save() the object back
        existingRes.setGroupSize(newRes.getGroupSize());
        existingRes.setLocation(newRes.getLocation());

        return reservationDAO.save(existingRes); //Send our updated Reservation back to the DB!

        //Spring is so smart - this res exists in the database already, so it knows save() is an update

    }



}
