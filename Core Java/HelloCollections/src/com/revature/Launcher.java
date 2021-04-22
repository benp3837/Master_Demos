package com.revature;

import java.util.*; //This import gives us access to all of our Collections

import models.Pokemon; //Import the Pokemon model so we can instantiate & use Pokemon objects

//Collections are like Arrays in that they are objects that hold things
//but specifically, they hold references to other objects

//unlike Arrays, collections can change size DYNAMICALLY
//there are MANY flavors of Collections, and we'll touch on some below

public class Launcher {

	public static void main(String[] args) {
		
		List<Pokemon> myPokemon = new ArrayList<>(); //ArrayList is an implementation of List interface
		
		myPokemon.add(new Pokemon("Pikachu", "Electric"));
		myPokemon.add(new Pokemon("Mudkip", "Water/Ground"));
		myPokemon.add(new Pokemon("Charizard", "Fire"));
		myPokemon.add(new Pokemon("Charizard", "Fire")); //lists can have duplicates
		myPokemon.add(new Pokemon("Gengar", "Ghost"));
		myPokemon.add(new Pokemon("Squirtle", "Water"));
		
		//we can simply print out the List
		System.out.println(myPokemon);
		
		//and we can use an enhanced for loop to iterate over the data structure
		for(Pokemon p : myPokemon) {
			System.out.println(p.name + " is " + p.type + " type."); //print the names and types one by one
		}
		
		
		//explore some other List methods (could also go into documentation and read some)----------------------
		
		myPokemon.add(4, new Pokemon("Absol", "Dark")); //we can also .add elements at specific indices
		
		System.out.println(myPokemon.get(4)); // .get(index) is how we specify a certain index in a List
		
		System.out.println(myPokemon.size()); // .size() is analogous to .length for Arrays
		
		
		//creating two new Pokemon objects to experiment with
		Pokemon pikachu = new Pokemon("Pikachu", "Electric");
		Pokemon duskull = new Pokemon("Duskull", "Ghost");
		
		//.contains checks if the List contains a certain object
		System.out.println(myPokemon.contains(pikachu)); 
		System.out.println(myPokemon.contains(duskull)); 
		
		//forEach will perform a given action FOR EACH element
		myPokemon.forEach(pokemon -> System.out.println(pokemon.name + " Attacked!")); 

		//.remove will remove an element at a specific index, OR a specific element
		myPokemon.remove(pikachu); //goodbye Pikachu :(
		myPokemon.remove(4); //goodbye Gengar :(
		
		System.out.println("two Pokemon have been removed...");
		
		myPokemon.forEach(pokemon -> System.out.println(pokemon.name + " Remains")); 
		
		
		System.out.println("=====================================");
		
		
		Set<Pokemon> myPokemonSet = new HashSet<>(); //HashSet is an implementation of Set interface
		
		//make sure to elaborate on how sets differ from lists when you add the elements below
		
		myPokemonSet.add(new Pokemon("Pikachu", "Electric"));
		myPokemonSet.add(new Pokemon("Mudkip", "Water/Ground"));
		myPokemonSet.add(new Pokemon("Charizard", "Fire"));
		myPokemonSet.add(new Pokemon("Charizard", "Fire")); //sets can't have duplicates
		myPokemonSet.add(new Pokemon("Gengar", "Ghost"));
		myPokemonSet.add(new Pokemon("Squirtle", "Water"));
		
		System.out.println(myPokemonSet); //notice how the results aren't ordered! Sets are unordered. 
		//also notice how the duplicate record isn't shown

		for(Pokemon p : myPokemonSet) {
			System.out.println(p);
		}
		
		//do some more with sets or we good?
		
		System.out.println("=====================================");
		
		
		Map<String, Pokemon> trainers = new TreeMap<>(); 
		
		
		trainers.put("Brittany", new Pokemon("Ditto", "Normal"));
		trainers.put("Nancy", new  Pokemon("Squirtle", "Water"));
		trainers.put("Elizabeth", new Pokemon("Magneton", "Electric"));
		trainers.put("Alex", myPokemon.get(3)); //getting the 3rd Pokemon from the ArrayList above!		
		
		System.out.println(trainers); //notice the default order given to the Map!!
		//Because TreeMaps niche is that they have sorted keys :)
		
	}	
	
}
