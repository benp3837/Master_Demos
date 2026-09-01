package com.fnma;

/* Here's another class with a main method. This is totally legal in Java!
* We just choose which one to run at any given time
*
* Here we're going to talk about some of the primitive data types in java
* By primitive I just mean "basic". int, double, boolean, etc.
* */
public class Primitives {

    //main method shortcut: type "main" and hit enter
    public static void main(String[] args) {

        //int is the most common integer-type primitive (others are byte, short, long)
        int i = 5;
        System.out.println("My int is: " + i);

        //if I ever need a BIG integer, I can use a long
        long l = 5000000000000000000L; //Longs need an "L" at the end

        //we can use our typical math operators to do mathematical operations
        System.out.println(5 + 10 / 6 * 35);
        System.out.println("i times 15: " + (i * 15));

        //doubles are the most common floating-type number (they have decimals)
        double d = 5.75;

        //can we do math on ints and doubles? Yes!
        System.out.println(i + d); //just be aware it will return a double

        //char (AKA CHARacters) hold a single 'char'acter
        char c = 'c';

        char c2 = 14000; //WHAT? I thought chars were just one character
        //REALLY what they are is a single UNICODE character

        System.out.println(c2);

        //the last primitive we'll see here is boolean
        //the ONLY way to denote true/false in Java
        boolean b = true;
        boolean b2 = false;

        //We can use booleans anywhere true/false is expected:

        if(b){
            System.out.println("b is true!");
        }

        if(b2){
            System.out.println("b2 is true!");
        }

        //booleans are the result of comparison operators too
        if(5>4){
            System.out.println("5 is greater than 4!");
        }

        System.out.println("===================(Arithmetic Operators)");

        //We know how +, -, /, * work

        //One that's less self-explanatory is the modulus operator (%)
        //% returns the REMAINDER of a division

        //A use case: checking even or odd
        int testNum = 10;

        if(testNum % 2 == 0){
            System.out.println(testNum + " is even!");
        }

        //Ternary operators can be very useful/elegant too
        String s = testNum % 2 == 0 ? "even":"odd";
        System.out.println("testNum is: " + s);

        //We can also increment and decrement numbers (increase or decrease by 1)

        int num = 5;

        System.out.println(num++); //why is this 5 still?
        System.out.println(num--); //why is THIS 6?

        //Java does the printing BEFORE it does the increment/decrement
        System.out.println(num); //5, as it should be

        //If you need the increment/decrement to happen FIRST, then switch the order

        System.out.println(++num); //6

        //This is the concept of PRE vs POST incrementing


    }

}
