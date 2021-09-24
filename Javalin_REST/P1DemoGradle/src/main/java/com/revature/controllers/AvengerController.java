package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Avenger;
import com.revature.services.AvengerService;

import io.javalin.http.Handler;

//the controller layer sits between the Launcher (with Javalin) and the service layer
//this is usually where we'll parse JSON into Java or vice versa
//We'll either be getting data from the service (which got it from the DAO/Database)
//or sending data to the service (which will validate it and send it to the DAO/Database)
public class AvengerController {

	private AvengerService as = new AvengerService();

	
	public Handler getAllAvengersHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { //if a session exists...
			
			System.out.println("user is logged in and has a session");
			
			List<Avenger> allAvengers = as.getAllAvengers(); //we create an array with avenger data (using service to talk to dao)
			
			Gson gson = new Gson(); //instantiate a GSON object to make JSON <-> POJO conversions
			
			String JSONAvengers = gson.toJson(allAvengers); //convert any Java object or collection into a JSON String 
			
			ctx.result(JSONAvengers); //return our dinos
			
			ctx.status(200); //success :)
			
		} else {
			System.out.println("user is NOT logged in and doesn't have a session");
			ctx.status(403); //forbidden
		}
		

		
	};

}
