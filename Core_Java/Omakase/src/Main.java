import java.util.Scanner;

/* Omakase is a Japanese dining experience
 * where the chef selects and prepares a series of dishes for the customer.
 * The word "omakase" translates to "I'll leave it up to you".
 * We'll be creating an Omakase Command Line Interface (CLI) app that demonstrates:
 * 1. User input and output
 * 2. Data structures (Lists, Maps)
 * 3. Control flow (review in a more realistic setting)
 * 4. Methods (to organize our code and make it reusable)
 */

// TODO: an assignment for them: add a functionality for _______
// TODO: (or make them come up with their own extra functionality!)

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*
                                   Welcome to the Omakase CLI App!
                We will be creating a personalized 3-course meal based on your preferences!
                *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*
                First, what is your name?""");
        System.out.print(">>> ");
        String name = scanner.nextLine();
        System.out.println("Great to meet you, " + name);

        // This boolean will trigger the while loop below
        // Once the user is full, we'll set it to false and exit the loop
        boolean hungry = true;

        // While loop that generates the menu and feeds the user until they're full
        while (hungry) {
            // Generate a menu based on user preferences
            var generatedMenu = RestaurantUtil.generateMenu(scanner);

            // Serve the menu items
            RestaurantUtil.serveUser(generatedMenu);

            // Ask the user if they're still hungry after eating
            System.out.println("Are you still hungry? (yes/no)");
            System.out.print(">>> ");
            String stillHungry = scanner.nextLine().toLowerCase();

            // Either break the loop, serve the user again, or ask them to repeat their answer
            if (stillHungry.equals("no")) {
                hungry = false; // THIS WILL BREAK THE LOOP!
                System.out.println("Thanks for dining with us, " + name + "! Here's a summary of the meals you ate:");
                System.out.println("-Apps: " + RestaurantUtil.eatenFoods.get("appetizers"));
                System.out.println("-Mains: " + RestaurantUtil.eatenFoods.get("mainCourses"));
                System.out.println("-Desserts: " + RestaurantUtil.eatenFoods.get("desserts"));
                System.out.println("That will be $" + RestaurantUtil.bill + " dollars. Have a great day!");
            } else {
                System.out.println("Great! Let's prepare another meal for you!");
            }
        }

        scanner.close();
    }
}