package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;

public class StructurePopup extends PopUp {

    public StructurePopup(Context context) {
        super(context);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText("Hier kommt BuyMenu für Structures hin",700,500,values.getTextPaint());
        super.draw(canvas);
    }

    @Override
    public boolean touched(float x, float y) {
        return false;
    }
}
