package com.company.mz.jdbcsocket.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Scanner;

import static com.company.mz.jdbcsocket.chat.DataBase.*;

public class ServerSide {
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;
    private static String clientSaid = "";

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(7779);
            Scanner scanner = new Scanner(System.in)){
            System.out.println("waiting for connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            connectDb();
            createTable();

            inputStream = new DataInputStream(clientSocket.getInputStream());
            outputStream = new DataOutputStream(clientSocket.getOutputStream());

            Thread serverThread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        String serverSaid = scanner.nextLine();
                        try {
                            outputStream.writeUTF(serverSaid);
                            addRecordToDb(serverSaid, true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            serverThread2.start();

            while(true){
                clientSaid = inputStream.readUTF();
                System.out.println(Instant.now().atZone(ZoneId.of("Europe/Moscow")) +" Client said: " + clientSaid);
                addRecordToDb(clientSaid, false);
            }
        }catch (IOException  ex){
            ex.printStackTrace();
        }
    }
}
