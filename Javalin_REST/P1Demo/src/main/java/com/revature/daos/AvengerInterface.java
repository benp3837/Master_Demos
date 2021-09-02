package com.revature.daos;

import java.util.List;

import com.revature.models.Avenger;

public interface AvengerInterface {

	public List<Avenger> getAllAvengers(); //return all the avengers from the database
	
	public Avenger getAvengerById(int id); //take in an int, find the avenger with that id
	
	public boolean addAvenger(Avenger avenger); //take in an Avenger object, put it in the database
	
	public boolean killAvenger(int id); //take in an int, delete the Avenger with that id
	
}
