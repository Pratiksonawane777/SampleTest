//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.interview.questions.pre.functional.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo
//    implements Supplier<String>
{
//    @Override
//    public String get() {
//        return "Hello Pratik";
//    }

    public static void main(String[] args) {
//        Supplier<String> supplier= new SupplierDemo();
//        System.out.println(supplier.get());

        Supplier<String> supplier= () -> "Hello Pratik";
        System.out.println(supplier.get());

        List<String> integerList= Arrays.asList();
        System.out.println(integerList.stream().findAny().orElseGet(supplier));
        System.out.println(integerList.stream().findAny().orElseGet(() -> "Hello Pratik"));
    }
}
