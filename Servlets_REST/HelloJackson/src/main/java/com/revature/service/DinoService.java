package com.revature.service;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DinoDAO;
import com.revature.models.Dinosaur;

//the service package talks to the dao package
public class DinoService {

	private DinoDAO dd = new DinoDAO(); //an object we'll use to get response data from the DAO
	private ObjectMapper om = new ObjectMapper(); //we need this to turn Java objects into JSON Strings
	
	//this method is related to the DAO method that returns all dinos
	public void getDinos(HttpServletResponse res) throws IOException { //when we use ObjectMapper it usually throws IOEx
		
		Dinosaur[] arr = dd.getAllDinos(); //we create an array with dino data that we get from the dao
		
		String json = om.writeValueAsString(arr); //change the Java array into a JSON array
		//why String? remember, JSON is just a string of characters in a particular format.
		
		res.getWriter().print(json); //take the String holding our JSON and put it into the response object
		//fun fact, the getWriter() method creates a PrintWriter object for us. which has that print() method
		
		//thus we could have done:
		
		/*
		 * PrintWriter pw = res.getWriter();
		 * pw.print(json); 
		 * 
		 * but why write two line when one line do trick?
		 */
	}

	//this method is related to the DAO method that creates dinos
	public void createDino(HttpServletRequest req) throws IOException {
		
		BufferedReader reader  = req.getReader(); //BufferedReader reads the body of the request
												  //(whereas PrintWriter prints to the body of a response)
		StringBuilder sb = new StringBuilder(); //Put the info I get out of the request into something mutable
		
		String line = reader.readLine(); //read the first line of the body.
										 //So every time you call readLine, it reads the next line
		
		while(line != null) { //while there is still content in the body of the request...
			sb.append(line); //add each line to the StringBuilder,
			line = reader.readLine(); //then get the next line.
		}
		
		//now that we have our entire dino in a StringBuilder, we can turn it into a String
		String body = new String(sb); //can't do String body = sb; (cannot convert from String to SB. gotta cast.)
		///ObjectMapper reads Strings, not StringBuilders. So you have to make sure you end with a String. 
		
		Dinosaur dino = om.readValue(body, Dinosaur.class); //read my body and turn it into a Java object!!! (readValue)
		//The ObjectMapper is using the no-id constructor btw
		
		dd.inputDino(dino); //input our new dino using the DAO's inputDino method
		
	}

	public void getOneDino(HttpServletResponse res, int id) throws IOException {
		Dinosaur dino = dd.getDinoById(id);
		String json = om.writeValueAsString(dino);
		res.getWriter().print(json);
	}

	//IOException? Input/Output exception. It's trying to access something outside the Java application
	//so it can't be absolutely sure it's there.
	//We won't handle it, we'll just throw it up
	
	//getting info out of the body of your request can be a little complicated
	//the request object comes with a BufferedReader cause it knows you're going to read the body
		//that's what req.getReader is doing
}
