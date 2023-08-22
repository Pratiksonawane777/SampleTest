//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.interview.questions.ds.sort;

import java.util.Arrays;

public class BubbleSort {
    //time complexity: O(n^2)
    public static void main(String[] args) {
        int[] arr = { 1, 4, 7, 9, 2, 3, 1, 9, 2 };
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 1; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

}
