package com.example.lfgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class GoldMine extends ResourceProduction{
    public GoldMine(Context context){
        bigBackground=BitmapFactory.decodeResource(context.getResources(),R.drawable.goldbigdemo);
        //smallBackground=;
        //fitBackground=;

    }



    /**
     * Set Gold production rate to correct value depending on level
     *
     * @param level the level of the goldmine
     */
    @Override
    public void setLevel(int level) {
        switch(level){
            case 1:
                productionRate=60;
                break;
            default:
                productionRate+=60;

        }
    }

    /**
     * returns true if minLevel of Player is reached and maxInstances not exceeded
     *
     * @param playerLevel
     * @return if Structure is buyable at the moment
     */
    @Override
    public boolean isBuyable(int playerLevel) {
        return true;
    }

    /**
     * Returns the Background for the Big Layout
     *
     * @return Bitmap bigBackground
     */
    @Override
    public Bitmap getBigBackground() {
        return bigBackground;
    }

    /**
     * Returns the Background for the small Layout
     *
     * @return Bitmap smallBackground
     */
    @Override
    public Bitmap getSmallBackground() {
        return null;
    }

    @Override
    public Bitmap getFitBackground(int width, int height) {
        return null;
    }
}
