package com.fnma.models;

public class Dog implements Animal {
    @Override
    public void makeNoise() {
        System.out.println("bork");
    }

    @Override
    public void walk() {
        System.out.println("click click click");
    }

    @Override
    public void eat() {
        System.out.println("SNORFFKDSLASDLKJDSLKSDFLKDJL");
    }
}
