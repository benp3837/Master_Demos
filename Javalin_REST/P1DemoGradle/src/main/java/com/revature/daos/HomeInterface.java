package com.revature.daos;

import java.util.List;

import com.revature.models.Home;

public interface HomeInterface {

	public List<Home> getAllHomes(); //return a List of all Homes in the database
	
	public Home getHomeByName(String name); //take in a String, return the Home with that name
	
	public boolean addHome(Home home); //take a home object, put it in the database
	
	public boolean destroyHome(String name); //take in a String, delete the Home with that name
	
}
