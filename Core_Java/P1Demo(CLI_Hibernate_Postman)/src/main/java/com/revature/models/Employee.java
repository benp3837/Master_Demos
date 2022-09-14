package com.revature.models;

import javax.persistence.*;

@Entity //@Entity makes a Class a DB table (as long as you register it in the hibernate.cfg.xml)
@Table(name = "employees") //@Table lets us change table values such as the table name
public class Employee {

    @Id //This will make employee_id the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this makes our PK serial
    private int employee_id;

    //we can also set attributes like constraints with the @Column annotation
    @Column(unique = true, nullable = false) //so now this column is unique and not null.
    private String first_name;

    @Column
    private String last_name;

    //Many to One relationship with the Role Class - Many Employees can have the same role.
    //We need to make this a Foreign Key to the Director table
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "role_id") //THIS is how you establish FK/PK relationships
    //the name attribute must be equal to the name of the PK in Directors in the DB. (in this case, role_id)
    //IMPORTANT NOTE: @Column will break this, because @JoinColumn already makes it a column
    private Role role;

    //What is FetchType and CascadeType????
    //BEN WILL NOT FORGET TO TALK ABOUT IT IN THE HIBERNATE NOTES

    //helpful for inserting employee, we can just use the role_id instead of the entire role
    private int role_id_fk;

    //boilerplate code----------------

    //check the Role class for more explanations on some of this boilerplate code

    public int getRole_id_fk() {
        return role_id_fk;
    }

    public void setRole_id_fk(int role_id_fk) {
        this.role_id_fk = role_id_fk;
    }

    //no args constructor
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

    //all args constructor
    public Employee(int employee_id, String first_name, String last_name, Role role) {
        super();
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    //all args minus ID constructor - necessary for inserting new Employee records
    public Employee(String first_name, String last_name, Role role) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    //first_name, last_name, role_id constructor so that we can insert employees to the DB easier (role is an int in the DB)
    public Employee(String first_name, String last_name, int role_id_fk) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.role_id_fk = role_id_fk;
    }

    @Override
    public String toString() {
        return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
                + ", role=" + role + "]";
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
