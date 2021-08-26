package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.revature.models.Avenger;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.HibernateUtil;

public class AvengerDAO implements AvengerInterface {

	private HomeInterface hDao = new HomeDAO(); //we'll need this to get home objects
	
	@Override
	public List<Avenger> getAvengers() {
		try(Connection conn = ConnectionUtil.getConnection()){ //try with resources, automatically closes connection
			
			String sql = "SELECT * FROM Avengers;"; //write our statement
			
			Statement s = conn.createStatement(); //put the SQL query into a statement
			
			ResultSet rs = s.executeQuery(sql); //put the query results into a ResultSet. (Execute the query into it!)
			
			List<Avenger> list = new ArrayList<>(); //create an ArrayList to populate with the results
			
			while(rs.next()) { 
				
				Avenger a = new Avenger( //create a new Avenger using the constructor... 
										 //using each returned column for their fields.
					rs.getInt("av_id"),
					rs.getString("av_name"),
					rs.getString("av_power"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("power_level"),
					null //here's the fun one, i'm temporarily filling it with null, then adding the home object below
				);
				if(rs.getString("home_fk") != null){ //if the Avenger DOES have a home...
					a.setHome_fk(hDao.getHomeByName(rs.getString("home_fk"))); 
					//set the Avenger's home_fk equal to the home object returned by the getHomeByName method.
					//the getHomeByName gets its parameter from the home_fk column returned by the SQL query
					//in this way, we can get an entire Home object with just our home_fk!
					//the logic given as a parameter in the setHome_fk() method is going to return a Home object...
					//and set it as the Home field in the new Avenger object
				}
				list.add(a); //after that whole ordeal, add the new Avenger object to the ArrayList
				//this will loop for the entire ResultSet, since we have while(rs.next())
			}
			
			return list; //return the list, thus fulfilling the return type of the method
			
		} catch(SQLException e) {		
			System.out.println("Failed to get Avengers");
			e.printStackTrace();		
		}
		
		return null;
	}

	@Override
	public Avenger getAvengerById(int id) {	
		
		Session session = HibernateUtil.getSession();
		
		Query query = session.createSQLQuery("CALL StoredProcedureTest(:parameter)")
				.addEntity(Avenger.class)
				.setParameter("parameter", parameter);

				ArrayList<Avenger> results = query.toString();
	}

	@Override
	public boolean addAvenger(Avenger a) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean updateAvenger(Avenger a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean killAvenger(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
