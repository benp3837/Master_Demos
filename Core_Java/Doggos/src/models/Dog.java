package models;
//This was just me talking to Chani about how/why to use Abstract classes.
//This could have easily been an interface too, but we usually don't put concrete methods in interfaces.

public abstract class Dog {

	String name;
	int weight;
	
	public abstract void bark();
	
	//we want all dogs to share this functionality
	//So we made it a concrete method!
	//usually you'd only use abstract classes if you want some concrete functionality.
	public void sleep() {
		System.out.println("dog is sleeping");
	}

	public Dog() {
	}

	public Dog(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
}
