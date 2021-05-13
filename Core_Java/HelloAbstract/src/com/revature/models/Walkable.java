package com.revature.models;

public interface Walkable {

	//Interface fields are public, static, final by default.
	String unitOfMeasurement = "miles";
	
	//abstract method - no method body! AKA Not implemented!
	void move(int distance);

	//default concrete method (which we won't usually use in Interfaces)
	default void trip() {
		System.out.println("Oh no you fell :(");
	}
	
}
