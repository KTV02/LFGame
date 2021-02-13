package com.example.lfgame;

import android.content.res.Resources;
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
    //Sets color for the top bar
    public void topBar(){
        int niceGrey = Color.rgb(115,115,115);
        color.setColor(niceGrey);
    }
    @Override
    //Draws elements of HUD
    //Why the fuck is left and right in drawRect opposite
    //and why doesn't the normal widthPixels() out of View not work, not cool
    public void draw(Canvas canvas) {
        int left = Resources.getSystem().getDisplayMetrics().widthPixels;
        canvas.drawRect(left, 0, 0, 2*BaseView.getMarginSpace(), color);
    }

    @Override
    public void update() {

    }

    @Override
    public void touched(MotionEvent event, Game g) {

    }
}
