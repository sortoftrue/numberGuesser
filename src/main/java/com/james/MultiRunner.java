package com.james;

public class MultiRunner {
    
    public static void main(String[] args) {
        
        for(int i=0;i<20;i++){

            Thread thread = new Thread(new ClientRepeat());
            thread.start();

        }

    }
    




}
