package com.fnma.models;

/*OrangeCat extends Cat... So what?

First of all, this is a primary example of INHERITANCE in Java (one of the pillars of OOP)
This means that the OrangeCat Class has everything the Cat Class has (fields/methods)
BUT, it can also have its own unique fields and methods
OrangeCat therefore is a child class of Cat. In other words, subclass/superclass relationship

We could make yet another Class that extends OrangeCat, which would give it everything from both Classes*/
public class OrangeCat extends Cat{

    //OrangeCat has all the members of Cat, but let's give it some unique ones

    public int felonies;

    //A bit different from the eat() method in Cat. This one has no return type (void) and it takes one arg
    public void bite(String victim){
        System.out.println(this.name + " just bit " + victim);
    }

    /*METHOD OVERRIDING - we are taking the original eat() method from Cat, and changing what it does
    This is something that's ONLY done by a Child Class changing a Parent Class

    Yes, we could have kept eat() exactly the same. That's fine.
    But we'll often override methods to make them more specific to the Child Class

    This is an example of POLYMORPHISM (another pillar of OOP) */
    @Override
    public String eat(){
        return this.name + " is absolutely destroying the bowl";
    }

    //Constructors

    //Check the Cat Class for an explanation on what Constructors are
    //SHORTCUT: right click -> generate -> constructor

    //no-args
    public OrangeCat() {
        super(); //This is a call to the parent's no-args constructor!
        this.felonies = 10;
    }

    //all-args
    public OrangeCat(String name, int age, int felonies) {
        super(name, age); //Again, a call to the parent constructor (all-args this time)
        this.felonies = felonies;
    }
}
