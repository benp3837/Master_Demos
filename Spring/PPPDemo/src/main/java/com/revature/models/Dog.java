package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "dogs")
@Component
public class Dog {

    //define instance variables: id, name, age, breed
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dogId;
    @Column(nullable = false)
    private String name;
    private int age;
    private String breed;

    //no args, all args, all args minus id constructor
    public Dog() {
        super();
    }

    public Dog(String name, int age, String breed) {
        super();
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public Dog(int dogId, String name, int age, String breed) {
        super();
        this.dogId = dogId;
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    //getters and setters
    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    //toString
    @Override
    public String toString() {
        return "Dog [dogId=" + dogId + ", name=" + name + ", age=" + age + ", breed=" + breed + "]";
    }

}
