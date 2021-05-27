package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Avenger;
import com.revature.utils.ConnectionUtil;

public class AvengerDAO implements AvengerInterface {

	@Override
	public List<Avenger> getAvengers() {
		try(Connection conn = ConnectionUtil.getConnection()){ //try with resources, automatically closes connection
			
			String sql = "SELECT * FROM Avengers;"; //write our statement
			
			Statement s = conn.createStatement(); //put the SQL query into a statement
			
			ResultSet rs = s.executeQuery(sql); //put the query results into a ResultSet. (Execute the query into it!)
			
			List<Avenger> list = new ArrayList<>(); //create an ArrayList to populate with the results
			
			while(rs.next()) {
				Avenger a = new Avenger( //create a new Avenger, using each returned column for their fields.
					rs.getInt("av_id"),
					rs.getString("av_name"),
					rs.getString("av_power"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("power_level"),
					null //here's the fun one, i'm temporary filling it with null, then adding the home object below
				);
				if(rs.getString("home_fk") != null){ //if the Avenger DOES have a home,
					
				}
				
			}
			
		} catch(SQLException e) {
			
			System.out.println("Failed to get Avengers");
			e.printStackTrace();
			
		}
		
		return null;
	}

	@Override
	public Avenger getAvengerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAvenger(Avenger a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean killAvenger(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
