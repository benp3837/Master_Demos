package com.revature.daos;

import java.util.List;

import com.revature.models.Home;

public interface HomeInterface {

	public List<Home> getHomes();
	
	public Home getHomeByName();
	
	public boolean addHome();
	
	public boolean destroyHome();
	
}
