package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;

import androidx.core.content.ContextCompat;

public class Container {

    Paint color;

    private Context context;

    public Container(Context context) {
        this.context = context;

        color = new Paint();
        int white = ContextCompat.getColor(context, R.color.white);
        color.setColor(white);

    }

    public void draw(Canvas canvas) {

        canvas.drawRect(100, 100, 500, 500, color);
    }

    public void changeColor() {
        int black = ContextCompat.getColor(context, R.color.black);
        color.setColor(black);
    }


}
