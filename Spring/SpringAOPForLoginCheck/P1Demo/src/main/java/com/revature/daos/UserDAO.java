package com.revature.daos;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*By extending JpaRepository, we get access to various DAO methods that we don't need to write

    JpaRepository takes two generics:
    -The Java Model we intend to perform DB operations with (User => users table in this case)
    -The datatype of the Primary Key field in the Model (Integer => userId in this case */
@Repository //1 of the 4 stereotype annotations. It registers this class as a Spring Bean
public interface UserDAO extends JpaRepository<User, Integer> {

    /*I want to be able to find a User by their username
      Unfortunately, Spring Data doesn't have a built in method for that
      So we have to define our own method signature, and Spring will implement it for us
      ****This is called a PROPERTY EXPRESSION */
    User findByUsername(String username);

    /*NOTE: The method MUST be named findByXyz, where Xyz is the name of a field in User

     How does Spring Data know? It's based on the name of the field in the Model
     more examples: User findByUsernameAndPassword, List<User> findByRole

    Property Expressions are quite flexible, look into them for more patterns!*/

}
