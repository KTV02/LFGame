package com.example.lfgame;

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
    Button cancel;
    int color;
    public ClosePopUp(Context context){
        super(context);
        exit= new Button(context,Values.getScreenWidth()/4,Values.getScreenWidth()/2,Values.getScreenHeight()/3,Values.getScreenHeight()/2);
        //cancel= new Button(context);
        exit.setText("Exit");
        //cancel.setText("Back to Game");
        color= ContextCompat.getColor(context,R.color.magenta);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        Paint text=new Paint();
        text.setTextSize(50);
        text.setColor(color);
        exit.draw(canvas,text);
        //cancel.draw(canvas,text);
        canvas.drawText("Do you want to exit? ",(float) Values.getScreenWidth()/2,(float) Values.getScreenHeight()/5,text);

    }

    @Override
    public boolean touched(float x, float y) {
        {
            if(exit.touched(x,y)){
                return true;
            }else if(cancel.touched(x,y)){
                return true;
            }else{
                return false;
            }
        }
    }
}
