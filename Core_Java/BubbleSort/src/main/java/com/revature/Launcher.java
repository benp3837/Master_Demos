package com.revature;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("=======Algorithms in order of efficiency.");
        System.out.println("=========================================(Bubble Sort)");

        //A bubble sort goes through a sequence and compares each value to the value after it.
        //if they aren't in the right order, it swaps them. if they are ordered, they're left alone.

        //so with every iteration, values BUBBLE up to the front of the list and an item is sorted.
            //the highest numbers bubble to the top.

        //the algorithm stops when it goes through the list and doesn't have to swap anything.

        int[] numbers = {5,2,6,8,254,74,4,8,2,1};

        //boolean that will check if a number was swapped while sorting
        //set to true so that the while loop will enter in the first place
        boolean numberSwapped = true;

        //the while loop will break
        while(numberSwapped) {

        numberSwapped = false; //going to set this back to true in the if statement

        //why .length - 1? because we're always going to be comparing two numbers.
        //there's no reason to look at the last number alone, so we can skip the unnecessary iteration
        for(int i = 0; i < numbers.length - 1; i++){

                //if this number is greater than the number after it...
                if (numbers[i] > numbers[i + 1]) {
                    numberSwapped = true;
                    //swapping two elements - a classic coding problem with a classic solution
                    //it's very helpful to create a temporary variable for this
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1]; //the first element is now equal to the second element
                    numbers[i + 1] = temp; //the second element is new equal to what the first element was
                }
            }

        } //end of while loop containing our bubble sort

        //just iterating over the sorted List one by one
        for (int i : numbers){
            System.out.println(i);
        }

        //Now, let's see a MERGE SORT-
        //which is a more efficient algorithm when dealing with larger data sets
        //we'll call it in a more sophisticated way too.
        System.out.println("===========================================(Merge Sort)");

        //we call the sort() method of the MergeSort class, leaving a cleaner main method
        //this is also the idea of CODE REUSABILITY - we wrote this method once, but can use it infinite times.

        int[] inputArray = {2,5,3,7,2,4,9,6,5,1};

        MergeSort ms = new MergeSort();

        ms.sort(inputArray);



    }//end of main method
}
