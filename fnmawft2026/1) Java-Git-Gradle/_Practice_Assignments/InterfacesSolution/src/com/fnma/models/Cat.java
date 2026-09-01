package com.fnma.models;

public class Cat implements Animal{

    @Override
    public void makeNoise() {
        System.out.println("mew");
    }

    @Override
    public void walk() {
        System.out.println(".....");
    }

    @Override
    public void eat() {
        System.out.println("lick lick");
    }

}
