package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import androidx.core.content.ContextCompat;

public class PopUpView extends Views {
    Context context;
    PopUp popup;
    public PopUpView(PopUp popup,Context context){
        this.popup=popup;
        this.context=context;
    }
    @Override
    public void draw(Canvas canvas) {
        //draw standard Popup background e.g. grey rectangle
        Paint color = new Paint();
        int white = ContextCompat.getColor(context, R.color.magenta);
        color.setColor(white);
        canvas.drawRect(100,200,1500,1000,color);
        popup.draw();
    }

    @Override
    public void update() {

    }

    @Override
    public void touched(MotionEvent event, Game g) {

    }
}
