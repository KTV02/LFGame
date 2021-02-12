package com.example.lfgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Bitmap;

public abstract class Views {
    private int widthPixels;
    private int heightPixels;
    protected Bitmap background;

    public void getScreen(Context context){
        widthPixels = Resources.getSystem().getDisplayMetrics().widthPixels;
        heightPixels =Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public int getWidthPixels(){
        return widthPixels;
    }

    public int getHeightPixels(){
        return heightPixels;
    }

    public abstract void draw(Canvas canvas);
}
