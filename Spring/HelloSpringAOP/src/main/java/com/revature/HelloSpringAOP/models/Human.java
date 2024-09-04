package com.revature.HelloSpringAOP.models;

import org.springframework.stereotype.Component;

//3 variables, all our boilerplate code, and a method called eat
@Component
public class Human {


    private String name;
    private int age;
    private String occupation;


    public String eat(int calories) {

        if(calories > 5000){
            throw new IllegalArgumentException("Too many calories you're gonna explode!");
        }

        return name + " is eating " + calories + " calories";
    }


    //boilerplate----------------------------

    public Human() {
        super();
    }

    public Human(String name, int age, String occupation) {
        super();
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
