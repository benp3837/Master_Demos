package com.revature;

public class Launcher {

	//This is a class scoped variable. We will immediately assign the value 5 at declaration. 
	static int i = 5;
		
	//This is class scoped but is not given a value at declaration, we say therefore it is not initialized.
	//Uninitialized primitives will have a default value, generally 0. 
	static int i2;
		
	//This is a class scoped reference variable. For uninitialized reference variables the default value is "null".
	static Launcher d; 
		
	//This is an instance/object scoped variable. 
	double d2 = 18.95;
	
	public static void main(String[] args) {
		
		System.out.println(i);
		System.out.println(i2);
		System.out.println(d);
		//System.out.println(d2); The static method can not see the instance scoped variables. 
		
		i2 = -98;
		
		d = new Launcher();
		
		System.out.println("=================================================");
		System.out.println(i);
		System.out.println(d.i2); //bad practice, should refernce through class but possible. 
		System.out.println(d);
		System.out.println(d.d2); //The object is an instance of the class so can access the class variable.
		
		d.i2 = 450;
		
		System.out.println(i2);
		System.out.println(d.i2);
		
		Launcher drive = new Launcher();
		
		drive.d2 = 1234;
		
		System.out.println(d.d2);
		System.out.println(drive.d2);
		System.out.println(d.i2);
		System.out.println(drive.i2);
		
		drive.example(true);
		
	}
	
	public void example(boolean b) {
		
		System.out.println(b);
		float f = 25.8f;
		
		System.out.println(f);
		
		if(b) {
			char c = 'c';
			System.out.println(c);
			System.out.println(f);
		}
		
		//System.out.println(c); c is blocked scoped in the if statement. 
		
	}
		
	
}
