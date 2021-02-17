package com.example.lfgame;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Abstract class of each View e.g. BaseView
 */
public abstract class Views extends Activity {
    protected Bitmap background;


    public abstract void draw(Canvas canvas);

    public boolean touched(MotionEvent event, Game g){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //check if any Elements on Screen are Touched
                return checkAllElements(event,g);
            case MotionEvent.ACTION_UP:
                //Code to scroll further down I guess
                Log.d("Views.java","Action UP triggered");
                return true;
            default:
                return false;
        }

    }

    /**
     * Checks if any Element on the current view has been touched
     * @param event
     * @param game
     * @return
     */
    public abstract boolean checkAllElements(MotionEvent event,Game game);
    public abstract void update();


}
