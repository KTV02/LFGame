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
    Context context;
    int[] backgroundSize;
    public PopUp(Context context){
        this.context=context;
        // get Values object from MainActivity.java class
        MainActivity m =(MainActivity) context;
        this.values= m.getValues();
        backgroundSize=values.getPopUpViewSize();

    }
    public abstract void draw(Canvas canvas);

}
