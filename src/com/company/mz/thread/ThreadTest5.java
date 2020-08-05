package com.company.mz.thread;

import javafx.scene.chart.ScatterChart;

import static java.lang.Thread.sleep;

public class ThreadTest5 {
    public static void main(String[] args)  {
//        interruptedThread();
//        interruptedExceptionMethod();
        joinThreads();

    }

    private static void joinThreads() {
        Thread t1 = new Thread(()->{
            try{
                sleep(1000);
                System.out.println("t1 is finished");
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try{
                sleep(1000);
                System.out.println("t2 is finished");
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main is waiting of finishing t1/t2 threads");
    }

    private static void interruptedExceptionSample() throws InterruptedException {
        Thread sleepThread = new Thread(new Runnable(){
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    try{
                        System.out.println("I'm still working");
                        sleep(1000);
                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        sleepThread.start();
        sleep(300);
        sleepThread.interrupt();
    }

    private static void interruptedThread() {
        Thread thread = new Thread(() ->{
            someLongWork();
        });
        thread.start();

        System.out.println("main waiting for finishing Thread t");
        thread.interrupt();
    }

    public static void someLongWork(){
        long time = System.currentTimeMillis();
        for(long i = 0; i<100000L; i++){
            long a = i*16;
            if(i>50_000 && Thread.currentThread().isInterrupted()){
                break;
            }
            for(long j = 0; j<a; j++){
                long b = j*4;
            }
        }
        System.out.println(System.currentTimeMillis() -time);
    }
}
