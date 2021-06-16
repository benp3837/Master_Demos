package com.revature.models;

import java.util.ArrayList;
import java.util.List;

//This CarDealership class will contain a mock database of Cars. In your P0, you will have a real database
//We're just going to instantiate an Array of Car objects. Essentially hardcoding a database to read/manipulate.
public class CarDealership implements CarDealershipInterface{

	//this Array of Cars will act as our database
	//in your P0, you'll have a DAO (Data Access Object) Class that directly accesses a SQL database with its methods. 
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
	
	//This is a relatively complicated method... Don't worry, this functionality will be easier when we use SQL/JDBC
	public void addCar(Car car) {
		
		Car[] newCarArray = new Car[carArray.length+1]; //make a new Car array with one more Car than the other
		
		//populate the new Array with the contens of the old one (note this will leave one null spot)
		for(int i = 0; i<carArray.length; ++i) {
			newCarArray[i] = carArray[i];
		}
		
		car.carId = newCarArray.length; //normally we'd use a setter for this type of action
		
		newCarArray[carArray.length] = car; //fill in the null spot with the new car
		
		carArray = newCarArray; //assign the new array to the main carArray variable we're using.
		
	}
	
	
	//TAKE HOME PROBLEM!!! Get them to implement this method on their own, and add a CLI option to call it.
	//This is a sort of hard problem if you don't have much Java experience. We'll talk about it tmrw!
	public void getCarsByColor(String color) {
		
	
		for(Car c : carArray) {
			if(c.color.equals(color)) {
				System.out.println(c);
			}
		}
		
	}
	
}
