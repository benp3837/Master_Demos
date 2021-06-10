package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

public class LoginController {

	ObjectMapper om = new ObjectMapper(); //so we can work with JSON
	private LoginService ls = new LoginService();
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		if(req.getMethod().equals("POST")) { //make sure it's actually getting a POST request before executing
			
			//this process below is to get our JSON String
			
			BufferedReader reader = req.getReader(); //BufferedReader reads text from an input stream 
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line != null) {
				sb.append(line);
				line = reader.readLine();
			}
			
			String body = new String(sb); //because ObjectMapper only takes Strings (not StringBuilder)
			
			//Use the ObjectMapper to read our JSON (now a String) into a LoginDTO class.
			LoginDTO lDTO = om.readValue(body, LoginDTO.class); 

			//do this stuff below AFTER building the login service method--------------------------------
			
			//control flow to determine what happens in the event of a successful/unsuccessful login
			if(ls.login(lDTO.username, lDTO.password)) {
				HttpSession ses = req.getSession(); //return a session to hold user info (if one doesn't exist)
													//remember, sessions are how you remember your different clients
				
				//this info stays on the server. all the client gets is the request's cookie created by getSession()
				ses.setAttribute("user", lDTO); //we'd probably use a User object if this was forreal
				ses.setAttribute("loggedin", true); 
				
				res.setStatus(200);
				res.getWriter().print("Login Successful"); //this won't rly be seen, but postman will show it so it helps
			}else {
				HttpSession ses = req.getSession(false); //will only return a session if one is active. otherwise null.
				if (ses != null) { //if a session exists...
					ses.invalidate(); //kill that session
				}
				res.setStatus(401); //unauthorized
				res.getWriter().print("Login failed");
			}
			
		}
	}
}
