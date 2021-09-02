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
	
	private HomeInterface hDAO = new HomeDAO(); //instantiating a HomeDAO object to use its methods
	
	@Override
	public List<Avenger> getAllAvengers() {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM \"P1Demo\".avengers;"; //write your sql statement to send to the DB
			
			Statement s = conn.createStatement(); //create a statement object to execute our query
			
			ResultSet rs = s.executeQuery(sql); //put the result of the query into the ResultSet 
												//(Execute the query into it!)
			
			List<Avenger> avengerList = new ArrayList<>(); //create a new ArrayList to hold all the Avengers
			
			
			
			while(rs.next()) { //while there are still rows in our ResultSet
				
				//make a new Avenger object for each row
				Avenger a = new Avenger (
					rs.getInt("av_id"),
					rs.getString("av_name"),
					rs.getString("av_power"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("power_level"),
					null //here's the fun part, I'll add the Home object below
				);
				
				//if the Avenger DOES have a home...
				if(rs.getString("home_fk") != null) {
					a.setHome_fk(hDAO.getHomeByName(rs.getString("home_fk")));
					//set the Avenger's home_fk equal to the home object returned by getHomeByName
					//the getHomeByName method gets its parameter from the home_fk column returned by the SQL query
					//in this way, we can get an entire Home object with just our home_fk!
					
					//the logic given as a parameter in the setHome_fk() method will return a Home object...
					//and set it as the Home field in the new Avenger object
				}
				
				//after creating the Avenger object, and adding a home_fk field if it exists, add it to the ArrayList
				avengerList.add(a);
			}
			
			//outside our while loop, once all avengers have been added, return the ArrayList
			return avengerList;
			
			
		} catch (SQLException e) {
			System.out.println("Get all avengers failed!");
			e.printStackTrace();
		}
		
		
		return null;
	}

	
	
	//will be left unimplemented in order to focus more on client-server communication
	//you should know how to do CRUD in the dao layer by now anyway ;) your P0s were successful
	
	
	
	@Override
	public Avenger getAvengerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAvenger(Avenger avenger) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean killAvenger(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
