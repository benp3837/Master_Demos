package com.revature.P1DemoTester.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity //makes the class a DB table
@Table(name = "roles")
@Component
public class Role {

    @Id //makes the field the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this makes the PK serial
    private int roleId;

    private String roleTitle;

    private int roleSalary;


    public Role() {
    }

    public Role(int roleId, String roleTitle, int roleSalary) {
        this.roleId = roleId;
        this.roleTitle = roleTitle;
        this.roleSalary = roleSalary;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public int getRoleSalary() {
        return roleSalary;
    }

    public void setRoleSalary(int roleSalary) {
        this.roleSalary = roleSalary;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleTitle='" + roleTitle + '\'' +
                ", roleSalary=" + roleSalary +
                '}';
    }
}
