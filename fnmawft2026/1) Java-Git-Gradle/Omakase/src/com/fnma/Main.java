package com.fnma;


import com.fnma.utils.RestaurantUtil;

import java.util.ArrayList;
import java.util.Scanner;

/* Omakase is a Japanese dining experience
Where the chef selects and prepares a series of dishes for the customer
The word "omakase" translates to "I'll leave it up to you".

We are going to create an old-school Command Line Interface (CLI) app that demonstrates:
1. Taking User Input and Return Output
2. Data Structures (ArrayList)
3. Review Control Flow
4. Classes/Methods */
public class Main {

    public static void main(String[] args) {

        System.out.println("""
                *~~~~~~~~~~~~~~~~~~~~~~~~~~[]~~~~~~~~~~~~~~~~~~~~~~~~~*
                         Welcome to the Omakase CLI App!
                We'll be creating a personalized 3 course meal for you
                *~~~~~~~~~~~~~~~~~~~~~~~~~~[]~~~~~~~~~~~~~~~~~~~~~~~~~*
               """);

        //We can use a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("What's your name?");
        System.out.println(">>> ");

        String name = scanner.nextLine();

        System.out.println("Welcome to the Restaurant, " + name);

        //This booleam will trigger the while loop menu below
        boolean hungry = true;

        //Start the CLI (with a while loop)
        //Once the user is full, we'll set "hungry" to false, which breaks the loop
        while(hungry){

            //Call the Method to take in fav foods and store it in a variable
            ArrayList<String> favFoods = RestaurantUtil.generateMenu();

            System.out.println(favFoods);

            //Method call to serve the user, using the favFoods variable we just defined
            RestaurantUtil.serveUser(favFoods);

            //Ask the user if they're still hungry
            System.out.println("Are you still hungry? (yes/no)");
            System.out.println(">>> ");
            String stillHungry = scanner.nextLine().toLowerCase();

            if(stillHungry.equals("no")){
                hungry = false; //This breaks the while loop!
                System.out.println("Have a nice day!");

                //Print the receipt out here
                System.out.println("Here's your receipt:");
                System.out.println(RestaurantUtil.receipt);

            } else {
                System.out.println("Great! Let's prepare another meal");
            }

        }

    }

}
