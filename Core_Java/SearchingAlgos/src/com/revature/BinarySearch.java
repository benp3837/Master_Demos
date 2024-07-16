package com.revature;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //Calling BinarySearch with an element that is in the array
        if(binarySearch(arr, 3) != -1) {
            System.out.println("found! index: " + binarySearch(arr, 5));
        } else {
            System.out.println("not found!");
        }

        //Calling BinarySearch with an element that is not in the array
        if(binarySearch(arr, 11) != -1) {
            System.out.println("found! index: " + binarySearch(arr, 11));
        } else {
            System.out.println("not found!");
        }

    }

    /*Binary Search
- Binary search is a more efficient way to search for a target in a SORTED array
- It works by comparing the target to the middle element of the array
- If the target is less than the middle element, we know the target is in the left half of the array
- If the target is greater than the middle element, we know the target is in the right half of the array
- We repeat this process on the half of the array that we know the target is in
- We continue this process until we find the target or determine that it is not in the array */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        //while the left pointer is less than or equal to the right pointer...
        while (left <= right) {

            int mid = left + (right - left) / 2; //find the middle index

            //if the middle element is the target, return the index - we found it!
            if (arr[mid] == target) {
                return mid;
            }

            //if the target is less than the middle element, search the left half of the array
            if (arr[mid] < target) {
                left = mid + 1; //move the left pointer to the right of the middle
            } else {
                right = mid - 1; //move the right pointer to the left of the middle
            }

        }

        return -1; //target not found
    }

}
