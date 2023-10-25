package com.bobocode.threads;

import java.util.Timer;
import java.util.concurrent.*;

//ONLINE TRAINING 7 | TASK 0
//        👉 Say hello from the other thread [10 min]
//
//        Think about all options you know to execute some code in the other thread
//        Create a code snippet for each option executing the following statement in the other thread:
//        System.out.println("Hello from " + Thread.currentThread().getName());
//        Post  screenshots of your code in the Thread 👇
public class ThreadDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hello from " + Thread.currentThread().getName()));
        thread.start();

        Runnable runnable = () -> System.out.println("Hello from " + Thread.currentThread().getName());
        new Thread(runnable).start();

        BlockingQueue<Runnable> runnableQueue = new ArrayBlockingQueue<>(1);
        new ThreadPoolExecutor(1, 1, 0, TimeUnit.MINUTES, runnableQueue).execute(runnable);


//        ExecutorService
//        CompletableFuture
//        Timer
//        ScheduledThreadPoolExecutor
    }


}
