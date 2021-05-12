package com.revature.throwables;

@SuppressWarnings("serial") //unnecessary, but if you really hate yellow warning squigglies go ahead
public class MyError extends Error {

	//Constructor for MyError class
	//will be exactly the same as the constructor in Error, hence super(); and nothing else
	public MyError() {
		super();
	}
	
	//Another Constructor for MyError
	//this one accepts a message to display. There's a Constructor like this in Error too
	public MyError(String arg) {
		super(arg);
	}
	
	//worth opening declaration for Error to show them the super(); that each of these constructors call
	
}
