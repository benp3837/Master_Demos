package com.revature;

import java.util.Comparator;

import com.revature.models.Pokemon;

public class ComparePokeName implements Comparator<Pokemon> {

	@Override
	public int compare(Pokemon o1, Pokemon o2) {
		System.out.println("The compare method is running!");
		return o2.name.compareTo(o1.name);

	}

	
	
}
