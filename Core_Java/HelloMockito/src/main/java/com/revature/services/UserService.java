package com.revature.services;

import com.revature.models.User;
import com.revature.daos.UserDAOInterface;

//we haven't really talked much about service classes
//but they sit between the controllers and DAOs, and contain extra business logic
//for instance validating inputs (is the incoming data valid? etc.)
public class UserService {

	private UserDAOInterface dao;
	
	public UserService(UserDAOInterface dao) {
		super();
		this.dao = dao;
	}

	public User loginWithId(int id, String password) {
		User u = dao.findById(id);

		try {
			System.out.println(u);
		if (u.getPassword().equals(password)) {
			return u;
		}} catch (Exception e) {
			System.out.println("oops...");
		}
		return null;
	}

	public User loginWithName(String name, String password) {
		User u = dao.findByUsername(name);
		
		try {
			System.out.println(u);
		if (u.getPassword().equals(password)) {
			return u;
		}
		} catch (Exception e) {
			System.out.println("oops...");
		}
		return null;
	}

}
