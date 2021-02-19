package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;

public class CollectablePopup extends PopUp{

    public CollectablePopup(Context context) {
        super(context);
    }

    @Override
    public void draw(Canvas canvas) {
    }

    @Override
    public boolean touched(float x, float y) {
        return false;
    }
}
