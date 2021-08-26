package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.DinoDAO;
import com.revature.models.Dinosaur;

import io.javalin.http.Handler;

//reading path parameters is a controller specific duty
//Controllers will usually call Services, but we're going straight to the DAO here for time's sake. 
public class DinoController {

	DinoDAO dao = new DinoDAO();
	
	//Below are our Javalin handlers, which HANDLE incoming HTTP requests, and potentially send back a response.
	//what's ctx? the Context object!! It provides a bunch of methods we need to handle HTTP requests/responses
	
	public Handler getAllDinosHandler = (ctx) -> {
		
		Dinosaur[] allDinos = dao.getAllDinos(); //we create an array with dino data that we get from the dao
		
		Gson gson = new Gson(); //instantiate a GSON object to make JSON <-> POJO conversions
		
		String JSONDinos = gson.toJson(allDinos); //convert any Java object or collection into a JSON String 
		
		ctx.result(JSONDinos); //return our dinos
		
		ctx.status(200); //success :)
		
	};


	public Handler getDinoByIdHandler = (ctx) -> {
		
		int id = Integer.parseInt(ctx.pathParam("id")); //take the given path param (id) and parse it into an int
		
		Dinosaur dino = dao.getDinoById(id); //get the dino using the appropriate dao method
		
        if(dino == null){ //if no dino is found with the given id, do this 
        	
            ctx.result("Dino not found!");
            
            ctx.status(404);
            
        }else{ //otherwise, turn the dino into JSON, and send it back to the user in the response
        	
            Gson gson = new Gson();
            
            String bookJSON = gson.toJson(dino);
            
            ctx.result(bookJSON);
            
            ctx.status(200);
        }
		
	};

	public Handler createDinoHandler = (ctx) -> {
		
		String body = ctx.body(); //the body will contain a JSON with the dino information. Turn it into a String!
		
        Gson gson = new Gson();
        
        Dinosaur dino = gson.fromJson(body, Dinosaur.class); //turn that JSON String into a Java Dinosaur Object
		
        dao.inputDino(dino); //use the dao method to create a new dino using our new Dinosaur object
        
        ctx.status(201); //created!
        
        String json = gson.toJson(dino); //optional - turn that Java object back into JSON if we wanna send it back
        
        ctx.result(json); //optional - send back the dino object that we just inputted into the database
      
	};
	
	
	
}
