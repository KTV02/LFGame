package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/**
 * Works as a simple UI Button
 * More Design customization needed
 */
public abstract class Button extends View{
    protected String text;
    protected Values values;
    protected Paint backgroundColor;
    protected Paint textColor;

    /**
     * Use This Constructor if creating a Button with specific Background Color and text Color
     */
    public Button(Context context, Paint backgroundColor, Paint textColor){
        super(context);
        this.values=((MainActivity) context).getValues();
        this.backgroundColor=backgroundColor;
        this.textColor= textColor;
    }

    /**
     * Constructor for Button with standard values
     */
    public Button(Context context){
        super(context);
        this.values=((MainActivity) context).getValues();
        this.backgroundColor=values.getComponentPaint();
        this.textColor= values.getTextPaint();

    }


    /**
     * Set Text that Button displays
     * Protected because only accessible by childreen
     * ALL CHILDREEN OVERLOAD THIS METHOD
     * width is calculated in subclass an passed up by super()
     *
     * @param text The text to be displayed
     */
    public Paint getPaint(String text,int width){
        this.text = text;
        setTextSizeForWidth(textColor,width,text);
        return textColor;

    }
    public void setText(String text){
        this.text=text;
        setTextSizeForWidth(textColor,getButtonWidth(),text);
        Log.d("Button.java","textSize: "+textColor.getTextSize()+" buttonWidth: "+getButtonWidth());
    }
//    private void setTextSizeForWidth(Paint paint, float desiredWidth, String text) {
//
//        // Pick a reasonably large value for the test. Larger values produce
//        // more accurate results, but may cause problems with hardware
//        // acceleration. But there are workarounds for that, too; refer to
//        // http://stackoverflow.com/questions/6253528/font-size-too-large-to-fit-in-cache
//        final float testTextSize = 48f;
//
//        // Get the bounds of the text, using our testTextSize.
//        paint.setTextSize(testTextSize);
//        Rect bounds = new Rect();
//        paint.getTextBounds(text, 0, text.length(), bounds);
//
//        // Calculate the desired size as a proportion of our testTextSize.
//        float desiredTextSize = testTextSize * desiredWidth / bounds.width();
//
//        // Set the paint for that size.
//        paint.setTextSize(desiredTextSize);
//    }
    /**
     * Retrieve the maximum text size to fit in a given width.
     * @param str (String): Text to check for size.
     * @param maxWidth (float): Maximum allowed width.
     * @return (int): The desired text size.
     */
    private int setTextSizeForWidth(Paint paint, float maxWidth, String str)
    {
        int size = 0;
        Rect bounds = new Rect();
        do {
            paint.setTextSize(++ size);
            paint.getTextBounds(str, 0, str.length(), bounds);
        } while(bounds.width() < maxWidth*0.9f && bounds.height() < BaseView.getMarginSpace());
        //System.out.println(bounds.height()+""+bounds.width());
        return size;
    } //End getMaxTextSize()

    /**
     * Get Text that is displayed by Button
     *
     * @return displayed text
     */
    public String getText() {
        return text;
    }

    /**
     * Returns if Button is on given Coordinates
     * @param x
     * @param y
     * @return
     */
    public abstract boolean isHere(float x, float y);
    public abstract int getButtonWidth();
}
