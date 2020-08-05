package com.company.mz.thread;

import static java.lang.Thread.sleep;

public class ThreadTest3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->{
            someLongWork();
        });
        thread.setDaemon(true);
        thread.start();

        sleep(3000);
        System.out.println("main thread finished");
    }
    public static void someLongWork(){
        long time = System.currentTimeMillis();
        for(long i = 0; i<100000L; i++){
            long a = i*8;
            for(long j = 0; j<a; j++){
                long b = j*4;
            }
        }
        System.out.println(System.currentTimeMillis() -time);
    }
}
