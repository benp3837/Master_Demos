package models;

import models.Dog;

public class Greyhound extends Dog {

	public String name;
	public int weight;
	
	
	@Override
	public void bark() {
		System.out.println("BOOF");
	}

	public Greyhound() {
	}

	public Greyhound(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}


}
