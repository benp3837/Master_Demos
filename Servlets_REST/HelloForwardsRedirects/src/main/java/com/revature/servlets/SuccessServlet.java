package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessServlet extends HttpServlet {
	
	//this is bad practice but I'm showing you that it's possible
	//we're gonna override service() directly (instead of a doXXX method)
	//so any request that comes in will be handled by this one method
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html"); //this will set the response to be HTML! (Since we're returning a success page)
		//in the future we'll see how to set the response to be JSON
		//you'll be expected to use servlets to send and recieve JSON in your project.
		PrintWriter pw = res.getWriter();
		//this will be forwarded. It'll have the request that was originally sent with the login
		pw.print("<h2>Welcome " + req.getParameter("userId") + "!</h2>"); //...so we can get the parameters sent with it! 
		pw.print("<a href='logout'>Click Here to Log Out.</a>"); //when clicked, it'll send a request to url/+logout
		//note how href works, you could send it anywhere, like www.google.com. But we're building a logout servlet.
		

		//Note how this servlet can only take forwards... 
		//By only using the service() method, we don't provide a way for anyone to access this servlet directly
		
		//Why is overriding the service() method considered bad practice?
		//Because you should leave room for differentiation for methods
		//You should want people to use the correct methods for what they want, they exist for a reason
		//Much more readable this way too!!
		
		//ok now let's go head and build the logout servlet
	}
}
