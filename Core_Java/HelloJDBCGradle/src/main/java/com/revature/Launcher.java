package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu;
import com.revature.utils.ConnectionUtil;


//we're going to create a CLI (command line interface) application
//the user can enter inputs into a menu on the console, and make stuff happen!
public class Launcher {

	public static void main(String[] args) {
		
		
		//here we're just testing whether our connection (from the ConnectionUtil class) is working
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("connection successful");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		//Now for the actual functionality of the CLI application------------
		
		
		//Create our menu object
		Menu menu = new Menu();
		
		//use the Menu's display method to use the menu
		menu.display();
		
		
		//really clean main method right? Power of abstraction ;)
		//all the complicated menu display logic is hidden in the Menu class
		
		

		
	}
	
}
