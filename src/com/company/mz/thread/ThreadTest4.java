package com.company.mz.thread;

import static java.lang.Thread.sleep;

public class ThreadTest4 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread(() ->{
            someWork();
        });
        Thread thread1 = new Thread(() ->{
            someWork();
        });
        thread0.setPriority(10);
        thread1.setPriority(1);

        thread0.setName("high priority thread");
        thread1.setName("low priority thread");

        thread1.start();
        thread0.start();

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    public static void someWork(){
        System.out.println("hello from " +Thread.currentThread().getName());
    }
}
