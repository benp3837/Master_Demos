package com.revature;

import com.revature.models.Associate;
import com.revature.models.Person;

public class Launcher {

	public static void main(String[] args) {
		
		//Good time to show them importing with ctrl+shift+o
		
		Person philip = new Associate("Philip", 23, "210419");
		
		philip.breathe(); //concrete method from Person 
		
		System.out.println(philip.talk("This is the best course ever!")); //overridden method from Associate
		
		//System.out.println(philip.batch); //Person variable does not have access to associate only field. 
		
		Associate Michael = new Associate("Michael", 25, "210419");
		
		Michael.move(5); //associate overrides this method, and uses a field from Walkable
		
		Michael.trip(); //trip method from Person, who inherits it from Joggable
		
	}
	
}
