package com.revature.daos;

import com.revature.models.Role;

//This Interface will lay out the methods I want to implement in the RoleDAO Class
public interface RoleDAOInterface {

    //a method that returns a Role object from the database given the Role's ID
    Role getRoleById(int id);

    //a method that updates the salary data for a given role
    boolean updateRoleSalary(String title, int salary);

    //ctrl + shift + o to import unimported Classes

}
