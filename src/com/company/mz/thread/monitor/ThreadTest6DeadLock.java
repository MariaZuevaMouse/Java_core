package com.company.mz.thread.monitor;

public class ThreadTest6DeadLock {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadThreadOne t1 = new DeadThreadOne();
        DeadThreadTwo t2 = new DeadThreadTwo();
        t1.start();
        t2.start();

    }
    private static  class DeadThreadOne extends Thread{
        @Override
        public void run() {
            synchronized (lock1){
                System.out.println("DeadThread1 is holding Lock 1 ...");
                try{
                    Thread.sleep(10);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println("DeadThreadOne is waiting for Lock 2 ...");
                synchronized (lock2){
                    System.out.println("DeadThreadOne is holding lock 1 and  lock 2 ... ");
                }
            }
        }
    }
    private static  class DeadThreadTwo extends Thread{
        @Override
        public void run() {
            synchronized (lock2){
                System.out.println("DeadThread1 is holding Lock 2 ...");
                try{
                    Thread.sleep(10);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println("DeadThreadOne is waiting for Lock 1 ...");
                synchronized (lock1){
                    System.out.println("DeadThreadOne is holding lock 1 and  lock 2 ... ");
                }
            }
        }
    }
}
