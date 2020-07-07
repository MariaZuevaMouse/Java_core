package com.company.mz.Generics;

public class BoxWithNumbers<T extends Number> {
    private T[] numbers;

    public BoxWithNumbers(T[] numbers) {
        this.numbers = numbers;
    }
    public double getAvg(){
        double res =0.0;
        for(Number number: numbers){
            res += number.doubleValue();
        }
        return res/numbers.length;
    }
    public boolean isAvgTheSame(BoxWithNumbers<?> another){
        return Math.abs(this.getAvg() - another.getAvg())< 0.0001;
    }
}
