package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDao implements EmployeeDaoInterface{

	@Override
	public List<Employee> getEmployees() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null; //initialize an empty ResultSet
			
			String sql = "select * from employees;"; //write out the SQL query
			
			Statement ps = conn.createStatement(); //put the SQL query into a Statement
			
			rs = ps.executeQuery(sql); //execute the query, putting the results into our ResultSet variable
			
			List<Employee> employeeList = new ArrayList<>(); //create the List we want to return
			
			while(rs.next()) { //while there are results in the result set...
				
				Employee e = new Employee( //create a new Employee Object from each returned row..
						rs.getInt("employee_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getString("hire_date"),
						rs.getInt("role_id")
						);
				
				employeeList.add(e); //and populate the ArrayList with each created Role Object
			}
			
			return employeeList; //Finally, return the populated List of Roles.
			
			
		} catch(SQLException e) {
			System.out.println("Something went wrong with your SQL!");
			e.printStackTrace();
		}
		
		return null;
	}

	
	//Bit more complicated query, takes a parameter in order to have a more flexible menu option
	@Override
	public List<Employee> getEmployeeByRoleTitle(String title) {

		try(Connection conn = ConnectionUtil.getConnection()){
			ResultSet rs = null;
			
			String sql = "select * from employees join roles "
					+ "on employees.role_id = roles.role_id where roles.role_title = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, title); //insert the method's argument as the first (and only) variable in the query
			
			rs = ps.executeQuery();	
			
			List<Employee> employeeList = new ArrayList<>();
			
			while(rs.next()) { //while there are results in the result set...
				
				Employee e = new Employee( //create a new Employee Object from each returned row..
						rs.getInt("employee_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getString("hire_date"),
						rs.getInt("role_id")
						);
				
				employeeList.add(e); //and populate the ArrayList with each created Role Object
			}
			
			return employeeList; //Finally, return the populated List of Roles.
			
			
			
		} catch (SQLException e) {
			System.out.println("Something went wrong with your SQL!");
			e.printStackTrace();
		}
		
		return null;
	}

	
	@Override
	public void addEmployee(Employee employee) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//This was my quick/dirty solution to get the current date in appropriate format. (see setString 3)
			//Surely there has to be a more elegant way!!! Figure it out associates
			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		     Date date = new Date();
		     String currentDate = dateFormat.format(date);
			
		    //then the rest proceeds pretty much as normal
			String sql = "INSERT INTO employees (f_name, l_name, hire_date, role_id)"
		+ "VALUES (?, ?, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, employee.getF_name());
			ps.setString(2, employee.getL_name());
			ps.setDate(3, java.sql.Date.valueOf(currentDate));
			ps.setInt(4, employee.getRole_id());
			ps.executeUpdate();
			
			//send confirmation to the console if successful
			System.out.println("Employee " + employee.getF_name() + " created. Welcome Aboard!");
			
		} catch (SQLException e) {
			System.out.println("Add Employee Failed :(");
			e.printStackTrace();
		}	
	}

	
	@Override
	public void removeEmployee(String fName) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "delete from employees where f_name = ?;";
						
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, fName);
			ps.executeUpdate();
			
			System.out.println("Get out of here " + fName + " yer costin' me money!!!");
						
		} catch(SQLException e) {
			System.out.println("Remove employee failed!");
			e.printStackTrace();
		}
		
	}

}
