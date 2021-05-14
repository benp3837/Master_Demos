package com.revature.dao;

import java.util.List;
import com.revature.models.Role;

public interface RoleDaoInterface {

	public List<Role> getRoles(); //this method will return a List of all roles
	
	public void changeSalary(int salaryId, String roleTitle); //this method will update a role salary with a certain id
	
}
