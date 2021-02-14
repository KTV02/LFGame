package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Button;

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
        exit= new Button(context);
        cancel= new Button(context);
        exit.setText("yeet");
        color= ContextCompat.getColor(context,R.color.magenta);
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        exit.draw(canvas);
        Paint text=new Paint();
        text.setTextSize(50);
        text.setColor(color);
        canvas.drawText("Do you want to exit? ",(float) Values.getScreenWidth()/2,(float) Values.getScreenHeight()/5,text);

    }
}
