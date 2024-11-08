package com.revature.services;

//Check UserService for general notes on Services

import com.revature.daos.PetDAO;
import com.revature.daos.UserDAO;
import com.revature.models.DTOs.IncomingPetDTO;
import com.revature.models.Pet;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //Makes a class a bean. Stereotype annotation.
public class PetService {

    //autowire the PetDAO with constructor injection so we can use the PetDAO methods
    private PetDAO pDAO;
    private UserDAO uDAO; //we also need some UserDAO methods!

    @Autowired
    public PetService(PetDAO pDAO, UserDAO uDAO) {
        this.pDAO = pDAO;
        this.uDAO = uDAO;
    }

    //This method takes in a new Pet object and inserts it into the DB
    public Pet addPet(IncomingPetDTO petDTO){

        //Another important role of the Service layer: data processing -
        //Turn the PetDTO into a Pet to send to the DAO (DAO takes Pet objects, not PetDTOs)

        //petId will be generated (so 0 is just a placeholder)
        //species and name come from the DTO
        //user will be set with the userId in the DTO
        Pet newPet = new Pet(0, petDTO.getSpecies(), petDTO.getName(), null);

        //Use the UserDAO to get a User by id
        Optional<User> u = uDAO.findById(petDTO.getUserId());

        /*findById returns an OPTIONAL... What does that mean?
         it will either hold the value requested, or it won't. This helps us avoid NullPointerExc.
         BECAUSE... we can't access the data if we don't use the .get() method
         Check out how it helps us write error handling functionality: */
        if(u.isEmpty()){
            throw new IllegalArgumentException("No user found with id: " + petDTO.getUserId());
        } else {
            //set the user object in the new Pet
            newPet.setUser(u.get()); //.get() is what extracts the value from the Optional

            //send the Pet to the DAO
            return pDAO.save(newPet);
        }

    }

    //This method gets all pets from the DB
    public List<Pet> getAllPets(){

        //not much error handling in a get all
        return pDAO.findAll();
    }

    //This method gets all pets by userId
    public List<Pet> getPetsByUserId(int userId){

        //TODO: error handling - incoming id, make sure user exists, make sure > 0 pets returned etc

        return pDAO.findByUserUserId(userId);

    }


}
