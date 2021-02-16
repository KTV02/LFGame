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
public class Button extends View implements Clickable {
    private String text;
    private float left;
    private float right;
    private float top;
    private float bottom;
    private Values values;
    Paint backgroundColor;
    Paint textColor;

    public Button(Context context,float left,float right, float top,float bottom, Paint backgroundColor, Paint textColor){
        super(context);
        this.backgroundColor=backgroundColor;
        this.textColor= textColor;

        setPosition(left,right,top,bottom);
    }
    public Button(Context context,float left,float right, float top,float bottom){
        super(context);
        this.values=((MainActivity) context).getValues();
        this.backgroundColor=values.getComponentPaint();
        this.textColor= values.getTextPaint();
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


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawRect(left, top, right, bottom, backgroundColor);
        //fits the Text from left to right into the button
        canvas.drawText(text,left,top+textColor.getTextSize(),textColor);



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
    public void setText(String text ) {
        this.text = text;
        setTextSizeForWidth(textColor,right-left,text);

    }
    private void setTextSizeForWidth(Paint paint, float desiredWidth,
                                     String text) {

        // Pick a reasonably large value for the test. Larger values produce
        // more accurate results, but may cause problems with hardware
        // acceleration. But there are workarounds for that, too; refer to
        // http://stackoverflow.com/questions/6253528/font-size-too-large-to-fit-in-cache
        final float testTextSize = 48f;

        // Get the bounds of the text, using our testTextSize.
        paint.setTextSize(testTextSize);
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);

        // Calculate the desired size as a proportion of our testTextSize.
        float desiredTextSize = testTextSize * desiredWidth / bounds.width();

        // Set the paint for that size.
        paint.setTextSize(desiredTextSize);
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
