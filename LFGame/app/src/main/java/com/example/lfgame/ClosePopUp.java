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
    public ClosePopUp(Context context){
        super(context);
        exit= new Button(context,values.getScreenWidth()/4,values.getScreenWidth()/2,values.getScreenHeight()/3,values.getScreenHeight()/2);
        exit.setText("Exit Game");
        this.activity=(MainActivity) context;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        exit.draw(canvas);

    }

    @Override
    public boolean touched(float x, float y) {
        {
            //exit game if exit button pressed
            if(exit.touched(x,y)){
                activity.onPause();
                activity.minimize();
                //System.exit(1);
                return true;
            }else{
                return false;
            }
        }
    }
}
