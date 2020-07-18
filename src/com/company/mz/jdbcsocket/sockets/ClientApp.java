package com.company.mz.jdbcsocket.sockets;

import java.awt.image.DataBufferInt;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket("127.0.0.1", 7777)) {
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            while(true){
                outputStream.writeUTF(scanner.nextLine());
                System.out.println(inputStream.readUTF());
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
