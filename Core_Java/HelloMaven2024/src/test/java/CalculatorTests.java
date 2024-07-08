import com.revature.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    //Uninitialized instance of Calculator that we'll instantiate for each test
    private Calculator calc;

    @BeforeAll //Just a simple greeting
    public static void init() {
        System.out.println("This is the CalculatorTests test suite!");
    }

    @BeforeEach
    public void setUp() {
        calc = new Calculator();
    }

    //I could write a similar @AfterAll method to run after all tests finish
    //@AfterAll and @AfterEach

    //positive test for add
    @Test
    public void testAdd() {
        int result = calc.add(5, 10);
        Assertions.assertEquals(15, result, "5 + 10 should equal 15");
    }

    //negative test for add
    @Test
    public void testAdd2() {
        int result = calc.add(5, 10);
        Assertions.assertNotEquals(16, result, "5 + 10 should not equal 16");
    }

    //positive and negative test for divide using assertTrue/False.
    //HEY look we can assert multiple times in one test! More elegant since we're testing the same thing
    @Test
    public void testDivide() {
        int result = calc.divide(10, 2);
        Assertions.assertTrue(result == 5, "10 / 2 should equal 5");
        Assertions.assertFalse(result == 6, "10 / 2 should not equal 6");
    }

    //test for divide by zero (is this a positive or negative test?)
    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0), "Dividing by zero should throw an IllegalArgumentException");
    }


}
