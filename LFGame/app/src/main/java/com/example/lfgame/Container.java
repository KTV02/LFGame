package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;

import androidx.core.content.ContextCompat;

public class Container {
    private int left;
    private int top;
    private int right;
    private int bottom;

    Paint color;

    private Context context;

    public Container(Context context,int left, int top, int right, int bottom) {
        this.context = context;
        setPosition(left,top,right,bottom);
        color = new Paint();
        int white = ContextCompat.getColor(context, R.color.white);
        color.setColor(white);

    }

    public void draw(Canvas canvas) {

        canvas.drawRect(left, top, right, bottom, color);
    }

    public void changeColor() {
        int black = ContextCompat.getColor(context, R.color.black);
        color.setColor(black);
    }
    public void click(){
        //open buy menu
    }
    public void setPosition(int left, int top, int right, int bottom){
        this.left=left;
        this.top=top;
        this.right=right;
        this.bottom=bottom;
    }


}
