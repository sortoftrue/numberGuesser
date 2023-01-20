package com.james;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    
    public static void main(String[] args) {
     
        try (Socket socket = new Socket("localhost",12345)) {

            System.out.println("Connected");

            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            DataInputStream is = new DataInputStream(socket.getInputStream());

            boolean isCorr = false;

            while (!isCorr){
                String guess = new Scanner(System.in).next();
                os.writeUTF(guess);

                String input = is.readUTF();
                System.out.println(input);

                isCorr = input.contains("correct");
            }
            
            System.out.println("Well done!");


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        


    }

    
}
