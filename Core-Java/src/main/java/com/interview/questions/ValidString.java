package com.interview.questions;

import java.util.Stack;

public class ValidString {

    public static void main(String[] args) {
        String input1 = "[(1+2)+1]";
        String input2 = "[(1+2)+1";
        String input3 = "[(1+2)+1)]";
        String input4 = "[((1+2)+1]]";
        String input5 = "[[(1+2)+1]]";

        System.out.println("input1 : "+ isStringValid(input1));
        System.out.println("input2 : "+ isStringValid(input2));
        System.out.println("input3 : "+ isStringValid(input3));
        System.out.println("input4 : "+ isStringValid(input4));
        System.out.println("input5 : "+ isStringValid(input5));

    }

    private static boolean isStringValid(String input) {
        Stack<Character> stack= new Stack<>();
        for(char ch : input.toCharArray()){
            if(ch == '(' || ch == '['){
                stack.push(ch);
            } else if(ch == ')' || ch == ']'){
                if(stack.isEmpty())
                    return false; // Unmatched closing bracket or parenthesis
                char top= stack.pop();
                if((ch==')' && top != '(') || (ch == ']' && top != '['))
                    return false; // Mismatched closing bracket or parenthesis
            }
        }
        return stack.isEmpty(); // All opening brackets and parentheses are matched
    }

}
