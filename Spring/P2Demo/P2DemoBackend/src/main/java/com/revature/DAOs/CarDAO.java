package com.revature.DAOs;

import com.revature.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//Check UserDAO for general notes on Spring Data DAOs
@Repository
public interface CarDAO extends JpaRepository<Car, UUID> {

    //Find all cars by User Id.
    //This custom method will need to dig into the Car's User, and find the ID
    public List<Car> findByUserUserId(UUID userId);

    //"UserUserId"???
    //This property expression tell spring data to dig into the User object to find the userId

}
