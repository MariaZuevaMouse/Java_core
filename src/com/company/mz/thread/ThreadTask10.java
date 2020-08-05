package com.company.mz.thread;

public class ThreadTask10 {
    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;
    static float[] arr =new float[SIZE];
    static float[] arr1 = new float[HALF];
    static float[] arr2 = new float[HALF];

    public static void main(String[] args) {
        for(int i = 0; i<SIZE; i++){
            arr[i] = 1;
        }


        float[] result1 = arrayFillInWithNewData(arr);
        System.out.println(result1[0]);
        System.out.println(result1[1]);

        float[] result2 = arrayFillInWithNewDataUsingThreads(arr);
        System.out.println(result2[0]);
        System.out.println(result2[1]);


    }
    private static float[] arrayFillInWithNewData(float[] arr){
        long a = System.currentTimeMillis();
        float[] newArray;
        newArray =  fillArrayWithNewData(arr);
        System.out.println("fill in array by simple method " + (System.currentTimeMillis() - a)  + " ms");
        return newArray;
    }
    private static float[] arrayFillInWithNewDataUsingThreads(float[] arr){
        long a= System.currentTimeMillis();
        float[] newArray = arr;
        System.arraycopy(newArray, 0, arr1, 0, arr1.length);
        System.arraycopy(newArray, HALF, arr2, 0, arr2.length );

        Thread thread1 = new Thread(() -> arr1  = fillArrayWithNewData(arr1));
        Thread thread2 = new Thread(() -> arr2 = fillArrayWithNewData(arr2));
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, newArray, 0, arr1.length);
        System.arraycopy(arr2, 0, newArray, HALF, arr2.length);

        System.out.println("fill in array using threads in method " + (System.currentTimeMillis() - a) + " ms");
        return newArray;
    }
    private static float[] fillArrayWithNewData(float[] arr){
        float[] newArray = new float[arr.length];
        for(int i = 0; i<arr.length; i++){
            newArray[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return newArray;
    }
}


