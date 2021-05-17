package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This is what we'll use to manage our connection to the database
public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {
		
		//For compatibility with other technologies/frameworks will need to register our Driver
		//This process makes the application aware of what Driver class we're using
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		//these are no longer hardcoded!
		//I hid the secrets in the Environment variables!!!
		//Run -> Run Configuration -> Environment -> Then I created key value pairs for these credentials
		String url = System.getenv("url"); 
		String username = System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD"); 
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
}
