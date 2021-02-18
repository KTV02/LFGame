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

    private Paint color;
    private Context context;
    private Values values;
    private int height;
    private RectangleButton underAmount;
    private Container goldIcon;


    public Hud(Context context) {
        values=((MainActivity)context).getValues();
        height=values.getGuiSpace(); //the height of the HUD interface is 2* the margin between containers;


        color = new Paint();
        this.context = context;
        setGold(context, topSectionsFiller(), values);
    }
    //Sets color for the top bar
    //please use niceGrey for further HUD/Menu elements which are grey
    public void topBar(Canvas canvas){
        int niceGrey = Color.rgb(115,115,115);
        int left = values.getScreenWidth();
        color.setColor(niceGrey);
        canvas.drawRect(left, 0, 0, height, color);
    }
    public float[] topSectionsFiller(){
        int screenWidth=values.getScreenWidth();
        float fullSectionSpace = screenWidth/2;
        float oneSection = fullSectionSpace/3;
        float[] base = {screenWidth-(oneSection-oneSection*0.02f), 0,screenWidth-oneSection, height, oneSection};
        return base;
    }
    //Draws sections in the topBar
    //At the moment thought to be used for tabs: troops, gold, diamonds
    public void topSections(Canvas canvas, float base[]){
        int screenWidth=values.getScreenWidth();
        Paint color=new Paint();
        color.setColor(ContextCompat.getColor(context,R.color.white));
        for(int i = 0; i<3; i++) {
            for (int j = 0; j < 4; j++) {
                canvas.drawRect(base[0], base[1], base[2], base[3], color);
            }
            base[0] = screenWidth-((i+2)*base[4]-base[4]*0.02f);
            base[2] = screenWidth-((i+2)*base[4]);
        }
    }
    @Override
    //Draws elements of HUD
    public void draw(Canvas canvas) {
        topBar(canvas);
        topSections(canvas, topSectionsFiller());
        drawGold(canvas);
    }

    /**
     * Draw Rectangle that displays Gold
     * @param canvas the canvas to draw on
     */
    private void drawGold(Canvas canvas){
        underAmount.draw(canvas);
    }
    private void setGold(Context c, float base[], Values v){
        context = c;
        //for base[] values look in Hud class in topSectionsFiller()
        underAmount = new RectangleButton(context,base[2]-base[4]*0.65f, base[2],0, base[3], v.getHudButtonPaint(), v.getTextPaint());
        //float width = base[4]*0.65f;
        underAmount.setText(Integer.toString(Gold.getAmount()));
        //new Container for goldIcon
        goldIcon = new Container(context, (int) (base[0]-base[4]),(int) (base[2]-base[4]*0.65f),0,(int) base[3], values.getGoldIcon(context));
    }



    public int getHeight(){
        return height;
    }

    @Override
    public void update() {

    }


    @Override
    public boolean checkAllElements(MotionEvent event, Game game) {
        if(underAmount.isHere(event.getX(), event.getY())) {
            CollectablePopup popup= new CollectablePopup(context);
            game.spawnPopup(popup);
            return true;
        }
        else
            return false;
    }
}
