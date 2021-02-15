package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Mother class of all Popups
 * NEEDS to be expanded!
 */
public abstract class PopUp implements Clickable {
    protected Values values;
    public PopUp(Context context){
        // get Values object from MainActivity.java class
        MainActivity m =(MainActivity) context;
        this.values= m.getValues();
    }
    public void draw(Canvas canvas) {
    }

}
