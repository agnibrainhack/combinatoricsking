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
    public static int answer = ThreadLocalRandom.current() .nextInt(5);
    static float total_execution_times = 0;
    static  float mean_of_times=0;
    private static float mean;

    public static void main(String[] args) {
	// write your code here

        worker();



    }

    private static  void worker(){
        total_execution_times ++;
        while(!returnStatus()){
            conter ++;



            int answer = ThreadLocalRandom.current() .nextInt(5);
            //print();
            if(balls_array[answer].equals("W")){
                balls_array[answer] = "B";
            }


        }
        System.out.println("Times executed: " + Integer.toString(conter));
       // print();
        mean_of_times += conter;
        mean = mean_of_times/total_execution_times;
        System.out.println("Mean of samples: " + Float.toString(mean));
        conter = 0;
        if(returnStatus()){
            for(int i=0;i<5;i++){
                balls_array[i] = "W";
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            worker();
        }
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
