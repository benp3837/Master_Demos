import com.revature.Greeter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreeterTests {

    Greeter greeter = new Greeter();

    //This test implies that our sendGreeting() method must return "Hey There!"
    @Test
    public void testGreeting(){
        assertEquals(greeter.sendGreeting(), "Hey there!");
    }

    //This test implies that sending "Bon" to the greetWithName() method returns "Hello, Bon"
    @Test
    public void testGreetWithName(){
        assertEquals(greeter.greetWithName("Bon"), "Hello, Bon");
    }

    //this test implies that sending an empty String to greetWithName() throws an IllegalArgException
    @Test(expected = IllegalArgumentException.class)
    public void testGreetWithNameThrowsException(){
        greeter.greetWithName("");
    }

}
