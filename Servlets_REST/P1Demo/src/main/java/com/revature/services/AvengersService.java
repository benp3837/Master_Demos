package com.revature.services;

import java.util.List;

import com.revature.daos.AvengerDAO;
import com.revature.daos.AvengerInterface;
import com.revature.models.Avenger;

//the service layer sits between the controller layer and dao layer
//we never want the web access layer to touch the database access layer
//there are also times where we may want to add more logic, and the service layer is a good spot for it. 
public class AvengersService {

	private AvengerInterface aDao = new AvengerDAO();
	
	public List<Avenger> getAvengers() {
		return aDao.getAvengers(); //don't get confused! the two getAvengers methods aren't the same!
	}

	
	
}
