package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	//Note the method signatures of the following doXXX methods. They're always the same.
	//You'll be expected to know this method signature ;)
	
	//overriding the doGet method. 
	//the service method of our HelloServlet will execute this if it receives a GET request. 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter(); //this is how we write to our Response object.
		pw.print("<h1>Hello from your doGet method!<h2>");
		res.setStatus(200); //optional but good to show it working in postman
	}
	
	//Now we have our first servlet! Does anyone have any idea of what we need to do now though?
	//Map the servlet in the web.xml so that tomcat can aknowledge its existence!!
	//get tomcat working and the hello from doGet working. then do our doPost.
	
	//overriding the doPost method. 
	//the service method of our HelloServlet will execute this if it receives a POST request. 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter(); //this is how we write to our Response object.
		pw.print("<h1>Hello from your doPost method!<h2>");
		res.setStatus(200);
	}
	
}
