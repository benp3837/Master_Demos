package com.revature.models;

public class Game {
    private int gameId;
    private String genre;
    private String title;
    private int userId;

    public Game() {}

    public Game(int gameId, String genre, String title, int userId) {
        this.gameId = gameId;
        this.genre = genre;
        this.title = title;
        this.userId = userId;
    }

    public int getGameId() { return gameId; }
    public void setGameId(int gameId) { this.gameId = gameId; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    @Override
    public String toString() {
        return "Game{gameId=" + gameId + ", title='" + title + "', genre='" + genre + "', userId=" + userId + "}";
    }
}
