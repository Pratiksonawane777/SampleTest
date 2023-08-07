package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CoreJavaTest {

    public static void main(String[] args) {
        //        String input1 = "[(1+2)+1]";
        //        String input2 = "[(1+2)+1";
        //        String input3 = "[(1+2)+1)]";
        //
        //        System.out.println(input1 + " is valid: " + isValidString(input1));
        //        System.out.println(input2 + " is valid: " + isValidString(input2));
        //        System.out.println(input3 + " is valid: " + isValidString(input3));
        //
        //        List<String> inputPaths = Arrays.asList("/a", "/a/b", "/c/d", "/c/d/e", "/c/f", "/a/e/f");
        //        List<String> outputPaths = removeSubfolders(inputPaths);
        //        System.out.println(outputPaths);
        //
        //
        //        int[] arr = { 3, 1, 0, 1, 6, 7, 3, 2, 10 };
        //        int targetSum = 5;
        //
        //        List<List<Integer>> subarrays = findSubarraysWithSum(arr, targetSum);
        //        System.out.println("Subarrays with sum " + targetSum + ":");
        //        for (List<Integer> subarray : subarrays) {
        //            System.out.println(subarray);
        //        }
        //
        //        List<List<Integer>> subarrays2 = findSubarraysWithSumBetterTimeComplexity(arr, targetSum);
        //        System.out.println("Subarrays with sum " + targetSum + ":");
        //        for (List<Integer> subarray : subarrays2) {
        //            System.out.println(subarray);
        //        }

        //        int inputNumber = 12345; // Replace this with your desired input number
        //        checkPalindromeOrNot(inputNumber);
        //        checkPalindromeOrNotWithRevers(inputNumber);
        //
        //        int nextPalindrome = findNextPalindrome(inputNumber);
        //        System.out.println("Next Palindrome: " + nextPalindrome);

        //        calculateTheSumOfDigits();

        String str = "1234A";
        convertGetSumOfInteger(str);
    }

    private static void convertGetSumOfInteger(String str) {
        int sum = 0;
        char[] ch = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                int digit = Character.getNumericValue(ch[i]);
                list.add(digit);
                sum += digit;
            }
        }
        System.out.println(list);
        System.out.println(sum);

        int sum2 = 0;
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(ch[i])) {
                int digit = Character.getNumericValue(str.charAt(i));
                list2.add(digit);
                sum2 += digit;
            }
        }
        System.out.println(list2);
        System.out.println(sum2);
    }

    private static void calculateTheSumOfDigits() {
        int num = 321;
        int sum = 0;
        // Calculate the sum of digits
        while (num != 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }

        System.out.println("The sum of the digits is: " + sum);
    }

    private static void checkPalindromeOrNotWithRevers(int inputNumber) {
        String numStr = Integer.toString(inputNumber);
        StringBuilder reverse = new StringBuilder();

        for (int i = numStr.length() - 1; i >= 0; i--) {
            reverse.append(numStr.charAt(i));
        }
        if (numStr.equalsIgnoreCase(reverse.toString())) {
            System.out.println("Entered string/number is a palindrome.");
        } else {
            System.out.println("Entered string/number isn't a palindrome.");
        }
    }

    private static void checkPalindromeOrNot(int n) {
        int r, sum = 0, temp;
        temp = n;
        while (n > 0) {
            r = n % 10;
            sum = (sum * 10) + r;
            n = n / 10;
        }
        if (temp == sum) {
            System.out.println("palindrome number ");
        } else {
            System.out.println("not palindrome");
        }
    }

    private static int findNextPalindrome(int inputNumber) {
        while (true) {
            inputNumber++;
            if (isPalindrome(inputNumber)) {
                return inputNumber;
            }
        }
    }

    private static boolean isPalindrome(int inputNumber) {
        String numStr = Integer.toString(inputNumber);
        int left = 0;
        int right = numStr.length() - 1;
        while (left < right) {
            if (numStr.charAt(left) != numStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static List<String> removeSubfolders(List<String> inputPaths) {
        Set<String> topLevelPaths = new HashSet<>();

        for (String path : inputPaths) {
            String[] folders = path.split("/");
            StringBuilder currentPath = new StringBuilder();

            // Skip the first empty element after splitting by "/"
            for (int i = 1; i < folders.length; i++) {
                currentPath.append("/").append(folders[i]);

                // Check if the currentPath exists in the topLevelPaths (subfolder found)
                if (topLevelPaths.contains(currentPath.toString())) {
                    break;
                }
            }

            // If subfolder not found, add the path to topLevelPaths
            if (!topLevelPaths.contains(currentPath.toString())) {
                topLevelPaths.add(path);
            }
        }

        return new ArrayList<>(topLevelPaths);
    }

    public static boolean isValidString(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing bracket or parenthesis
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[')) {
                    return false; // Mismatched closing bracket or parenthesis
                }
            }
        }
        return stack.isEmpty(); // All opening brackets and parentheses are matched
    }

    public static List<List<Integer>> findSubarraysWithSumBetterTimeComplexity(int[] arr, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> sumMap = new HashMap<>();
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == targetSum) {
                List<Integer> subarray = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    subarray.add(arr[j]);
                }
                result.add(subarray);
            }

            int requiredSum = currentSum - targetSum;
            if (sumMap.containsKey(requiredSum)) {
                int start = sumMap.get(requiredSum) + 1;
                int end = i;
                List<Integer> subarray = new ArrayList<>();
                for (int j = start; j <= end; j++) {
                    subarray.add(arr[j]);
                }
                result.add(subarray);
            }

            sumMap.put(currentSum, i);
        }

        return result;
    }

    public static List<List<Integer>> findSubarraysWithSum(int[] arr, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        int left = 0;
        int right = 0;
        int currentSum = 0;

        while (right < arr.length) {
            currentSum += arr[right];

            while (currentSum > targetSum) {
                currentSum -= arr[left];
                left++;
            }

            if (currentSum == targetSum) {
                List<Integer> subarray = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    subarray.add(arr[i]);
                }
                result.add(subarray);

                // Move the left pointer to find other subarrays.
                currentSum -= arr[left];
                left++;
            }

            right++;
        }

        return result;
    }

}
