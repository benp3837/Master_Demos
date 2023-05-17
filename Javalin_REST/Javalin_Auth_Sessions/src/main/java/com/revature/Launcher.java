package com.revature;

import com.revature.controllers.AuthController;
import io.javalin.Javalin;

public class Launcher {

    public static void main(String[] args) {

        AuthController ac = new AuthController();

        //In order to use Javalin in our application, we need a Javalin object!
        Javalin app = Javalin.create().start(3000);

        /* we need .start() to start our Java server on some specific port
        You can do any port, I chose 3000 because probably nothing is using it.
        a port is like a parking space for an application, where messages etc. can find it */

        app.post("/auth", ac.LoginHandler);

    }

}
