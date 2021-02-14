package com.example.lfgame;

import android.content.res.Resources;
import android.util.Log;

/**
 * This class handles Data thats needed Globally STAY STATIC
 */
public class Values {
    private static int screenWidth;
    private static int screenHeight;
    // WE NEED TO SOLVE THE MARGIN SPACE SITUATION WTF

    /**
     * Getter for Screenwidth in Pixels
     * REALLY NEADS TO CALCULATE THIS SHIT EVERY TIME???
     * @return screenwidth
     */
    public static int getScreenWidth(){
        screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        return screenWidth;
    }
    /**
     * Getter for Screenheight in Pixels
     * REALLY NEADS TO CALCULATE THIS SHIT EVERY TIME???
     * @return screenheigth
     */
    public static int getScreenHeight(){
        screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        return screenHeight;
    }




}
