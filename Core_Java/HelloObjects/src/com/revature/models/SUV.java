package com.revature.models;

//SUV extends car!! So what? Inheritance. (an OOP pillar)
//This means that the SUV class inherits all of the variables and methods of the Car class
//But it can also have its own variables and methods unique to the SUV class
//SUV is therefore a child class of Car. (Child/Parent relationship) (Subclass/Superclass relationship)
public class SUV extends Car{ 

	//SUV has all the fields of the Car class (tires, color, etc.)
	//But let's declare one more variable unique to the SUV class
	public int seats;
	
	//no args Constructor
	public SUV() {
		super(); //this will call the Car class's no args constructor
		System.out.println("In SUV's no args constructor");
	}

	//all args Constructor
	public SUV(int tires, String color, int maxSpeed, double fuelLevel, int seats) {
		super(tires, color, maxSpeed, fuelLevel); //calls Car class's all args constructor
		this.seats = seats;
		System.out.println("In SUV's all args constructor");
	}
	
	
	//here's a method unique to the SUV class
	public void offRoading() {
		System.out.println("You're driving in the dirt!!!");
	}
	
	
	//The SUV would have the same "drive" method as the Car class
	//But here, we declare the same method signature, with a different implementation (method body).
	//This is an example of METHOD OVERRIDING
	@Override
	public String drive(int speed) {
		return "You are going " + speed + " miles per hour in your SUV";
	}
	
}
