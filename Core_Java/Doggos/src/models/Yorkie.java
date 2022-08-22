package models;

import models.Dog;

public class Yorkie extends Dog {

	public String name;
	public int weight;
	
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
