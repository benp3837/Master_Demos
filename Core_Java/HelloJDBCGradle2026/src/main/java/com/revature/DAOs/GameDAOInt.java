package com.revature.DAOs;

import com.revature.models.Game;

import java.util.List;

public interface GameDAOInt {
    List<Game> getAllGames();
    List<Game> getGamesByUserId(int userId);
    Game insertGame(Game game);
    Game updateGame(Game game);
}
