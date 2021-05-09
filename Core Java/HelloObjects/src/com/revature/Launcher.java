package com.revature;

import com.revature.models.Car; //import the Car class, so that we can access its fields/methods
import com.revature.models.SUV; //import the SUV class 

//import com.revature.models.*; 
//we can use * to import all of the package's contents
//but be careful, this is really resource intensive, consider a package with 500 classes
//if you only want one of those classes, you should just import that class specifically.

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("===========================================(Constructors)");
		
		Car myCar = new Car("Black", 4); //create a new Car object, giving it two arguments (color, speed)
		//Is this a reference variable or a primitive? (reference variable)
		
		System.out.println(myCar); //shows the object's location in memory
		System.out.println(myCar.color);
		System.out.println(myCar.tires);
		
		System.out.println("My Car is " + myCar.color + " and can go " + myCar.maxSpeed + " MPH");
		
		
		System.out.println("======================================(Constructors cont.)");
		
		Car yourCar = new Car(3, "Red", 180, 0.5);
		//another new Car object, with all arguments
		//remember, our all args Constructor actually calls one of our other Constructors!
		
		System.out.println(yourCar); //different location in memory than the myCar Car object
		System.out.println(yourCar.color);
		System.out.println(yourCar.tires);
		
		System.out.println("Your Car is " + yourCar.color + " and can go " + yourCar.maxSpeed + " MPH");
		
		
		System.out.println("==========================================(Casting)");
		
		//This is upcasting - subclass (SUV) gets assigned to superclass (Car)
		Car coolSUV = new SUV(4, "Purple", 100, 0.9, 2); //assign an SUV object to a Car variable
		//legal because an SUV is always a Car.
		//this will go through 3 different constructors!
		
		//System.out.println(coolSUV.seats); - coolSUV is a Car variable, so SUV-specific fields aren't visible.

		//coolSUV = myCar; - This is downcasting, but the compiler will throw an error.
		//illegal because not all Cars are necessarily SUVs.
		
		//here's an 2 examples of legal downcasting (has to be done explicitly.)
		((SUV)coolSUV).seats = 7; //coolSUV is a Car type variable, so seats wouldn't be visible without casting.
		
		SUV newSUV = (SUV)coolSUV; 
		
		//some experimentation below...
		
		System.out.println(newSUV.color);
		System.out.println(coolSUV.color);
		System.out.println(newSUV.seats); //newSUV is a SUV type variable, so seats is visible
		//System.out.println(coolSUV.seats); nope! same issue as above
		
		System.out.println(myCar.getClass());
		System.out.println(yourCar.getClass());
		System.out.println(coolSUV.getClass()); 
		System.out.println(newSUV.getClass());
	
		
		System.out.println("=========================================(Using the Methods)");
		
		System.out.println(yourCar.drive(25)); //the drive() method of Car gets used.
		System.out.println(coolSUV.drive(5)); //the drive() method of SUV, not Car, gets used.
		
		//note, despite coolSUV being a Car type variable, it's still an SUV object
		//thus the overridden drive() method gets called.
		
		newSUV.offRoading(); //offRoading() method of SUV
		//coolSUV.offRoading(); //coolSUV is a Car variable type, so the offRoading() method isn't visible
		//myCar.offRoading(); - doesn't exist in Car class!

	}
	
}
