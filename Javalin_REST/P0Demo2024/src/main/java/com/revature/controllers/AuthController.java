package com.revature.controllers;

import com.revature.DAOs.AuthDAO;
import com.revature.models.Employee;
import com.revature.models.LoginDTO;
import io.javalin.http.Handler;

import jakarta.servlet.http.HttpSession;

public class AuthController {

    //AuthDAO so we can access its methods
    AuthDAO aDAO = new AuthDAO();

    //empty HttpSession object that will be filled upon successful login
    public static HttpSession ses;
    //to prevent functionalities from running until login, have them check whether this Session is null;

    //login will be a POST request, since the user is expected to send some data in the HTTP Request
    public Handler loginHandler = (ctx) -> {

        //ctx.bodyAsClass() to grab the HTTP Request data and convert it into a LoginDTO object
        LoginDTO lDTO = ctx.bodyAsClass(LoginDTO.class);

        //if the login is successful, this Employee object will be populated. otherwise, null
        Employee loggedInEmployee = aDAO.login(lDTO.getFirst_name(), lDTO.getPassword());

        System.out.println(loggedInEmployee);

        if(loggedInEmployee != null){

            //This is how we create sessions in Javalin 5
            ses = ctx.req().getSession();

            //we can use setAttribute() to set certain values to certain keys
            //THIS IS HOW WE CAN SAVE DATA IN A SESSION
            ses.setAttribute("role_id", loggedInEmployee.getRole().getRole_id());
            ses.setAttribute("employee_id", loggedInEmployee.getEmployee_id());

            //role id would be used to determine manager/employee, giving access to only certain methods
            //employee id would be used to get all reimbursements of the logged in employee...
                //...as well anything else that needs user id, like the employee FK of reimbursements

            //turn the employee back into JSON, and send it in the HTTP Response with 202 accepted
            ctx.json(loggedInEmployee);
            ctx.status(202); //202 "accepted"
        } else {
            ctx.status(401); //401 "unauthorized"
        }

    };

}
