package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class Gold{

    private static int amount = 0;
    private static RectangleButton underAmount;
    private static Context context;

   public static void startUP(Context c, float base[], Values v){
        context = c;
        //for base[] values look in Hud class
        underAmount = new RectangleButton(context,base[2]-base[4]*0.65f, base[2],0, base[3], v.getHudButtonPaint(), v.getTextPaint());
        float width = base[4]*0.65f;
        //underAmount.getPaint(Integer.toString(amount), (int) width);
        underAmount.setText(Integer.toString(amount));
    }

    public static void setAmount(int a) {
        amount = a;
    }

    public static void draw(Canvas canvas){
        underAmount.draw(canvas);
    }

    public static boolean touched(MotionEvent e, Game g){
        if(underAmount.isHere(e.getX(), e.getY())) {
            CollectablePopup popup= new CollectablePopup(context);
            g.spawnPopup(popup);
            return true;
        }
        else
            return false;
    }

}