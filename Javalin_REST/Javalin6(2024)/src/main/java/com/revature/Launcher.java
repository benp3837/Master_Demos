package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.RoleController;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.RoleDAO;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher {

    public static void main(String[] args) {

        /*
        This is a try with resources block
        How they work, is a resource is opened within parenthesis
        If successful, the rest of the try block runs
        Another benefit is that the resource will close for us when the block completes
        This is helpful for code cleanup and preventing memory leaks
         */
        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("CONNECTION SUCCESSFUL :)");
        }
        catch(SQLException e){
            System.out.println("connection failed :(");
        }

        //Typical Javalin object creation syntax
        var app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello World")) //just for fun
                .start(3000);
        /* We need .start() to start our Java server on port 3000
        You can do any port, I chose 3000 because nothing is using it (probably).
        a port is like a parking space for an application, where messages etc. can find it */

        //ENDPOINT HANDLERS BELOW--------------------

        /*Below, we'll expose different paths to different functionalities...
        ...by using the app.get(), app.post(), app.patch(), etc. methods
         When requests come in, they must match one these paths in order to execute some specific behavior.
         they'll call the Handlers we write in our Controllers- they "handle" http requests */

        //instantiating Controllers so that we can access their Handlers
        EmployeeController ec = new EmployeeController();
        RoleController rc = new RoleController();
        AuthController ac = new AuthController();

        /* app.get() is the Javalin method that takes in GET requests.
        In this case, it's calling to the getAllEmployeesHandler in the EmployeeController
        SO, when we send a request to localhost:3000/employees, the getEmployeesHandler will execute*/
        app.get("/employees", ec.getEmployeesHandler);

        //app.post() is the Javalin method that takes in POST requests
        //why are we allowed to have two handlers that both take requests ending in /employees?
        app.post("/employees", ec.insertEmployee);

        //app.patch() is the Javalin method that takes in PATCH requests
        //{title}?? This is a PATH PARAMETER. The value that the user inputs after /roles/ will be stored.
        app.patch("/roles/{title}", rc.updateSalaryHandler);

        //this is the endpoint handler for login
        app.post("/login", ac.loginHandler);

        //TEMPORARY - we'll be accessing the DAO using HTTP Requests later

        /*
        //Instantiate a RoleDAO and EmployeeDAO so that we can their methods
        RoleDAO rDAO = new RoleDAO();
        EmployeeDAO eDAO = new EmployeeDAO();

        //getting role by id
        System.out.println(rDAO.getRoleById(3));

        //getting all employees
        ArrayList<Employee> employees = eDAO.getEmployees();

        for(Employee e : employees){
            System.out.println(e);
        }

        //insert a new employee
        //NOTE: first_name has a UNIQUE constraint in the DB.
        //This won't succeed if you have duplicate first names
        Employee newEmp = new Employee("Reid", "Schroder", rDAO.getRoleById(1));

        //System.out.println(eDAO.insertEmployee(newEmp));

        //update a salary
        System.out.println(rDAO.updateRoleSalary("Cashier", 70000));

        //reassigning the employee list to the new data, and printing it out
        employees = eDAO.getEmployees();

        for(Employee e : employees){
            System.out.println(e);
        }

        */

    } //end of main method

}