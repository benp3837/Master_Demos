package com.revature.daos;

import java.util.List;

import com.revature.models.Home;

public interface HomeInterface {

	public List<Home> getHomes();
	
	public Home getHomeByName(String name);
	
	public boolean addHome(Home home);
	
	public boolean destroyHome(String name);
	
}
