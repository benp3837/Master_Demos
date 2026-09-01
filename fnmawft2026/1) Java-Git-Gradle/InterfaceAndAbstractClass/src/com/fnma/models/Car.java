package com.fnma.models;

/*This is an Abstract Class, note the abstract keyword. It will implement the Vehicle Interface
So now, this Abstract Class also has access to the two abstracts methods in vehicle
Abstract Classes are Classes with AT LEAST one abstract method.

Why use an Abstract Class over an Interface?
-I use Abstract Classes when I KNOW I want to have methods that are defined.
-This causes all subclasses share the same default behavior for that method.

-I use Interfaces when I don't care about specific implementations of methods
-If I'm fine with every subclass implementing the methods differently, I'll use an Interface
-I mostly use Interfaces */
public abstract class Car implements Vehicle{

    //Notice how abstract Classes are JUST like concrete classes, but with 1+ abstract method

    public int wheels;
    public int doors;

    //abstract method - not every car will start the same way! So let's make it abstract
    //NOTE: public abstract is NOT implied in an abstract class
    public abstract void start();

    //concrete method (AKA implemented method, "regular" method)
    //every car will reverse the same way. So we can make this concrete
    public void reverse(){
        System.out.println("Car is reversing!");
    }

    //Abstract Classes AND Interfaces CAN'T BE INSTANTIATED. (Can't make objects out of them).
    //They're meant to be INHERITED by concrete classes that implement all of their abstract methods.

}
