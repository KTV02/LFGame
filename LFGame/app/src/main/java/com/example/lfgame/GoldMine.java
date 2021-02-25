package com.example.lfgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class GoldMine extends ResourceProduction {
    public GoldMine(Context context) {
        setIcon(context);
        setName("Gold Mine");
        setInfoText(productionRate+" Gold/h");
        cost=100;
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
        switch (level) {
            case 1:
                productionRate = 60;
                break;
            default:
                productionRate += 60;

        }
    }

    public void setIcon(Context context){
        icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.goldmine);
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
     * The specific attribute which counts as InfoText is set in here
     *
     * @param infoText infoText to be displayed
     */
    @Override
    public void setInfoText(String infoText) {
        this.infoText=infoText;
    }

    /**
     * The name of the Structure
     *
     * @param name name
     */
    @Override
    public void setName(String name) {
        this.name=name;
    }


}