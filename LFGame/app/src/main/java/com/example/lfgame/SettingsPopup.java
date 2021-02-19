package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;

public class SettingsPopup extends PopUp{

    public SettingsPopup(Context context) {
        super(context);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    public boolean touched(float x, float y) {
        return false;
    }
}
