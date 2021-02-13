package com.example.lfgame;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;


public class HUD extends Views{

    Paint color;

    public HUD(Context context) {
        color = new Paint();
        topBar();
    }

    public void topBar(){
        int niceGrey = Color.rgb(115,115,115);
        color.setColor(niceGrey);
    }
    @Override
    public void draw(Canvas canvas) {
        //canvas.drawRect(0, 0, getWidthPixels(), 2*BaseView.getMarginSpace(), color);
        //canvas.drawRect(left, top, right, bottom, color);
    }

    @Override
    public void update() {

    }

    @Override
    public void touched(MotionEvent event, Game g) {

    }
}
