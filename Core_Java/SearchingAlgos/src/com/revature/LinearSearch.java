package com.revature;

public class LinearSearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //Calling LinearSearch with an element that is in the array
        if(linearSearch(arr, 3) != -1) {
            System.out.println("found! index: " + linearSearch(arr, 5));
        } else {
            System.out.println("not found!");
        }

        //Calling LinearSearch with an element that is not in the array
        if(linearSearch(arr, 11) != -1) {
            System.out.println("found! index: " + linearSearch(arr, 11));
        } else {
            System.out.println("not found!");
        }

    }

    /*Linear Search
    - Linear search is a simple way to search for a target in an array
    - It works by iterating through the array and comparing each element to the target
    - If the element is equal to the target, we return the index
    - If we reach the end of the array without finding the target, we return -1
    - Super simple, but not that efficient. It goes straight through the Array one by one
    */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
