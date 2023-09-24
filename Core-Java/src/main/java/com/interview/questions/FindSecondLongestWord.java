package com.interview.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

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

        Optional<String> maxString = Arrays.stream(words)
            .max((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        if (maxString.isPresent()) {
            System.out.println("Max String: " + maxString.get());
        } else {
            System.out.println("Array is empty.");
        }

    }
}
