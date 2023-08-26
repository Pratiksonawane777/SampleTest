//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.interview.questions.java8.pre.functional.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo
//    implements Consumer<Integer>
{

//    @Override
//    public void accept(Integer integer) {
//        System.out.println("Printing    :" + integer);
//    }

    public static void main(String[] args) {
//        ConsumerDemo consumerDemo= new ConsumerDemo();
//        consumerDemo.accept(10);

        //Using Lambda anonymous function
        Consumer<Integer> integerConsumer = t -> System.out.println("Printing through anonymous  function:" + t);
        integerConsumer.accept(20);

        List<Integer> integerList= Arrays.asList(1,2,3,4,5);

        //passing the function
        integerList.stream().forEach(integerConsumer);

        // directly pass lambda
        integerList.stream().forEach(t -> System.out.println("Printing  Consumer foreach  :" + t));
    }
}
