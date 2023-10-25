package com.bobocode.threads;

//
//ONLINE TRAINING 7 | TASK 1
//        👉 Implement a deadlock [10 min] ☠️
//
//        Create a code snippet that causes a deadlock
//        Prep a demo showing that it's really a deadlock
//        Post  screenshots of your code in the Thread 👇
public class DeadlockDemo {

    private static final String resourceA = "Resource A";
    private static final String resourceB = "Resource B";

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(resourceA + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (resourceB) {
                    System.out.println(resourceB + " " + Thread.currentThread().getName());
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println(resourceB + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (resourceA) {
                    System.out.println(resourceA + " " + Thread.currentThread().getName());
                }
            }
        });

        // todo add monitoring thread it

        thread1.start();
        thread2.start();
        Thread.sleep(2000);

        System.out.println("thread2.getState() = " + thread2.getState());
        System.out.println("thread1.getState() = " + thread1.getState());

        Thread.sleep(10000);
        System.out.println("thread2.getState() = " + thread2.getState());
        System.out.println("thread1.getState() = " + thread1.getState());
    }

}
