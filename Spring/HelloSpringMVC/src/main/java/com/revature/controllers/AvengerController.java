package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.AvengerDAO;
import com.revature.models.Avenger;

@RestController
//@Controller (use this one before changing it to RestController)
@RequestMapping(value="/avenger")
//@ResponseBody //Adds the @ResponseBody to every method in the controller at compile time. 
@CrossOrigin //This will act as a CORS filter, allowing all requests if no attributes 
//are provided. You can specify specific origins.
public class AvengerController {
	
	private AvengerDAO dao;

	@Autowired //we want a constructor with only the AvengerDAO so we can use constructor injection
	public AvengerController(AvengerDAO dao) {
		super();
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET) //Ensures any GET request to /avenger (defined above) uses this method
	//@ResponseBody //this makes sure any data sent back in the body is in JSON format.
	public List<Avenger> assemble() {
		return Arrays.asList(dao.getAll());
	}
	
	@GetMapping("/{id}")//GetMapping will specify that GET requests with this endpoint go here. (same as above)
						//@PathVariable allows you to get the path variable you specified in the mapping. 
	//Spring has an object called ResponseEntity that lets us set things like the status code of our response
	public ResponseEntity<Avenger> getOneAvenger(@PathVariable("id") int id) {
		Avenger a = dao.getById(id);
		if(a==null) {
			 //sends back an empty body with a no content status code.
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //build is for when you send nothing back
		}
		//Sends back the avenger in the body of the response and a 200 status code.
		return ResponseEntity.status(HttpStatus.OK).body(a); //body is for when you send something back
	}
	
	@PutMapping
	//@RequestBody converts JSON from the request into the object we indicated. Like @ResponseBody but... for requests
	public ResponseEntity<Avenger> updateAvenger(@RequestBody Avenger a){
		a = dao.update(a); 
		if(a==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
	
}
