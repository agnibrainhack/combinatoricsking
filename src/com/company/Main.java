package com.company;

import java.util.Random;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    static  private   String balls_array []= {"W","W","W","W","W"};
    static  int conter = 0;
    private static int answer;
    ;
    public static void main(String[] args) {
	// write your code here


      /*  final long timeInterval = 1000;
        Runnable runnable = new Runnable() {

            public void run() {
                while (true) {
                    // ------- code for task to run
                    worker();
                    // ------- ends here
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    */

      for (int i=0;i<100;i++) {
               Random rn = new Random();
               answer = rn.nextInt(5);
              //System.out.println("Times executed: " + Integer.toString(answer));

          worker();
      }

    }
    private static  void worker(){
        while(!returnStatus()){
            conter ++;



            //int answer = ThreadLocalRandom.current() .nextInt(5);
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
