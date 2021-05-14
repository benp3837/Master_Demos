package com.revature.services;

import java.util.List;

import com.revature.dao.RoleDao;
import com.revature.dao.RoleDaoInterface;
import com.revature.models.Role;

public class RoleService {

	RoleDaoInterface rd = new RoleDao();
	
	public List<Role> showRoles(){
		return rd.getRoles();
	}
	
	public void changeSalary(int newSalary, String roleTitle) {
		rd.changeSalary(newSalary, roleTitle);
	}
	
}
