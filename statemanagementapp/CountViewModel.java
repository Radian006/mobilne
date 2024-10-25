package com.example.statemanagementapp;

import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel{
    private static int count=0;

    public static int getCount(){
        return count;
    }
    public static void incrementCount(){
        count++;
    }
}
