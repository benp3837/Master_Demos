package com.revature;

import com.revature.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringWithLambdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithLambdaApplication.class, args);
	}

	@Autowired //field injection bad
	ItemService is = new ItemService();

	//COMMENT THESE ALL OUT, LEAVING ONE UNCOMMENTED PER LAMBDA
	//you will create a lambda for each individual function
	//which means you'll make a .jar for each of the 3 versions.

	@Bean
	public Function<String,String> uppercase() {
		return value -> value.toUpperCase();
	}
	@Bean
	public Supplier<List<String>> getItems(){
		return () -> is.getItems();
	}

	@Bean
	public Consumer<String> insertItem() { return value -> System.out.println(value);}

}
