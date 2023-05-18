package com.revature.controllers;

import io.javalin.http.Handler;

public class GreetingController {

    public Handler SayHiHandler = (ctx) -> {

        if(AuthController.ses != null){
            ctx.status(200);
            ctx.result(AuthController.ses.getAttribute("greeting").toString());
        } else {
            ctx.status(401);
            ctx.result("I won't say hi to you til you log in.");
        }

    };

}
