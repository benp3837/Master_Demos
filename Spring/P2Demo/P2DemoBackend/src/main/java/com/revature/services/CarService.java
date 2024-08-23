package com.revature.services;

import com.revature.DAOs.CarDAO;
import com.revature.DAOs.UserDAO;
import com.revature.models.Car;
import com.revature.models.DTOs.IncomingCarDTO;
import com.revature.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {

    //autowire a CarDAO and UserDAO
    private CarDAO cDAO;
    private UserDAO uDAO;

    @Autowired
    public CarService(CarDAO cDAO, UserDAO uDAO) {
        this.cDAO = cDAO;
        this.uDAO = uDAO;
    }

    //This method will take Car data from the Controller and send it to the DAO
    public Car addCar(IncomingCarDTO newCar){

        //TODO: error handling

        //We do need to build a Car object to send to the service... so we'll do that conversion
        //0 for id since it gets generated, null for User and we'll add it next
        Car car = new Car(null, newCar.getMake(), newCar.getModel(), newCar.isFourWheelDrive(), null);

        //use the DTO's userId field to get a User by its ID.
        Optional<User> u = uDAO.findById(newCar.getUserId());

        //Extract the optional if it exists
        if(u.isPresent()){
            car.setUser(u.get()); //assign the User to the Car
            Car c = cDAO.save(car); //save our Car to the DB
            return c;
        } else {
            return null;
        }

        /*Optional?? What's going on here?

         findById returns an Optional<Datatype>. What's the point?
         Optionals are often used to prevent NullPointerExceptions. The data may or may not exist
         In other words, the presence of our data is OPTIONAL.
         We can check if the value is present with .isPresent() method, and extract it with .get() */

    }

    //This method will return all the Cars in the DB from the DAO
    public List<Car> getAllCars(){
        return cDAO.findAll();
    }

    //This method will take in a Car ID and delete it through the DAO
    public void deleteCarById(UUID id){

        //First we need to get the Car by its id, for error handling AND for deletion
        //The car WILL NOT fully delete unless it's also deleted from the User's List<Car>

        //we're just gonna use .get() straight up this time (instead of Optional.isPresent())
        Car car = cDAO.findById(id).get();

        //delete the Car from the User's List<Car>
        car.getUser().getCars().remove(car);

        //now, perform the actual delete
        cDAO.deleteById(id);
    }

    //This method will take in an int and find Cars with that user ID from the DAO
    public List<Car> getCarsByUserId(UUID userId){

        //TODO: error handling, check for valid id, maybe check for empty return

        return cDAO.findByUserUserId(userId);

    }

    //Example method using @Transactional - for when you need a method to run as a SQL transaction

//    @Transactional
//    public Car tradeCar(int x int y int z){
//
//        dao.updatecar
//
//        dao.updatecarsomeotherway
//
//        dao.sendcarsomewhereelse
//
//        dao.deletecar
//
//        dao.savenewcar //What if this fails here? Without @Transactional, you'd lose a car for nothing
//
//    }

}
