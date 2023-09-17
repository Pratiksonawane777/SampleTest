package com.interview.questions;

import java.util.Arrays;
import java.util.List;

public class MaximumSubarraySum {

    public static int maxSubarraySum(List<Integer> nums) {
        int maxSum = nums.get(0);
        int currentSum = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3);
        int maxSum = maxSubarraySum(nums);
        System.out.println("Maximum Subarray Sum: " + maxSum);
    }
}
