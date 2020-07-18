package com.company.mz.jdbcsocket.sockets;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.nio.charset.StandardCharsets.UTF_8;

public class URLApp {
    public static void main(String[] args) throws IOException {
        URL targetURL = new URL("https://belkasoft.com"); //https://html5css.ru  https://www.payoneer.com
        HttpURLConnection urlConnection =(HttpURLConnection)targetURL.openConnection();
        urlConnection.setConnectTimeout(300);
        urlConnection.connect();

        System.out.println(urlConnection.getResponseCode() + " " + urlConnection.getResponseMessage());
        System.out.println(urlConnection.getHeaderFields());

        urlConnection.getInputStream();
    }

    public static void openStreamToServer() throws IOException{
        URL targetURL = new URL("https://belkasoft.com"); //https://html5css.ru  https://www.payoneer.com
        Writer writer = new FileWriter("belka.html");
        InputStream inputStream = targetURL.openStream();
        new BufferedReader(new InputStreamReader(inputStream, UTF_8))
                .lines()
                .forEach(str -> {
                    try {
                        writer.write(str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
    public static void openConnectionToServer() throws IOException{
        URL targetURL = new URL("https://belkasoft.com"); //https://html5css.ru  https://www.payoneer.com
        HttpURLConnection urlConnection =(HttpURLConnection)targetURL.openConnection();
        urlConnection.setConnectTimeout(300);
        urlConnection.connect();

        System.out.println(urlConnection.getResponseCode() + " " + urlConnection.getResponseMessage());
        System.out.println(urlConnection.getHeaderFields());

        urlConnection.getInputStream();
    }
}
