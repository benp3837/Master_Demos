package com.fnma.models;

/* This concrete Class extends the Car Abstract Class
Think of it as a more specific version of the Car Abstract Class
Since Car also implements the Vehicle Interface, AlfaRomeo is a Car AND a Vehicle
In other words, AlfaRomeo has inherited EVERY member from Car and Vehicle*/
public class AlfaRomeo extends Car {

    //one field unique to AlfaRomeo
    String logo = "An English flag looking thing next to a Dragon looking thing";

    //The app won't compile until AlfaRomeo has implemented ALL abstract methods it inherited
    //(go(), turn(), start())

    @Override
    public void start() {
        System.out.println("Press start on the steering wheel");
    }

    @Override
    public void go() {
        System.out.println("Mamma mia Imma starting the car");
    }

    @Override
    public void turn(int degrees) {
        System.out.println("Turning on a dime in Italy at " + degrees + " degrees");
    }

    //NOTE: Yes, we could make a method unique to AlfaRomeo


    //constructors -------

    //no-args
    public AlfaRomeo() {
        //(keeping logo the defined default)
        this.wheels = 4;
        this.doors = 4;
    }

    //all-args
    public AlfaRomeo(String logo, int wheels, int doors) {
        this.logo = logo;
        this.wheels = wheels;
        this.doors = doors;
    }
}
