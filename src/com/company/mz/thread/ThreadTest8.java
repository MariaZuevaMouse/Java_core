package com.company.mz.thread;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class ThreadTest8 {
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(3);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<5; i++){
                    try {
                        sleep(1000);
                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<5; i++){
                    try {
                        sleep(1000);
                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<5; i++){
                    try {
                        sleep(1000);
                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<5; i++){
                    try {
                        sleep(1000);
                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }
            }
        });

        Future<Integer> callableResult = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "!Callable! is running");
                sleep(2000);
                return 13;
            }
        });
        try {
            int result = callableResult.get();
            System.out.println("Result from callable: " +result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}

