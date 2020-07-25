package com.company.mz.thread;

public class ThreadTest1 {
    public static  class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("hello from " +currentThread().getName());
        }
    }
    public static void main(String[] args) {
        createThreadInSeparateStaticClass();

        CreateThreadWithInterface();
    }

    private static void CreateThreadWithInterface() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello from " +Thread.currentThread().getName());
            }
        }).start();
    }

    private static void createThreadInSeparateStaticClass() {
        MyThread t = new MyThread();
        MyThread t2 = new MyThread();
        t.start();
    }
}
