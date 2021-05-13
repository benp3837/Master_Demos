package com.revature;

import com.revature.throwables.*; //import all our throwables

public class Launcher {
	

	public static void main(String[] args) {
		
		
		//the compiler will let you call these methods straight up...
		//but it'll just end up crashing your program once the first Error is thrown via throwError().
		
//		throwError();
//		throwChecked(); //would need "throws" in the method signature to compile
//		throwUnchecked(); //does not need "throws" in the method signature to compile
		
		
		System.out.println("=========================================(Using our Exceptions)");
		
		System.out.println("Starting the main method...");
		
		try { //try will TRY a block of code that may or may not throw an exception
			System.out.println("try block starting...");
			throwChecked(); 
		} catch(MyUncheckedException e) { 
			System.out.println("I won't run - I can only catch Unchecked Exceptions!");
		} catch(MyException e) { 
			System.out.println("Hello from the catch block!");
			System.out.println("Caught MyException!");
			e.printStackTrace(); //print out the error message	
		} catch(Exception e) { 
			System.out.println("I could've caught any Exception..."); 
			e.printStackTrace();
		} finally {
			System.out.println("Hello from the finally block!");
		}
		
			
		
		System.out.println("=======================================(A Couple Misc. Exceptions)");
		
		//these are both unchecked exceptions btw
		
		try {
			System.out.println("I am going to try accessing an index that's out of bounds!");
			int[] nums = {1,2};
			System.out.println(nums[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException caught! That index doesn't exist...");

		
		try {
			System.out.println("I am going to try dividing by zero!");
			int i = 5/0;
		} catch (ArithmeticException a) {
			System.out.println("ArithmeticException caught! You really shouldn't be doing that...");
		}
	
		
		//this won't run! The generic exception catch renders the more specific exception catch unreachable
//		try {
//			System.out.println("I am going to try dividing by zero!");
//			int i = 5/0;
//		} catch(Exception e) {
//			System.out.println("I'm up to no good >:0");
//		}catch (ArithmeticException e) {
//			System.out.println("Arithmetic Exception caught! You really shouldn't be doing that...");
//		}
		
			
	}

	}
	
	//creating some methods that throw our errors/exceptions
	
	public static void throwError() throws MyError {
		System.out.println("I'm about to throw an Error!!!");
		throw new MyError();
	}
	
	public static void throwChecked() throws MyException {
		System.out.println("I'm about to throw a checked Exception!!!");
		throw new MyException();
	}
	
	public static void throwUnchecked() throws MyUncheckedException {
		System.out.println("I'm about to throw an unchecked Exception!!!");
		throw new MyUncheckedException();
	}
	
	
	
}
