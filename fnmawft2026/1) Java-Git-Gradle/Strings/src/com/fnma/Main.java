package com.fnma;

public class Main {

    public static void main(String[] args) {

        System.out.println("========================(String Immutability)");

        //Strings are Immutable which means we can't change them

        String s = "I AM IMMUTABLE (AKA unchangeable)";

        s.toLowerCase(); //This should turn the string all lowercase... right?...

        System.out.println(s); //toLowerCase RETURNS A STRING all in lowercase
        //It does NOT change the original String. We can't do that.

        //We can print out the result of toLowerCase, or save it in a new variable
        System.out.println(s.toLowerCase());

        System.out.println("========================(String Equality)");

        //We can check if primitives are equal with ==
        int i = 5;
        int i2 = 5;

        System.out.println("i == i2?");
        System.out.println(i == i2);

        //For Strings, we need to use the .equals() method

        String s1 = "Hello Java"; //This is a String literal (no "new" keyword)
        String s2 = "Hello Java"; //This is another String literal with the same value
        //JAVA MAKES THESE VARIABLES THE SAME OBJECT IN MEMORY

        String s3 = "HELLO JAVA";
        String s4 = new String("Hello Java"); //we used "new" which makes a new object in memory
        //"new" bypasses the String Pool.

        System.out.println("s1 == s2?");
        System.out.println(s1 == s2); // true. == compares MEMORY ADDRESS when comparing objects
        System.out.println("s1 == s4?");
        System.out.println(s1 == s4); // false. again, == compares memory address and s4 is a different object
        System.out.println("s1.equals(s3)?");
        System.out.println(s1.equals(s3)); //false, obviously
        System.out.println("s1.equals(s4)");
        System.out.println(s1.equals(s4)); //true - .equals() compares VALUE. This is what we use for Strings

        //MORAL OF THE STORY - always use .equals() for Strings. It compares the value.

        System.out.println("========================(String Methods)");

        //a pangram to use some String methods on
        String pangram = "Sphinx of Black Quartz, judge my Vow";

        //.length() is a method that returns in int representive the length of the String (how many chars)
        System.out.println(pangram.length());

        //.charAt() is a method that returns the CHARacter at a given index
        System.out.println(pangram.charAt(0));
        System.out.println(pangram.charAt(pangram.length() - 1));

        //.subString() is a method that a returns the String found within the OG String
        System.out.println(pangram.substring(15, 30));

        //.split() creates an Array based on a certain delimiter (separator)
        System.out.println(pangram.split(" "));
        //What is this... It's a memory address! We can't just print an Array.

        //Instead, let's save the Array into a variable and loop through it
        String[] words = pangram.split(" ");

        for(String word : words){
            System.out.println(word);
        }

        System.out.println("====================(StringBuilder Practice Problem Solution)");

        //TODO: probs won't have time for StringBuilder Practice



    }

}
