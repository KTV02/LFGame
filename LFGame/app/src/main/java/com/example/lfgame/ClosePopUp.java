package com.example.lfgame;

import android.app.Application;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

/**
 * Popup triggered by back button
 * asks user if he is trying to exit game
 * UNDER CONSTRUCTION
 */
public class ClosePopUp extends PopUp {
    Button exit;
    int color;
    MainActivity activity;
    public ClosePopUp(Context context,MainActivity activity){
        super(context);
        exit= new Button(context,Values.getScreenWidth()/4,Values.getScreenWidth()/2,Values.getScreenHeight()/3,Values.getScreenHeight()/2);
        exit.setText("Exit Game");
        color= ContextCompat.getColor(context,R.color.magenta);
        this.activity=activity;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        Paint text=new Paint();
        text.setTextSize(50);
        text.setColor(color);
        exit.draw(canvas,text);

    }

    @Override
    public boolean touched(float x, float y) {
        {
            //exit game if exit button pressed
            if(exit.touched(x,y)){
                activity.onPause();
                System.exit(1);
                return true;
            }else{
                return false;
            }
        }
    }
}
