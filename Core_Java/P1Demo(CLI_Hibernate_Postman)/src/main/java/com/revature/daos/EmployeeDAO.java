package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

//DAO stands for Data Access Object - it's the layer of classes that DIRECTLY talk to the database
//so this is where any SELECT, INSERT, UPDATE, DELETE commands will go.
public class EmployeeDAO implements EmployeeDAOInterface {

    //method that inserts data into the DB
    @Override
    public boolean insertEmployee(Employee employee) {

        //at the top of EVERY DAO METHOD, we need to open a database connection.
        try(Connection conn = ConnectionUtil.getConnection()){

            //First, we need out SQL String that represents the INSERT statement we want to send to the DB
            //There are variables here, and we can fill them out thanks to a PreparedStatement object
            //The question marks are how we indiciate that it's a value that we'll fill below
            String sql = "insert into employees (first_name, last_name, role_id_fk) values (?, ?, ?);";

            //Instantiate a PreparedStatement to fill in the variables of our SQL String (the ?s).
            //we use the prepareStatement() method from our Connection object to do this.
            PreparedStatement ps = conn.prepareStatement(sql);

            //fill in the values of our variables using ps.setXYZ()
            //these methods take two parameters - the variable we'll filling, and the value to fill it with
            ps.setString(1, employee.getFirst_name()); //by "1" here, we're referring to the first question mark in the SQL String.
            ps.setString(2, employee.getLast_name());
            ps.setInt(3, employee.getRole_id_fk()); //PreparedStatement doesn't have a setRole() method,
            //so we can just use the id here, because it takes an int on the database side

            System.out.println(ps);

            //we've created the SQL String and filled it with data - now we need to EXECUTE THE STATEMENT!
            ps.executeUpdate(); //This is what actually sends our SQL off to the database.

            //Tell the user the insert was successful
            System.out.println("Employee " + employee.getFirst_name() + " was added!");

            return true; //if the update is successful, true will get returned

        } catch (SQLException e) { //if anything goes wrong, this SQLException will get thrown
            System.out.println("INSERT EMPLOYEE FAILED"); //tell the console we failed
            e.printStackTrace(); //print out the error log, which we'll need for debugging
        }

        return false; //if it fails, we'll get here (instead of the "return true" in the try block)

    } //end of insertEmployee()


    //There is a TDD test written for this method (not necessary to do this, just wanted to demonstrate TDD0
    //This method gets all employees from the DB
    @Override
    public ArrayList<Employee> getEmployees() {

        try(Connection conn = ConnectionUtil.getConnection()){

            //A String that will represent our SQL statement
            String sql = "select * from employees;";

            //no variables so we don't need a PreparedStatement!
            //What we'll use instead is a Statement object to execute our query
            Statement s = conn.createStatement();
            //IMPORT STATEMENT FROM JAVA.SQL, NOT JAVA.BEANS!!!!!!!!!!!!!!!!!!!!!

            //remember we need to execute our query into a ResultSet object, which will hold the incoming data
            ResultSet rs = s.executeQuery(sql);

            //Instantiate an empty ArrayList to hold our Employee data (remember, java can't read SQL).
            ArrayList<Employee> employeeList = new ArrayList<>();

            //use rs.next() in a while loop to create Employee object and populate our ArrayList with them.
            while(rs.next()) { //rememeber, rs.next() returns "true" if there are more results that we haven't looked at yet

                //Create a new Employee object from each record in the ResultSet
                //we're using the all-args constructor!!
                Employee e = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        null //there is no JDBC method for getRole()... we'll add the Role object below
                        //this is an extra step we have to take, because in the DB, role_id_fk is an int
                        //but we need a Role object here... not an int
                );

                //we need to get a Role object somehow
                //we need to use the RoleDAO method to get a role by ID.
                int roleFK = rs.getInt("role_id_fk");

                //Instantiate a RoleDAO so we can use getRoleById
                RoleDAO rDAO = new RoleDAO();

                //get a Role object using the int that we populate with rs.getInt()!!!!
                Role r = rDAO.getRoleById(roleFK);

                //use the SETTER of our Employee class to set the Role object to the one we got from the DB
                e.setRole(r);
                //thanks to this setter, we have a FULLY INITIALIZED Employee object

                //add the new Employee to our ArrayList. For every employee returned, we put it in the ArrayList
                employeeList.add(e);

            } //end of while loop

            //once the while loop breaks (once rs.next() == false), return the ArrayList
            return employeeList;

        } catch (SQLException e) {
            System.out.println("SOMETHING WENT WRONG GETTING EMPLOYEES"); //tell the console it failed
            e.printStackTrace(); //print the error log for debugging
        }

        return null; //so the compiler doesn't complain when our REAL return is in a try block

    } //end of get all

    @Override
    public void deleteEmployee(int id) {

        try(Connection conn = ConnectionUtil.getConnection()){

            //SQL String that we want to send to the DB
            String sql = "delete from employees where employee_id = ?;";

            //instantiate our PreparedStatement to fill in the variable
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            //ps.executeUpdate() to send our delete to the DB
            ps.executeUpdate();

            //let the user know that the dreams of their former employee have been crushed
            System.out.println("Get outta here, employee #" + id);

        } catch (SQLException e) {
            System.out.println("YOU CAN'T FIRE ME MY FATHER WILL SUE");
            e.printStackTrace();
        }

    }

}
