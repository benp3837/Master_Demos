package com.fnma.utils;

import java.util.ArrayList;
import java.util.Scanner;

//A Util(ity) Class contains methods and variables meant to be used in other Classes
//It's a great way to clean up the main code by hiding ugly stuff elsewhere (Abstraction)
public class RestaurantUtil {

    //Variable that stores the eaten foods
    public static ArrayList<String> receipt = new ArrayList<>();

    //Method to get the user's favorite foods and return that list of foods
    public static ArrayList<String> generateMenu(){
        //Get a new Scanner and ask the user their 3 favorite foods
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> favFoods = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            System.out.println("Food #" + (i + 1) + " >>>"); //User's prompt
            String food = scanner.nextLine(); //Taking the input
            favFoods.add(food); //Adding the food to the ArrayList
            receipt.add(food); //Adding the food to the receipt ArrayList too
        }

        return favFoods;

    }

    //Method to serve the user. It takes in their fav foods and returns the dishes to the user
    public static void serveUser(ArrayList<String> foods){
        System.out.println("-----------------------");
        System.out.println("Your Appetizer: " + foods.get(0) + " Souffle");
        System.out.println("Your Entree: " + foods.get(1) + " Wellington");
        System.out.println("Your Dessert: Frozen " + foods.get(2));
        System.out.println("-----------------------");
    }


}
