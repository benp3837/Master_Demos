package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		//this might just get removed for Tim's HelloStrings instead
		
		System.out.println("===============================================(Something)");
		
		//Remember, Strings AREN'T primitives.
		//The Strings we're working with are objects/instantiations of the String Class
		
		String greeting = "Hello There"; //store a String in a variable called "greeting"
		
		System.out.println(greeting); //print the value of the variable
		
		String myName = "Ben";
		
		System.out.println("My name is " + myName); //we can use the + operator to concatenate Strings
		
		System.out.println(greeting + myName); //concatenating two variables of String type
		System.out.println(greeting + " " + myName); //cleaner version of the above line, include a space
		
	}
	
}
