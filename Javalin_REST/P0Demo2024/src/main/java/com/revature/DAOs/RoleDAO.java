package com.revature.DAOs;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//This Class is responsible for all things ROLE data. This class will query the Role table
public class RoleDAO implements RoleDAOInterface{

    @Override
    public Role getRoleById(int id) {

        //use a try-with-resources block to open our connection and host our DB communication
        try(Connection conn = ConnectionUtil.getConnection()){

            /*
             We need a String that lays out the sql query we intend to run on the DB
             This String has a wildcard/parameter/variable for the role_id
             We have to take the user-inputted role id and put it into this statement somehow
              */
            String sql = "select * from roles where role_id = ?;";

            //we need a PreparedStatement object to fill the variable in
            //PreparedStatements "prepare" a query to get sent to the DB
            PreparedStatement ps = conn.prepareStatement(sql);

            //now, we can insert a value for the ? above
            ps.setInt(1, id); //"the first wildcard will be equal to the id variable"

            /*
            Here, we're running the SQL statement stored in the PreparedStatement
            The results of the SQL statement will get stored in the ResultSet object
             */
            ResultSet rs = ps.executeQuery();

            /*While loop to extract the resultset data
            WHILE there are results in the ResultNext (.next())...
            Make a new Role object.
             */
            while(rs.next()){

                /*We need to use the data from the ResultSet to fill in a Role all-args constructor
                    Basically, we need to make a Role object from the data */
                Role role = new Role(
                        rs.getInt("role_id"),
                        rs.getString("role_title"),
                        rs.getInt("role_salary")
                );
                //This is just a CONSTRUCTOR that we opened up for the sake of cleaner code

                return role; //return the Role data to the user!!
            }
        } catch(SQLException e){
            e.printStackTrace(); //if something goes wrong, this will display an error message
            //VERY important for debugging, so we know what went wrong and where
        }

        return null; //null will get returned if something goes wrong
    }

    @Override
    public boolean updateRoleSalary(String title, int salary) {

        //As usual, we need to open a connection
        /*Try with resources refresher
            In this try block, we open a Connection object within parenthesis
            By doing this, our Connection closes right after the try completes
            this is good for code cleanup and preventing memory leaks
          */
        try(Connection conn = ConnectionUtil.getConnection()){

            //create our SQL String (to be filled with values from the method arguments)
            String sql = "update roles set role_salary = ? where role_title = ?;";

            //Prepared statement so that we can fill appropriate values
            PreparedStatement ps = conn.prepareStatement(sql);

            //using ps.setXZY we can fill the wildcards (?) in our SQL statement
            ps.setInt(1, salary);
            ps.setString(2, title);

            //execute the update!
            ps.executeUpdate();

            //if we get this far in the try block, we can assume nothing went wrong. return true.
            return true;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
