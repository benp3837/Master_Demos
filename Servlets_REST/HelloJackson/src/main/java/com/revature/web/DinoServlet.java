package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.DinoService;

//the web package talks to the service package
public class DinoServlet extends HttpServlet {
	
	private DinoService ds = new DinoService(); //2.) an object that we'll use to send requests to the DinoService
	
	//1.) I'd like to return all dinos when I receive a get request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//remember to add the findOneDino functionality AFTER doing all the findAllDino functionality
		//everything in the else block is the findAllDino functionality. just 3 lines.
		
		String URI = req.getRequestURI();
		
		String possibleId = URI.replace("/HelloJackson/dinos/", "");
		
		if (!possibleId.equals("")) {
			int id  = 0;

			try {
				id = Integer.parseInt(possibleId);
			} catch (NumberFormatException e) {

			}
			if(id<1) {
				res.setStatus(406);
			}else {
				ds.getOneDino(res, id);
				res.setStatus(200);
				res.setContentType("application/json");
			}
		} else {
		
		res.setContentType("application/json"); //3.) this specifies what type of content is being sent
		
		ds.getDinos(res); //4.) show them that you can just autocomplete this method (which we use to populate the res)
						  //5.) then go fill out the appropriate service method
		res.setStatus(200); //6.) set the status code that gets sent back
		
		//STOP HERE-- you can set up the servlet in the web.xml and show them the GET method working before moving on
		}
	}
	
	//ok that was awesome and exhilarating but NOW, let's use a POST request
	//so instead of doing a GET which will retrieve data, we'll use a POST to send data
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ds.createDino(req);
		res.setStatus(201); //success, resource created.
		ds.getDinos(res); //optional, return the updated array automatically
	}	
	
	//Take note on how the doGET sends the response object, while the doPOST sends the request object
	//We want to get data from the server when we GET. We want to send data to the server when we POST.
	
	//can't figure out how to put an object into your POST in postman?
	//click body, then raw, and you can insert JSON objects to be read there. 
	//make sure to switch it from text to JSON. 
	//Don't forget to delete the ID field, since our Java logic will autogenerate it (which we wrote)
	//Should get 201 response created
	
	//check it with a GET request
	
	//btw, Tim's github has implemented the getDinoById functionality. Depending on time you can do it. It's good practice
	
}
