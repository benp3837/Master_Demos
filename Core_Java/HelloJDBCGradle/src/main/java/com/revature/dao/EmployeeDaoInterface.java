package com.revature.dao;

import java.util.List;
import com.revature.models.Employee;

//Remember, Interfaces provide methods with no body (abstract methods) meant to be implemented in another Class
public interface EmployeeDaoInterface {

	public List<Employee> getEmployees(); //this method will return a list of all employees
	
	public List<Employee> getEmployeeByRoleTitle(String title); //this one will get employees of certain roles
	
	public void addEmployee(Employee employee); 
	
	public void removeEmployee(String fName);
	
}
