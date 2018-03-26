package com.company;

import java.util.concurrent.ThreadLocalRandom;

import static com.company.Main.conter;

public class backgroundThread implements Runnable {
    static  private   String balls_array []= {"W","W","W","W","W"};
    static  int conter = 0;
    private static int answer;

    @Override
    public void run() {
        worker();
    }

    private synchronized static  void  worker(){
        while(!returnStatus()){
            conter ++;



            int answer = ThreadLocalRandom.current() .nextInt(5);;
            //print();
            if(balls_array[answer].equals("W")){
                balls_array[answer] = "B";
            }


        }
        System.out.println("Times executed: " + Integer.toString(conter));
        // print();
    }
    private static void  print(){
        for(int i = 0;i<5; i++){
            System.out.print( balls_array[i]);
            System.out.println ();
        }

    }

    private static Boolean returnStatus(){
        StringBuilder status = new StringBuilder();
        for(int i = 0;i<5; i++){
            status.append(balls_array[i]);
        }
        return  status.toString().equals("BBBBB");
    }

}
