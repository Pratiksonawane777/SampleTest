package com.interview.questions;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "orange", "papaya", "apple", "apple", "banana", "apple");

        // Remove duplicates while preserving order
        List<String> uniqueList = new ArrayList<>(new LinkedHashSet<>(list));

        // Print the result
        for (String fruit : uniqueList) {
            System.out.println(fruit);
        }

        List<String> uniqueListUsingStream = list.stream()
            .distinct() // Remove duplicates
            .collect(Collectors.toList()); // Collect the result back into a List

        // Print the result
        uniqueListUsingStream.forEach(System.out::println);
    }
}
