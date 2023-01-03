package com.revature;

import io.javalin.Javalin;

public class Launcher {

    public static void main(String[] args) {
        Javalin app = Javalin.create(

                //This config lambda lets us specify certain configurations for our Javalin object
                // ->? "For this config object, do the following things"
                //ANYONE USING JAVALIN 5 SHOULD LEAVE THIS OUT
                config -> {
                    config.enableCorsForAllOrigins(); //This lets us process HTTP Requests from anywhere
                }

        ).start(5000);

        AuthController ac = new AuthController();

        app.post("/auth", ac.loginHandler);




    }

}
