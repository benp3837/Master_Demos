package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.clients.FlashcardClient;
import com.revature.models.Flashcard;
import com.revature.models.Quiz;
import com.revature.repositories.QuizRepository;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizRepository quizDao;
	
//	//Remember, RestTemplate is used in MVC to receive JSON from an external RESTful API.
//	//In this way, our microservices can communicate with each other!
//	@Bean //@Bean is NOT a stereotype annotation!! It specifies that this method will return a bean 
//	RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
//	
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	//^^now we have a RestTemplate that we can use to send HTTP requests!!
	
	//EDIT: WE REMOVED RESTTEMPLATE IN FAVOR OF OPENFEIGN BELOW
	
	@Autowired
	private FlashcardClient flashcardClient;
	
	
	@GetMapping
	public ResponseEntity<List<Quiz>> findAll() {
		
		List<Quiz> all = quizDao.findAll();
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Quiz> findById(@PathVariable("id") int id) {
		Optional<Quiz> optional = quizDao.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Quiz> insert(@RequestBody Quiz quiz) {
		int id = quiz.getId();
		
		if(id != 0) {
			return ResponseEntity.badRequest().build();
		}
		
		quizDao.save(quiz);
		return ResponseEntity.status(201).body(quiz);
	}
	
	@GetMapping("/cards")
	public ResponseEntity<List<Flashcard>> getCards() {
		//We are now using FeignClient to make calls to our FlashCard controller. Easier than RestTemplate!!
		List<Flashcard> all = this.flashcardClient.findAll();
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/load")
	public ResponseEntity<String> retrievePort(){
		String info = this.flashcardClient.retrievePort();
		
		return ResponseEntity.ok(info);
	}
	
}
