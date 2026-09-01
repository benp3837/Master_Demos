package com.fnma;

import java.util.Arrays;
import java.util.List;

public class StringManipulationSolution {

    public static void main(String[] args) {

        String phrase = "I'll take a Double Triple Bossy Deluxe on a raft, 4x4, animal style, extra shingles with a shimmy and a squeeze, light axle grease, make it cry, burn it, and let it swim";

        //Word count
        int wordCount = phrase.split(" ").length;
        System.out.println(wordCount + " is too many words.");

        //Replace "I'll take" with "May I please have"
        phrase = phrase.replace("I'll take", "May I please have");

        //Remove any characters after "have" (kind of tricky)
        int haveIndex = phrase.indexOf("have") + "have".length();
        phrase = phrase.substring(0, haveIndex);

        //Add "a water bottle" to the end
        phrase = phrase + " a water bottle";

        //"May I please have a water bottle"
        System.out.println(phrase);

        //Split into array, sort alphabetically, print
        String[] words = phrase.split(" ");
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));

        //BONUS - Palindrome checker
        String word1 = "racecar";
        String word2 = "car";

        System.out.println(isPalindrome(word1)); // true
        System.out.println(isPalindrome(word2)); // false


        //BONUS BONUS - Sum of list values
        List<String> letters = Arrays.asList("a", "b", "c", "a", "b", "c", "a", "a", "b", "b", "c", "c", "a", "a");

        //I like a switch for this cuz it's cleaner, but you had options for this one.
        int sum = 0;
        for (String letter : letters) {
            switch (letter) {
                case "a" -> sum += 5;
                case "b" -> sum += 10;
                case "c" -> sum += 15;
            }
        }
        System.out.println("Sum: " + sum);
    }

    // Palindrome method - quick way using StringBuilder
    public static boolean isPalindrome(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equals(reversed); //returns true or false
    }
}
