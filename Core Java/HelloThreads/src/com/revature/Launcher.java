package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
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
		
	}
	
}
