package com.example.lfgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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
    private Paint hudButtonPaint;
    private Paint hudTextPaint;
    // WE NEED TO SOLVE THE MARGIN SPACE SITUATION WTF

    public Values(){
        createPaint();
        getScreenSize();
    }
    private void getScreenSize(){
        screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
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
       //textPaint.setTextSize(20);

        //Wanted a lighter grey for Hud Buttons
        hudButtonPaint = new Paint();
        hudButtonPaint.setColor(Color.rgb(160,160,160));

        hudTextPaint = new Paint();
        hudTextPaint.setColor(Color.rgb(10, 10, 10));


    }

    public Paint getClosePaint(){
        return closePaint;
    }

    public Paint getPopupPaint(){
        return popupPaint;
    }

    public Paint getHudButtonPaint() {return hudButtonPaint;}

    public Paint getHudTextPaint() {return hudTextPaint;}
    /**
     * Getter for Screenwidth in Pixels
     * REALLY NEEDS TO CALCULATE THIS SHIT EVERY TIME???
     * @return screenwidth
     */
    public int getScreenWidth(){
        return screenWidth;
    }
    /**
     * Getter for Screenheight in Pixels
     * REALLY NEEDS TO CALCULATE THIS SHIT EVERY TIME???
     * @return screenheigth
     */
    public int getScreenHeight(){
        return screenHeight;
    }


    public float[] getPopupExitButtonDimensions() {
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
