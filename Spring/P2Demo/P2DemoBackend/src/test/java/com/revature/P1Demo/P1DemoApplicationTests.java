package com.revature.P1Demo;

import com.revature.DAOs.CarDAO;
import com.revature.DAOs.UserDAO;
import com.revature.models.Car;
import com.revature.models.DTOs.IncomingCarDTO;
import com.revature.models.User;
import com.revature.services.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class P1DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	//NOTE: In a real test suite, it's good to structure the tests parallel to your src structure
		//-ControllerTests or CarControllerTests + UserControllerTests
		//-ServiceTests or CarServiceTests + UserServiceTests


	//A RestTemplate test for insertCar in the Controller----------------/

	//commented this out because our EC2 will have no idea what "localhost:8080" is.

//	@Test
//	public void insertCarTestRestTemplate(){
//
//		//Create a TestRestTemplate object to send HTTP Requests
//		TestRestTemplate restTemplate = new TestRestTemplate();
//
//		//Create a new IncomingCarDTO to use in our test
//		IncomingCarDTO newCar = new IncomingCarDTO("Toyota", "Camry", true, 1);
//
//		//send the new car to our insertCar method with RestTemplate, save the returned Car
//		Car returnedCar = restTemplate.postForObject("http://localhost:8080/cars", newCar, Car.class);
//
//		//super basic tests on the returned Car object
//		assertNotNull(returnedCar);
//		assertTrue(returnedCar.isFourWheelDrive());
//		assertEquals("Toyota", returnedCar.getMake());
//	}

	//HEY what if I DON'T want a real request that affects the real DB??
	//That's when you might want to use MockMVC to mock the HTTP Request instead


	//A Mockito test for insertCar in the Service Layer------------------/

	//A lot of setup first...

//	//Create a mock CarDAO and mock UserDAO
//	@Mock
//	CarDAO mockCarDAO;
//	@Mock
//	UserDAO mockUserDAO;
//
//	//Next, we have a concrete instance of the CarService so we can "spy" on it with methods like verify()
//	@Spy
//	CarService cs = new CarService(mockCarDAO, mockUserDAO);
//
//	//Regular IncomingCarDTO and Car objects to help with tests
//	IncomingCarDTO newCar = new IncomingCarDTO("Toyota", "Camry", true, 1);
//	Car returnedCar = new Car(1, "Toyota", "Camry", true, null);
//
//	//Before each test, we want to initialize our mocks and our spy
//	@BeforeEach
//	public void setup(){
//		MockitoAnnotations.openMocks(this); //open the registered mocks in "this" test class
//		cs = spy(new CarService(mockCarDAO, mockUserDAO)); //register the spy() of CarService
//	}

	//This is so much setup... but it is all we need for comprehensive, powerful service layer tests

	//Finally, we can write our test
//	@Test
//	public void insertCarTestMockito(){
//
//		//set up some stubbing - placeholder values that our Mocked DAOs will return
//		//remember, we're not testing the DAO, we're testing the service. so fake DAO returns are fine
//		when(mockUserDAO.findById(1)).thenReturn(Optional.of(new User(1, "placeholderUser", "password", "user")));
//		when(mockCarDAO.save(any(Car.class))).thenReturn(returnedCar);
//
//		//call the Service's insertCar method with our newCar object
//		Car c = cs.addCar(newCar);
//
//		//we can use the verify() method to verify that certain methods were called during runtime (thanks to @spy)
//		//these are verifications that the service method called the DAO methods we expect it to call
//		verify(mockCarDAO, times(1)).save(any(Car.class));
//		verify(mockUserDAO, times(1)).findById(1);
//
//		//basic assertNotNull - make sure a car got returned. We could test the values of the Car AND its user too.
//		assertNotNull(c);
//	}

}
