package com.revature;

import com.revature.controllers.AuthController;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		AuthController ac = new AuthController();
		
		//Typical Javalin syntax to create a Javalin object
		Javalin app = Javalin.create(
					//the config lambda lets us specify certain configurations.
					config -> {
						config.enableCorsForAllOrigins(); //this allows us to process JS requests from anywhere
					}
				).start(5000); //we need this to start our application on port 3000
		
		app.post("login", ac.loginhandler);
		
	}
	
}
