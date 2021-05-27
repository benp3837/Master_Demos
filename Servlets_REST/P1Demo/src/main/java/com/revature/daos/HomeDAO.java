package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Home;
import com.revature.utils.ConnectionUtil;

public class HomeDAO implements HomeInterface {

	@Override
	public List<Home> getHomes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Home getHomeByName(String name) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM homes WHERE home_name = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name); //set the wildcard to the parameter given to the method
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) { //we won't need a while loop, since we're only expecting one result
				
				Home h = new Home();
				
				//a different way to populate the Home object's fields - 
				//...using the setters instead of the constructor like we did in the get all Avenger's method
				h.setHomeName(name);
				h.setStAddr(rs.getString("home_address"));
				h.setCity(rs.getString("home_city"));
				h.setState(rs.getString("home_state"));
				h.setZip(rs.getString("home_zip"));		
				return h; //after building the Home object, return it
			} 	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null; //if no result, we'll just return null
	}

	
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
