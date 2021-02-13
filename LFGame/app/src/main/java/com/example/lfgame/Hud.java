package com.example.lfgame;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;


public class Hud extends Views{

    Paint color;
    private static int height=2*BaseView.getMarginSpace(); //the height of the HUD interface is 2* the margin between containers;

    public Hud(Context context) {
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
    //weil du larry des falsch implementiert hattest aber ich cooler typ habs natürlich gefixt LG KTV
    public void draw(Canvas canvas) {
        int left = getWidthPixels();
        canvas.drawRect(left, 0, 0, height, color);
    }
    public static int getHeight(){
        return height;
    }

    @Override
    public void update() {

    }

    @Override
    public void touched(MotionEvent event, Game g) {

    }
}
