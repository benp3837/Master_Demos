package com.revature;

public class Launcher {

	//This is a class scoped primitive variable. (Note the "static")
	//We will immediately assign the value 5 at declaration. (in other words, we INITIALIZE the variable.)
	static int i = 5;
		
	//This primitive is class scoped but is not given a value at declaration, therefore it is not initialized.
	//Uninitialized primitives will have a default value, generally 0. (false for boolean)
	static int i2;
		
	//This is a class scoped reference variable. For uninitialized reference variables the default value is "null".
	static Launcher launcher; 
	//Launcher is the data type, launcher is the variable name we gave it.

		
	//This is an instance/object scoped variable. (Note no "static")
	double d = 18.95;
	
	public static void main(String[] args) {
		
		System.out.println(i); //printing the initialized class scoped primitive variable
		System.out.println(i2); //printing the uninitialized class scoped primitive variable
		System.out.println(launcher); //printing the uninitialized class scoped reference variable
		
		//System.out.println(d); A static method can not see an instance scoped variables. 
		
		//Remember, static indicates that something belongs to the class itself
		
		
		System.out.println("=================================================");
		
		i2 = -98; //initializing the previously uninitialized primitive variable
		
		launcher = new Launcher(); //initializing the previously uninitialized reference variable
		
		System.out.println(i); //this primitive variable hasn't been changed
		System.out.println(i2); //this primitive variable HAS been changed 
		System.out.println(launcher); //remember, reference variables store the location of an object in memory.
		
		System.out.println(launcher.d); //The launcher object is an instance of the class 
										//so it can access the instance scoped variable.
		
		launcher.i2 = 450; //bad practice, should refence class-scoped variables through the class, not an object.
		
		System.out.println(i2); //good practice
		System.out.println(launcher.i2); //bad practice
		
		
		System.out.println("=================================================");
		
		Launcher launcher2 = new Launcher(); //make a new object of type Launcher
		
		launcher2.d = 1234;
		
		System.out.println(launcher.d); //18.95
		System.out.println(launcher2.d); //1234.0
		//d is an instance scoped variable, each object can have their own value for it.
		
		System.out.println(launcher.i2); //450
		System.out.println(launcher2.i2); //450
		//i2 is a class scoped variable, each object has the same value for it.
		
		System.out.println("=================================================");
		
		launcher.example(true); //calling the example method below
		
		//System.out.println(f); --method scoped variable, not visible outside its method!
		
	}
	
	public void example(boolean b) {
		
		System.out.println(b);
		float f = 25.8f; //example of method scoped variable
		
		System.out.println(f);
		
		if(b) {
			char c = 'c'; //example of block scoped variable
			System.out.println(c);
			System.out.println(f); //f is visible, since we're inside the method
		}
		
		//System.out.println(c); c is blocked scoped in the if statement! 
		//it's not visible outside of the if statement.
		
	}
	
}
