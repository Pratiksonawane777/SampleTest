package com.interview.questions;

public class Removing5FromNumberAndGetBigestNumber {

    public static void main(String[] args) {
        System.out.println(solution(15958));
        //        Example test:   15958
        //        expected 1958
        System.out.println(solution(-5859));
        //        Example test:   -5859
        //         expected -589
        System.out.println(solution(-5000));
        //        Example test:   -5000
        //        5000 expected 0
    }

    public static int solution(int n) {
        String nStr = Integer.toString(n);
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nStr.length(); i++) {
            if (nStr.charAt(i) == '5') {
                StringBuilder tempStr = new StringBuilder(nStr);
                tempStr.deleteCharAt(i);
                int tempNum = Integer.parseInt(tempStr.toString());
                maxNum = Math.max(tempNum, maxNum);
            }
        }
        return maxNum;
    }

}
