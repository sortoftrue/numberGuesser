package com.james;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientRepeat implements Runnable {
    
    @Override
    public void run() {
     
        try (Socket socket = new Socket("localhost",12345)) {

            System.out.println("Connected");

            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            DataInputStream is = new DataInputStream(socket.getInputStream());

            boolean isCorr = false;
            int counter = 0;

            while (!isCorr){
                //String guess = new Scanner(System.in).next();
                int guessNo = (int) (Math.random()*100);
                String guess = "" + guessNo;
                os.writeUTF(guess);

                String input = is.readUTF();
                System.out.println(input);

                isCorr = input.contains("correct");
                counter++;
            }
            
            System.out.println("Well done! %d tries.".formatted(counter));


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        


    }

    
}
