package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.HibernateUtil;
import org.hibernate.Session;

//DAO stands for Data Access Object - it's the layer of classes that DIRECTLY talk to the database
//so this is where any SELECT, INSERT, UPDATE, DELETE commands will go.
public class EmployeeDAO implements EmployeeDAOInterface {

    //method that inserts an employee into the DB using SESSION METHOD
    @Override
    public boolean insertEmployee(Employee employee) {

        //open a Session object to establish a connection to the DB
        Session ses = HibernateUtil.getSession(); //similar to opening a Connection object in JDBC

        //use a save() session method to save the movie to the DB
        ses.save(employee);

        //close the Session to prevent memory leaks
        HibernateUtil.closeSession();

        return true; //if the insert is successful, we'll get here, and true will be returned.

        //This is the ENTIRE DAO method to insert a new employee - much cleaner and less complicated than JDBC
    }

    //This method gets all employees from the DB using HQL
    @Override
    public ArrayList<Employee> getEmployees() {

        //open a Session object to connect to the DB
        Session ses = HibernateUtil.getSession();

        //SELECT ALL movies using HQL instead of sessions methods.
        ArrayList<Employee> employeeList = (ArrayList<Employee>) ses.createQuery("FROM Employee").list();
        //we're selecting ALL records FROM the employees table.
        //Remember, HQL uses Class names, not DB table names

        //close the session
        HibernateUtil.closeSession();

        //return the List of employees
        return employeeList;

    } //end of get all


    //this one they'll do on their own---------------------------

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
