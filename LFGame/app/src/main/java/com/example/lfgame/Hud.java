package com.example.lfgame;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;


import androidx.core.content.ContextCompat;

import java.util.LinkedList;


public class Hud extends Views{

    Paint color;
    Context context;
    private static int height=2*BaseView.getMarginSpace(); //the height of the HUD interface is 2* the margin between containers;

    public Hud(Context context) {
        color = new Paint();
        this.context = context;
    }
    //Sets color for the top bar
    //please use niceGrey for further HUD/Menu elements which are grey
    public void topBar(Canvas canvas){
        int niceGrey = Color.rgb(115,115,115);
        int left = getWidthPixels();
        color.setColor(niceGrey);
        canvas.drawRect(left, 0, 0, height, color);
    }
    //Draws sections in the topBar
    //At the moment thought to be used for tabs: troops, gold, diamonds
    public void topSections(Canvas canvas){
        float fullSectionSpace = getWidthPixels()/2;
        float oneSection = fullSectionSpace/3;
        float[] base = {getWidthPixels()-(oneSection-oneSection*0.02f), 0,getWidthPixels()-oneSection, height};
        Paint color=new Paint();
        color.setColor(ContextCompat.getColor(context,R.color.white));
        for(int i = 0; i<3; i++) {
            for (int j = 0; j < 4; j++) {
                canvas.drawRect(base[0], base[1], base[2], base[3], color);
            }
            base[0] = getWidthPixels()-((i+2)*oneSection-oneSection*0.02f);
            base[2] = getWidthPixels()-((i+2)*oneSection);
        }
    }
    @Override
    //Draws elements of HUD
    public void draw(Canvas canvas) {
        topBar(canvas);
        topSections(canvas);
    }
    public static int getHeight(){
        return height;
    }

    @Override
    public void update() {

    }


    @Override
    public boolean checkAllElements(MotionEvent event, Game game) {
        return false;
    }
}
