package com.designpatterns.demo;

public class SingletonPattern {
    public static void main(String[] args) {
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = SingletonClass.getInstance();

        // Both instance1 and instance2 should be the same object
        if (instance1 == instance2) {
            System.out.println("Both instances are the same. Singleton works!");
        } else {
            System.out.println("Singleton failed!");
        }

        if (instance1.equals(instance2)) {
            System.out.println("Both instances are the same. Singleton works!");
        } else {
            System.out.println("Singleton failed!");
        }
    }
}

class SingletonClass {

    private static SingletonClass instance;

    SingletonClass(){
        // Private constructor to prevent instantiation from other classes
    }

    // Lazy initialization of the Singleton instance
    public static SingletonClass getInstance() {
        if(instance==null){
            synchronized (SingletonClass.class){
                if(instance==null){
                    instance= new SingletonClass();
                }
            }
        }
        return instance;
    }
}
