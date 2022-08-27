package com.revature;

public class MergeSort {

    //Divide and Conquer-
    //This Merge Sorts order the incoming data by splitting it up, and merging it back together in order.
    //It's generally faster than a bubble sort, but can be slower with smaller data sets and uses more memory.

    public static void sort(int[] inputArray){
        sort2(inputArray, 0, inputArray.length-1);
    }

    //could have called this sort(), but I don't want to use method overloading since they do pretty different things
    public static void sort2(int[] inputArray, int start, int end){

        //if the inputted Array's last value is less than or equal its first value...
        if(start <= end){
            return; //we're done sorting the Array
        }

        int mid = (start+end)/2; //get the middle of the Array (PEMDAS)
        //in a 10 element array: (0+9)/2 = 4.
        //(int gets rounded down from 4.5 to 4 - has no room for those decimals)

        //calling the sort2() method WITHIN itself, to sort the right and left side of the Array separately
        sort2(inputArray, start, mid); //left half (0-4)
        sort2(inputArray, mid+1, end); //right half (5-9)

        //calling the merge() method to merge the sorted results into inputArray[]
        merge(inputArray, start, mid, end);
    }

    public static void merge(int inputArray[], int start, int mid, int end){

        //make a new int Array the size of the each incoming Array half
        int[] tempArray = new int[end - start + 1];
        //first half of a 10 element Array: 4-0+1 = 5
        //second half of a 10 element Array: 9-5+1 = 5

        //index counter for the left side of the Array
        int leftHalf = start;
        //index counter for the right side of the Array
        int rightHalf = mid + 1;

        int k = 0;

        //while
        while(leftHalf <= mid && rightHalf <= end){

            //if the leftHalf counter is less than the rightHalf counter...
            //(in a 10 element array the counters should start at 0 and 5 respectively)
            if(inputArray[leftHalf] < inputArray[rightHalf]){
                tempArray[k] = inputArray[leftHalf];
                leftHalf = leftHalf + 1;
            } else {
                tempArray[k] = inputArray[rightHalf];
                rightHalf = rightHalf + 1;
            }

            k = k + 1;
        }

        //once the right and left side are both sorted, the while loop breaks


    }

}
