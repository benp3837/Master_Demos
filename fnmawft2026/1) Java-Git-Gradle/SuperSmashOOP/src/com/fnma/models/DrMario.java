package com.fnma.models;

// DrMario extends Character - This is INHERITANCE (one of the 4 pillars of OOP)
public class DrMario extends Character{

    //PRIVATE field - only accessible in this class... unless we use getters/setters
    //1/2 of ENCAPSULATION (one of the pillars of OOP)
    private String stethoscopeBrand;

    //Not overriding the shield() method. It's fine as is

    //Overriding methods is yet another form of Polymorphism (A pillar of OOP)
    @Override
    public void superSmash() {
        System.out.println("Dr. Mario shoots very big pills from his hand");
    }


    //boilerplate code -------------------------------------

    /*2 Constructors - one no-args and one all-args

    This is an example of method overloading (same method name, different params)
    method overloading is an example of POLYMORPHISM (one of the 4 pillars of OOP)*/
    public DrMario() {
    }

    public DrMario(String stethoscopeBrand) {
        this.stethoscopeBrand = stethoscopeBrand;
    }

    //GETTERS AND SETTERS - boilerplate methods that let you GET or SET private variables
    //(The other half of ENCAPSULATION - one of the pillars of OOP)
    public String getStethoscopeBrand() {
        return stethoscopeBrand;
    }

    public void setStethoscopeBrand(String stethoscopeBrand) {
        this.stethoscopeBrand = stethoscopeBrand;
    }
}
