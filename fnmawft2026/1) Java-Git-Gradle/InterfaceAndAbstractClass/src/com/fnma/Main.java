package com.fnma;

import com.fnma.models.AlfaRomeo;

public class Main {

    public static void main(String[] args) {

        AlfaRomeo myCar = new AlfaRomeo();

        //Why can we instantiate an AlfaRomeo before defining a constructor??
        //It has a default no args constructor. This disappears as soon as we make our own

        //Here's an all-args alfaromeo
        AlfaRomeo myOtherCar = new AlfaRomeo("The BMW logo", 6, 6);

        //Let's just call some methods and remember where they came from

        myOtherCar.go(); //from the Vehicle interface, implemented in AlfaRomeo
        myOtherCar.turn(360); //from the Vehicle interface, implemented in AlfaRomeo
        myOtherCar.start(); //from the Car Abstract Class, implemented in AlfaRomeo
        myOtherCar.reverse(); //from the Car Abstract Class, implemented in Car

    }

}
