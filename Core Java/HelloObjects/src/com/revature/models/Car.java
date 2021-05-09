package com.revature.models;

//This is a Car class 
//It defines all the variables (attributes) and methods (behaviors) I want a Car object to have

public class Car {

	//Declaring some Car variables
	public int tires;
	public String color;
	public int maxSpeed; 
	public double fuelLevel;

	
	//Some Constructors below----------------------------------------------------------------------
	
	//Remember, constructors are special methods that initialize the object
	//In order words, they give values to the object's variables
	
	//No args constructor
	//If you create a Car object without arguments, this no args constructor will be called
	//Essentially providing default values to the Car object's fields.
	public Car() {
		super(); //The parent class of Car is Object (more on this later) 
				 //thus, this super(); calls the no args constructor of the Object class
		this.tires = 4;
		this.color = "white";
		this.maxSpeed = 90;
		this.fuelLevel = .25;
		System.out.println("Inside the no args constructor");
	}
	
	
	//Constructor with some (not all) arguments
	public Car(int tires, String color) {
		//super(); is not technically required, since it'll get called implicitly
		//but it's good practice to have an explicit call to super
		this.tires = tires;
		this.color = color;
		this.maxSpeed = 100;
		this.fuelLevel = .7;
		System.out.println("In the (int, String) constructor");
	}
	
	//Constructor with the same arguments as above, but in a different order!
	public Car(String color, int tires) {
		super();
		this.tires = tires;
		this.color = color;
		this.maxSpeed = 90;
		this.fuelLevel = .5;
		System.out.println("In the (String, int) constructor");
	}


	//All args Constructor
	public Car(int tires, String color, int maxSpeed, double fuelLevel) {
		//this calls the 2-args Constructor above (Constructor chaining!)
		this(tires, color); 
		//then these two will call the instance or class scoped variables like usual
		this.maxSpeed = maxSpeed;
		this.fuelLevel = fuelLevel;
		System.out.println("In the all args constructor");
	}
	
	
	
	//Notice!!! These 4 constructors have the same names, but different arguments
	//This is METHOD OVERLOADING
	
	
	//Let's also give the Car class a method-------------------
	
	//This method will return a String. We do so with the "return" keyword
	public String drive(int speed) {
		return "You are going " + speed + " miles per hour in your Car";
		//note that this isn't a System.out.println!!
		//we'll see how return types work when we call this method in the Launcher.
	}
	
	//Let's use this method as a quick review on method components:
	
	//access modifier (public)
	//non-access modifier (none in this method)
	//method name (drive)
	//parameters (an int called speed)
	
}
