package com.example.lfgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.media.Image;
import android.content.Context;

public class BaseView{
    Context context;
    Bitmap background;
    public BaseView(Context  context){
        this.context=context;
        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.background);
    }
    public void draw(Canvas canvas) {
       canvas.drawBitmap(background,0,0,new Paint());
    }
    public void update(){


    }
}
