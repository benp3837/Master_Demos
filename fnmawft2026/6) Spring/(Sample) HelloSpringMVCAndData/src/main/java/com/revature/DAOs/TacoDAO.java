package com.revature.DAOs;

import com.revature.models.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacoDAO extends JpaRepository<Taco, Integer> {

}
