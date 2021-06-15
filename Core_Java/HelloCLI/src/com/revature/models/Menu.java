package com.revature.models;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

	//Instantiate a CarDealership object so that we can use CarDealership methods.
	//We'll call different CarDealership methods depending on what menu option the user chooses.
	CarDealership cd = new CarDealership();
	
	//All of the menu display options and control flow are contained in this method
	//Based on user input, this menu will execute certain functionality
	public void display() {
		
		boolean displayMenu = true; //this will toggle whether the menu continues after user input
		Scanner scan = new Scanner(System.in); //Scanner object to parse user input
		
		//pretty greeting :)
		System.out.println("Welcome to the Car Dealership!");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		
		//display the menu options as long as displayMenu is true.
		while(displayMenu) {
			
			System.out.println("-----------------");
			System.out.println("CHOOSE AN OPTION:");
			System.out.println("-----------------");
			
			//menu options
			System.out.println("hi -> get greeted");
			System.out.println("cars -> show all car");
			System.out.println("carById -> get a car by it's id");
			System.out.println("addCar -> add a car");
			System.out.println("carsByColor -> show cars of certain colors");
			System.out.println("exit -> exit car dealership");
			
			//parse user input after they ponder menu options
			String input = scan.nextLine();
			
			//switch statement that takes the input and delivers the appropriate prompt
			//this is long ugly functionality. Better here than in the main method though!
			switch(input) {
			
			case "hi": {
				System.out.println("um... hello.");
				break;
			}
			
			case "cars": {
				Car[] cars = cd.getAllCars(); //get all the Car objects using the appropriate CarDealership method
				for(Car car : cars)
				{
					System.out.println(car); //print them out one by one via the enhanced for loop
				}
				break;
			}
			
			case "carById": {	
				System.out.println("Enter Car Id to Search for: ");
				int idInput = scan.nextInt(); //get user's input for Id to search by
				scan.nextLine(); //we have to use .nextLine, since nextInt doesn't do it for us... :/
				
				Car car = cd.getCarById(idInput); //get the List of Employees from the service
				System.out.println(car);
				break;				
			}
			
			case "addCar": {
				
			//we're going to put this in a try block to catch user error
				try {
					System.out.println("How many tires does you car have?");
					int tireInput = scan.nextInt();
					scan.nextLine();
					
					System.out.println("What color is your car?");
					String colorInput = scan.nextLine(); //for Strings we can just use nextLine. Convenient! 
														 //creates a line break for us while gathering input
					cd.addCar(new Car(tireInput, colorInput)); 
					System.out.println(colorInput + " car with " + tireInput + " tires added!");
					
				} catch (InputMismatchException e) {
					
					scan.nextLine(); //since the nextLine() in the try won't run if an exception is thrown
					System.out.println("Something went wrong! Try again...");
					
				}
				
				break;
			}
			
			case "carsByColor" : {
				
				System.out.println("What color car are you looking for?");
				String color = scan.nextLine();
				cd.getCarsByColor(color);
				break;
			}
			
			case "exit": {
				System.out.println("bye.");
				displayMenu = false;
				break;
			}
			
			//this default block will catch anything that doesn't match a menu option
			default: {
				System.out.println("What? Try again");
				break;
			}
			
			}
	
		}
			
	}
}
