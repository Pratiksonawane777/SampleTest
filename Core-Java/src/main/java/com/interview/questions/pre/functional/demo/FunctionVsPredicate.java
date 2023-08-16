//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.interview.questions.pre.functional.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionVsPredicate {

    public static void main(String args[]) {
        //    Example of Predicate
        List<Integer> numList = new ArrayList<>();
        numList.add(5);
        numList.add(10);
        Predicate<Integer> pred = i -> i > 5;
        numList.stream().filter(pred).forEach(i -> System.out.println(i));

        //    Example of Function
        List<Integer> numList2 = new ArrayList<>();
        numList2.add(78);
        numList2.add(10);
        Function<Integer, Integer> fun = i -> i / 2;
        numList2.stream().map(fun).forEach(System.out::println);
    }
    // https://www.tutorialspoint.com/difference-between-function-and-predicate-in-java-8
}
