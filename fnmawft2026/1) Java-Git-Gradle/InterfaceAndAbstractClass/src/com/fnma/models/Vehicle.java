package com.fnma.models;

/*This is an Interface, which can contain fields and abstract methods (methods with no method bodies)
  The fields can be initialized or uninitialized, but the methods are abstract (usually)
  Interfaces are meant to be implemented by Classes, which give functionality to the abstract methods
  The reason Interfaces are called "contracts" is that implementing Classes MUST define the method bodies*/
public interface Vehicle {

    //We could put fields here, but I don't usually have any in an Interface

    //Abstract method - no method body! public abstract by default
    void go();

    //Another one - this one takes a parameter
    void turn(int degrees);

    /* Every vehicle should be able to go and turn

    This interface sets that rule, but DOESN'T force subclasses of vehicle to go or turn in specific ways
    We can make subclasses of Vehicle (Car, Boat, Plane), and they'll all go and turn in different ways.

    The job of an Interface is to lay out WHAT subclasses do, but not HOW they do it.
    And it's also a good way to organize. A way to quickly reference what a subclass can do */

}
