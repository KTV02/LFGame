package com.example.lfgame;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;

/**
 * View that displays specific Popup passed in Constructor
 */
public class PopUpView extends Views {
    Context context;
    PopUp popup;
    Views backgroundview;
    public PopUpView(Views backgroundview, PopUp popup, Context context){
        //save last View
        this.backgroundview= backgroundview;
        this.popup=popup;
        this.context=context;
        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.popupbackground);
    }
    @Override
    public void draw(Canvas canvas) {
        //draw the last View in the Background
        backgroundview.draw(canvas);
        //set Color and Size Variables for the background of a popup
        Paint popupBackground=new Paint();
        int backgroundColor= ContextCompat.getColor(context,R.color.poupbackground);
        popupBackground.setColor(backgroundColor);
        int horizontalMargin=getWidthPixels()/10;
        //draw standard Popup background as rectangle
        //draws rectangle from below the HUD to bottom with 1/5 of the screen as margin at the sides -> here you can see last View
        canvas.drawRect(horizontalMargin, Hud.getHeight(),getWidthPixels()-horizontalMargin,getHeightPixels(),popupBackground);
        //draw Specific Popup
        popup.draw(canvas);
    }

    @Override
    public void update() {

    }

    @Override
    public void touched(MotionEvent event, Game g) {

    }
}
