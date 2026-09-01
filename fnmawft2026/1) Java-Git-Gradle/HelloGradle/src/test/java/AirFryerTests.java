import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Here's where our JUnit unit tests will live for the AirFryer Class
public class AirFryerTests {

    //setup
    @BeforeEach
    public void beforeEach(){
        System.out.println("Setting up some stuff before each method...");
    }

    //teardown
    @AfterEach
    public void afterEach(){
        System.out.println("Tearing down some stuff before each method...");
    }

    //Instantiate an AirFryer so we can use its methods
    AirFryer fryer = new AirFryer();

    //GREEN TEST (AKA Positive test) - tests that the method behaves as expected given valid input
    @Test
    public void testInsertFoodWithValidInput(){

        String result = fryer.insertFood("Potato");

        assertEquals("Inserted Potato", result);

        //We CAN assert multiple things per tests
        assertNotNull(result);

    }


    //RED TEST (AKA Negative test) - tests that the method behaves as expected given INPUT input
    @Test
    public void testInsertFoodWithInvalidInput(){

        String result = fryer.insertFood("    ");

        assertEquals("HEY! There's no food in here...", result);

    }


    //Here's another green test with some different strategies
    @Test
    public void testSetTempWithValidInput(){

        String result = fryer.setTemp(350);

        //I would just use assertEquals again, but just wanna put a different assert() on paper
        assertTrue(result.equals("Temp has been set to: " + 350));

    }

    //Another Red test that tests for an Exception throw
    @Test
    public void testSetTempWithInvalidInput(){

        //No need to store the result, we're testing that the Exception is thrown
        assertThrows(IllegalArgumentException.class, () -> fryer.setTemp(500));

    }

}
