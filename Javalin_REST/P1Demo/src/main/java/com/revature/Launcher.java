package com.revature;

import com.revature.controllers.AvengerController;
import com.revature.controllers.LoginController;

import io.javalin.Javalin;

public class Launcher {

public static void main(String[] args) {
		
		AvengerController dc = new AvengerController(); //instantiate a AvengerController object to use its methods
		LoginController lc = new LoginController();
		
		//.create() instantiates a Javalin object, and .start() starts the server (you can use any free port)
		Javalin app = Javalin.create(
                config -> {
                    config.enableCorsForAllOrigins();// allows the server to process JS requests from anywhere
                }
		).start(8090);
		
        //GET /avengers => return all avengers
		
        	app.get("/avengers", dc.getAllAvengersHandler);

        //app.get("/avengers/:id", dc.getAvengerByIdHandler);
		
        //app.post("/avengers", dc.createAvengerHandler);
        
        //app.put("/avengers/:id", dc.updateAvengerByIdHandler);
        
        //imagine we had users
        app.post("/login", lc.loginHandler);
        
	}
	
}
