package com.revature;

import java.util.Scanner; //import our Scanner class from java.util

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("======================================(Testing String Equality)");
		
		String s1 = "Hi Java";
		String s2 = "Hi Java"; //since s2 is the same as s1, they will refer to the same object in memory
		String s3 = "hi java";
		String s4 = new String("Hi Java"); //since we specify new, s4 will be a new object in memory
		
		System.out.println(s1 == s2); //true
		System.out.println(s1 == s3); //false
		System.out.println(s1 == s4); //false, they aren't the same object in memory
		System.out.println(s1.equals(s4)); //true, the value of the characters are the same
		
		//see why we tend to use .equals with Strings and == with primitives?
		//we're usually comparing the value of the variables, not whether they're the same object in memory.
		
		System.out.println("=======================================(Some String Methods)");
		
		//Remember, Strings AREN'T primitives. We assign String objects to reference variables.
		//The Strings we're working with are objects/instantiations of the String Class
		
		String pangram = "Sphinx of Black Quartz, Judge my Vow";
		
		//hopefully these methods are self-explanatory ;)
		System.out.println(pangram.toLowerCase());
		System.out.println(pangram.toUpperCase());
		
		//length() returns the length of the String, similar to .length in Arrays
		System.out.println("The pangram is " + pangram.length() + " characters long");
		
		//charAt() returns the character at a given index.
		System.out.println(pangram.charAt(0)); //first character
		System.out.println(pangram.charAt(pangram.length() - 1)); //last character
		//using charAt in a for loop
		for(int i = 0; i < pangram.length(); i++) {
			System.out.println(pangram.charAt(i));
		}
		
		//System.out.println(pangram.charAt(pangram.length())); 
		//why doesn't this ^^^ work? Because of zero indexing! the indeces go from 0-35, not 1-36.
		//so there IS NO char at index 36. You'll get a nice IndexOutOfBoundsException
		
		
		//find the index where a certain string occurs
		System.out.println(pangram.indexOf("a"));
		System.out.println(pangram.lastIndexOf("a"));
		
		//return a substring of the full String
		System.out.println(pangram.substring(5, 20));
		
		
		//note that using these methods WON'T change the original pangram String.
		//we've been using methods to print manipulations of it, but they aren't stored as new objects
		//Strings are immutable!!! see stringBuilder below for immutable String-like behavior 
		
		//you could always assign a new String variable to these manipulations, eg:
		String s5 = s1 + s2.length() + s3.toUpperCase() + pangram.charAt(5);
		System.out.println(s5);
		//ugly but proves my point lol
		
		
		//one more method (though there are many). split() will create an Array via specified partitions
		String[] words = pangram.split(" "); //split on the empty spaces in the pangram
		
		for(String word : words) { //enhanced for loop. WOAH... "for every String in the words Array, do this"
			System.out.println(word);
		}
				
		System.out.println("=====================================================(Using StringBuilder)");
		
		StringBuilder sb = new StringBuilder(pangram); 
		
		sb.reverse(); //reverse the characters
		sb.append("BENJAMIN"); //append something (add it to the end)
		sb.insert(12, "AYO"); //insert something at a given index
		sb.delete(3, 6); //delete a substring from a range of indeces
		sb.replace(0, 1, s5); //replace a substring with something else
		
		System.out.println(sb); //what even is this	
		
		//note that every method we ran on sb actually changed the object!!
		//StringBuilder (and the basically-obsolete StringBuffer) are mutable, unlike Strings

		System.out.println("========================================================(Scanner)");
		
		//create a Scanner object
		Scanner scan = new Scanner(System.in); //System.in represents the console
		
		/*
		 * String s = scan.nextLine(); //gather user input and go to the next line
		 * System.out.println(s); //print the gathered user input
		 */
		
		System.out.println("What's your name?");
		String name = scan.nextLine(); 	
		
		System.out.println(name + " huh?... Lovely name, bro");
		
		System.out.println("How old are you?");
		int age = scan.nextInt(); //nextInt() will grab the integer, but doesn't make a new line
		scan.nextLine(); //we need to go to the next line with nextLine()
		//^^^^^try and show them what happens without doing this first
		
		System.out.println("What!? " + age + "?? What's your secret?");	
		String secret = scan.nextLine();
		System.out.println("OK! Starting tomorrow I'll " + secret);
		
		
		//ba
		//2
		//im baby
	}
	
}
