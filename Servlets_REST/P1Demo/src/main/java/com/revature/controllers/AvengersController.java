package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Avenger;
import com.revature.services.AvengersService;

public class AvengersController {

	private AvengersService as = new AvengersService();
	private ObjectMapper om = new ObjectMapper();
	
	public void getAllAvengers(HttpServletResponse res) throws IOException {
		
		List<Avenger> list = as.getAvengers(); //get the list of avengers that the service method got from the dao method
		
		String json = om.writeValueAsString(list); //turn the list into a JSON String
		
		res.getWriter().print(json); //put the JSON into the response object
		
		res.setStatus(200); //override the default 404 error we set in the MasterServlet
		
	}

}
