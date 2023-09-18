package com.revature.P1DemoTester.controllers;

import com.revature.P1DemoTester.daos.EmployeeDAO;
import com.revature.P1DemoTester.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController //Aside from making this class a bean... this allows automatic Java <-> JSON conversions
@RequestMapping("/employee") //every request to /p1/employee will go to this class
@CrossOrigin //This lets us take in HTTP requests from anywhere (like a front end)
public class EmployeeController {

    private final EmployeeDAO eDAO;

    @Autowired
    public EmployeeController(EmployeeDAO eDAO) {
        this.eDAO = eDAO;
    }

    //HTTP Requests-------------------------------

    @GetMapping
    public ResponseEntity<ArrayList<Employee>> getAllEmployees() {

        ArrayList<Employee> employees = eDAO.getAllEmployees();

        //we return a ResponseEntity, set the status code to 200 (OK) and set the response body data.
        return ResponseEntity.status(200).body(employees);

        //no error handling in these first two methods - see later methods

    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee e){

        Employee newEmp = eDAO.insertEmployee(e);

        return ResponseEntity.status(202).body(e);
    }

    @GetMapping("/{id}") //here, we add a PATH VARIABLE, which allows us to accept user input in the path
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {

        //@PathVariable will allow us to get the user-inputted path variable sent in the request

        //get an avenger from the DAO
        Employee e = eDAO.getEmployeeById(id);

        //if getById fails (the avenger is null)
        if(e == null) {
            //send back an empty response body, with a 400 level status code
            return ResponseEntity.status(404).build(); //.build is how we sent back NO response body
        }

        //if the avenger populates...
        return ResponseEntity.status(200).body(e);

    }


    //This method will take in an Employee object, and update that employee in the fake database
    @PutMapping //any HTTP PUT Request ending in /avenger will go here
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){

        //This Employee will either be updated or null, depending on the validity of the incoming data
        Employee updatedEmployee = eDAO.updateEmployee(employee);

        //if the update fails...
        if(updatedEmployee == null){
            return ResponseEntity.badRequest().build();
            //.badRequest() is a short way of applying a 400 status code
            //.build() is how we send no method body
        }

        //if update succeeded
        return ResponseEntity.accepted().body(updatedEmployee);
        //.accepted() is a short way of applying a 202 status code

    }


}