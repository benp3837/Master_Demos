package com.revature.models;

//Let them choose the object we work with - 
//as long as it can have a similar relationship to Car/CarDealership

//Remember - in your Project 0, the CarDealership will be the database and the Cars will be pieces of data
//We're hardcoding data for now, since we haven't learned SQL yet.
public class Car {

	int carId; //We'll use this to uniquely identify each car.
	int tires = 4; //we can assume all cars have 4 tires by default
	String color;


	
	//Constructors and toString method below---------
	
	//no args constructor
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args except carId constructor (will be useful for adding Cars)
	public Car(int tires, String color) {
		super();
		this.tires = tires;
		this.color = color;
	}

	//all args constructor
	public Car(int carId, int tires, String color) {
		super();
		this.carId = carId;
		this.tires = tires;
		this.color = color;
	}


	//The toString method allows us to print an object and its fields.
	//Without this method, trying to print a car would print something like com.revature.models.Car@26f0a63f
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", tires=" + tires + ", color=" + color + "]";
	}
	
	
	
}
