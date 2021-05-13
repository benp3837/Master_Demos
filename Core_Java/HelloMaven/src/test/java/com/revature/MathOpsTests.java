package com.revature;

import static org.junit.jupiter.api.Assertions.*;
//import vs import static? In this case, we need to import the static members of the Assertions class
//our assert methods won't be visible without the "static"

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 

public class MathOpsTests {

	public static MathOps mo; //uninitialized MathOps object
	
	//unititialized variables
	public int i;
	public int j;
	public int k;
	public int result;
	
	@BeforeAll //used for things you want to happen BEFORE the test class does ANYTHING
	public static void setMO() {
		System.out.println("In BeforeAll");
		mo = new MathOps(); //so before the test class runs, we initialize our MathOps object
	}
	
	@BeforeEach //used for things you want to happen BEFORE EACH METHOD
	public void setInts() {
		System.out.println("In BeforeEach");
		i = 3;
		j = 7;
		k = 0;
	}
	
	@AfterEach //used for things you want to happen AFTER EACH METHOD
	public void clearResult() {
		System.out.println("In AfterEach");
		result = 0;
	}
	
	@AfterAll //used for things you want to happen AFTER the test class finished EVERYTHING
	public static void clearMO() {
		System.out.println("In AfterAll");
		mo = null; //return our MathOps object to the void, now it can be garbage collected.
	}
	
	
	//Now let's actually write some tests---------------------------
	
	//Remember, the @BeforeEach method resets i = 3, j = 7, k = 0 before each method runs
	//And the @AfterEach method resets result = 0. 
	//We could technically use one or the other method to do it all, but I'm showing both for education!
	
	@Test //We need the @Test annotation for the method to be recognized as a Test
	public void testAdd() {
		System.out.println("TESTING ADD...");
		result = mo.add(i, j);
		assertTrue(result == 10);
	}
	
	@Test //run these two methods first, without the @Test annotation on the second. Only one will run.
	public void TestAdd2() {
		System.out.println("TESTING ADD once again...");
		result = mo.add(i, k);
		assertEquals(result, 3);
	}
	
	@Test
	public void TestSubtract() {
		System.out.println("TESTING SUBTRACT");
		result = mo.subtract(i, j);
		Runnable lambda = () -> {System.out.println("I'm an out of place lambda function");};
		lambda.run();
		assertNotEquals(0, result);
	}
	
	@Test
	public void testDivideByZero() {
		System.out.println("Going to try and throw something");
		assertThrows(ArithmeticException.class, () -> mo.divide(i, k));
		//"assert that dividing by zero throws an arithmetic exception"
	}
	
}
