package com.revature;

import java.lang.*; //we don't need to do this - the .lang package is implicitly imported!

public class Launcher {

	public static void main(String[] args) {

		System.out.println("==================================================(if/elseif/else)");

		double randomNum = Math.random();
		// Math is a Class in the java.lang package. It has methods that let us do basic
		// math stuff

		System.out.println("Today's random number is: " + randomNum);

		if (randomNum > .75) {
			System.out.println("randNum is greater than .75!");
		} else if (randomNum > .50) {
			System.out.println("randNum is between .50 and .75!");
		} else {
			System.out.println("randNum is less than .50!");
		}

		
		System.out.println("==================================================(while/do-while)");

		
		short smallNum = 2;

		while (smallNum < 500) {
			smallNum += 100;
			// we haven't seen += before! It's basically shorthand for smallNum = smallNum +
			// 100;
			// you can use this syntax with any arithmetic operator eg. smallNum /= 2;
			System.out.println("smallNum has increased to " + smallNum + " in the while loop");
		}

		System.out.println("While loop complete!");

		
		do { 
			smallNum -= 100; System.out.println("smallNum has decreased to " + smallNum + " in the do-while loop"); 
		}
		   while (smallNum != 2 && smallNum < 500);

		System.out.println("Do-While loop complete!");

		
		System.out.println("==================================================(For)");

		
		int loopVictim = 0;
		
		//"for as long as this int which starts at zero is less than 10, increment it once per loop"
		for (int i = 0; i < 10; i++) {
			loopVictim += 5;
			System.out.println("Our loop victim is now: " + loopVictim);
			System.out.println("Our loop variable is now: " + i);
		}
		//The loop executed 10 times, once i = 10, the loop completed and didn't execute again
		
		
	    //More complicated use of For loop below...
		
		//This is an Array, which we'll talk more about tomorrow
		char[] myName = {'B', 'E', ' ', 'N', 'A', 'A', 'A'};
		
		System.out.println(myName); //print the Array as it is, without processing
		
		//now let's use some control flow statements to print only the chars that we want
		
		for(int i = 0; i < myName.length; i++) { //.length returns the length of the Array as an int
			
			if(myName[i] == ' ') {
				continue;
				//if the char at position i = ' ', skip the current iteration of the loop.
			} 
			
			if (myName[i] == 'A') {
				break;
				//if the char at position i = 'A', break (end) the loop.
			}
			
			System.out.println(myName[i]); //if none of those if statements run, the char at position i will print.
			
		}
		
		System.out.println(myName); //the actual Array isn't affected by any of this!
		
	}

}
