package com.james;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public final class App {
    
    public static void main(String[] args) {
        
        try (ServerSocket ss = new ServerSocket(12345)) {
            
            while(true){
                System.out.println("Waiting for new conn");
                Socket socket = ss.accept();

                Thread thread = new Thread(new Game(socket));

                thread.start();

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
