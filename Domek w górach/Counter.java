package com.example.domek_w_gorach;


public class Counter{
    private static int count=0;

    public static int getCount(){
        return count;
    }
    public static void incrementCount(){
        count++;
    }
}