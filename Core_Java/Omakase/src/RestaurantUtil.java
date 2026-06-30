import java.util.*;

//A Util(ity) class contains methods and variables meant to be used in other classes
//It's a great way to clean up the code by hiding ugly stuff away (Abstraction)

public class RestaurantUtil {

    // Dictionary (Map) that stores the meals the user has eaten
    // The keys are strings, and the values are Lists that hold each food
    public static Map<String, List<String>> eatenFoods = new HashMap<>();

    // Tracks the amount the user owes based on the meals they eat
    public static int bill = 0;

    static {
        eatenFoods.put("appetizers", new ArrayList<>());
        eatenFoods.put("mainCourses", new ArrayList<>());
        eatenFoods.put("desserts", new ArrayList<>());
    }

    // Method to get the user's fav foods as a list, and return the list
    public static List<String> generateMenu(Scanner scanner) {
        System.out.println("What are 3 foods you like?");
        List<String> favoriteFoods = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.print("Food " + (i + 1) + ": ");
            String food = scanner.nextLine();
            favoriteFoods.add(food);
        }
        return favoriteFoods;
    }

    // Method to serve the user, save meals in the eatenFoods map, update the bill
    public static void serveUser(List<String> menu) {
        System.out.println("*||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||*");
        System.out.println("Your appetizer: " + menu.get(0) + " Bisque");
        System.out.println("Your main course: " + menu.get(1) + " Wellington");
        System.out.println("Your dessert: Frozen " + menu.get(2));
        System.out.println("*||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||*");

        eatenFoods.get("appetizers").add(menu.get(0) + " Bisque");
        eatenFoods.get("mainCourses").add(menu.get(1) + " Wellington");
        eatenFoods.get("desserts").add("Frozen " + menu.get(2));

        // For simplicity, let's say each course costs $10
        bill += 30;
    }
}