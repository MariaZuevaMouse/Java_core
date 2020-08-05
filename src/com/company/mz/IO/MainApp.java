package com.company.mz.IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    private static class Person{
        private long id;
        private String name;
        private String email;

        public Person(long id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
       // System.out.println(readPersonFromFile("5.txt"));

        Path path = Paths.get("src", "main");
        try {
            Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(path.getFileSystem());

    }
    private static List<Person> readPersonFromFile(String filename){
        List<Person> personList = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new FileReader(filename))){
            String str = in.readLine();
            while((str = in.readLine()) != null){
                String[] tokens = str.split("\\s");
                personList.add(new Person(Long.parseLong(tokens[0]), tokens[1], tokens[2]));

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return personList;
    }
    public static void start(){
        /*
         * InputStream in;
         * OutputStream out;
         * Reader reader;
         * Writer writer;
         * */

        File file = new File("12345.txt");
        File fileDir = new File(".\\src\\main");

        System.out.println(file.isFile());
        System.out.println(fileDir.getAbsolutePath());
    }
    public static void writeToFile(){
        try {
            FileOutputStream out = new FileOutputStream("1.txt", true);
            out.write(" I love Java".getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFromFile(){
        try {
            FileInputStream in = new FileInputStream("2.txt");
            int x = 0;
            while((x = in.read()) != -1){
                System.out.print((char)x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFromFileTryWithResources(){
        try(FileInputStream in = new FileInputStream("2.txt")) {
            int x = 0;
            while((x = in.read()) != -1){
                System.out.print((char)x);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        FileInputStream in = null;
        try {
            in = new FileInputStream("2.txt");
            int x = 0;
            while((x = in.read()) != -1){
                System.out.print((char)x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void writeByOneBytes(){
        long time = System.currentTimeMillis();
        try(FileOutputStream out = new FileOutputStream("3.txt")){
            for(int i =0; i< 5*1024*1024; i++){
                out.write(65);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("time: " +(System.currentTimeMillis()-time));
    }
    public static void writeWithBuffer(){
        long time = System.currentTimeMillis();
        try(OutputStream out = new BufferedOutputStream( new FileOutputStream("3.txt"))){
            for(int i =0; i< 5*1024*1024; i++){
                out.write(65);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("time: " +(System.currentTimeMillis()-time));
    }
    public static void readWithSplit(){
        try(BufferedReader in = new BufferedReader(new FileReader("4.txt"))){
            String str = null;
            while ((str = in.readLine())!= null){
                String[] tokens = str.split("\\s");
                System.out.println(tokens[0]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
