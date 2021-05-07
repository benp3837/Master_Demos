package com.revature;

import java.util.*; //This import gives us access to all of our Collections
//this is MEMORY INTENSIVE so if you wanted only one or two classes from .util, just import them specifically

import com.revature.models.Pokemon; //Import the Pokemon model so we can instantiate & use Pokemon objects

//Collections are like Arrays in that they are objects that hold things
//but specifically, they hold references to other objects

//unlike Arrays, collections can change size DYNAMICALLY
//there are MANY flavors of Collections, and we'll touch on some below

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("=======================================================(Lists)");
		
		//ArrayList is a very common implementation of the List interface
		List<Pokemon> myPokemon = new ArrayList<>(); //empty Arraylist
		
		//.add method can add elements to your Collection
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
			System.out.println(p.name + " is " + p.type + " type."); 
			//will print the names and types one by one
		}
		
		
		//explore some other List methods (could also go into documentation and read some)----------------------
		
		myPokemon.add(4, new Pokemon("Absol", "Dark")); //we can also .add elements at specific indexes
		
		System.out.println("The Pokemon at index 4 is: " + myPokemon.get(4)); 
		// .get(index) is how we specify a certain index in a List
		// NOTE: because of zero-indexing, Absol is at index 4, but it's technically 5th in the ArrayList
		
		System.out.println("The size of the pokemon ArrayList is: " + myPokemon.size()); 
		// .size() is analogous to .length for Arrays
		
		
		//creating two new Pokemon objects to experiment with
		//note that we haven't added either to the ArrayList!
		Pokemon pikachu = new Pokemon("Pikachu", "Electric");
		Pokemon duskull = new Pokemon("Duskull", "Ghost");
		
		//.contains checks if the List contains a certain object
		System.out.println(myPokemon.contains(pikachu)); //true - there's a pikachu object in the Arraylist
		System.out.println(myPokemon.contains(duskull)); //false - there's no duskull object though...
		
		
		//using a lambda to make the pokemon "fight"
		//forEach will loop through our collection and perform a given action FOR EACH element
		myPokemon.forEach(pokemon -> System.out.println(pokemon.name + " Attacked!"));
			

		//.remove will remove a specific element OR an element at a specific index,
		myPokemon.remove(pikachu); //goodbye Pikachu :(
		myPokemon.remove(4); //goodbye Gengar :(
		
		System.out.println("two Pokemon have fainted...");
		
		//using a lambda to see which pokemon remain
		//forEach will perform a given action FOR EACH element
		myPokemon.forEach(pokemon -> System.out.println(pokemon.name + " Remains")); 
		
		
		System.out.println("====================================================(Sets)");
		
		
		Set<Pokemon> myPokemonSet = new HashSet<>(); //HashSet is an implementation of Set interface
		
		//make sure to elaborate on how sets differ from lists when you add the elements below
		
		myPokemonSet.add(new Pokemon("Pikachu", "Electric"));
		myPokemonSet.add(new Pokemon("Mudkip", "Water/Ground"));
		myPokemonSet.add(new Pokemon("Charizard", "Fire"));
		myPokemonSet.add(new Pokemon("Charizard", "Fire")); //sets can't have duplicates
		myPokemonSet.add(new Pokemon("Gengar", "Ghost"));
		myPokemonSet.add(new Pokemon("Squirtle", "Water"));
		
		System.out.println(myPokemonSet); 
		//notice how the results aren't ordered! Sets are unordered. 
		//also notice how the duplicate record isn't shown

		for(Pokemon p : myPokemonSet) {
			System.out.println(p);
		}
		
		//remember, sets have no order... what happens when we try to use .get()?
		//myPokemonSet.get(4);
		
		System.out.println("=====================================================(Maps)");
			
		Map<String, Pokemon> trainers = new TreeMap<>();  
		
		trainers.put("Joey", new Pokemon("Ditto", "Normal"));
		trainers.put("Nancy", new  Pokemon("Squirtle", "Water"));
		trainers.put("Alex", myPokemon.get(3)); //getting the 3rd Pokemon from the ArrayList above!		
		
		System.out.println(trainers); //notice the default order given to the Map!!
		//Because TreeMaps niche is that they have sorted keys :)
		
		//Now let's use a map with an int as a key
		Map<Integer, Pokemon> pokemonIds = new TreeMap<>(); 
		//remember, Maps (and Collections in general) only take objects! So we need Integer, not int.
		
		pokemonIds.put(1, new Pokemon("Ditto", "Normal"));
		pokemonIds.put(2, new  Pokemon("Squirtle", "Water"));
		pokemonIds.put(3, myPokemon.get(3)); //getting the 3rd Pokemon from the ArrayList above!		
		
		//a way to perform Iterable functionality with maps
		for (Map.Entry<Integer, Pokemon> entry : pokemonIds.entrySet()) {
		    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}

		System.out.println("=====================================");
		
		//Let's sort our ArrayList alphabetically 
		
		//using the .sort method, providing an ArrayList and a Comparator as arguments
		Collections.sort(myPokemon, new ComparePokeName());
		
		for(Pokemon p : myPokemon) {
			System.out.println(p);
		}
		
		//reverse the alphabetical order that was to the ArrayList
		Collections.reverse(myPokemon);
		
		System.out.println("-----Now we've reversed the order-----");
		
		for(Pokemon p : myPokemon) {
			System.out.println(p);
		}
		
		
	}	
	
}
