package com.revature;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.services.LoginService;

public class Tests {
	
	LoginService ls = new LoginService();
	
	@Test //we need the @Test annotation in order for this to be recognized as a testing method
	public void testValidLogin() {
		System.out.println("TESTING VALID LOGIN...");
		
		assertTrue(ls.login("demoMan", "password"));
	}
	
	@Test //we need the @Test annotation in order for this to be recognized as a testing method
	public void testInvalidLogin() {
		System.out.println("TESTING INVALID LOGIN...");
		
		assertFalse(ls.login("sadfadsfdsfaf", "gdfgfddsfas"));
	}
	
	
	
	
}
