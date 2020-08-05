package com.company.mz.thread.monitor;

//sync by block

public class BeerManufacture {
    private long bottleCount;
    private Object monitor;

    public BeerManufacture(long bottleCount) {
        this.bottleCount = bottleCount;
        monitor = new Object();
    }

    public BeerManufacture() {
        this.bottleCount = 0;
        monitor = new Object();
    }

    public long getCurrentBottleCount() {
        return bottleCount;
    }
    public void addBeerToBottle(long count){
        synchronized (monitor){
            this.bottleCount +=count;
        }
    }
    public void pourOutBeerFromBottles(long count){
        synchronized (monitor){
            this.bottleCount -=count;
        }
    }
}
