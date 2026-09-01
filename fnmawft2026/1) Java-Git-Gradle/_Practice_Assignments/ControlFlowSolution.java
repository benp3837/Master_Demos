package com.fnma;

public class ControlFlowSolution {

    public static void main(String[] args) {

        //1)

        String order = "water";

        if(order.equals("latte")){
            System.out.println("ONE LATTE!");
        } else if (order.equals("espresso")){
            System.out.println("ONE ESPRESSO!");
        } else if (order.equals("water")){
            System.out.println("There is a hose outside");
        } else{
            System.out.println("We don't have that");
        }

        //2)

        int customers = 10;

        while (customers > 0){
            System.out.println("NEXT!!!");
            customers--;
        }

        System.out.println("Time to eat in my car");

        //3)

        String[] shipment = {"beans", "beans", "beans", "beans", "beans", "jeans", "beans"};

        for(String item : shipment){
            if(item.equals("beans")){
                System.out.println("Unloading Beans");
            } else {
                System.out.println("What.....");
            }
        }

    }

}
