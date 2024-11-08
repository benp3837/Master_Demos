package com.revature.P1Demo;

import com.revature.daos.PetDAO;
import com.revature.daos.UserDAO;
import com.revature.models.DTOs.IncomingPetDTO;
import com.revature.models.Pet;
import com.revature.models.User;
import com.revature.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class P1DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	//TestRestTemplate test for our PetController------------------------------------

	//RestTemplate lets us send HTTP requests FROM OUR JAVA SERVER
		//TestRestTemplate is a subclass that we can use for Testing

	@Test
	public void testInsertPet(){

		//Instantiate a new TestRestTemplate object
		TestRestTemplate restTemplate = new TestRestTemplate();

		//Create a new IncomingPetDTO to use in our test
		IncomingPetDTO petDTO = new IncomingPetDTO("Dog", "Fido", 1);

		//Send a POST request to /pets and save the returned Pet to run our tests on
		                    //{verb}ForObject  //URL, Request Body, Response Type
		Pet p = restTemplate.postForObject("http://localhost:7777/pets", petDTO, Pet.class);

		//basic tests, make sure our Pet object came back as expected
		assertNotNull(p);
		assertNotEquals(p.getPetId(), 0);
		assertEquals(p.getSpecies(), "Dog");

		//Let's do asserts on the ResponseEntity as well

		ResponseEntity<Pet> response = restTemplate.postForEntity("http://localhost:7777/pets", petDTO, Pet.class);

		//Now we can test what status code comes back too!
		assertEquals("201 CREATED", response.getStatusCode().toString());

	}

	//HEY what if I DON'T want to send real requests that manipulate our real DB?
	//We can use MockMVC instead of TestRestTemplate

	//A Mockito test for our addPet() method in PetService----------------

	//A lot of setup first...

	//Create a mock PetDAO and mock UserDAO - fake DAO objects our Service tests will use
	@Mock
	PetDAO pDAO;
	@Mock
	UserDAO uDAO;

	//Next, we'll have a concrete PetService that we'll "spy" on.
	//This lets us run methods like verify() to make sure a method in the service method got called
	@Spy
	PetService petService = new PetService(pDAO, uDAO);

	//Concrete IncomingPetDTO and Pet objects to use in our test (Pet will match the DTO)
	IncomingPetDTO petDTO = new IncomingPetDTO("Cat", "Grandpa", 1);
	Pet pet = new Pet(0, "Cat", "Grandpa", null);
	//we'll leave the Pet's user null just for ease of testing

	//Before each test, we want to initialize our mocks and our PetService spy
	@BeforeEach
	public void setup(){
		MockitoAnnotations.openMocks(this); //open the registered mocks in "this" test class
		petService = spy(new PetService(pDAO, uDAO));
	}

	//Finally, we can write our test will all of the object we set up
	@Test
	public void testInsertPetWithMockito(){

		//set up some stubbing - placeholder values that our Mocked DAOs will return
		//remember, we're not testing the DAO, we're testing that the Service does what it's meant to. Fake DAOs are fine
		when(uDAO.findById(1)).thenReturn(Optional.of(new User(1, "testUser", "testPassword", "user")));
		when(pDAO.save(any(Pet.class))).thenReturn(pet);

		//We can do one for exception Throws too
		when(uDAO.findById(0)).thenThrow(new IllegalArgumentException("User ID cannot be zero!"));

		//Let's finally call the Service's insertPet method with our petDTO object we defined above this test
		Pet returnedPet = petService.addPet(petDTO);

		//Now, we can verify that the methods in question got called
		verify(uDAO, times(1)).findById(1);
		verify(pDAO, times(1)).save(any(Pet.class));

		//And we can assert that the Pet object is as expected
		assertNotNull(returnedPet);
		assertEquals(returnedPet.getSpecies(), "Cat");

	}

}
