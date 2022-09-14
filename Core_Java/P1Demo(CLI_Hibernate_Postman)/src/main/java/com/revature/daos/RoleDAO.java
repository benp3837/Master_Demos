package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

//This RoleDAO is responsible for communicating with the roles table in the database
//Every DB table should have a DAO Class associated with it for organization.
//We COULD just have one huge DAO Class with methods for every table, but that will be a longgggg scroll.
public class RoleDAO implements RoleDAOInterface {

    //Session methods are best used when you're SELECTing by the primary key
    //because get() and load() both expect a serializable (which our PK is)
    @Override
    public Role getRoleById(int id) {

        //open a Session object
        Session ses = HibernateUtil.getSession();

        //SELECT a Movie by ID
        Role role = ses.get(Role.class, id);

        //close the Session
        HibernateUtil.closeSession();

        //return the role
        return role;

    } //end of select by id method

    //updating role salary using HQL
    //I prefer HQL when we're only updating one or two columns
    //I prefer the merge() method when we're updating entire records
    @Override
    public boolean updateRoleSalary(String title, int salary) {

        System.out.println(title);

        Session ses = HibernateUtil.getSession();

        //remember, updates and deletes must be in TRANSACTIONS
        Transaction tran = ses.beginTransaction();

        //Assign our query syntax to a query object
        //note the triple quotes, the single quotes are for SQL, the double quotes are for our String concatenation
        //it's like saying UPDATE Role SET salary = 'new salary' WHERE role_title = 'the given role';
        Query q = ses.createQuery("UPDATE Role SET role_salary = '" + salary + "' WHERE role_title = '" + title + "'");

        //we have to actually execute this update
        q.executeUpdate();

        //close the transaction and session
        //we must commit the changes if we want them to actually save to the DB
        tran.commit();
        HibernateUtil.closeSession();

        return true;

    }

}
