package com.revature.controllers;

import com.revature.daos.RoleDAO;

import io.javalin.http.Handler;

public class RoleController {

    //we need a RoleDAO to use its methods
    RoleDAO rDAO = new RoleDAO();

    //this Handler will get the HTTP PUT request to update a Role salary.
    public Handler updateSalaryHandler = (ctx) -> {

        //String to hold the role title (which comes in as a PATH PARAMETER)
        String title = ctx.pathParam("title"); //pathParam() gives us the value the user sends in as a path parameter
        //in this case, our Launcher endpoint handler calls it "title", so this is what we need to call here

        //int to hold the new Role salary, which the user will include in the BODY of the HTTP Request
        int salary = Integer.parseInt(ctx.body()); //we need to use parseInt here, because ctx.body() returns a String
        //in postman, no need to make a JSON object, we can just input whatever number we want.

        //if the update DAO method returns true (which means successful)..
        if(rDAO.updateRoleSalary(title, salary)) {
            ctx.status(202); //202 stands for "accepted"
        } else {
            ctx.status(406); //406 stands for "not acceptable"
        }

    };

}
