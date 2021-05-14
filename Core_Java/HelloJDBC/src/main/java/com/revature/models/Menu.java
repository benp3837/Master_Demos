package com.revature.models;

import java.util.Scanner;

public class Menu {

	//All of the menu display options and control flow are contained in this method
	public void display() {
		
		boolean displayMenu = true; //this will toggle whether the menu continues after user input
		Scanner scan = new Scanner(System.in); //Scanner object to parse user input
		
		//pretty greeting :)
		System.out.println("Welcome to the Krusty Krab Employee Management System!");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		
		//display the menu options as long as displayMenu is true.
		while(displayMenu) {
			
			System.out.println("-----------------");
			System.out.println("CHOOSE AN OPTION:");
			System.out.println("-----------------");
			
			//menu options
			System.out.println("hi -> get greeted");
			System.out.println("exit -> exit EMS");
			
			//parse user input after they ponder menu options
			String input = scan.nextLine();
			
			//switch statement that takes the input and delivers the appropriate prompt
			switch(input) {
			
			case "hi": {
				System.out.println("um... hello.");
				break;
			}
				
			case "exit": {
				displayMenu = false;
				break;
			}
			
			//this default block will catch anything that doesn't match a menu option
			default: {
				System.out.println("What?");
				break;
			}
				
			
			}

			//eventually, the user input gets sent to the service layer or the application ends
			
			
			
		}
		
		System.out.println("Thank you for using the Krusty Krab EMS!");
		scan.close(); //close the Scanner
	}

	
}
