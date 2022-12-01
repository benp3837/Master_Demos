package com.revature;

public class Launcher {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        int i = calc.add(6,10);
        System.out.println(i);

        int i2 = calc.subtract(6,10);
        System.out.println(i2);

        int i3 = calc.divide(6,2);
        System.out.println(i3);

        int i4 = calc.divide(6,0);
        System.out.println(i4);

    }

}