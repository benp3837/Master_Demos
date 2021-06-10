package com.revature.daos;

import java.util.List;

import com.revature.models.Avenger;

public interface AvengerInterface {

	//we'll typically have at least one method for each CRUD operation (create, read, update, delete)
	//but we won't do updates in this demo. (just know that the insert/update/delete processes are pretty similar)
	
	public List<Avenger> getAvengers(); //this will return all our Avengers
	
	public Avenger getAvengerById(int id); //get one specific Avenger by their id
	
	public boolean addAvenger(Avenger a); //add an Avenger. Boolean instead of void so we can make sure it works
	
	public boolean killAvenger(int id); //delete an Avenger. We'll just use the unique identifier instead of an Avenger
	
}
