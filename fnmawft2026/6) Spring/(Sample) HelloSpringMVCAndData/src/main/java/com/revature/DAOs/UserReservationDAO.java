package com.revature.DAOs;

import com.revature.models.UserReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReservationDAO extends JpaRepository<UserReservation, Integer> {



}
