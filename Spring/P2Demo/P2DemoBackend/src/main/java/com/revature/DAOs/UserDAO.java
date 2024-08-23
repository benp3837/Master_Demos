package com.revature.DAOs;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/*By extending JpaRepository, we get access to various DAO methods that we don't need to write

 JpaRepository takes two generics:
 -The Java Model we intend to perform DB operations with
 -The data type of the Primary Key of that Model */
@Repository //1 of the 4 stereotype annotations. Registers this Interface as a Bean
public interface UserDAO extends JpaRepository<User, UUID> {

    /*I want to be able to find a User by their username
    Since JpaRepository doesn't have that method, we need to make one ourselves
    Spring Data is smart enough to implement this method for us. We just need to define the abstract*/
    public User findByUsername(String username);

    /* NOTE: The method MUST be named "findByXyz", otherwise it won't work as intended

        How does Spring Data know? It's based on the name of the field in your Class
        another example: findByUsernameAndPassword, findByUsernameAndPasswordAndEmail

        This is referred to as a PROPERTY EXPRESSION. Look into them, there are a LOT of options */

}
