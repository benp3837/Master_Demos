package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class UserController {

    private final UserService userService = new UserService();

    public void getAllUsers(Context ctx) {
        ctx.json(userService.getAllUsers());
    }

    public void getUserById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        User user = userService.getUserById(id);

        if (user == null) {
            ctx.status(404).result("User not found");
        } else {
            ctx.json(user);
        }
    }

    public void insertUser(Context ctx) {
        User user = ctx.bodyAsClass(User.class);
        User inserted = userService.insertUser(user);

        if (inserted == null) {
            ctx.status(400).result("Failed to insert user - check your fields");
        } else {
            ctx.status(201).json(inserted);
        }
    }

    public void updateUser(Context ctx) {
        User user = ctx.bodyAsClass(User.class);
        User updated = userService.updateUser(user);

        if (updated == null) {
            ctx.status(400).result("Failed to update user - check your fields");
        } else {
            ctx.json(updated);
        }
    }
}