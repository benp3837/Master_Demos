package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class EmployeeDao implements EmployeeDaoInterface{

	@Override
	public List<Employee> getEmployees() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null; //initialize an empty ResultSet
			
			String sql = "select * from employees;"; //write out the SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql); //put the SQL query into a PreparedStatement
			
			rs = ps.executeQuery(); //execute the query, putting the results into our ResultSet variable
			
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
	public void addEmployee() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void removeEmployee() {
		// TODO Auto-generated method stub
		
	}

}
