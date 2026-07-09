package com.revature.controllers;

import com.revature.models.Game;
import com.revature.services.GameService;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class GameController {

    private final GameService gameService = new GameService();

    public void getAllGames(Context ctx) {
        ctx.json(gameService.getAllGames());
    }

    public void getGamesByUserId(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("id"));
        List<Game> games = gameService.getGamesByUserId(userId);

        if (games == null || games.isEmpty()) {
            ctx.status(404).result("No games found for that user");
        } else {
            ctx.json(games);
        }
    }

    public void insertGame(Context ctx) {
        Game game = ctx.bodyAsClass(Game.class);
        Game inserted = gameService.insertGame(game);

        if (inserted == null) {
            ctx.status(400).result("Failed to insert game - check your fields");
        } else {
            ctx.status(201).json(inserted);
        }
    }

    public void updateGame(Context ctx) {
        Game game = ctx.bodyAsClass(Game.class);
        Game updated = gameService.updateGame(game);

        if (updated == null) {
            ctx.status(400).result("Failed to update game - check your fields");
        } else {
            ctx.json(updated);
        }
    }
}