package com.example.lfgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import androidx.core.content.ContextCompat;

/**
 * This class handles Data thats needed Globally STAY STATIC
 */
public class Values {
    private int screenWidth;
    private int screenHeight;
    private Paint popupPaint;
    private Paint closePaint;
    private Paint componentPaint;
    private Paint textPaint;
    // WE NEED TO SOLVE THE MARGIN SPACE SITUATION WTF

    public Values(){
        createPaint();

    }

    /**
     * Defines backgroundcolor of all Popups
     */
    private void createPaint(){
        popupPaint = new Paint();
        int niceGrey = Color.rgb(115,115,115);
        popupPaint.setColor(niceGrey);

        closePaint = new Paint();
        closePaint.setColor(Color.rgb(255,0,0));

        componentPaint = new Paint();
        componentPaint.setColor(Color.rgb(0,255,0));

        textPaint= new Paint();
        textPaint.setColor(Color.rgb(0,0,255));

    }

    public Paint getClosePaint(){
        return closePaint;
    }

    public Paint getPopupPaint(){
        return popupPaint;
    }
    /**
     * Getter for Screenwidth in Pixels
     * REALLY NEEDS TO CALCULATE THIS SHIT EVERY TIME???
     * @return screenwidth
     */
    public int getScreenWidth(){
        screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        return screenWidth;
    }
    /**
     * Getter for Screenheight in Pixels
     * REALLY NEEDS TO CALCULATE THIS SHIT EVERY TIME???
     * @return screenheigth
     */
    public int getScreenHeight(){
        screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        return screenHeight;
    }


    public static float[] getPopupExitButtonDimensions() {
        float[] dimensions={1800,2020,200,300};
        return dimensions;
    }

    public Paint getComponentPaint() {
        return componentPaint;
    }

    public Paint getTextPaint() {
        return textPaint;
    }
}
