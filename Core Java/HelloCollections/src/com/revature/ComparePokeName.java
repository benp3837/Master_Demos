package com.revature;

import java.util.Comparator;

import com.revature.models.Pokemon;

//Implementing an interface is an example of INHERITANCE
public class ComparePokeName implements Comparator<Pokemon> {

	//Overriding a method is an example of POLYMORPHISM
	@Override
	public int compare(Pokemon o1, Pokemon o2) {
		System.out.println("The compare method is running for " + o1.getName() + " and " + o2.getName());
		//We want to sort the Pokemon by alphabetical order based on names
		return o1.getName().compareTo(o2.getName());
	}
	
}
