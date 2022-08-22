package com.revature;

import models.Greyhound;
import models.Yorkie;

public class Launcher {

    public static void main(String[] args) {

        //instantiate one of each dogs, and print out a statement that indicates their names and weights

        Greyhound g = new Greyhound("big", 100);

        System.out.println(g.name + " weighs " + g.weight + " pounds ");

        Yorkie y = new Yorkie("pip", 10);

        System.out.println(y.name + " weighs " + y.weight + " pounds ");

        //let the dogs bark
        g.bark();
        y.bark();

        //let the dogs sleep
        g.sleep();
        y.sleep();

        //as you can see, both dogs inherit the concrete sleep method from the Dog abstract class
        //thus, they sleep the same way (though we could have still overridden the sleep() method for each dog)

        //the dogs have two different implementations of the bark() method though -- they're overridden.

        //what is the example of method overriding that we saw in this demo?

        //the constructors! every Dog has two constructors with the same name that take different parameters.

    }

}
