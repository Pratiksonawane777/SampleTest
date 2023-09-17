package com.interview.questions;

public class FindFirstAndLastIndexOfNum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5, 2};
        int target = 2; // Element to search for

        int firstIndex = -1; // Initialize with -1 to indicate not found
        int lastIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (firstIndex == -1) {
                    firstIndex = i; // Found the first occurrence
                }
                lastIndex = i; // Update the last occurrence
            }
        }

        if (firstIndex != -1) {
            System.out.println("First occurrence of " + target + " is at index " + firstIndex);
            System.out.println("Last occurrence of " + target + " is at index " + lastIndex);
        } else {
            System.out.println(target + " was not found in the array.");
        }
    }
}
