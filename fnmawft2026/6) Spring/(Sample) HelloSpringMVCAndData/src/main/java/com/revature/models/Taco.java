package com.revature.models;

import jakarta.persistence.*;

//Typical annotation setup for DB Entity
@Entity //Now this is a DB entity
@Table(name = "tacos") //Now the table is names "tacos"
public class Taco {

    @Id //Make this the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Make the PK auto increment
    private int tacoId;

    //@Column isn't necessary unless we want to apply constraints!

    @Column(nullable = false)
    private String tacoFilling;

    @Column(nullable = false)
    private String tacoShell;

    /* Every Taco has a User it belongs to. This is a @ManyToOne relationship

        fetch - defines whether the Dependency (User in this case) is eagerly or lazily loaded
            -eager = loads the dependency as soon as the app starts
            -lazy = loads the dependency only when it's called

        @JoinColumn - defines the column (field) that will be used to link these tables
            -So we have to supply the name of the PK field of User in the @JoinColumn
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    //boilerplate--------------------------

    //no args, all args minus id, all args, getter/setter, toString
    public Taco() {
    }

    public Taco(String tacoFilling, String tacoShell, User user) {
        this.tacoFilling = tacoFilling;
        this.tacoShell = tacoShell;
        this.user = user;
    }

    //We'll use this one for insert - ID gets autogenned and User will get gathered from the session
    public Taco(String tacoFilling, String tacoShell) {
        this.tacoFilling = tacoFilling;
        this.tacoShell = tacoShell;
    }

    public Taco(int tacoId, String tacoFilling, String tacoShell, User user) {
        this.tacoId = tacoId;
        this.tacoFilling = tacoFilling;
        this.tacoShell = tacoShell;
        this.user = user;
    }

    public int getTacoId() {
        return tacoId;
    }

    public void setTacoId(int tacoId) {
        this.tacoId = tacoId;
    }

    public String getTacoFilling() {
        return tacoFilling;
    }

    public void setTacoFilling(String tacoFilling) {
        this.tacoFilling = tacoFilling;
    }

    public String getTacoShell() {
        return tacoShell;
    }

    public void setTacoShell(String tacoShell) {
        this.tacoShell = tacoShell;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Taco{" +
                "tacoId=" + tacoId +
                ", tacoFilling='" + tacoFilling + '\'' +
                ", tacoShell='" + tacoShell + '\'' +
                ", user=" + user +
                '}';
    }
}
