//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.interview.questions;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        rotateArray(arr,3);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void rotateArray(int[] arr,int positionsToRotate) {
        int length = arr.length;
        int[] rotated = new int[length];  // Create a new array to store rotated elements

        for (int i = 0; i < length; i++) {
            // Calculate the new position after rotation
            int newPosition = (i + length - positionsToRotate) % length;

            // Put the current element into the new position in the rotated array
            rotated[newPosition] = arr[i];
        }
        // Copy the elements from rotated array back to the original array
        for (int i = 0; i < length; i++) {
            arr[i] = rotated[i];
        }
    }
}
