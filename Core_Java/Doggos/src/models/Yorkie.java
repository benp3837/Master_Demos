package models;

import models.Dog;

public class Yorkie extends Dog {

	String name;
	int weight = 10;
	
	@Override
	public void bark() {
		System.out.println("yip");
	}

	public Yorkie() {
	}

	public Yorkie(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

}
