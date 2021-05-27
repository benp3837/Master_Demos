package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {
		
		//For compatibility with other technologies/frameworks will need to register our Driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//run -> run configurations -> environment -> add the appropriate url, password, username
		String url = System.getenv("url");
		String username = System.getenv("username");
		String password = System.getenv("password"); 
		
		return DriverManager.getConnection(url, username, password);
	}

//	public static void main(String[] args) {
//		
//		//Try with resources block. The try statement will stake a method that creates a resource, that will
//		//automatically be closed at the end of the try or catch block. It avoids the need for a finally block.
//		try(Connection conn = ConnectionUtil.getConnection()){
//			System.out.println("connection successful");
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}

	
}
