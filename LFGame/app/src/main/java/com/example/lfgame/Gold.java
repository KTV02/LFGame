package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class Gold{
    static int amount = 0;
    static RectangleButton underAmount;

   public static void startUP(Context context, float base[]){
        underAmount= new RectangleButton(context,base[2],base[2]-base[4]*0.6f,0,base[3]);
        underAmount.setText(""+amount);
    }

    public static void setAmount(int a) {
        amount = a;
    }

    public static void draw(Canvas canvas){
        underAmount.draw(canvas);
    }

    public static boolean touched(MotionEvent e, Game g){
        if(underAmount.isHere(e.getX(), e.getY())) {
            System.out.println("Yay");
            return true;
        }
        else
            return false;
    }

}