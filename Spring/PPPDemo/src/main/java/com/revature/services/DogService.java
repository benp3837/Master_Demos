package com.revature.services;

import com.revature.daos.DogDAO;
import com.revature.models.Dog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    //autowire a DogDAO
    private DogDAO dogDAO;
    DogService(DogDAO dogDAO) {
        this.dogDAO = dogDAO;
    }

    public List<Dog> getAllDogs() {
        return dogDAO.findAll();
    }

    public Dog getDogById(int id) {
        return dogDAO.findById(id).get();
    }

    public Dog addDog(Dog dog) {
        System.out.println(dog);
        return dogDAO.save(dog);
    }

}
