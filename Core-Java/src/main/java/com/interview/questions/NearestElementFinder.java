package com.interview.questions;

import java.util.Arrays;

public class NearestElementFinder {

    public static void main(String[] args) {
        int[] array = {2, 5, 6, 7, 8, 8, 9};

        int n = 4; // The number you want to find the nearest element to

        int nearestElement = findNearestElement(array, n);
        System.out.println("The nearest element to " + n + " is: " + nearestElement);

        Arrays.stream(array)
            .boxed() // Convert to Integer stream
            .min((a, b) -> Integer.compare(Math.abs(a - n), Math.abs(b - n))) // Find the element with the minimum absolute difference
            .orElse(array[0]); // If the array is empty, return a default value (in this case, the first element of the array)
        System.out.println("The nearest element to " + n + " is: " + nearestElement);

    }

    private static int findNearestElement(int[] array, int n) {
        int nearestElement = array[0];
        int minDiffrence = Math.abs(nearestElement-n);

        for(int i=1;i<array.length;i++) {
            int diffrence = Math.abs(array[i]-n);
            if(minDiffrence > diffrence){
                minDiffrence=diffrence;
                nearestElement= array[1];
            }
        }
        return nearestElement;
    }
}
