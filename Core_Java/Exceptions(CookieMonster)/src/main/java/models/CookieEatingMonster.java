package models;

import exceptions.NotACookieException;


//This Class will model a monster that only eats cookies... A cookie monster if you will
//It has methods that will take in a Food object, and throw an exception if that food is not a cookie (boolean isCookie == false)
public class CookieEatingMonster {


    public void eatCookieWithTryCatch(Food food){

        try{
            if(food.isCookie){
                System.out.println("Cookie Eating Monster Eats a Cookie!!");
            }else{
                throw new NotACookieException("I only eat COOKIES. Feed me a cookie.");
            }

        } catch(NotACookieException e){
            System.out.println("NotACookieException Caught");
            e.printStackTrace();
        }

    }

    public void eatCookieWithThrows(Food food) throws NotACookieException{

        if(food.isCookie){
            System.out.println("Thanks for the cookie :)");
        }else {
            throw new NotACookieException("Do not feed me anything other than cookies.");
        }

    }



}
