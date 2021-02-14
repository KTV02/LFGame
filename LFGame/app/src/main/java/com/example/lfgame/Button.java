package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

/**
 * Works as a simple UI Button
 * More Design customization needed
 */
public class Button implements Clickable {
    private String text;
    private float left;
    private float right;
    private float top;
    private float bottom;
    private Context context;

    public Button(Context context,float left,float right, float top,float bottom){
        this.context=context;
        setPosition(left,right,top,bottom);
    }

    //Needs to be pulled up in abstraction!! Duplicate Code!!
    @Override
    public boolean touched(float x, float y) {
        if (x > right || x < left) {
            return false;
        } else if (y > bottom || y < top) {
            return false;
        } else {
            return true;
        }
    }

    public void draw(Canvas canvas, Paint paint) {
        canvas.drawRect(left, top, right, bottom, paint);;
        paint.setColor(ContextCompat.getColor(context,R.color.black));
        canvas.drawText(text,left+((right-left)/3),top+(bottom-top)/3,paint);

    }

    /**
     * Set Position of Button on Screen
     *
     * @param left   left Border in Pixels
     * @param right  right Border in Pixels
     * @param top    top Border in Pixels
     * @param bottom bottom Border in Pixels
     */
    public void setPosition(float left, float right, float top, float bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    /**
     * Set Text that Button displays
     *
     * @param text The text to be displayed
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get Text that is displayed by Button
     *
     * @return displayed text
     */
    public String getText() {
        return text;
    }
}
