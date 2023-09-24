package com.interview.questions;

public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        generatePermutations(str, 0, str.length() - 1);
    }

    public static void generatePermutations(String str, int left, int right) {
        if (left == right) {
            System.out.println(str);
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                generatePermutations(str, left + 1, right);
                str = swap(str, left, i); // Backtrack to the original string
            }
        }
    }

    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }
}
