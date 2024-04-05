package com.revature.daos;

import com.revature.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogDAO extends JpaRepository<Dog, Integer>{

}
