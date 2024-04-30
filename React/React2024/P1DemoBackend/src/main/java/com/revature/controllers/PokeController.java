package com.revature.controllers;

import com.revature.models.DTOs.IncomingPokeDTO;
import com.revature.models.Pokemon;
import com.revature.services.PokeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin(origins = "http://localhost:3001", allowCredentials = "true")
public class PokeController {

    //autowire pokeService
    private PokeService pokeService;

    @Autowired
    public PokeController(PokeService pokeService) {
        this.pokeService = pokeService;
    }

    //PostMapping for adding a new pokemon
    @PostMapping
    public ResponseEntity<?> addPokemon(@RequestBody IncomingPokeDTO pokeDTO, HttpSession session) {

        System.out.println("Session: " + session.getAttribute("userId"));

        if(session.getAttribute("userId") == null) {
            return ResponseEntity.status(401).body("You must log in to do this!");
        }

        //if there is a valid session, try to add the pokemon to the DB
        try{
            int userId = (int) session.getAttribute("userId");
            pokeDTO.setUserId(userId);
            Pokemon p = pokeService.addPokemon(pokeDTO);
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //GetMapping for getting all pokemon
    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllPokemon(HttpSession session) {

        int userId = (int) session.getAttribute("userId");

        return ResponseEntity.ok(pokeService.getAllPokemon(userId));
    }

}
