package org.fnma.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Again, the @Component Stereotype annotation (1 of 4)
@Component
@Scope("prototype") //Now, we can have multiple instances of this bean!
public class Shoe {

    private int shoeId;
    private String shoeName;

    //Owner is a DEPENDENCY of SHOE.
    //With Spring, we can "wire" Spring Beans to inject dependencies on instantiation
    //@Autowired <- BAD PRACTICE! This autowiring works, but it breaks encapsulation
    private Owner owner;

    //boilerplate code-----------------------------------

    //no args, all args, JUST OWNER constructor, getters/setters, toString

    public Shoe() {
    }

    public Shoe(int shoeId, String shoeName, Owner owner) {
        this.shoeId = shoeId;
        this.owner = owner;
        this.shoeName = shoeName;
    }

    //Constructor injection! Best practice dependency injection
    //You'd just have a Constructor will all the necessary dependencies (just 1 in this case)
    @Autowired
    public Shoe(Owner owner) {
        this.owner = owner;
    }

    public int getShoeId() {
        return shoeId;
    }

    public void setShoeId(int shoeId) {
        this.shoeId = shoeId;
    }

    public Owner getOwner() {
        return owner;
    }

    //Setter Injection - usually only used if the dependency is optional
    //@Autowired
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "shoeId=" + shoeId +
                ", shoeName='" + shoeName + '\'' +
                ", owner=" + owner +
                '}';
    }


}
