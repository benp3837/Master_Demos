package com.revature.factory;

//Factories are one of the best ways to create objects in Java
//Imagine a scenario where there are multiple different types of one Object that we can potentially make.
//we can use a factory, paired with an Interface (in this case, Cookie) to abstract away all that decision making code!

public class CookieFactory {

	//use the getCookie method to get an object of type Cookie (anything that implements the Cookie Interface)
	public Cookie getCookie(String cookieType) {
		
		//control flow to determine what kind of Cookie to make (based on the cookieType parameter)
		if(cookieType == "SNICKERDOODLE") {
			return new Snickerdoodle();
		} else if(cookieType == "OATMEALRAISIN") {
			return new OatmealRaisin();
		} else if(cookieType == "CHOCOLATECHIP") {
			return new ChocolateChip();
		} else {
			return null; //in case the cookieType argument doesn't match any of the if statements
		}
		
	}
}
