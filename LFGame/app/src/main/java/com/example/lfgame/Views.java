package com.example.lfgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.view.MotionEvent;

public abstract class Views {
    protected Bitmap background;



    public int getWidthPixels()
    {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public int getHeightPixels(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public abstract void draw(Canvas canvas);
    public abstract void update();
    public abstract void touched(MotionEvent event, Game g);
}
