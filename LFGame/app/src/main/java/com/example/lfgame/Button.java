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
    public Paint getPaint(String text,int width, int height){
        this.text = text;
        setTextSizeForWidth(textColor,width,text, height);
        return textColor;

    }
    public void setText(String text){
        this.text=text;
        setTextSizeForWidth(textColor,getButtonWidth(),text, getButtonHeight());
        Log.d("Button.java","textSize: "+textColor.getTextSize()+" buttonWidth: "+getButtonWidth());
    }

    /**
     * Retrieve the maximum text size to fit in a given width.
     * And height as well actually
     * Height adjustments can be tricky, because in contrast to width, there
     * is a space between the top of the rectangle and the text set in Paint.
     * That space increases proportional to to Font size, which is annoying.
     * @param paint (Paint): an object of Paint
     * @param str (String): Text to check for size.
     * @param maxWidth (float): Maximum allowed width.
     * @param maxHeight (float): Maximum allowed height.
     * @return (int): The desired text size.
     * @author Frederik Spieß
     * @since 17/02
     */
    private int setTextSizeForWidth(Paint paint, float maxWidth, String str, float maxHeight)
    {
        int size = 0;
        Rect bounds = new Rect();
        do {
            paint.setTextSize(++ size);
            paint.getTextBounds(str, 0, str.length(), bounds);
        } while(bounds.width() < maxWidth*0.9f && bounds.height() < (maxHeight/2));
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
    public abstract int getButtonHeight();
}
