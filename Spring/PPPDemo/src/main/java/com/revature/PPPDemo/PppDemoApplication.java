package com.revature.PPPDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.revature")
@EntityScan("com.revature.models")
@EnableJpaRepositories("com.revature.daos")
public class PppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PppDemoApplication.class, args);
	}

}
