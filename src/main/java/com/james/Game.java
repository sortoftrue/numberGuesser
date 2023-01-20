package com.james;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Game implements Runnable {
    
    Socket socket;

    Game(Socket socket){
        this.socket=socket;
    }


    @Override
    public void run(){

        Integer answer = (int) (Math.random()*100);
        System.out.println(answer);

        String choice = "";
        Boolean isCorr = false;

        try (DataInputStream is = new DataInputStream(socket.getInputStream())) {
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());


            while(!choice.equals("exit") && !isCorr){
                choice = is.readUTF();
                int guess;

                switch(choice){
                    case "exit":{
                        break;
                    }
                    default:{
                        try{
                            guess = Integer.parseInt(choice);
                            if(guess == answer){
                                os.writeUTF("%d is correct!".formatted(guess));
                                isCorr = true;
                            } else if(guess > answer){
                                os.writeUTF("%d is too high!".formatted(guess));
                            } else {
                                os.writeUTF("%d is too low!".formatted(guess));
                            }

                        } catch(NumberFormatException e){
                            os.writeUTF("Invalid entry!");
                        }

                        break;
                    }
                }


            }
            

            



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        

    }

}
