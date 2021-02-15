package com.example.lfgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.Log;

import androidx.core.content.ContextCompat;

/**
 * This class handles Data thats needed Globally STAY STATIC
 */
public class Values {
    private static int screenWidth;
    private static int screenHeight;
    Paint paint = new Paint();
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


    public static float[] getPopupExitButtonDimensions() {
        float[] dimensions={1800,2020,200,300};
        return dimensions;
    }

}
