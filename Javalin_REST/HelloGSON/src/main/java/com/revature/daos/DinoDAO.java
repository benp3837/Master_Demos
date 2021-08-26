package com.revature.daos;

import com.revature.models.Dinosaur;

//usually, we'll have a DinoDAOInterface that this DinoDAO implements. But this is just to show Jackson
public class DinoDAO {
		
	//here's an array with all our dinos. Usually this data would be in the DATABASE. Think of this like a mock database
	private Dinosaur[] dinoArray= {
			new Dinosaur(1, "chicken", 2, 4.3, true),
			new Dinosaur(2, "triceratops", 4, 6000.3, true),
			new Dinosaur(3, "T-Rex", 2, 10595.8, true),
			new Dinosaur(4, "velociraptor", 2, 7.7, true)
	};

	public Dinosaur[] getAllDinos() {
		return dinoArray;
	}
	
	public Dinosaur getDinoById(int id) {
		return dinoArray[id-1]; //remember, arrays are 0 indexed. So we have to subtract the given id by 1.
	}
	
	//as we know, Arrays are fixed in size. So what if we want to add a new dino? (Well we should've used an ArrayList...)
	//an ugly workaround will be to just create a new array with the existing and new values
	//then we can assign the original dinoArray to this new array
	public void inputDino(Dinosaur dino) {
		Dinosaur[] newArr = new Dinosaur[dinoArray.length+1]; //length of dinoArray plus one spot for the new dino
		
		for(int i = 0; i<dinoArray.length; ++i) {
			newArr[i] = dinoArray[i]; //populate the new array with the existing array (note this leaves one null spot)
		}
		
		dino.setId(newArr.length); //clever hehe, this will "autogenerate" the new dino id using the length of newArr.
		
		newArr[dinoArray.length] = dino; //insert the new dino into the last index, which was null til now.
		
		dinoArray = newArr; //assign the OG dinoArray variable to this newArr.
}
	
}
