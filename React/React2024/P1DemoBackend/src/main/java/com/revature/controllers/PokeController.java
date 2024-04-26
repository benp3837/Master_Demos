package com.revature.controllers;

import com.revature.models.DTOs.IncomingPokeDTO;
import com.revature.models.Pokemon;
import com.revature.services.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin
public class PokeController {

    //autowire pokeService
    private PokeService pokeService;

    @Autowired
    public PokeController(PokeService pokeService) {
        this.pokeService = pokeService;
    }

    //PostMapping for adding a new pokemon
    @PostMapping("/{userId}")
    public ResponseEntity<Pokemon> addPokemon(@RequestBody IncomingPokeDTO pokeDTO, @PathVariable int userId) {
        try{
            pokeDTO.setUserId(userId);
            System.out.println(pokeDTO);
            Pokemon p = pokeService.addPokemon(pokeDTO);
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //GetMapping for getting all pokemon
    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        return ResponseEntity.ok(pokeService.getAllPokemon());
    }

}
