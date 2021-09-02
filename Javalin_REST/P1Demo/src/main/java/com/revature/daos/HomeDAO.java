package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Home;
import com.revature.utils.ConnectionUtil;

public class HomeDAO implements HomeInterface {

	//won't implement
	@Override
	public List<Home> getAllHomes() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	@Override
	public Home getHomeByName(String name) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM \"P1Demo\".homes WHERE home_name = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name); //set our wildcard to the parameter given in the method
			
			ResultSet rs = ps.executeQuery(); //the results of our query will be put into the ResultSet object
			
			if(rs.next()) { //we won't need a while loop, we're only expecting one result
				
				//Just for the sake of showing you a different way to populate a Home object...
				//...using the setters instead of the constructor like we did in getAllAvengers()	
				Home h = new Home(); //instantiate an empty home object
				
				//use the setters to populate its fields
				h.setHome_name(name); //this can just be the name object getting sent in from the parameters
				h.setHome_address(rs.getString("home_address"));
				h.setHome_city(rs.getString("home_city"));
				h.setHome_state(rs.getString("home_state"));
				h.setHome_zip(rs.getString("home_zip"));
			
				return h; //return the home object
			}
		
			
		} catch (SQLException e) {
			System.out.println("Couldn't get home by name");
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	
	
	
	
	
	
	//wont implement-----------------------------------------
	@Override
	public boolean addHome(Home home) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean destroyHome(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
