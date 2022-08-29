package com.revature;

public class MergeSort {

    //Divide and Conquer-
    //Merge Sorts order the incoming data by dividing it up, sorting those divisions, and merging them back together.
    //It's generally faster than a bubble sort, but can be slower with smaller data sets and uses more memory.
    //As you'll see below, it's a bit more complex to write as well.

    public static void mergeSort(int[] inputArray){

        //get the length of the Array we're sorting
        int arrayLength = inputArray.length;

        //if the Array is 1 or 0 elements in size, it's already sorted.
        if(arrayLength < 2) {
            return;
        }

        //we need the midpoint of the Array, in order to split it in half.
        int mid = arrayLength/2;

        int[] leftSide = new int[mid]; //this Array is the size of the first half of the inputted Array
        int[] rightSide = new int[arrayLength-mid]; //this Array is the size of the first half of the inputted Array
        //why not just use mid for this second half? hmmm???

        //now we fill up each side with the appropriate data from the inputted Array!

        //left side - we want to loop once for every value in the left Array
        for(int i = 0; i < mid; i++) {
            //we want to copy each value from the first half of the inputted Array into our leftSide Array
            leftSide[i] = inputArray[i];
        }

        //right side - note we're starting from mid this time, since we want the right half now.
        for(int i = mid; i < arrayLength; i++) {
            rightSide[i - mid] = inputArray[i];
            //we use [i - mid] because we're working with the 0th element of rightSide,
        }

        //ok what now? We want to MERGE SORT both of these Arrays, and then merge them together.
        //we must now recursively call this method once for each half of the original Array
            //recursion - calling a method within itself. Good for breaking big problems into smaller ones.

        mergeSort(leftSide);
        mergeSort(rightSide);
        //when will this recursion end? Check the if statement near the top.
        //once the Arrays are broken down into small enough divisions, the merging can begin.

        //now we need to actually merge these two Arrays together.
        //we'll abstract that code away to the method below (to make this method less cluttered).
        merge(inputArray, leftSide, rightSide);
    }

    //only this Class needs to use this method!
    private static void merge(int[] inputArray, int[] leftSide, int[] rightSide){

        //welcome to the merge method! This method will take in the Array halves
        //and merge them together in another Array, in order.

        //we need the sizes of the two Array halves
        int leftSize = leftSide.length;
        int rightSize = rightSide.length;

        //this is potentially the most confusing part.
        //we're going to loop through both arrays and compare the 1st, 2nd, 3rd etc elements of each Array
        //we will add the lowest elements to the merged Array until we run out of elements in both Arrays

        //so, the left, right, and merged Array each need a counter variable.
        int lCount = 0, rCount = 0, mCount = 0;

        //This while loop will break when we run out of elements to check in either side of the original Array
        while(lCount < leftSize && rCount < rightSize){

            //if the element on the left Array is <= the element on the right Array...
            if(leftSide[lCount] <= rightSide[rCount]){
                inputArray[mCount] = leftSide[lCount];//then add it to the merged Array!
                lCount++; //and move one element over on the left Array
            } else {
                //if the left element isn't less than or equal to the right element, that means the right is smaller.
                inputArray[mCount] = rightSide[rCount]; //so add THAT element to the merged Array instead.
                rCount++; //and move one element over on the right Array
            }

            //we want to increment the merged Array's counter no matter what. So we'll put it after the if/else
            mCount++;

            //so to summarize, with every loop, an element from the left and right will be compared to each other
            //the lesser of the two will get added to the merged Array
            //and we continue this loop until we're out of elements on one of the sides of the Array

        } //end of initial while loop

        //BUT... when we run out of elements on one side, the other side still has one or more elements
        //we can clean that up by simply adding them onto the merged Array.

        //if there are no elements remaining in the left Array, we don't enter this loop
        //if there ARE elements remaining in the left Array, loop through and add them to the merged Array
        while(lCount < leftSize){
            inputArray[mCount] = leftSide[lCount];
            lCount++;
            mCount++;
        }

        //same as above, but for the right side
        while(rCount < rightSize){
            inputArray[mCount] = rightSide[rCount];
            rCount++;
            mCount++;
        }

    }

}
