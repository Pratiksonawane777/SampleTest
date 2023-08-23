package com.interview.questions;

import java.util.ArrayList;
import java.util.List;

public class CalculateTheSumOfDigits {

    public static void main(String[] args) {
        int number = 321;
        calculateTheSumOfDigits(number);

        String str = "1234A";
        convertGetSumOfInteger(str);
    }

    private static void convertGetSumOfInteger(String str) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int value = Character.getNumericValue(str.charAt(i));
                sum += value;
                list.add(value);
            }
        }
        System.out.println(list);
        System.out.println(sum);
    }

    private static void calculateTheSumOfDigits(int numbers) {
        int sum = 0;
        while (numbers != 0) {
            int digit = numbers % 10;
            sum = sum + digit;
            numbers = numbers / 10;
        }
        System.out.println("Sum of Digit : " + sum);
    }
}
