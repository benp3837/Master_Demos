package com.fnma.models;

//This Class is meant to MODEL a Cat - think of it like a "model" or "blueprint" for Cat objects
//This Class defines attributes (fields/variables) and behaviors (methods) of Cats
public class Cat {

    //Declare some Cat fields - every Cat object will have these attributes
    public String name;
    public int age;

    //Declare a method for Cat - something all cats can do
    public String eat(){
        return this.name + " is eating frozen salmon";
    }

    /* Method Disambiguation

     public - the Access Modifier. Public means this is accessible throughout the app
     String - the Return Type. This method must output a String value when it completes
     eat() - the Name and Arguments. This method takes no extra values, so it has (no args)
     */


    //Constructors below-------------------------

    /* Remember, constructors are how we give values to the object's variables
    When we instantiate an object, we use a constructor depending on what values we want it to have
    Constructors will be public and the same name as the Class but no return type */

    //no-args Constructor. They take no arguments.
    //Typically used when we want an object with default values
    public Cat(){
        this.name = "Kav";
        this.age = 1;
    }

    //all-args Constructor. This takes all possible arguments for Cat
    //This lets us instantiate a Cat with whatever values we want
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    //Yes, we can have a "some args" constructor, where some values are default and some are passed in


    /* These constructors are an example of METHOD OVERLOADING
    They have the same names, but different amount, type, or order of parameters (arguments)
    This is one example of POLYMORPHISM (a pillar of OOP)
    "Same thing, different form", these constructors share the same name, but do different things. */


}
