package com.revature.P1DemoTester.models;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity //makes the class a DB table
@Table(name = "employees")
@Component
public class Employee {

    @Id //makes the field the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this makes the PK serial
    private int employeeId;

    //remember, we don't NEED @Column unless we're adding constraints

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    //We are establishing a @ManyToOne relationship - one role can have many employees
    //We will make this field a FK to the Role table
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId") //This is how we specify the PK that this FK points to
    //the name attribute of the @JoinColumn annotation will name the column in your table.
    //IMPORTANT NOTE: using @Column will break this, @JoinColumn already fills that role.
    private Role role;

    /* WHAT are fetch and cascade??

     fetch - sets whether we want the dependency to be eagerly or lazily loaded
     (typically we want eager loading so that the object/relationship is ready before we even need it)

     cascade - sets how changes in a table cascade to dependent records
     (with CascadeType.ALL, if a Role is updated/deleted, that update/delete will cascade down) */

    //boilerplate code-----------------------------

    public Employee() {
    }

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Employee(int employeeId, String username, String password) {
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}