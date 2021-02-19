package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

/**
 * This Class creates a rectangular Button filled with colors
 */
public class RectangleButton extends Button{
    private float left;
    private float right;
    private float top;
    private float bottom;




    /**
     * Use This Constructor if creating a Button with specific Background Color and text Color
     * LEFT, RIGHT, TOP, BOTTOM
     * @param context
     * @param left
     * @param right
     * @param top
     * @param bottom
     * @param backgroundColor
     * @param textColor
     */
    public RectangleButton(Context context, float left, float right, float top, float bottom, Paint backgroundColor, Paint textColor){
        super(context,backgroundColor,textColor);
        setPosition(left,right,top,bottom);

        textX=left;
    }

    @Override
    void center(Rect bounds,Paint textPaint) {
        //the space of the button that is not covered by the texts width
        int margins=getButtonWidth()-bounds.width();
        int textHeight=bounds.height();
        //adds decender and acender idk wtf
        //textHeight -= textPaint.ascent();
        //textHeight += textPaint.descent();
        //height space not covered by text
        int topMargins=getButtonHeight()-textHeight;
        textX=left+(margins/2);
        textY=top+(topMargins/2)+textHeight;
    }

    /**
     * Constructor for Button with standard values
     * @param context
     * @param left
     * @param right
     * @param top
     * @param bottom
     */
    public RectangleButton(Context context,float left,float right, float top,float bottom){
        super(context);
        setPosition(left,right,top,bottom);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawRect(left, top, right, bottom, backgroundColor);
        //fits the Text from left to right into the button if there is a text
        if(text!=null) {
            textColor.setTextSize(size);
            //textY= top + textColor.getTextSize();
            canvas.drawText(text, textX, textY, textColor);
            System.out.println(""+textColor.getTextSize());
        }
    }

   




    public void setPosition(float left, float right, float top, float bottom){
        this.left=left;
        this.right=right;
        this.bottom=bottom;
        this.top=top;
    }


    @Override
    public boolean isHere(float x, float y) {
        if(x>left&&x<right){
            if(y>top&&y<bottom){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getButtonWidth() {
        return (int) (right-left);
    }

    @Override
    public int getButtonHeight() {
        return (int) (bottom-top);
    }
}
