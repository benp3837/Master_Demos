package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Entity
@Table(name = "cars")
@Component //make this class a Bean
public class Car {

    //Using UUIDs instead of int now!
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID carId;

    //We could have constraints in the following columns (make, model, 4wD), but I left them out

    private String make;

    private String model;

    //TODO: shouldn't have "is" in these boolean variable names
    private boolean isFourWheelDrive;

    /*Primary Key Foreign Key relationship! (Many to One relationship)

     fetch - defines whether the dependency (User) is eagerly or lazily loaded
        -eager: loads the dependency as soon as the app starts
        -lazy: loads the dependency as soon as it's called for (I've had trouble with this)

    @JoinColumn - defines the column that will be used to join the tables (PK of the User Class)
        -We have to supply the name of the PK that this FK is referring to.
        -We use the name of the CLASS field, not the DB column */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId") //reference to the PK in User
    private User user;

    //boilerplate code-------------------


    public Car() {
    }

    public Car(UUID carId, String make, String model, boolean isFourWheelDrive, User user) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.isFourWheelDrive = isFourWheelDrive;
        this.user = user;
    }

    public UUID getCarId() {
        return carId;
    }

    public void setCarId(UUID carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isFourWheelDrive() {
        return isFourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        isFourWheelDrive = fourWheelDrive;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", isFourWheelDrive=" + isFourWheelDrive +
                ", user=" + user +
                '}';
    }
}
