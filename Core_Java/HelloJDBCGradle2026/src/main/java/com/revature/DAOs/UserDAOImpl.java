package com.revature.DAOs;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAOInt {

    @Override
    public List<User> getAllUsers() {

        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "SELECT * FROM users";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<User> users = new ArrayList<>();

            while (rs.next()) {
                User u = new User(
                        rs.getInt("user_id"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("username")
                );
                users.add(u);
            }

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserById(int userId) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                User u = new User(
                        rs.getInt("user_id"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("username")
                );
                return u;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User insertUser(User user) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO users (password, role, username) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getRole());
            stmt.setString(3, user.getUsername());
            stmt.executeUpdate();

            // return the new user (no need for ID but you could get it... tediously)
            return user;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User updateUser(User user) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE users SET password = ?, role = ?, username = ? WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getRole());
            stmt.setString(3, user.getUsername());
            stmt.setInt(4, user.getUserId());
            stmt.executeUpdate();

            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
