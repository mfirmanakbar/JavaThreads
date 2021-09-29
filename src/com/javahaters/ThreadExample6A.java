package com.javahaters;

import java.util.Date;

public class ThreadExample6A {

    public static void main(String[] args) {
        hitApi("www.hitapi.com", 100);
    }

    private static void hitApi(String baseUrl, int NumberOfThreads) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            //System.out.println(threadName + " running " + baseUrl);
            System.out.println(
                    "ThreadName: " + threadName
                            + " - ThreadTime: " + new Date()
                            + " - " + baseUrl
            );
        };

        for (int i = 0; i < NumberOfThreads; i++) {
            Thread thr = new Thread(runnable, "The Thread " + i);
            thr.start();
        }
    }
}
