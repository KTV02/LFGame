package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * This class creates a round button filled with color
 */
public class CircularButton extends Button {

    private float xCenter;
    private float yCenter;
    private float radius;

    /**
     * Use This Constructor if creating a Button with specific Background Color and text Color
     *
     * @param context
     * @param backgroundColor
     * @param textColor
     */
    public CircularButton(Context context,float xCenter,float yCenter,float radius, Paint backgroundColor, Paint textColor) {
        super(context, backgroundColor, textColor);
        setPosition(xCenter,yCenter,radius);
    }

    /**
     * Constructor for Button with standard values
     *
     * @param context
     */
    public CircularButton(Context context,float xCenter,float yCenter,float radius) {
        super(context);
        setPosition(xCenter,yCenter,radius);
    }

    private void setPosition(float xCenter, float yCenter, float radius) {
        this.xCenter=xCenter;
        this.yCenter=yCenter;
        this.radius=radius;

    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawCircle(xCenter,yCenter,radius,backgroundColor);
        //Text fitting for Circular buttons is not yet working!
        //canvas.drawText(text,xCenter-radius,(yCenter-radius)+textColor.getTextSize(),getPaint(text,getWidth(), getWidth()));

    }


    /**
     * Childreen Overwrite this Method and center Text in the middle of specific Button
     *
     * @param bounds
     */
    @Override
    void center(Rect bounds,Paint paint) {

    }

    @Override
    public boolean isHere(float x, float y) {
        if(x>(xCenter-radius)&&x<(xCenter+radius)){
            if(y>(yCenter-radius)&&y<(yCenter+radius)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getButtonWidth() {
        return (int)((xCenter+radius)-(xCenter-radius));
    }

    @Override
    public int getButtonHeight() {
        return getButtonWidth();
    }
}
