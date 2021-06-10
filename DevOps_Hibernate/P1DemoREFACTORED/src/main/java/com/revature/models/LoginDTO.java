package com.revature.models;

//what the heck is a DTO? Data Transfer Object. A DTO is just a model of some data coming from the client
//your servlet will parse a JSON object sent by the user containing their username and password.
//the username and password will get put into this DTO which gets checked/used by the service layer.
//you NEVER store a DTO in the database! It's purely for data transfer... Data Transfer Object
public class LoginDTO {

	//our LoginDTO has these two fields because that's the info we need to log in 
	public String username;
	public String password;
	
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public LoginDTO() {
		super();
	}
	
}
