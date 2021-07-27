package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.PokemonDAO;
import com.revature.models.Pokemon;

@RestController
@RequestMapping(value="/pokemon")
public class PokemonController {

	private PokemonDAO pDAO; //need an instance of PokemonDAO to use its methods
	
	//using constructor injection to inject the PokemonDAO
	@Autowired
	public PokemonController(PokemonDAO pDAO) {
		super();
		this.pDAO = pDAO;
	}


	//This method will return a list of all our Pokemon no need for us to write a dao method :)
	@GetMapping
	public ResponseEntity<List<Pokemon>> getAllPokemon(){
		return ResponseEntity.status(200).body(pDAO.findAll()); //We didn't write this findAll() method!! IT COMES FROM JPAREPOSITORY
	}
	

	@GetMapping("/{name}") //the name given as a URL endpoint will be the parameter in this method - hence @PathVariable
	public ResponseEntity<List<Pokemon>> findbyName (@PathVariable String name){
		
		//Remember, an Optional is an object that MAY have whatever the generic is, or it may be null. Avoids NullPointerExceptions!
		Optional<List<Pokemon>> opt = pDAO.findByName(name); 
		
		List<Pokemon> pokeList = null; //instantiate an empty List of Pokemon, to get filled if data is returned successfully
		
		if(opt.isPresent()) { //if my optional exists...
			pokeList = opt.get(); //get the contents of the Optional List and put it into our pokeList
		}
	
		return ResponseEntity.status(200).body(pokeList);
		
	}
	
	@PostMapping
	public ResponseEntity addPokemon(@RequestBody Pokemon p) {
		pDAO.save(p);
		return ResponseEntity.status(201).build();
	}
	
	
}