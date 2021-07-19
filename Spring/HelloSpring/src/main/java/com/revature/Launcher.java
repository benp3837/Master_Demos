package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.config.Config;
import com.revature.models.User;

public class Launcher {

	public static void main(String[] args) {
		
		//Create an Application Context Spring Container
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		
		//Now that we have a container that is storing User and Account beans, we can make some!
		
		//A cast is required because the applicationContext isn't sure what kind of object will be returned
		//why? because getBean returns a generic object so you can specify whatever kind of object you want
		User u = (User)ac.getBean("user"); //in the getBean() method, we give the name of the bean we want 
		
		//Let's look at what our User bean looks like! 
		System.out.println(u);
		//Notice that we got a User object that we created using getBean! 
		//But nowhere did I create an Account object to attach to it
			//Magic of autowiring! 
		
		//Now we can play around with our new User bean. Let's give it some values
		u.setId(1);
		u.setName("CoolUser");
		u.getAccount().setAmount(55865.63);
		u.getAccount().setType("Checking");
		
		System.out.println(u);
		
		System.out.println("====================================");
		
		//Recall bean scopes - Beans are singletons by default
		//If we made our user bean "prototype" scoped, this would return a new user. 
		//However since the account is still singleton scoped, our u3 user and u user would both share the same account. 
		User u3 = (User) ac.getBean("user");
		System.out.println(u3);
		
	}

}

