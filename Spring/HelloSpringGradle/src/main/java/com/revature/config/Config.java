package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.revature.models.Account;
import com.revature.models.User;

@Configuration
//@ComponentScan("com.revature") //one way to do autowiring - scans the com.revature package for annotations
public class Config {

//	@Bean(name = "user")
//	//@Scope("prototype")
//	public User getUser() {
//		//we include the getAccount method to wire our user bean with the account bean dependency. 
//		//return new User();
//		return new User(getAccount()); //we need to make a new constructor for this (autocomplete it)
//	}
//	
//	@Bean(name="account")
//	public Account getAccount() {
//		return new Account();
//	}
	
}
