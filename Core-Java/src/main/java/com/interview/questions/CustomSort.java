package com.interview.questions;

import java.util.ArrayList;
import java.util.List;

public class CustomSort {

    public static List<Integer> sortList(List<Integer> inputList) {
        int n = inputList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (inputList.get(j) > inputList.get(j + 1)) {
                    // Swap the elements
                    int temp = inputList.get(j);
                    inputList.set(j, inputList.get(j + 1));
                    inputList.set(j + 1, temp);
                }
            }
        }
        return inputList;
    }

    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        // Add your integers to the inputList
        inputList.add(5);
        inputList.add(2);
        inputList.add(9);
        inputList.add(1);

        List<Integer> sortedList = sortList(inputList);

        System.out.println("Sorted List: " + sortedList);
    }
}
