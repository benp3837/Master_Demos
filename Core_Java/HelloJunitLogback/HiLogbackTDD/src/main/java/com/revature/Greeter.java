package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Greeter {

    //Instantiate a Logger for our GreetingController
    private static final Logger logger = LoggerFactory.getLogger(Greeter.class);

    //this method gives the user a basic greeting
    public String sendGreeting(){

        //INFO log - general info about the application's runtime. Most logs are INFO logs
        logger.info("greeted the user!");

        return "Hey there!";
    }

    //this method greets the user based on the name they send in
    public String greetWithName(String name){

        if(name.equals("") || name.equals(null)){

            //warn logs typically warn against application misuses or potential malicious behavior
            logger.warn("Invalid name was inserted!");

            //just for some more variety in the tests we wrote
            throw new IllegalArgumentException("No name was included!");

        }

        //another standard info log
        logger.info("User entered a name of: " + name);

        return "Hello, " + name;
    }

}
