package com.revature.models;

import jakarta.persistence.*;

import java.util.Set;

//This is 1/2 of the Many to Many relationship with Users mapped by the UserReservation Entity

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    @Column(nullable = false)
    private int groupSize;

    private String location;

    //OneToMany to the UserReservation Join table
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Set<UserReservation> userReservations;


    //boilerplate--------------

    //no args, all args, all args minus id, getter/setter, tostring
    public Reservation() {
    }

    public Reservation(int groupSize, String location) {
        this.groupSize = groupSize;
        this.location = location;
    }

    public Reservation(int reservationId, int groupSize, String location) {
        this.reservationId = reservationId;
        this.groupSize = groupSize;
        this.location = location;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", groupSize=" + groupSize +
                ", location='" + location + '\'' +
                '}';
    }
}
