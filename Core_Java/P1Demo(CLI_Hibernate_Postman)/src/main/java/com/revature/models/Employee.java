package com.revature.models;

//This Class models the employees table in our database
public class Employee {

    //variables for the employee class which must match the names of the columns of the employee DB table
    private int employee_id;
    private String first_name;
    private String last_name;
    //Every employee in this application has a role, so we'll give a Role object as a variable
    private Role role;

    //make a variable for int roleId for inserting Employees. This constructor will only be used when inserting
    //because remember, the role_id_fk is an int on the DB side. This saves us from doing quirky conversions
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
