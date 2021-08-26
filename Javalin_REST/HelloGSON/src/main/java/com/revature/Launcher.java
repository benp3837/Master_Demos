package com.revature;

import com.revature.controllers.DinoController;

import io.javalin.Javalin;

public class Launcher {
	
	public static void main(String[] args) {
		
		DinoController dc = new DinoController(); //instantiate a DinoController object to use its methods
		
		//.create() instantiates a Javalin object, and .start() starts the server (you can use any free port)
		Javalin app = Javalin.create().start(8090);
		
        // GET /dinos => return all dinos
        // this will send a GET request with endpoint /dinos to the getAllDinosHandler, which will get dinos from the DAO
        app.get("/dinos", dc.getAllDinosHandler);
		
        // GET /dinos/2 => return the dino with id = 2
        app.get("/dinos/:id", dc.getDinoByIdHandler);
		
        //POST /dinos => create a new dino
        app.post("/dinos", dc.createDinoHandler);
        
	}

}
