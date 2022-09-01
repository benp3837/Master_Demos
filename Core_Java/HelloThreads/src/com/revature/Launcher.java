package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Launcher {

	public static void main(String[] args) {

		System.out.println("===========================================(Threads)");

		CoolThread ct1 = new CoolThread();
		ct1.setPriority(1); //Priority is a value 1-10. 
		//The higher the number, the more priority the Thread has over others

		CoolThread ct2 = new CoolThread();
		ct2.setPriority(2);

		//These don't actually create new Threads since we didn't use the start() method
		//Hence "main is working"
//		ct1.run();
//		ct2.run();

		System.out.println("Before Threads start() methods");

		ct1.start();
		ct2.start();


		CoolThread ct3 = new CoolThread();
		//ct3.setPriority(5); show with and without a setPriority
		ct3.start();

		System.out.println("===========================================(Streams)");
		//watch how these interact with our running threads
		//why might this be happening?

		//Create a Stream of Integer objects...
		IntStream
				.range(1, 10) //...from 1 to 9...
				.skip(3)//...but skip the first 3 elements...
				.forEach(x -> System.out.println(x)); //...then print it out!


		//Stream.of() is convenient because you can define whatever you want
		//The elements must be of the same data type though.
		Stream.of("Okay", "ben", "yuh", "hello", "bark")
		.sorted() //notice the Stream is sorted alphabetically, with capitals prioritized.
		.forEach(element -> System.out.println(element));

		//Something more interesting - we'll make a Stream from an ArrayList...
		//...filter out duplicates, and we'll skip a certain element
		ArrayList<String> names = new ArrayList<String>(){{
				add("Ben");
				add("Jamie");
				add("Scooby Doo");
				add("The Hamburglar");
				add("Scooby Doo");
		}};
		names.stream() //same as Stream.of(names)
			.distinct() //knocks out the duplicate elements
			.forEach(element -> {
				if(!element.startsWith("The")){ //everything besides "The Hamburglar" will print
					System.out.println("======");
					System.out.println(element);
				}
			});

		//but notice the "names" ArrayList itself does not actually get manipulated
		System.out.println(names);

		//I also want to demonstrate .map(), which lets us apply some function to the stream's elements
		IntStream
			.range(1, 11) //get elements 1-10
			.map(x -> x * x * x) //cube them all
			.average()
			.ifPresent(System.out::println); //if the value is present, print it out
			//:: lets you invoke the println method with an anonymous parameter.
			//so basically it's shorthand for x -> System.out.println(x)

	} //end of main

}
