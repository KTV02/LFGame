package com.example.lfgame;
/**
 * Gold Icon sits with the other Icons in Values
 */

import android.graphics.Bitmap;

public class Gold {
    //amount is at the moment set in MainActivity, because of experiments with saving the Game state
    //33 is just for testing, to see when something went wrong
    private static int amount = 33;


    public static void buy(int cost){
        Gold.amount-= cost;
    }
    public static int getAmount() {
        return amount;
    }
    public static void setAmount(int i){
        amount = i;
    }
}


