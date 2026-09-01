package com.revature.services;

import com.revature.DAOs.TacoDAO;
import com.revature.DAOs.UserDAO;
import com.revature.models.Taco;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacoService {

    //Autowire (constructor inject) our TacoDAO and UserDAO
    private final TacoDAO tacoDAO;
    private final UserDAO userDAO;

    @Autowired
    public TacoService(TacoDAO tacoDAO, UserDAO userDAO) {
        this.tacoDAO = tacoDAO;
        this.userDAO = userDAO;
    }

    //Insert Taco!
    public Taco insertTaco(Taco newTaco, Integer userId){

        //TODO: error handling, input validation

        //Need to get the User that this Taco belongs to from the DB
        User loggedInUser = userDAO.findById(userId).get();

        //TODO: talk about optionals instead of just get()ing the value

        //set the User in the Taco
        newTaco.setUser(loggedInUser);

        return tacoDAO.save(newTaco);

    }

}
