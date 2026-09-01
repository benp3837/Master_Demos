package com.fnma;

import com.fnma.models.Cat;
import com.fnma.models.Dog;
import com.fnma.models.Snake;

public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();
        Cat c = new Cat();
        Snake s = new Snake();

        System.out.println("------Dog------");
        d.makeNoise();
        d.walk();
        d.eat();

        System.out.println("------Cat------");
        c.makeNoise();
        c.walk();
        c.eat();

        System.out.println("------Snake------");
        s.makeNoise();
        s.walk();
        s.eat();

    }

}
