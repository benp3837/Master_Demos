package com.revature.P1DemoTester.daos;

import com.revature.P1DemoTester.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

//fake DAO to demonstrate Spring MVC before talking about Spring Data
@Repository
public class EmployeeDAO {

    public static ArrayList<Employee> employees = new ArrayList<Employee>(){{
        add(new Employee(1, "Spongebobbo", "password"));
        add(new Employee(2, "MoneyKrab$", "password"));
        add(new Employee(3, "itssquiddyT", "unrecognizedTalent"));
    }};

    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        if(id>employees.size() || id<1) {
            return null;
        }
        return employees.get(id - 1);
    }

    public Employee updateEmployee(Employee e) {
        if(e.getEmployeeId()> employees.size()||e.getEmployeeId()<1){
            return null;
        } else {
            employees.set(e.getEmployeeId()-1, e);
            return getEmployeeById(e.getEmployeeId());
        }

    }

    public Employee insertEmployee(Employee e) {
        employees.add(e);
        return e;
    }
}
