package com.interview.questions;

public class HighestLengthOfRepetedSubString {

    //        Input: "abcabcbb"
    //        Output: 3
    //        Explanation: The answer is "abc", with the length of 3.
    public static void main(String[] args) {
        String str = "bbbbb";
        int startFrom = str.length() / 2;
        for (int i = startFrom - 1; i >= 0; i--) {
            String strToMatch = str.substring(0, startFrom);
            String strToMatchWith = str.substring(startFrom);
            if (strToMatchWith.contains(strToMatch)) {
                System.out.println(strToMatch.length() + "");
                break;
            }
            startFrom--;
        }
    }

}
