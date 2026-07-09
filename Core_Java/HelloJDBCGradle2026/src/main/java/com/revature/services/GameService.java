package com.revature.services;

import com.revature.DAOs.GameDAOImpl;
import com.revature.models.Game;

import java.util.List;

public class GameService {

    private final GameDAOImpl gameDAO = new GameDAOImpl();

    public List<Game> getAllGames() {
        return gameDAO.getAllGames();
    }

    public List<Game> getGamesByUserId(int userId) {
        // Validation: ID must be positive
        if (userId <= 0) {
            System.out.println("Invalid user ID");
            return null;
        }
        return gameDAO.getGamesByUserId(userId);
    }

    public Game insertGame(Game game) {
        // Validation: title can't be blank
        if (game.getTitle() == null || game.getTitle().isBlank()) {
            System.out.println("Game title cannot be blank");
            return null;
        }
        return gameDAO.insertGame(game);
    }

    public Game updateGame(Game game) {
        // Validation: must have a valid ID to know which record to update
        if (game.getGameId() <= 0) {
            System.out.println("Cannot update game without a valid ID");
            return null;
        }
        return gameDAO.updateGame(game);
    }
}