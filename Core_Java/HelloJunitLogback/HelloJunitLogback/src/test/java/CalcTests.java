import com.revature.Calculator;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTests {

    static Calculator calc;

    //@BeforeClass lets you execute some functionality before any tests run
    //you could also use @Before to make it run before each test
    @BeforeClass
    public static void instantiateCalc(){
        calc = new Calculator();
    }

    //@AfterClass and @After work in the opposite way: functionality executes after tests run
    @AfterClass
    public static void tearDownCalc(){
        calc = null;
    }

    //actual tests now---------------------------

    @Test
    public void testAddition(){
        //check for a true statement
        assertTrue(calc.add(5,5) == 10);
    }

    @Test
    public void testWrongAddition(){
        //check for a false statement
        assertFalse(calc.add(9,10) == 21);
    }

    @Test
    public void testSubtraction(){
        //check for equality
        assertEquals(calc.subtract(5,5), 0);
    }

    //This Test will check to make sure an ArithmeticException gets thrown when dividing by zero
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero(){
        //we run the exception causing code
        //this WON'T crash our program, since our test is looking for an ArithmeticException
        calc.divide(5, 0);
    }

}
