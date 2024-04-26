package com.revature.services;

import com.revature.DAOs.AuthDAO;
import com.revature.DAOs.PokeDAO;
import com.revature.models.DTOs.IncomingPokeDTO;
import com.revature.models.Pokemon;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokeService {

    //autowire pokeDAO and userDAO
    private PokeDAO pokeDAO;
    private AuthDAO authDAO;

    @Autowired
    public PokeService(PokeDAO pokeDAO, AuthDAO authDAO) {
        this.pokeDAO = pokeDAO;
        this.authDAO = authDAO;
    }

    //add pokemon to DB
    public Pokemon addPokemon(IncomingPokeDTO pokeDTO) {

        //we know there will be a name, this is just an example
        //this would be more useful for situations where we take user input for their names
        if(pokeDTO.getName() == null || pokeDTO.getName().equals("")) {
            throw new IllegalArgumentException("Invalid Pokemon name!");
        }

        //need to get the user from the incoming DTO and attach it to the pokemon
        Pokemon pokemon = new Pokemon(
                pokeDTO.getName(),
                pokeDTO.getImage(),
                authDAO.findById(pokeDTO.getUserId()).get());

        return pokeDAO.save(pokemon);
    }

    //get all pokemon
    public List<Pokemon> getAllPokemon() {
        return pokeDAO.findAll();
    }

}
