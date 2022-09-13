package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

//This RoleDAO is responsible for communicating with the roles table in the database
//Every DB table should have a DAO Class associated with it for organization.
//We COULD just have one huge DAO Class with methods for every table, but that will be a longgggg scroll.
public class RoleDAO implements RoleDAOInterface {

    //This method takes in an int, and returns the Role with the role_id that matches the given int.
    @Override
    public Role getRoleById(int id) {

        //use a try-with-resources to open a DB connection object
        try(Connection conn = ConnectionUtil.getConnection()){

            //String that lays out the SQL query we want to run
            //This String has a parameter for role_id, which we'll fill with our PreparedStatement
            String sql = "select * from roles where role_id = ?;";

            //we need a PreparedStatment object to fill in the variable above with setInt().
            PreparedStatement ps = conn.prepareStatement(sql);

            //insert a value for the variable in out SQL statement
            ps.setInt(1, id); //1 == the first (and only) question mark, id == the parameter sent in to this method

            //The data returned from a SELECT statment is known as a ResultSet
            //We need a ResultSet OBJECT to hold our incoming data.
            ResultSet rs = ps.executeQuery(); //execute the query into our new ResultSet

            //the above code gets our data, and stores in a ResultSet object
            //we have to ITERATE through our ResultSet to create a new Role object on the Java side (Java can't read SQL)

            //while there are records in the ResultSet...
            while(rs.next()) {

                //we need to use the data in the ResultSet to fill a Role all-args constructor
                //note we're getting data by calling each column name of our Role table
                Role role = new Role(
                        rs.getInt("role_id"),
                        rs.getString("role_title"),
                        rs.getInt("role_salary")
                );

                return role; //return the Role data to the user!

                //In this case, we know we're only going to get one role, so we can return from within the while loop
                //If we were getting multiple records (like in get all employees), we would do it a little different.
            }

        } catch (SQLException e) {
            System.out.println("Get Role failed"); //tell the console it failed
            e.printStackTrace(); //print an error log for debugs
        }

        return null;

    } //end of select by id method

    @Override
    public boolean updateRoleSalary(String title, int salary) {

        try(Connection conn = ConnectionUtil.getConnection()){

            //SQL String for our UPDATE command
            String sql = "update roles set role_salary = ? where role_title = ?;";

            //create our PreparedStatement to fill in the variables
            PreparedStatement ps = conn.prepareStatement(sql);

            //input the appropriate values into our PreparedStatement
            ps.setInt(1, salary);
            ps.setString(2, title);

            //execute the update!
            ps.executeUpdate();

            //tell the console the update was successfully
            System.out.println(title + " has been updated to " + salary);

            //if it succeeds, return true
            return true;

        } catch (SQLException e) {
            System.out.println("FAILED TO UPDATE");
            e.printStackTrace();
        }


        return false; //if update fails, return false

    }

}
