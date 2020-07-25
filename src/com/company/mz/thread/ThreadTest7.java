package com.company.mz.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest7 {
    static AtomicInteger x = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i = 0; i<4000; i++){
                x.getAndIncrement();
                try{
                    Thread.sleep(5);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }

            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            for(int i = 0; i<4000; i++){
                x.getAndDecrement();
                try{
                    Thread.sleep(5);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }

            }
        });
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("atomic int value: " + x);
    }
}
