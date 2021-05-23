package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get the user inputs from the HTML form, turn them into Java variables
		String username = req.getParameter("userId");
		String password = req.getParameter("password");
		
		RequestDispatcher rd = null; //check the notes - we create a RequestDispatcher to acheive forwards!
		PrintWriter pw = res.getWriter(); //remember this? we create a PrintWriter to write to our Response object
		
		//normally this will be handled in a service layer, actually checking the user credentials against records in a DB
		//but for now we're just gonna hardcode a username and password, no database in this demo lol
		if(username.equals("blandUsername") && password.equals("wasspord")) {
			rd = req.getRequestDispatcher("success"); //if user and pass are good, initialize the RequestDispatcher object
			//we also state the relative path I want to forward to as a String parameter (so url+success)
			rd.forward(req, res); //forward the request and response objects to our success servlet, if successfully logged in.	
		} else {
			rd = req.getRequestDispatcher("index.html"); //if login fails, don't forward, resend the login page (index.html)
			rd.include(req, res); //"this is the request you sent me, this is the HTML page I want to display as a response
			pw.print("<p style='color:red; text-align:center'>Login Failed! );<p>"); //adds to response, tell the user they FAILED.	
		}	
	}
}
