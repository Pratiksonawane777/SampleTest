package com.interview.questions;

public class ReverseEveryThreeValues {
    public static void main(String[] args) {
        int[] aa = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int size = 3;

        for (int i = 0; i < aa.length; i += size) {
            int start = i;
            int end = Math.min(i + size - 1, aa.length - 1);

            // Reverse the values within the current group of size 3
            while (start < end) {
                int temp = aa[start];
                aa[start] = aa[end];
                aa[end] = temp;
                start++;
                end--;
            }
        }

        // Print the modified array
        for (int value : aa) {
            System.out.print(value + " ");
        }
    }
}
