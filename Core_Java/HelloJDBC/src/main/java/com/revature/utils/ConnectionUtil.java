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
				
		//these are hardcoded... which is horrible practice.
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=krusty_krab"; 
		String username = "postgres";
		String password = "Sparky2014!!"; 
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
}
