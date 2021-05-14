package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.services.EmployeeService;
import com.revature.services.RoleService;

public class Menu {

	RoleService rs = new RoleService();
	EmployeeService es = new EmployeeService();
	
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
			System.out.println("employees -> show all employees");
			System.out.println("employeeByRole -> get employees by their role title (search roles for a list of roles)");
			System.out.println("roles -> show all roles");
			System.out.println("changeSalary -> update a role salary");
			System.out.println("exit -> exit EMS");
			
			//parse user input after they ponder menu options
			String input = scan.nextLine();
			
			//switch statement that takes the input and delivers the appropriate prompt
			//you may have a hard time reading all this functionality
			//I suggest you look at the DAO Interfaces first to see everything the CLI is able to do
			switch(input) {
			
			case "hi": {
				System.out.println("um... hello.");
				break;
			}
			
			case "employees": {
				List<Employee> employees = es.showEmployees(); //get the List of Employees from the service
				for(Employee r : employees)
				{
					System.out.println(r); //print them out one by one via the enhanced for loop
				}
				break;
			}
			
			case "employeeByRole": {	
				System.out.println("Enter Employee Role to Search:");
				String titleInput = scan.nextLine(); //get user's input for Role to search by
				
				List<Employee> employees = es.showEmployeeByRoleTitle(titleInput); //get the List of Employees from the service
				for(Employee r : employees)
				{
					System.out.println(r); //print them out one by one via the enhanced for loop
				}
				break;				
			}
			
			case "roles": {
				List<Role> roles = rs.showRoles(); //get the List of Roles from the service
				for(Role r : roles)
				{
					System.out.println(r); //print them out one by one via the enhanced for loop
				}
				break;
			}
			
			case "changeSalary": {
				System.out.println("Enter Role Title to change:");
				String titleInput = scan.nextLine();
				
				System.out.println("Enter New Salary:");
				int salaryInput = scan.nextInt();
				scan.nextLine(); //need this to refresh the input stream (nextInt doesn't skip to the next line)
				
				rs.changeSalary(salaryInput, titleInput);
				
				System.out.println(titleInput + " Salary has been changed to " + salaryInput);
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
				
			
			} //switch closes here

			
			//eventually, the user input gets sent to the service layer or the application ends
			
			
			
		}
		
		System.out.println("Thank you for using the Krusty Krab EMS!");
		scan.close(); //close the Scanner
	}

	
}
