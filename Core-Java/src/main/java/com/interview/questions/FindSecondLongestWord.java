package com.interview.questions;

import java.util.Arrays;
import java.util.Comparator;

public class FindSecondLongestWord {
    public static void main(String[] args) {
        String str = "I am a good programmer";
        String[] words = str.split(" ");

        String longestWord = "";
        String secondLongestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                secondLongestWord = longestWord;
                longestWord = word;
            } else if (word.length() > secondLongestWord.length() && !word.equals(longestWord)) {
                secondLongestWord = word;
            }
        }

        System.out.println("Longest Word: " + longestWord);
        System.out.println("Second Longest Word: " + secondLongestWord);

        String secondLongestWord2 = Arrays.stream(words)
            .distinct()
            .sorted(Comparator.comparingInt(String::length).reversed())
            .skip(1)
            .findFirst()
            .orElse(null);

        System.out.println("Second Longest Word: " + secondLongestWord2);
    }
}
