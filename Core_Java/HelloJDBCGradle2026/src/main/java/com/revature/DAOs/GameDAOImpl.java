package com.revature.DAOs;

import com.revature.models.Game;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAOImpl implements GameDAOInt {

    @Override
    public List<Game> getAllGames() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM video_games";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<Game> games = new ArrayList<>();

            while (rs.next()) {
                Game g = new Game(
                        rs.getInt("game_id"),
                        rs.getString("genre"),
                        rs.getString("title"),
                        rs.getInt("user_id")
                );
                games.add(g);
            }

            return games;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Game> getGamesByUserId(int userId) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM video_games WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            List<Game> games = new ArrayList<>();
            while (rs.next()) {
                Game g = new Game(
                        rs.getInt("game_id"),
                        rs.getString("genre"),
                        rs.getString("title"),
                        rs.getInt("user_id")
                );
                games.add(g);
            }
            return games;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Game insertGame(Game game) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO video_games (genre, title, user_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, game.getGenre());
            stmt.setString(2, game.getTitle());
            stmt.setInt(3, game.getUserId());
            stmt.executeUpdate();

            return game;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Game updateGame(Game game) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE video_games SET genre = ?, title = ?, user_id = ? WHERE game_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, game.getGenre());
            stmt.setString(2, game.getTitle());
            stmt.setInt(3, game.getUserId());
            stmt.setInt(4, game.getGameId());
            stmt.executeUpdate();

            return game;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}