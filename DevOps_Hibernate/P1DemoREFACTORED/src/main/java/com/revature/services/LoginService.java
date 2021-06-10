package com.revature.services;

public class LoginService {

	public boolean login(String username, String password) {
		
		//I don't want to create a whole users table, so I'm just going to hardcode in a user/pass
		//Typically, you'll want to validate the given user/pass against some user/pass in the database.
		
		if(username.equals("coolUser") && password.equals("coolPassword")) { //validate user/pass
			return true;
		} 
		return false;
	}
}
