package com.fnma;

import com.fnma.models.DrMario;

public class Main {

    public static void main(String[] args) {

        //Instantiate a Dr. Mario object
        DrMario player1 = new DrMario();

        //use getter/setter
        System.out.println(player1.getStethoscopeBrand());

        player1.setStethoscopeBrand("Cardionics");

        System.out.println(player1.getStethoscopeBrand());

        //Here's our dinky example of Abstraction (A Pillar of OOP)
        //Nobody NEEDS to know how superSmash() method was implemented
        //The name is descriptive enough that we can call and trust that it fires the super smash
        player1.superSmash();


    }

}
