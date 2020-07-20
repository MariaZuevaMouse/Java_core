package com.company.mz.jdbcsocket.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Scanner;

public class ClientSide {
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;
    private static String clientSaid = "";

    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1",7779);
            Scanner scanner = new Scanner(System.in)){
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            Thread clientThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true){
                            String serverSaid = inputStream.readUTF();
                            System.out.println(Instant.now().atZone(ZoneId.of("Europe/Moscow")) +" Server said: " +serverSaid);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            clientThread.start();

            while(true){
                clientSaid =scanner.nextLine();
                outputStream.writeUTF( clientSaid);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}

