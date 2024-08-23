package com.revature.DAOs;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthDAO extends JpaRepository<User, UUID> {

    //we just need the Auth layer for login purposes. could've also thrown register stuff in here

    //to verify that a user's login credentials are valid
    //we check for users where username = ? and password = ?
    public User findByUsernameAndPassword(String username, String password);

}
