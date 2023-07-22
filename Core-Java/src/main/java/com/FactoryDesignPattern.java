//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com;
interface Product{
    void doSomething();
}

class ConcreteProductA implements Product{
    @Override
    public void doSomething() {
        System.out.println("Doing something in ConcreteProductA.");
    }
}

class ConcreteProductB implements Product{
    @Override
    public void doSomething() {
        System.out.println("Doing something in ConcreteProductB.");
    }
}

class ProductFactory {
    public static Product createProduct(String type){
        if(type.equals("A")) {
            return new ConcreteProductA();
        }else if(type.equals("B")){
            return new ConcreteProductB();
        }
        throw new IllegalArgumentException("Invalid product type.");
    }
}


public class FactoryDesignPattern {

    public static void main(String[] args) {
        Product productA = ProductFactory.createProduct("A");
        productA.doSomething();
        Product productB = ProductFactory.createProduct("B");
        productA.doSomething();
    }
}
