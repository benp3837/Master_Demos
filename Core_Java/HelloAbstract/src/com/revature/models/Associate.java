package com.revature.models;

//Associate extends Person, think of it like a more specific implementation of a generic Person type
public class Associate extends Person{

	public String batch;
	
	//no args Constructor
	public Associate() {
		super();
	}

	//all args Constructor (notice the variables of Person)
	public Associate (String name, int age, String batch) {
		super(name, age); //call the parent class Constructor
		this.batch = batch; //then initialize the Associate-specific field
	}

	@Override //Overriding the Abstract method in the Person Class
	public String talk(String words) {
		//Super will allow access to parent's fields and methods in the child class. 
		return super.name+" is saying '"+words+".'";
	}
	
	//We can access the unitOfMeasurement field from allll the way in the Walkable Interface
	//because the Person Class inherits by by implementing Walkable
	public void move(int i) {
		System.out.println("I walked "+i+" "+unitOfMeasurement+" today");
	}
	
	
}
