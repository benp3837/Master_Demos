package com.fnma.models;

public class Snake implements Animal{

    @Override
    public void makeNoise() {
        System.out.println("sssssss");
    }

    @Override
    public void walk() {
        System.out.println("*slither*");
    }

    @Override
    public void eat() {
        System.out.println("GULP");
    }

}
