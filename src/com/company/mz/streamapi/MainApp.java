package com.company.mz.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApp {
    static class Person {
        enum Position {
            ENGINEER, DIRECTOR, MANAGER;
        }

        private String name;
        private int age;
        private Position position;

        public Person(String name, int age, Position position) {
            this.name = name;
            this.age = age;
            this.position = position;
        }
    }

    public static void main(String[] args) {


    }

    private static void StreamNotChangeSource() {
        String[] arr = {"ABC", "BCD", "DEFA", "MARI"};

        long count = Arrays.stream(arr)
                .filter(str -> str.length() > 3)
                .count();

        System.out.println(Arrays.toString(arr));

        System.out.println(arr.length);

        List<String> newCollectionString = Arrays.stream(arr)
                .filter(str -> str.length() > 3)
                .collect(Collectors.toList());

        newCollectionString.forEach(System.out::println);
        System.out.println(count);
    }
    public static void endlessStream(){
        Optional<Integer> sum = Stream.iterate(5, x -> x + 5)
                .limit(100)
                .reduce((a, b) -> a + b);
        Integer sum2 = Stream.iterate(5, x -> x + 5)
                .limit(100)
                .map(it ->{
                    System.out.println(it);
                    return it;
                })
                .reduce((a, b) -> a + b).orElse(0);
        System.out.println(sum2);
    }
    private static void generateStreamList() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .forEach(x-> System.out.println(x*x));

        IntStream intStream;
        DoubleStream doubleStream;

        int sum = IntStream.range(0, 100)
                .sum();
        System.out.println(sum);
        sum = IntStream.rangeClosed(0, 100)
                .sum();
        System.out.println(sum);

        List<Person> personList = IntStream.range(0, 101)
                .mapToObj(x -> {
                    String name="";
                    if(x%15 ==0){
                        name = "Vasily";
                    }else{
                        name = "Ivan";
                    }
                    return new Person(name, x, (x%2 ==0) ? Person.Position.DIRECTOR : Person.Position.MANAGER);

                })
                .collect(Collectors.toList());
        System.out.println("123");
    }
    public static void predicateTest(){
        Predicate<Person> personPredicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.age >= 18;
            }
        };
        Person p = new Person("Kate", 19, Person.Position.DIRECTOR);
        p.age = 19;
        System.out.println(personPredicate.test(p));
    }
    public  static void functionTest(){
        Function<String, Integer> strToInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        System.out.println(strToInt.apply("13"));
    }
    public static  void unaryOperatorTest(){
        UnaryOperator<Integer> getCube = (integer) -> integer * integer * integer;
        System.out.println(getCube.apply(13));
    }
    private static void streamSimpleTask() {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Bob1", 35, Person.Position.MANAGER),
                new Person("Bob2", 44, Person.Position.DIRECTOR),
                new Person("Bob3", 25, Person.Position.ENGINEER),
                new Person("Bob4", 42, Person.Position.ENGINEER),
                new Person("Bob5", 55, Person.Position.MANAGER),
                new Person("Bob6", 19, Person.Position.MANAGER),
                new Person("Bob7", 33, Person.Position.ENGINEER),
                new Person("Bob8", 37, Person.Position.MANAGER)
        ));

        List<String> engineersNames = persons.stream()
                .filter(person -> person.position == Person.Position.ENGINEER)
                .sorted((o1, o2) -> o1.age - o2.age)
                .map((Function<Person, String>) person -> person.name)
                .collect(Collectors.toList());
        System.out.println(engineersNames);
        persons.stream()
                .filter(p -> p.age <36)
                .limit(3)
                .map(p -> p.name)
                .forEach(System.out::println);
    }
}
