package com.interview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSuArrayOfGivenSum {

    public static void main(String[] args) {
        int[] arr = { 3, 1, 0, 1, 6, 7, 3, 2, 10 };
        int targetSum = 5;

        List<List<Integer>> subarrays = findSubArraysOfGivenSum(arr, targetSum);
        System.out.println("Subarrays with sum " + targetSum + ":");
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }

        List<List<Integer>> subarrays2 = findSubarraysWithSumBetterTimeComplexity(arr, targetSum);
        System.out.println("Subarrays with sum " + targetSum + ":");
        for (List<Integer> subarray : subarrays2) {
            System.out.println(subarray);
        }
    }

    private static List<List<Integer>> findSubArraysOfGivenSum(int[] arr, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        int currentSum = 0;

        while (right < arr.length) {
            currentSum = currentSum + arr[right];

            while (currentSum > targetSum) {
                currentSum = currentSum - arr[left];
                left++;
            }

            if (currentSum == targetSum) {
                List<Integer> subarray = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    subarray.add(arr[i]);
                }
                list.add(subarray);

                // Move the left pointer to find other subarrays.
                currentSum = currentSum - arr[left];
                left++;
            }

            right++;
        }

        return list;
    }

    public static List<List<Integer>> findSubarraysWithSumBetterTimeComplexity(int[] arr, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> sumMap = new HashMap<>();
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == targetSum) {
                List<Integer> subarray = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    subarray.add(arr[j]);
                }
                result.add(subarray);
            }

            int requiredSum = currentSum - targetSum;
            if (sumMap.containsKey(requiredSum)) {
                int start = sumMap.get(requiredSum) + 1;
                int end = i;
                List<Integer> subarray = new ArrayList<>();
                for (int j = start; j <= end; j++) {
                    subarray.add(arr[j]);
                }
                result.add(subarray);
            }

            sumMap.put(currentSum, i);
        }

        return result;
    }
}
