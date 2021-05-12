package com.revature.models;

//This is an abstract class, that will also implement our interfaces (Hence inheriting their functionality)
public abstract class Person implements Walkable, Joggable {

	public String name;
	public int age;
	
	//Now, you can show them how to use the shortcuts for constructors.
	
	//No args Constructor
	public Person() {
		super();
	}
	
	//All args Constructor
	public Person (String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//concrete method
	public void breathe() {
		System.out.println("hoo hah hoo hah hoo hah");
	}

	//abstract method. If a Class has any abstract methods, it must be declared Abstract
	public abstract String talk(String words);
	

	//show the duplicate default method problem before fixing it with:
	
	//Override the trip method of the Joggable Interface (could have overridden Joggable or Walkable).
	@Override
	public void trip() {
		// TODO Auto-generated method stub
		Joggable.super.trip();
	}
	
}
