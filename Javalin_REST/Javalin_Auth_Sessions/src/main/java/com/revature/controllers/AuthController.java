package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import io.javalin.http.Handler;

public class AuthController {

    public Handler LoginHandler = (ctx) -> {

        Gson gson = new Gson();

        LoginDTO lDTO = gson.fromJson(ctx.body(), LoginDTO.class);

        System.out.println(lDTO);

        if(lDTO.getUsername().equals("username") && lDTO.getPassword().equals("password")){
            ctx.status(202);
            ctx.result("Logged In!");
        } else{
            ctx.status(401);
            ctx.result("Login Failed!");
        }

    };

}
