package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoInterface;
import com.revature.models.Employee;

public class EmployeeService {

	EmployeeDaoInterface ed = new EmployeeDao();
	
	public List<Employee> showEmployees(){
		return ed.getEmployees();
	}
	
	public List<Employee> showEmployeeByRoleTitle(String title){
		return ed.getEmployeeByRoleTitle(title); //send the user-inputted title for the DAO method's query
	}
	
	public void addEmployee(Employee employee) {
		ed.addEmployee(employee);
	}
	
	public void removeEmployee(String fName) {
		ed.removeEmployee(fName);
	}
	
}
