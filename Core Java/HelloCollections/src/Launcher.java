
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
		myPokemon.add(new Pokemon("Gengar", "Ghost"));
		myPokemon.add(new Pokemon("Squirtle", "Water"));
		
		//we can simply print out the contents of the List
		System.out.println(myPokemon);
		
		//and we can use an enhanced for loop to iterate over the data structure
		for(Pokemon p : myPokemon) {
			System.out.println(p.name + " is " + p.type); //print the names and types one by one
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
		myPokemon.remove(4); //goodbye Absol :(
		
		
		
		System.out.println("=====================================");
		
		
		Set<Pokemon> mySet = new HashSet<>(); //HashSet is an implementation of Set interface
		
		
		
		
		
		
		
		
	}	
	
}
