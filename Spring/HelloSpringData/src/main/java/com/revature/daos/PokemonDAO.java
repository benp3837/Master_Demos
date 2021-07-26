package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Pokemon;

//JpaRepository takes 2 generics. The first is the entity that is being persisted. 
//The second is the data type of the Primary Key 
public interface PokemonDAO extends JpaRepository<Pokemon, Integer> {

	//an Optional is an object that MAY have whatever the generic is, or it may be null. Avoids NullPointerExceptions!
	public Optional<List<Pokemon>> findByName(String name); //for this method to work, the field must be in camel case 
	
	//We had to define this method signature on our own...
	//But Spring Data will create this method body for us!!!
	
}
