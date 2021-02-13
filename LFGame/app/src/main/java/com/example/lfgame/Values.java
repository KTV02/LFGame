package com.example.lfgame;

import android.content.res.Resources;
import android.util.Log;

public class Values {
    private static int marginSpace=0;
    private static int screenWidth;
    private static int screenHeight;

    public static int getScreenWidth(){
        screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        return screenWidth;
    }
    public static int getScreenHeight(){
        screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        return screenHeight;
    }
    public static int getMarginSpace(){
        if(marginSpace==0){
            Log.d("Values.java","MARGIN SPACE NOT SET!! THIS IS A PROBLEM");
        }
        return marginSpace;
    }
    public static void setMarginSpace(int marginSpace){

    }


}
