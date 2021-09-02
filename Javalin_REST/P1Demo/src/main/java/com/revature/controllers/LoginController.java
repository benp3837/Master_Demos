package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;
import com.revature.utils.JwtUtil;

import io.javalin.http.Handler;

public class LoginController {

	LoginService ls = new LoginService();
	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body(); //turn the body of the POST request into a Java String
		
		Gson gson = new Gson(); //rememeber, we need this for JSON -> Java conversions
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); //turn that JSON String into a Java Dinosaur Object
		
		//----------------do this stuff below AFTER building the login service method--------------------------------
		
		//control flow to determine what happens in the event of a successful/unsuccessful login
		
		//execute the login() method of LoginController using the username and password in the newly created LoginDTO
		if(ls.login(LDTO.username, LDTO.password)) { //if login from the LoginService is successful...

		String jwt = JwtUtil.generate("demoMan","password"); //generate a Java Web Token to establish a session(???)
		
		ctx.status(200); //successful status code
		
        ctx.result(jwt); //return the JWT back to the user	
        
		} else {
			ctx.status(401); //unauthorized status code
			
	        ctx.result("Login Failed :(");
		}
		
		
		
	};

}
	
