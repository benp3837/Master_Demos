package com.revature.throwables;

public class MyUncheckedException extends RuntimeException {

	public MyUncheckedException() {
		super();
	}
	
	public MyUncheckedException(String message) {
		super(message);
	}
	
}
