package com.bobocode.threads;

public class DeadlockDemo2 {

    private static Integer resource1 = 1;
    private static Integer resource2 = 2;

    public static void main(String[] args) throws InterruptedException {

        var thread1 = createThread1(resource1, resource2);
        var thread2 = createThread2(resource1, resource2);

        var monitor = getMonitorThread(thread1, thread2);

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        monitor.setName("Monitor");

        thread1.start();
        thread2.start();
        monitor.start();
    }

    private static Thread createThread1(Integer resource1, Object resource2) {
        return new Thread(() -> {
            try {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " locked resource1");
                    Thread.sleep(1000);
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread().getName() + " locked resource2");
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static Thread createThread2(Object resource1, Object resource2) {
        return new Thread(() -> {
            try {
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " locked resource2");
                    Thread.sleep(1000);
                    synchronized (resource1) {
                        System.out.println(Thread.currentThread().getName() + " locked resource1");
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static Thread getMonitorThread(Thread thread1, Thread thread2) {
        return new Thread(() -> {
            try {
                while (true) {
                    System.out.println(thread1.getName() + " is in state " + thread1.getState());
                    System.out.println(thread2.getName() + " is in state " + thread2.getState());
                    System.out.println();
                    Thread.sleep(400);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
