package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MathOps {

	//here, we're creating a Logger object for the MathOps class
	private static final Logger log = LogManager.getLogger(MathOps.class);

	
	//three super simple methods we'll create unit tests on
	//remember, unit tests tend to test the smallest possible blocks of code, so methods in Java's case
	
	public int add(int i, int j) {
		return i + j;
	}
	
	public int subtract(int i, int j) {
		log.info("Subtract method running!");
		return i - j;
	}
	
	public int divide(int i, int j) {
		log.info("Divide method running!");
		return i / j;
	}
	
}
