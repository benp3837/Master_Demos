package com.revature.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user-reservations")
public class UserReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userReservationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reservationId")
    private Reservation reservation;

    //Could do other fields - easier since we did @ManyToOnes instead of @ManyToManys

    //boilerplate -----------------------------------

    //no args. all args minus id, all args, getter/setter, tostring

    public UserReservation() {
    }

    public UserReservation(User user, Reservation reservation) {
        this.user = user;
        this.reservation = reservation;
    }

    public UserReservation(int userReservationId, User user, Reservation reservation) {
        this.userReservationId = userReservationId;
        this.user = user;
        this.reservation = reservation;
    }

    public int getUserReservationId() {
        return userReservationId;
    }

    public void setUserReservationId(int userReservationId) {
        this.userReservationId = userReservationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "UserReservation{" +
                "userReservationId=" + userReservationId +
                ", user=" + user +
                ", reservation=" + reservation +
                '}';
    }
}
