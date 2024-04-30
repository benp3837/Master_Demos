package com.revature.DAOs;

import com.revature.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokeDAO extends JpaRepository<Pokemon, Integer> {

    public List<Pokemon> findAllByUserUserId(int userId);

}
