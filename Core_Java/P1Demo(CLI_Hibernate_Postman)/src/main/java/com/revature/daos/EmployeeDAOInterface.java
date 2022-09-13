package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Employee;

//Recall that Interfaces contain ONLY abstract methods meant to be implemented by concrete classes
//So this is a great way to organize and plan out what we want our EmployeeDAO Class to have.
public interface EmployeeDAOInterface {

    //I'm going to lay out a bunch of abstract methods that the EmployeeDAO must implement

    //What's the point? DAO classes get VERY long and complicated. This is a great way to see what methods are actually there.
    //A good way to quickly reference the methods found in the very code heavy DAO Classes.

    //A method to insert a new employee
    boolean insertEmployee(Employee employee);

    //A method to get all employees
    ArrayList<Employee> getEmployees();


    //A method to delete employees
    public void deleteEmployee(int id);

    //Potentially a method to get employees by role title (which would require a join)


    //we'll probably save update for the RoleDAO

}