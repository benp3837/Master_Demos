package com.revature.DAOs;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*We extend JpaRepository, which takes 2 generics:

 -The Java Entity that we intend to perform CRUD operations on (Users -> users table)
 -The datatype of the Primary Key in the Entity (Integer wrapper class for int userId)

 With just that information, Spring Data implements and instantiates this Interface at startup
 this makes all of the inherited CRUD methods available to our codebase*/

@Repository //1 of the 4 stereotype annotations - makes this Interface a bean
public interface UserDAO extends JpaRepository<User, Integer> {

    //By simply extending JpaRepository, we get access to a wealth of CRUD operations
    //WE DON'T HAVE TO WRITE:
        //save() - inserts and updates
        //findAll()
        //findById()
        //deleteById()
        //And many many more...


    //Sometimes, you need a more specific CRUD operation that Spring Data can't predict
    //It knows all our Entities will have IDs, but can't predict what your other fields are

    //We can use PROPERTY EXPRESSIONS to define custom CRUD operations
    //Spring just needs the abstract method, and implements it for us
    User findByUsername(String username);

    //This one will be for login
    User findByUsernameAndPassword(String username, String password);


    /*Property Expression NOTE:

        The methods MUST be named like findByXyz, existsByXyz, findByXyzAndAbc
        Where "xyz" is the exact name of one of the fields in your entity

        We need to follow this naming convention so Spring Data can implement the methods for us
        Property expressions are very flexible! Look into all the different options
     */

}
