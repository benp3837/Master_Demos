package com.revature.singleton;

//Using a singleton makes it so that only one instance of the Class can ever exist
//This ensures that all objects of the Class will be exactly the same.

//A big difference between a normal class and a singleton class is...
//To instantiate normal Classes, we use the constructor
//To instantiate Singletons, we use a getIinstance() method

public class Singleton {

	//static variable of type Singleton
	private static Singleton singleton = null;
	
	//String variable to help us demonstrate that there will only ever be one instance of this Singleton Class
	public String singletonMessage;
	
	//static method to create a (SINGLE) instance of our Singleton Class
	public static Singleton getInstance() {
		if(singleton == null) { //if there is no current instance of the Singleton...
			singleton = new Singleton(); //instantiate a new one
		}
		return singleton; //return the new (or previously existing) Singleton object
	}
	
	//private constructor (so only the Singleton Class can see it)
	private Singleton() {
		super();
		singletonMessage = "I'm the only possible instance of this Singleton Class!";
	}

	
	
}
