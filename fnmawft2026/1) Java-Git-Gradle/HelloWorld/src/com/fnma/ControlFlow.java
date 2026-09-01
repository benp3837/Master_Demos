package com.fnma;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//Control Flow statments let us CONTROL the FLOW of the app
//Skipping code, looping code, running this code instead of that code, etc.
public class ControlFlow {

    public static void main(String[] args) {

        //Using the built-in Math Class to get a random number
        int randomNumber = (int) (Math.random() * 100);

        System.out.println(randomNumber);

        System.out.println("================if/else if/else");

        //"If this, then do that. Otherwise, do this, Otherwise, do this other thing"

        if(randomNumber > 70){
            System.out.println("Random Number is rather large");
        }
        else if (randomNumber > 40){
            System.out.println("Random Number is medium");
        }
        else {
            System.out.println("Random Number is smol");
        }

        System.out.println("===================(While/Do-While Loops)");

        //While Loop: "While X is true, do Y"
        while(randomNumber < 500){
            randomNumber += 100;
            //+= is just a quick way to do "randomNumber = randomNumber + 100"
            System.out.println("randomNumber is now: " + randomNumber);
        }
        System.out.println("While Loop has Broken!");

        //Do-While Loops execute the code block FIRST, then check the expression.
        do {
            randomNumber -= 100;
            System.out.println("randomNumber is now: " + randomNumber);
        } while (randomNumber > 100);
        System.out.println("Do While Loop has Broken!");

        System.out.println("=============For Loops");

        //"For a set number of loops, do this"

        //Basic for loop - writing a loop that runs 10 times
        //"for as long as int i, which is 0, is less than 10, run the code and increment it by 1"
        for(int i = 0; i < 10; i++){
            System.out.println("Hello loop #" + i);
        }

        //More useful loop - we have a list of things to do
        //This is an Array, and it holds a list of values
        String[] chores = {"Wake Up", "Grab a Brush", "Put a Little Makeup"};

        for(int i = 0; i < chores.length; i++){
            System.out.println("Doing Chore: " + chores[i]);
        }

        //enhanced for loop = easier syntax
        //"for every String which we'll call 'chore' in the chores Array, do this"
        for(String chore : chores){
            System.out.println("Doing chores again: " + chore);
        }

        //More interesting use case of for loops ----

        //This time a char Array that we need to clean up

        char[] myName = {'B', 'E', ' ', 'N', 'A', 'A', 'A', 'A'};

        //Arrays are INDEXED, so we can retrieve individual values through the index
        System.out.println(myName[0]);
        System.out.println(myName[7]);
        System.out.println(myName[myName.length - 1]); //less hardcoded way to get last index

        System.out.println("-----");

        //Foreshadowing of a later topic: An ArrayList that will get filled with the letters in my name
        ArrayList<Character> myRealName = new ArrayList<>();

        //I'm going to make a for loop to iterate through the array
        //...and take out anything that doesn't belong in my name
        for(int i = 0; i < myName.length - 1; i++){
            if(myName[i] == ' '){
                continue; //continue causes the for loop to skip this loop and go to the next one
            }

            if(myName[i] == 'A'){
                break; //break kills the loop entirely
            }

            //If the char we're on is NOT ' ' or 'A', print it out
            System.out.println(myName[i]);

            //Also, add the char to the ArrayList so we can save it!
            myRealName.add(myName[i]); //REGULAR ARRAYS CANT DO THIS
        }

        System.out.println(myRealName); //print out the ArrayList

        System.out.println("=============(Switch)");

        //Switches are like if statements but a bit more elegant if there are a ton of possible outcomes

        String myFavPokemon = "Goldeen";

        switch(myFavPokemon){
            case "Lucario":
                System.out.println("Pretty good");
                break; //if we don't include this, all following cases will run
            case "Pidgeot":
                System.out.println("Also pretty good");
                break;
            case "Snorlax":
                System.out.println("Yawn");
                break;
            case "Arcanine":
                System.out.println("Good boy");
                break;
            case "Mudkip":
                System.out.println("Correct!");
                break;
            default: //if no cases match, we can put a default block
                System.out.println("Your choice is irrelevant");

        }

    }



}
