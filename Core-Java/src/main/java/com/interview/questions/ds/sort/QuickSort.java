//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.interview.questions.ds.sort;

import java.util.Arrays;

public class QuickSort {
//    Average-case time complexity: O(n log n)
//    Worst-case time complexity: O(n^2) (although with good partitioning strategies, this is rarely encountered)
//    Best-case time complexity: O(n log n)
    public static void main(String[] args) {
        int[] numbers = { 1, 4, 7, 9, 2, 3, 1, 9, 2 };
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
    }

    private static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int partition = partition(numbers, start, end);
            quickSort(numbers, start, partition - 1);
            quickSort(numbers, partition + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }

}
