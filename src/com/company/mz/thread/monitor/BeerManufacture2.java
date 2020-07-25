package com.company.mz.thread.monitor;

//sync by block

public class BeerManufacture2 {
    private long bottleCount;

    public BeerManufacture2(long bottleCount) {
        this.bottleCount = bottleCount;
    }

    public BeerManufacture2() {
        this.bottleCount = 0;
    }

    public long getCurrentBottleCount() {
        return bottleCount;
    }
    public synchronized void addBeerToBottle(long count){
         this.bottleCount +=count;
    }
    //equivalent to
    public void pourOutBeerFromBottles(long count){
        synchronized (this){
            this.bottleCount -=count;
        }
    }
    public static void doSomethingElse(){
        synchronized (BeerManufacture.class){
            System.out.println(" something else");
        }
    }
    public static synchronized void doSomethingElse2(){
        System.out.println("something else");
    }
}
