package com.revature;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("testing testing");
		
		//.create() instantiates a Javalin object, and .start() starts the server (you can use any free port)
		Javalin app = Javalin.create().start(8090);

		//any GET requests to this default endpoint will return this text
		//btw - throwing URLs in a browser sends a GET request. you can search for localhost:8090/ and get this text
		app.get("/", ctx -> ctx.result("Hello Javalin! My application recieved a GET request"));
		
		//any POST requests to this default endpoint will return this text
		//you'd either have to send a POST request in postman or have frontend functionality that sends a post request
		app.post("/", ctx -> ctx.result("Hello Javalin! My application recieved a POST request"));
		
		//what's ctx? the Context object!! It provides a bunch of methods we need to handle HTTP requests/responses
		//we'll usually see them in the Controller classes...
			//the javalin documentation (javalin.io) lists the ctx methods out in good detail :)
		
		//usually we'll be sending requests off to Controller classes, instead of just returning text
		
		//of course, Javalin can handle all other kinds of requests - PUT, PATCH, DELETE, etc
		
		//using Javalin, we can send data back and forth between our front end and back end! Usually in the form of JSON
		//we'll see this in practice in the HelloJackson demo...
		
		
		//just for fun, let's use a before handler and an after handler (as opposed to the two endpoint handlers above)
		app.before(ctx -> {
			System.out.println("Hello console :) I run BEFORE every request!");
		});
		
		app.after(ctx -> {
			System.out.println("Hello again console :) I run AFTER every request!");
		});
		
	}

}
