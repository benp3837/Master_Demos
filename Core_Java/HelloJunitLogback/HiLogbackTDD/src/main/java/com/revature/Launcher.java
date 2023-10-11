package com.revature;

public class Launcher {

    public static void main(String[] args) {

        Greeter greeter = new Greeter();

        System.out.println(greeter.sendGreeting());

        System.out.println(greeter.greetWithName("Bon"));

        try{
            greeter.greetWithName("");
        } catch (IllegalArgumentException e){
            System.out.println("IllegalArgumentException Caught: " + e.getMessage());
        }

    }

}
