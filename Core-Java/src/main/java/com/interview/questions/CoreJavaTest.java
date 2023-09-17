//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.interview.questions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CoreJavaTest {

    public static void main(String[] args) {

    }
}

class first {

    void runTime() throws NullPointerException {
    }

    void compileTime() throws FileNotFoundException {
    }
}

class Second extends first {

    @Override
    void runTime() throws RuntimeException {
        throw new RuntimeException();
    }

//    @Override
//    void compileTime() {
//        throw new IOException();
//    }
}