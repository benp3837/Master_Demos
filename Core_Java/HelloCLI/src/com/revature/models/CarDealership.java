package com.revature.models;


//This CarDealership class will act as our fake database for now
//We're just going to instantiate an Array of Car objects. Essentially hardcoding a database to read/manipulate.
public class CarDealership {

	Car[] carArray = { 
		new Car(1, 4, "blue"),	
		new Car(2, 4, "red"),
		new Car(3, 3, "blue"),
		new Car(4, 4, "yellow")
	};
	
	
	
	//some methods that we can call with the CLI
	
	public Car[] getAllCars() {
		return carArray;
	}
	
	public Car getCarById(int id) {
		return carArray[id - 1]; //-1 because Arrays are zero-indexed 
	}
	
	public void addCar(Car car) {
		
		Car[] newCarArray = new Car[carArray.length+1]; //new Car array with one more Car than the other
		
		//populate the new Array with the contens of the old one (note this will leave one null spot)
		for(int i = 0; i<carArray.length; ++i) {
			newCarArray[i] = carArray[i];
		}
		
		car.carId = newCarArray.length; //normally we'd use a setter for this type of action
		
		newCarArray[carArray.length] = car; //fill in the null spot with the new car
		
		carArray = newCarArray; //assign this new array to the main one we're using.
		
	}
	
	
	//TAKE HOME PROBLEM!!! Get them to implement this ______  method on their own, and add a menu option to call it.
	//We'll talk about it tmrw...
	//Don't overthink it, it's a bit easier than adding a car in my opinion.
	public void deleteCar(int id) {
		
	}
	
}
