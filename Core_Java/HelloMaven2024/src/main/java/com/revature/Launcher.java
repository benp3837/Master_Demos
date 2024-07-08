package com.revature;

public class Launcher {

    public static void main(String[] args) {

        //all we're gonna do here is call add() and divide() to trigger different logs

        Calculator calc = new Calculator();

        System.out.println(calc.add(5, 10));

        System.out.println(calc.divide(10, 2));

        System.out.println(calc.divide(10, 0));
        //someone really should've caught this with a try/catch block


    }

}
