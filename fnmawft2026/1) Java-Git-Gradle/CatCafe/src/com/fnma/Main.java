package com.fnma;

import com.fnma.models.Cat;
import com.fnma.models.OrangeCat;

/* This CatCafe app will demonstrate Classes and Objects
-Fields and Methods
-Inheritance (Tabby extends Cat)
-Constructors
-Method Overloading/Overriding (Polymorphism)
*/
public class Main {

    public static void main(String[] args) {

        System.out.println("========================(Using Constructors)");

        //Instantiate (make) some new Cat objects. Remember objects are "instances" of Classes

        //Using the no-args constructor for all 3 cats. They'll all be Kav, 1
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();

        //Calling the fields and method
        System.out.println(cat1.name);
        System.out.println(cat2.age);
        System.out.println(cat3.eat());

        //These are 3 distinct objects, but they all have the same value
        System.out.println(cat1 == cat2); //false

        //Now, instantiate 3 cats with the all args constructor
        Cat cat4 = new Cat("Fluffy", 3);
        Cat cat5 = new Cat("Bugs", 2);
        Cat cat6 = new Cat("Stephen", 12);

        //Printing some fields and the method again
        System.out.println(cat4.name);
        System.out.println(cat5.age);
        System.out.println(cat6.eat());

        //let's use the Subclass of Cat - OrangeCat. Instantiation is exactly the same process
        OrangeCat bingus = new OrangeCat();
        System.out.println(bingus.eat()); //No args, so "Kav" is called here

        OrangeCat kitty = new OrangeCat("Kitty", 60, 200);
        System.out.println("Kitty has " + kitty.felonies + " felonies");

    }

}
