package com.revature;

import com.revature.factory.Cookie;
import com.revature.factory.CookieFactory;
import com.revature.singleton.Singleton;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("===============================================================(Using the Singleton)");
		
		//creating 3 different instances of our Singleton Class
		Singleton x = Singleton.getInstance();
		Singleton y = Singleton.getInstance();
		Singleton z = Singleton.getInstance();
		
		//printing the singletonMessage field
		System.out.println("x: " + x.singletonMessage);
		System.out.println("y: " + y.singletonMessage);
		System.out.println("z: " + z.singletonMessage);
		
		//changing the variable of instance x
		x.singletonMessage = (x.singletonMessage).toUpperCase();
		
		//printing the singletonMessage field after changing instance x
		System.out.println("x: " + x.singletonMessage);
		System.out.println("y: " + y.singletonMessage);
		System.out.println("z: " + z.singletonMessage);

		//we see that changing the singletonMessage field of one instance changes it for all instances...
		//what's the point of this??
		
		//This allows a global point of access to the Class. 
		//Every instance of the Singleton will refer to the same Object. This allows for behavioral consistency
		
		//Usually, singletons aren't a great idea honestly. We won't usually make our own.
		//But know what they are because lots of built in classes in Java use them
		
		System.out.println("==========================================================(Using the Factory)");
		
		CookieFactory cf = new CookieFactory(); //instantiate a CookieFactory to use its getCookie method
		
		//use the getCookie method of the CookieFactory to get new Objects of type Cookie
		Cookie cookie1 = cf.getCookie("SNICKERDOODLE");
		Cookie cookie2 = cf.getCookie("OATMEALRAISIN");
		Cookie cookie3 = cf.getCookie("CHOCOLATECHIP");
		
		//use the getBaked method of each new Cookie object, notice how they're all of their respective Cookie types!!
		cookie1.getBaked();
		cookie2.getBaked();
		cookie3.getBaked();
		
		//Thanks to the power of abstraction (Factory design pattern)... Making Cookie objects is way cleaner! 
		//We hid ugly decision making code in the CookieFactory Class, and can now just use the getBaked() method.
		
	}
	
}
