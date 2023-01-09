package com.revature;

import com.google.gson.Gson;
import io.javalin.Javalin;

public class Launcher {


    public static void main(String[] args) {

        Javalin app = Javalin.create(
                config -> {
                    config.enableCorsForAllOrigins(); //this lets us take in any HTTP requests
                }
        ).start(5000);

        //a really dinky endpoint handler just for the sake of taking in login requests
        app.post("/auth", (ctx -> {

            String loginCreds = ctx.body();

            Gson gson = new Gson();

            LoginDTO lDTO = gson.fromJson(loginCreds, LoginDTO.class);

            if (lDTO.username.equals("trainer") && lDTO.password.equals("password")) {

                lDTO.id = 1;

                String loginJSON = gson.toJson(lDTO);

                ctx.status(202);
                ctx.result(loginJSON);

            } else {
                ctx.status(401); //401 stands for forbidden
            }

        }));

    }
}
