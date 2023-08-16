//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.customexception.demo;

//@RestController
public class MyController {
//    @GetMapping("/my-endpoint")

    public static void main(String[] args) {
        // Some condition that triggers the custom exception
        if (true) {
            throw new CustomException("Custom exception occurred.");
        }
        // Rest of the code
    }
}
