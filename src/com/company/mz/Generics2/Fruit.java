package com.company.mz.Generics2;

public abstract class Fruit {
    protected static float weight;

    public static float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }
}
