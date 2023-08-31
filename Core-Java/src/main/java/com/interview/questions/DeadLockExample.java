package com.interview.questions;

public class DeadLockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " trying to acquire lock2");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " trying to acquire lock1");
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
