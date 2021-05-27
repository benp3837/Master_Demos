package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.AvengersController;

//Remember, this is our front controller. so ALL requests will come here first
public class MasterServlet extends HttpServlet { //who remembers what I have to extend?
	
	private AvengersController ac = new AvengersController(); //First controller, handles Avengers stuff
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("application/json");
		
		//by default, tomcat will send back a successful status code (200) if a request gets handled by a method
		//since we have a master servlet that takes all requests, this means every request will get handled by it. 
		//but we don't want a 200 if the request isn't actually handled correctly (or if the endpoint given doesn't exist)
		//thus, we'll set 404 as our default status code.
		//if a request goes through successfully, this should change at some point in our code.
		res.setStatus(404); 
		
		//now we want to write some code that will determine where the request gets sent.
		
		String URI = req.getRequestURI().replace("/P1Demo/", ""); //get the request URI and strip out the base path
																  //so we'll just be left with the end of the URI
		
		switch (URI) { 
		
		case "avengers":
			ac.getAllAvengers(res); //if the URI is avengers, execute the controller method and send it the response obj
			
		
			
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
	
}
