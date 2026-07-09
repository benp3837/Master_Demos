package com.revature.DAOs;

import com.revature.models.User;
import java.util.List;

/*

This is great for two reasons:

1) As a quick reference to see what methods are available in the DAO
2) As a ruleset if we want multiple DAOs that implement this Interface differently */

public interface UserDAOInt {

    List<User> getAllUsers();
    User getUserById(int userId);
    User insertUser(User user);
    User updateUser(User user);

}
