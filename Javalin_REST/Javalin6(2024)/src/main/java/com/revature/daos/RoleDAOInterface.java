package com.revature.daos;

import com.revature.models.Role;

//This Interface will lay out the methods that the RoleDAO implements
//This is a great way to document what functionalities exist in the concrete class
public interface RoleDAOInterface {

    //a method that returns a Role given an id.
    Role getRoleById(int id);

    //a method that updates a Role's salary.
    boolean updateRoleSalary(String title, int salary);

}
