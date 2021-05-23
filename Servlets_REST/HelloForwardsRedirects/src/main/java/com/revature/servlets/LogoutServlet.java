package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	
	//we'll use a redirect here instead of a forward
	
	//btw, what's IOException?
	//IOException happens when there is a failure during reading, writing, and searching file or directory operations
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.sendRedirect("http://www.google.com"); //normally we would probably just redirect to the homepage with ""
											//But we have fun here
		
		//done with our servlets! Let's go map them in the web.xml
	}

}
