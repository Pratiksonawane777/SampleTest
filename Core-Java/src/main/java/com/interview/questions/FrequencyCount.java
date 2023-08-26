package com.interview.questions;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCount {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 2, 3, 1, 3, 4, 4 };

        // Create a HashMap to store the frequency of array elements
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element in the array
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Count pairs using the frequency of array elements
        int totalCount = 0;
        for (int freq : frequencyMap.values()) {
            // Calculate the number of pairs that can be formed with the current frequency
            totalCount += freq / 2;
        }

        System.out.println("Total pairs: " + totalCount);
    }
}
