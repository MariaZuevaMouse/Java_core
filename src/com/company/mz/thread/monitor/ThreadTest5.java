package com.company.mz.thread.monitor;

public class ThreadTest5 {
    public static void main(String[] args) throws InterruptedException {
        BeerManufacture beerManufacture = new BeerManufacture();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    beerManufacture.addBeerToBottle(1);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    beerManufacture.pourOutBeerFromBottles(1);
                }
            }
        });


        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();

        System.out.println(beerManufacture.getCurrentBottleCount());
    }
}
