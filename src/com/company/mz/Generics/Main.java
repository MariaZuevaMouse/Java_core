package com.company.mz.Generics;

import javafx.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList =
                new ArrayList<>(Arrays.asList(10, 20, 30));
        System.out.println(getFirstElement(intList));
        Integer a =(Integer) getFirstElement(intList);
        Integer intFirst = getFirstElement2(intList);


        List<Number> numberList =
                new ArrayList<Number>(Arrays.asList(10,20,30));
        List<Integer> integerList =
                new ArrayList<>(Arrays.asList(100,200,300));
        Collections.copy(numberList, integerList);
    }
    private static Object getFirstElement(List list){
        if(list == null || list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    private static <T extends Number> T getFirstElement2(List<T> list){
        if(list == null || list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    private <T extends Number & Comparable & Serializable>  void diSomething(List<? super Number> list){
        System.out.println("Hello, Generics!");
    }
    public static void intro(){
        Box box1 = new Box(15);
        Box box2 = new Box(17);

//        box2.setObject("str");

        System.out.println(box1);
        System.out.println(box2);
        if(box1.getObject() instanceof Integer && box2.getObject() instanceof Integer){
            int result = (Integer) box1.getObject() + (Integer)box2.getObject();
            System.out.println(result);
        } else System.out.println("Objects in boxes do not contain Integers");

    }
    public static void boxWithTwoParams(){
        BoxWithParameter<Integer> box1 =
                new BoxWithParameter<>(15);
        BoxWithParameter<Integer> box2 =
                new BoxWithParameter<>(17);
        BoxWithParameter<String> str =
                new BoxWithParameter<>("string");

        int result = box1.getObject()+ box2.getObject();
        System.out.println(result);

        BoxWithTwoParams<Integer, Integer> DoubleIntBox =
                new BoxWithTwoParams<>(100,100);

        /*
         * E - element
         * K, V - key, value
         * T - type
         * S, U, V - neighbors of T
         */
    }
    public static void boxWithNumbers(){
        BoxWithNumbers<Integer> integerBoxWithNumber =
                new BoxWithNumbers<>(new Integer[]{10,20,30});

        BoxWithNumbers<Double> doubleBoxWithNumbers =
                new BoxWithNumbers<>(new Double[]{10.0, 20.0, 30.0});

        System.out.println(integerBoxWithNumber.isAvgTheSame(doubleBoxWithNumbers));


        float a = 1.0f;
        float b = 0.0f;
        for(int i = 0; i<=100; i++){
            b+=0.01f;
        }
        System.out.println("a = " + a + " b = " + b);
    }
}
