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
import android.view.WindowInsetsAnimation;

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
    protected int size;

    float textX;
    float textY;

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
    public void setBackgroundColor(Paint backgroundColor){
        this.backgroundColor=backgroundColor;
    }


    /**
     * Set Text that Button displays
     * Protected because only accessible by childreen
     * ALL CHILDREEN OVERLOAD THIS METHOD
     * width is calculated in subclass an passed up by super()
     *
     * @param text The text to be displayed
     */
    public void setText(String text){
        this.text=text;
        this.textColor=setTextSizeForWidth(getButtonWidth(),text, getButtonHeight());
        //Log.d("Button.java","textSize: "+textColor.getTextSize()+" buttonWidth: "+getButtonWidth());
    }

    /**
     * Retrieve the maximum text size to fit in a given width.
     * And height as well actually
     * Height adjustments can be tricky, because in contrast to width, there
     * is a space between the top of the rectangle and the text set in Paint.
     * That space increases proportional to to Font size, which is annoying.
     * @param str (String): Text to check for size.
     * @param maxWidth (float): Maximum allowed width.
     * @param maxHeight (float): Maximum allowed height.
     * @author Frederik Spieß
     * @since 17/02
     */
    private Paint setTextSizeForWidth(float maxWidth, String str, float maxHeight)
    {
        Paint textSize = new Paint();
        int size = 0;
        Rect bounds = new Rect();
        do {
            textSize.setTextSize(++ size);
            textSize.getTextBounds(str, 0, str.length(), bounds);
        } while(bounds.width() < maxWidth*0.9f && bounds.height() < (maxHeight/1.7f));
            //center the text in the middle of the specific button or child class
        center(bounds,textSize);
        this.size = size;
        return textSize;
    } //End getMaxTextSize()

    /**
     * Childreen Overwrite this Method and center Text in the middle of specific Button
     */
    abstract void center(Rect bounds,Paint textPaint);

    /**
     * Get Text that is displayed by Button
     *
     * @return displayed text
     */
    public String getText() {
        return text;
    }

    /**
     * Returns if Button Object is on given Coordinates
     * @param x x coordinate of Touch event
     * @param y y coordinate of Touch event
     * @return boolean if Button Object is at Coordinates of Touch Event
     */
    public abstract boolean isHere(float x, float y);

    /**
     * Returns Width of the Button Object
     * @return width in pixels
     */
    public abstract int getButtonWidth();

    /**
     * Returns Height of the Button Object
     * @return height in pixels
     */
    public abstract int getButtonHeight();
}
