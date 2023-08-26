package com.interview.questions.java8.pre.functional.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapNdFlatMap {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Java");
        List<Integer> wordLengths = words.stream()
            .map(word -> word.length())
            .collect(Collectors.toList());
        // Output: [5, 5, 4]
        System.out.println("Using Map : " + wordLengths.toString());

        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );
        List<Integer> flattenedList = listOfLists.stream()
            .flatMap(list -> list.stream())
            .collect(Collectors.toList());
        // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println("Using Map : " + flattenedList.toString());

    }
}
