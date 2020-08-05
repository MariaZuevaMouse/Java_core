package com.company.mz.Generics2;
/*
*
*1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
* 2. Написать метод, который преобразует массив в ArrayList;
* Задача:
* Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
* Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
* поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
* Для хранения фруктов внутри коробки можно использовать ArrayList;
*
* 3.1 Сделать метод getWeight(), который высчитывает вес коробки,
* зная вес одного фрукта и их количество: вес яблока – 1.0f,
* апельсина – 1.5f (единицы измерения не важны);
* 3.2 Внутри класса Box сделать метод compare(),
* который позволяет сравнить текущую коробку с той,
* которую подадут в compare() в качестве параметра.
* true – если их массы равны, false в противоположном случае.
* Можно сравнивать коробки с яблоками и апельсинами;
* 3.3 Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
* Помним про сортировку фруктов:
* нельзя яблоки высыпать в коробку с апельсинами.
* Соответственно, в текущей коробке фруктов не остается,
* а в другую перекидываются объекты, которые были в первой;

* Не забываем про метод добавления фрукта в коробку.
*
*
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] strArr = {"Java", "Python", "JavaScript"};
        System.out.println(Arrays.toString(strArr));
        swapItemsInArray(strArr, 0,1);
        System.out.println(Arrays.toString((strArr)));

        Integer[] intArr = {100,300,200};
        System.out.println(Arrays.toString(intArr));
        swapItemsInArray(intArr,1,2);
        System.out.println(Arrays.toString(intArr));
//        try {
//            swapItemsInArray(intArr,1,3);
//        }catch (IndexOutOfBoundsException e){e.printStackTrace();}

        List<String> stringList = arrayToList(strArr);
        List<Integer> integerList = arrayToList(intArr);


        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Orange> orangeFruitBox = new FruitBox<>();
        appleBox.addFruitToTheBox(new Apple());
        appleBox.addFruitToTheBox(new Apple());

        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple());
        appleList.add(new Apple());
        appleBox.addFruitToTheBox(appleList);

        FruitBox<Apple> appleBox2 = new FruitBox<Apple>(appleList);
        orangeFruitBox.addFruitToTheBox(new Orange());
        FruitBox<Apple> appleBox3 = new FruitBox<>(appleList);

        System.out.println("apples in the first box:" + appleBox.getFruitQty());
        System.out.println("apples in the second box:" + appleBox2.getFruitQty());
        System.out.println("apples in the third box:" + appleBox3.getFruitQty());

        System.out.println("weight of first apple box"+appleBox.getWeight());
        System.out.println("weight of second apple box"+appleBox2.getWeight());
        System.out.println("weight of third apple box"+appleBox3.getWeight());
        System.out.println("weight of first orange box"+ orangeFruitBox.getWeight());

        System.out.println("compare second apple box with third apple box: "+ appleBox2.compare(appleBox3));
        System.out.println("compare second apple box with orange box: "+appleBox2.compare(orangeFruitBox));

        boolean check = appleBox2.shiftFruit(appleBox3);
        System.out.println("replace fruits from second to third box:  "+ check);
        System.out.println("apples in the second box:" + appleBox2.getFruitQty());
        System.out.println("apples in the third box:" + appleBox3.getFruitQty());

        List<Orange> orangeList5 = new ArrayList<>();
        orangeList5.add(new Orange());
        orangeList5.add(new Orange());
        orangeList5.add(new Orange());
        orangeList5.add(new Orange());
        orangeList5.add(new Orange());
        FruitBox<Orange> orangeFruitBox2 = new FruitBox<>(orangeList5);


        // check orange replacement
        System.out.println("oranges in the first box: " + orangeFruitBox.getFruitQty());
        System.out.println("oranges in the second box: " + orangeFruitBox2.getFruitQty());
        orangeFruitBox.shiftFruit(orangeFruitBox2);
        System.out.println("oranges in the first box after replacement: " + orangeFruitBox.getFruitQty());
        System.out.println("oranges in the second box  after replacement: " + orangeFruitBox2.getFruitQty());
        orangeFruitBox2.clearBox();
        System.out.println("oranges in the second box after clear: " + orangeFruitBox2.getFruitQty());



    }
    private static <T> void swapItemsInArray(T[] array, int index1, int index2)throws IndexOutOfBoundsException{
        T new1 = array[index2];
        T new2 = array[index1];
        array[index1] = new1;
        array[index2] = new2;
    }
    private static <T> List<T> arrayToList(T[] list){
        List<T> listBack = new ArrayList<T>();
        for (int i = 0; i<list.length; i++){
            listBack.add(list[i]);
        }
        return listBack;
    }
}
