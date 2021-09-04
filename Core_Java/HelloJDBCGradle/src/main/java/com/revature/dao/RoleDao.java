package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class RoleDao implements RoleDaoInterface {

	@Override
	public List<Role> getRoles() {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null; //initialize an empty ResultSet
			
			String sql = "select * from roles;"; //write out the SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql); //put the SQL query into a PreparedStatement
			
			rs = ps.executeQuery(); //execute the query, putting the results into our ResultSet variable
			
			List<Role> roleList = new ArrayList<>(); //create the List we want to return
			
			while(rs.next()) { //while there are results in the result set...
				
				Role r = new Role( //create a new Role Object from each returned row..
						rs.getInt("role_id"),
						rs.getString("role_title"),
						rs.getInt("role_salary")
						);
				
				roleList.add(r); //and populate the ArrayList with each created Role Object
			}
			
			return roleList; //Finally, return the populated List of Roles.
			
			
		} catch(SQLException e) {
			System.out.println("Something went wrong with your SQL!");
			e.printStackTrace(); //print out the exception message
		}
		
		return null; //to make the compiler stop yelling at us for potentially not returning a Role List
		
	}

	@Override
	public void changeSalary(int newSalary, String roleTitle) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			//notice how there's no resultset in this method, because we aren't returning anything
			//only changing a role salary in the database
			
			String sql = "update roles set role_salary = ? where role_title = ?;"; //write out the SQL query
			
			PreparedStatement ps = conn.prepareStatement(sql); //put the SQL query into a PreparedStatement
			
			ps.setInt(1, newSalary);
			ps.setString(2, roleTitle);
			ps.executeUpdate(); //execute the update... notice it's executeUpdate not executeQuery
		
			
		} catch (SQLException e) {
			System.out.println("blah blah blah you messed up it's all ruined because of YOU");
			e.printStackTrace();
		}
			
	}

}
