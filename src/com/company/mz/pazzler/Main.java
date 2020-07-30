package com.company.mz.pazzler;

public class Main {
    public static void main(String[] args) {
        method1();
        method3();
        method4();
    }
    public static void method1(){
        for(;;){;;}
    }
    //can not be compiled as unreachable statement after endless cycle.
    // Other methods will be compiled successfully and can be launched all from main
    /*
    * public static void method2(){
    *   for(;;);;
    *}
    * */
    public static void method3(){
        {;}for(;;){;}
    }
    public static void method4(){
        ; for(;;){;;}
    }


}
