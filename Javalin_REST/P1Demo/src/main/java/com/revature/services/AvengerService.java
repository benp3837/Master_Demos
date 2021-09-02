package com.revature.services;

import java.util.List;

import com.revature.daos.AvengerDAO;
import com.revature.daos.AvengerInterface;
import com.revature.models.Avenger;

//The service layer sits between the controller layer and the dao layer
//we never want the web access layer (the servlets and controllers) to touch the database access layer
//there are also time were we want to add more logic, like input validation, and the service is a great place for it
public class AvengerService {

	//instantiate an AvengerDAO to use it's method
	private AvengerInterface aDAO = new AvengerDAO();
	
	//create a method that sends the DAO data up to the controller (this method will be called by the controller)
	public List<Avenger> getAllAvengers() {
		return aDAO.getAllAvengers();
	}
	//literally all we're doing here is calling the method of the dao in order to get the List of Avengers
	
}
