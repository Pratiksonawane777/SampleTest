//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.interview.questions.pre.functional.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo
//    implements Predicate<Integer>
{

    public static void main(String[] args) {
//        Predicate<Integer> predicate= new PredicateDemo();
//        System.out.println(predicate.test(10));

        Predicate<Integer> predicate= t-> t%2==0;
        System.out.println(predicate.test(10));
        System.out.println(predicate.test(5));

        List<Integer> integerList= Arrays.asList(1,2,3,4,5);
        integerList.stream().filter(i-> i%2==0).forEach(t-> System.out.println("print Even:" + t));

    }

//    @Override
//    public boolean test(Integer integer) {
//        return integer%2==0;
//    }
}
