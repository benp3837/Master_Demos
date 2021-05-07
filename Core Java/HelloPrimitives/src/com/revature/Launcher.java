package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		//great time to have them practice syso + space and clicking the min/max functions
		//show them dat nice workflow
		
		System.out.println("======================================(Integer Primitives)");
		
		//these first 5 primitives are integer numbers
		//whole numbers, no decimal
		
		byte b = 1; //1 byte in size
		System.out.println(b); 
		System.out.println(Byte.MIN_VALUE); //-128
		System.out.println(Byte.MAX_VALUE); //127
		
		short s = 300;//2 bytes in size
		System.out.println(s);
		System.out.println(Short.MIN_VALUE); //-32768
		System.out.println(Short.MAX_VALUE); //32767
		
		char c = 'a';//2 bytes in size
		char c2 = '$';
		char c3 = '7';
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(Character.MIN_VALUE + "(a blank space)"); //
		System.out.println(Character.MAX_VALUE); // ?
		
		int i = 20000;//4 bytes in size 
		System.out.println(Integer.MIN_VALUE); //-2147483648
		System.out.println(Integer.MAX_VALUE); //2147483647

		
		long l = 9000000000000000000L;//8 bytes in size
		System.out.println(Long.MIN_VALUE); //very low
		System.out.println(Long.MAX_VALUE); //very high
		
		System.out.println("======================================(Floating Point Primitives)");
		
		//these next 2 primitives are floating point numbers
		//they can have decimals
		
		float f = 1.1f;//4 bytes in size
		System.out.println(f);
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		

		double d = 2.2;//8 bytes in size
		System.out.println(d);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_VALUE);
		
		
		System.out.println("======================================(Boolean)");
		
		//the last primitive is boolean
		//this is the only way to denote true or false
		//cannot use 1 for true or 0 for false, no using null, only boolean
		boolean bool = true;	
		System.out.println(bool);
		
		boolean bool2 = false;
		System.out.println(bool2);
		
		
		System.out.println("======================================(Arithmetic Operators)");

		//Let's quickly run through the arithmetic operators
		
		//creating some variables to play with
		
		int plus = 5 + 5; //10
		int minus = 20 - 10; //10
		int mult = 5 * 2; //10
		int div = 100 / 10; //10
		int rmndr = 30 % 20; //10
		//% (aka modulus) is the only potentially confusing one, it returns the remainder.

		System.out.println(plus + minus + mult + div + rmndr); //50
		System.out.println(plus - minus - mult - div - rmndr); //-50
		System.out.println(plus * minus); //100
		System.out.println(plus / minus); //1
		System.out.println(plus % minus); //0
		
		
		System.out.println("=======================(Increment/Decrement)");
		
		//We also have increment (++) and decrement (--), very useful in loops
		
		int funnyNumber = 24;	
		System.out.println(funnyNumber);
		
		funnyNumber++;
		System.out.println(funnyNumber); 
		
		--funnyNumber;
		System.out.println(funnyNumber);
		
		//Difference between putting the increment/decrement before and after the variable?
		
		//A prefix increment/decrement returns the value of a variable AFTER it has been incremented.
		//A suffix increment/decrement returns the value of a variable BEFORE it has been incremented.
		
		int incTest = 20;
		
		System.out.println("incTest before change: " + incTest);
	
		System.out.println("During prefix increment: " + ++incTest);
		//increment incTest, and print the new value
		
		System.out.println("After prefix increment: " + incTest);
		
		incTest = 20; //set incTest back to 20
		
		System.out.println("Resetting incTest: " + incTest);
		
		System.out.println("During suffix increment: " + incTest++);
		//print the value of incTest, then increment it
		
		System.out.println("After suffix increment: " + incTest);
		
	}
	
}
