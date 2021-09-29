package com.javahaters;

public class ThreadExample6 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");
        };

        Thread thread1 = new Thread(runnable, "The Thread 1");
        thread1.start();

        Thread thread2 = new Thread(runnable, "The Thread 2");
        thread2.start();

        Thread thread3 = new Thread(runnable, "The Thread 3");
        thread3.start();

        Thread thread4 = new Thread(runnable, "The Thread 4");
        thread4.start();

        Thread thread5 = new Thread(runnable, "The Thread 5");
        thread5.start();

    }
}
