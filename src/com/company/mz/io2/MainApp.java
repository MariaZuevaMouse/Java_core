package com.company.mz.io2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.setHeader(new String[]{"value1", "value2", "value3"});
        appData.setData(new int[][]{{100, 200,300},{400,500,600},{700,800,900},{1000,1100,1200}});

        String file = writeFile(appData);
        readFile(file);

    }
    private static String writeFile(AppData data){
        List<AppData> appDataList = new ArrayList<>();
        String file = "appData.csv";
        try(BufferedWriter out = new BufferedWriter(new FileWriter(new File(file)))){
            for(int i = 0; i <data.getHeader().length; i++){
                out.write(data.getHeader()[i]);
                out.write(";");
            }
            out.newLine();
            for(int i = 0; i<data.getData().length; i++){
                for(int j = 0; j<data.getData()[i].length; j++){
                    out.write(Integer.toString(data.getData()[i][j]));
                    out.write(";");
                }
                out.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return file;
    }
    private static void readFile(String filename){
        try(BufferedReader in = new BufferedReader(new FileReader(filename))){
            String str = in.readLine();
            String[] tokens = str.split(";");
            for(int i = 0; i<tokens.length; i++){
                System.out.print(tokens[i]);
                System.out.print(";");
            }
            System.out.println();
            while((str = in.readLine())!=null){
                tokens = str.split(";");
                for(int i = 0; i< tokens.length; i++){
                    System.out.print(tokens[i]);
                    System.out.print(";");
                }
                System.out.println();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
