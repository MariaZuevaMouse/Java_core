package com.company.mz.thread;

public class ThreadTest2 {
    public static void main(String[] args) {
        for (int i = 0; i<10; i++){
            new MyDemoThread1().start();
        }
    }
    private static class MyDemoThread1 extends Thread{
        @Override
        public void run() {
            System.out.println("hello from " + getName());
        }
    }
}
