package com.revature;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("hi**************");

        //goes through the list and compares each number to the number after it.

        //if they aren't in the right order, it swaps them. if they are ordered, they're left alone.

        //so with every iteration, values BUBBLE up to the front of the list and an item is sorted.
            //the highest numbers tend to bubble to the top.

        //the algorithm stops when it goes through the list and doesn't have to swap anything.

        int[] toSort = {5,2,6,8,254,74,4,8,2,1};

        //boolean that will check if a number was swapped while sorting
        //set to true so that the while loop will enter in the first place
        boolean numberSwapped = true;

        //the while loop will break
        while(numberSwapped) {

        numberSwapped = false; //going to set this back to true in the if statement

        //why .length - 1? because we're always going to be comparing two numbers.
        //there's no reason to look at the last number alone, so we can skip the unnecessary iteration
        for(int i = 0; i < toSort.length - 1; i++){

                //if this number is greater than the number after it...
                if (toSort[i] > toSort[i + 1]) {
                    numberSwapped = true;
                    //swapping two elements - a classic coding problem with a classic solution
                    //it's very helpful to create a temporary variable for this
                    int temp = toSort[i];
                    toSort[i] = toSort[i + 1]; //the first element is now equal to the second element
                    toSort[i + 1] = temp; //the second element is new equal to what the first element was
                }



            }



        }

        for (int i : toSort){

            System.out.println(i);

        }

    }

}
