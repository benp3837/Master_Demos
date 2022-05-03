package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;

import io.javalin.http.Handler;

public class AuthController {

	public Handler loginhandler = (ctx) -> {
		
		String loginCreds = ctx.body();
		
		System.out.println(loginCreds);
		
		Gson gson = new Gson();
		
		LoginDTO lDTO = gson.fromJson(loginCreds, LoginDTO.class);
		
		if(lDTO.username.equals("trainer") && lDTO.password.equals("password")) {
			ctx.status(202);
			
			//of course, we're hardcoding the user's id here, but if done with a DB, the users ID will definitely be > 0.
			lDTO.id = 1;
			
			String JSONlogin = gson.toJson(lDTO);
			
			ctx.result(JSONlogin);
		} else {
			ctx.status(401);
		}
		
	};
	
}
