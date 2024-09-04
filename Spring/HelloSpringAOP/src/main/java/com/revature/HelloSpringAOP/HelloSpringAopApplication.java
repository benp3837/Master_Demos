package com.revature.HelloSpringAOP;

import com.revature.HelloSpringAOP.models.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringAopApplication {

	static Human h = new Human();

	@Autowired
	public HelloSpringAopApplication(Human h) {
		this.h = h;
	}

	public static void main(String[] args) {

		SpringApplication.run(HelloSpringAopApplication.class, args);

		h.setName("Eggmond");
		h.setAge(5);
		h.setOccupation("Just a lil guy");

		System.out.println(h.eat(2000));

		try{
			System.out.println(h.eat(8000));
		}catch(Exception e){
			System.out.println("Caught Exception before Human exploded");
		}

		System.out.println("done");
	}

}
