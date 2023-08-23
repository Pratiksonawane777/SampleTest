package com.interview.questions;

public class Palindrome {

    public static void main(String[] args) {
        int inputNumber1 = 12345;
        int inputNumber2 = 12321;

        checkPalindromeOrNot(inputNumber1);
        checkPalindromeOrNot(inputNumber2);

        checkPalindromeOrNotWithRevers(inputNumber1);
        checkPalindromeOrNotWithRevers(inputNumber2);

        int nextPalindromeNumber = findNextPalindrome(inputNumber1);
        System.out.println("Next Palindrome: " + nextPalindromeNumber);
    }

    private static void checkPalindromeOrNot(int inputNumber) {
        int temp = inputNumber;
        int sum = 0;
        int r;
        while (temp > 0) {
            r = temp % 10;
            sum = (sum * 10) + r;
            temp /= 10;
        }

        if (inputNumber == sum) {
            System.out.println(inputNumber + " is palindrome number ");
        } else {
            System.out.println(inputNumber + " not palindrome");
        }
    }

    private static void checkPalindromeOrNotWithRevers(int inputNumber) {
        String inputString = Integer.toString(inputNumber);
        StringBuilder reverse = new StringBuilder();
        for (int i = inputString.length() - 1; i >= 0; i--) {
            reverse.append(inputString.charAt(i));
        }
        if (inputString.equalsIgnoreCase(reverse.toString())) {
            System.out.println(inputNumber + " is palindrome number ");
        } else {
            System.out.println(inputNumber + " not palindrome");
        }
    }

    private static int findNextPalindrome(int inputNumber) {
        while (true) {
            if (isPalindrome(inputNumber)) {
                return inputNumber;
            }
            inputNumber++;
        }
    }

    private static boolean isPalindrome(int inputNumber) {
        String inputString = Integer.toString(inputNumber);
        int left = 0;
        int right = inputString.length() - 1;

        while (left < right) {
            if (inputString.charAt(left) != inputString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
