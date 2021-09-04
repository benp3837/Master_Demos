package com.revature.services;

public class LoginService {

	public boolean login(String username, String password) {
		
		//Hardcoding user/pass because I don't want to create a whole users table to check username/password
		//Plus I have to hold your hands less as we get new projects, so I don't want to give you all the keys here
		
		//Typically, you'll want to validate the given username/password against some username/password in the DB.
			//How would we do this? You'd send the username and password from the LoginService to some DAO method
			//That DAO method would check to see if there is a user with that username/password pair
			//"select the row from the users table where username is demoMan and password is password"
				//If something valid is returned, you know that a valid username/password was sent in
		
		if(username.equals("demoMan") && password.equals("password")) {
			return true;
		}
		
		return false;
	}

}
