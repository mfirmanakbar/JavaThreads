package com.javahaters;

import java.util.Date;

public class ThreadExample6B {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Running: ThreadName: " + Thread.currentThread().getName() + " - ThreadTime: " + new Date());
        };

        for (int i = 1; i <= 100; i++) {
            Thread thr = new Thread(runnable, "The Thread " + i);
            thr.start();
        }
    }
}
