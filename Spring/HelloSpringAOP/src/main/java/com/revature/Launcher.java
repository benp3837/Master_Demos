package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.AvengerDAO;
import com.revature.models.Avenger;

public class Launcher {

	public static void main(String[] args) {
		
		//Instantiate an ApplicationContext so we can do stuff with our beans
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Instantiate an AvengerDAO object by getting the bean for it
		//Notice we specify AvengerDAO.class, so we don't have to do the cast
		AvengerDAO dao = ac.getBean(AvengerDAO.class);
		
		//Make a new avenger object using the DAO method
		Avenger a = dao.getById(1);
		
		System.out.println(a);
		
		//Make a new Avenger bean so I can make a brand new Avenger
		Avenger a2 = ac.getBean(Avenger.class);
		
		//Have them choose their own avenger tho...
		a2.setAveId(6);
		a2.setAveName("Scarlet Witch");
		a2.setFirstName("Wanda");
		a2.setLastName("Maximoff");
		a2.setPower("Magic hands");
		a2.setPowerLevel(200);
		
		//using the fight method with our captain america object (this will throw an exception)
		System.out.println(dao.fight(a, "Shield Smash", 18));
		
		System.out.println(dao.fight(a2, "Smack", 1));
		
	}

}
