package com.revature.services;

import com.revature.DAOs.AuthDAO;
import com.revature.DAOs.PokeDAO;
import com.revature.models.DTOs.IncomingPokeDTO;
import com.revature.models.DTOs.OutgoingPokeDTO;
import com.revature.models.Pokemon;
import com.revature.models.User;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<OutgoingPokeDTO> getAllPokemon(int userId) {

        //get the pokemon from the DB
        List<Pokemon> pokes = pokeDAO.findAllByUserUserId(userId);

        //for every pokemon retrieved from the DB, we'll create a new OutgoingPokeDTO
        //and add it to a List to return to the controller
        List<OutgoingPokeDTO> outPokes = new ArrayList<>();

        for(Pokemon p : pokes) {
            outPokes.add(new OutgoingPokeDTO(p.getPokeId(),
                    p.getName(),
                    p.getImage(),
                    p.getUser().getUserId()));
        }

        return outPokes;
    }

    //delete a pokemon
    @Transactional
    public String deletePokemon(int pokeId) {

        //make sure the pokemon exists.
        //we'll also use this in the delete and the return
        Optional<Pokemon> p = pokeDAO.findById(pokeId);

        if(p.isEmpty()) {
            throw new IllegalArgumentException("Pokemon not found!");
        }

        System.out.println(pokeId);
        System.out.println(p.get());

        //remove the pokemon from the user's list of pokemon (or it won't delete)
        p.get().getUser().getPokemon().remove(p.get());

        //perform the delete
        pokeDAO.deleteById(pokeId);

        //return the deleted pokemon (which we instantiated above)
        return p.get().getName();
    }

}
