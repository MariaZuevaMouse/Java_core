package com.company.mz.jdbcsocket.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.time.ZoneId;

public class ServerApp {
    public static void main(String[] args) {
        while (true){
            try(ServerSocket serverSocket = new ServerSocket(7777)){
                Socket client = serverSocket.accept();
                System.out.println("Client connected.");
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                while(true){
                    String clientResponse = in.readUTF();
                    System.out.println("Client response: " + clientResponse);
                    out.writeUTF(clientResponse + " "+ Instant.now().atZone(ZoneId.of("Europe/Moscow")));
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
