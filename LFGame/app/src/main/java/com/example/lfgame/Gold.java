package com.example.lfgame;
/**
 * Gold Icon sits with the other Icons in Values
 */

import android.graphics.Bitmap;

public class Gold {
    private static int amount = 1000;


    public static void buy(int cost){
        Gold.amount-= cost;
    }
    public static int getAmount() {
        return amount;
    }
}


