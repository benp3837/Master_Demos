package com.revature;

import com.revature.models.Car;
import com.revature.models.Menu;

//We're going to create a CLI (command line interface) application
//the user can enter inputs into a menu displayed on the console, and make stuff happen in the application
public class Launcher {


	public static void main(String[] args) {
		
		//create a Menu object
		Menu menu = new Menu();
		
		//use the Menu's display method to display a menu
		menu.display();
		
		//Really clean main method! The power of Abstraction >:)
		//all the complicated Menu logic is hidden in the Menu class.
		
	}
	
	
}
