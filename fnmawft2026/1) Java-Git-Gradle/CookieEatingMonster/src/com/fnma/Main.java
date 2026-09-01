package com.fnma;

import com.fnma.exceptions.NotACookieException;
import com.fnma.models.CookieEatingMonster;
import com.fnma.models.Food;

public class Main {

    public static void main(String[] args) {

        String[] hi = {"hi"};

        //Causing an Error to get thrown
        //Errors are caused by severe problems in the code. We should fix the code instead of bypass the Error
        //main(hi); <- StackOverflowError! No more room in the Stack


        System.out.println("===============(2 Unchecked Exceptions)");

        //An "Unchecked Exception" (AKA Runtime Exceptions)
        //The compiler does NOT notice these before compiling. They're encountered at RUNTIME.

        System.out.println("Trying to divide by zero");

        //int i = 5/0; <- ArithmeticException - Can't divide by zero!

        System.out.println("Trying to access an Array index that doesn't exist");

        //System.out.println(hi[5]); <- ArrayIndexOutOfBoundsException - index 5 doesn't exist!

        //Here's a CHECKED Exception (AKA Compile Time Exception)
        //These are noticed BEFORE the app lets you compile

        //The top level Exception is a Checked Exception. Let's "throw" it directly
        //throw new Exception(); <- Won't let us compile!!!


        System.out.println("================(Handling Exceptions with try/catch)");

        String nullString = null; //Going to cause a NullPointerException

        //Let's handle the null pointer exception with a try/catch block!
        try{
            System.out.println("Try block starting...");
            //Try to run some code that MAY throw an Exception
            System.out.println(nullString.length());
        }
        catch (ArithmeticException e){
            System.out.println("I'll never run... No ArithException gets thrown");
        }
        catch (NullPointerException e){
            System.out.println("Catch block starting...");
            System.out.println("String must not be null!!");
        }
        catch (Exception e){
            System.out.println("I could have caught any Exception... good fallback");
        }
        finally{
            System.out.println("I will ALWAYS run!");
        }


        System.out.println("===================(Using CookieEatingMonster)");

        Food food1 = new Food(false, "broccoli");
        Food food2 = new Food(true, "Snickerdoodle");

        CookieEatingMonster monster = new CookieEatingMonster();

        monster.eatCookieWithTryCatch(food2); //isCookie == true
        monster.eatCookieWithTryCatch(food1); //isCookie == false

        monster.eatCookieWithThrows(food2);

        //Since we used the "throws" keyword, main has to handle the Exception.
        try {
            monster.eatCookieWithThrows(food1);
        } catch (NotACookieException e){
            System.out.println("Exception handled in MAIN since the monster used throws");
        }

        /*Exceptions will ALWAYS end in a try/catch or crash the code
        even if we "throw"s it to some other method, it still needs to get handled

        So why use throws?...
        Typically separation of concerns

        If I have Exceptions that can pop up in Class A, but I don't want to clutter it with try/catch,
        we can defer all exception handling to Class B, which calls Class A's methods.
         */
    }

}
