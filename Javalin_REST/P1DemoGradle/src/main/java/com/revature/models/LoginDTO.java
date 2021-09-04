package com.revature.models;

//What the HECK is a DTO? Data Transfer Object. A DTO is just a model of some data coming from the client.
//An HTTP handlers will parse a JSON object sent by the user, containing their username and password, 
//which gets sent to the controller to be turned into a Java object
//The username and password will be put into this DTO as fields, which will get checked/validated by the service layer
//you NEVER store a DTO in the database. It's purely for data transfer... hence Data Transfer Object

public class LoginDTO {

	//our LoginDTO is going to store the username/password sent in by the user
	public String username;
	public String password;

	
	//then I just want two constructors so we can instantiate LoginDTO objects
	
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	
}
