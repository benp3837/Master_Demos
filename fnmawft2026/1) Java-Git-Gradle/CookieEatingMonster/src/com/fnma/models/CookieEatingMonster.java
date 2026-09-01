package com.fnma.models;

import com.fnma.exceptions.NotACookieException;

//This Class will model a Monster that only eats Cookies... A Cookie Monster if you will
//It has methods that will take in a Food object and throw our Custom Exception if the Food is not a cookie
public class CookieEatingMonster {

    //A Method that uses try/catch to catch NotACookieException
    public void eatCookieWithTryCatch(Food food){

        try{
            //Try to eat a food object - throws Exception if isCookie == false
            if(food.isCookie){
                System.out.println("Me love cookie!");
            }
            else {
                throw new NotACookieException("Me only eat cookie D:<");
            }
        } catch(NotACookieException e){

            System.out.println("NotACookieException Caught!");
            System.out.println("The following is a stack trace that we printed manually:");
            e.printStackTrace();

        }

    }


    //A Method that uses throws to defer the NotACookieException to the method that called it
    public void eatCookieWithThrows(Food food) throws NotACookieException{

        if(food.isCookie){
            System.out.println("Me still like cookie");
        } else {
            throw new NotACookieException("I said stop feeding me non-cookies");
        }

        //No try catch! We're not handling the exception here!
        //We're "throws"ing it to whatever method called this method (in our case, main).

    }



}
