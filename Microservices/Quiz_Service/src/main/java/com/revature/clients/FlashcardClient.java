package com.revature.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.models.Flashcard;

@FeignClient(name="flashcard")
public interface FlashcardClient {
	
	//This is like when we created our own method in HelloSpringData...
	//It's able to parse the name of the method, and determine what we want. 
	//It's not coming in with prebuilt methods like Spring Data, but it's smart enough to take the method names and get what we want.
	
	@GetMapping()
	public List<Flashcard> findAll();
	
	@GetMapping("/port")
	public String retrievePort();
	

}
