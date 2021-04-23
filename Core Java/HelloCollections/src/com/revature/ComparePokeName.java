package com.revature;

import java.util.Comparator;

import com.revature.models.Pokemon;

public class ComparePokeName implements Comparator<Pokemon> {

	@Override
	public int compare(Pokemon o1, Pokemon o2) {
		System.out.println("The compare method is running for " + o1.name + " and " + o2.name);
		//We want to sort the Pokemon by alphabetical order based on names
		return o1.name.compareTo(o2.name);
	}
	
}
