package com.revature.services;

import java.util.List;

import com.revature.daos.AvengerDAOHibernate;
import com.revature.daos.AvengerInterface;
import com.revature.daos.HomeDAOHibernate;
import com.revature.daos.HomeInterface;
import com.revature.models.Avenger;

//the service layer sits between the controller layer and dao layer
//we never want the web access layer to touch the database access layer
//there are also times where we may want to add more logic, and the service layer is a good spot for it. 
public class AvengersService {

	private AvengerInterface aDao = new AvengerDAOHibernate();
	//This is why we use interfaces btw. Refactoring projects becomes way easier.
	//I can SUPER easily switch between the regular DAOs and the Hibernate DAOs
	//Thanks Inheritance :)
	
	public List<Avenger> getAvengers() {
		return aDao.getAvengers(); //don't get confused! the two getAvengers methods aren't the same!
	}

	
	
	
}
