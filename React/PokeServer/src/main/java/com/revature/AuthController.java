package com.revature;

import com.google.gson.Gson;
import io.javalin.http.Handler;

public class AuthController {

    public Handler loginHandler = (ctx) -> {

        String loginCreds = ctx.body();

        Gson gson = new Gson();

        LoginDTO lDTO = gson.fromJson(loginCreds, LoginDTO.class);

        if(lDTO.username.equals("trainer") && lDTO.password.equals("password")) {

            lDTO.id = 1;

            String loginJSON = gson.toJson(lDTO);

            ctx.status(202);
            ctx.result(loginJSON);

        } else {
            ctx.status(401); //401 stands for forbidden
        }

    };

}
