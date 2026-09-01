package com.fnma.models;

public abstract class Character {

    //shield (concrete method)
    public void shield(){
        System.out.println("Raising Shield!");
    }


    //superSmash (abstract method)
    public abstract void superSmash();

}
