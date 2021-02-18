package com.example.lfgame;

import android.graphics.Bitmap;

/**
 * Mother Class? or Class of Structure which is used for Producing Troops
 */
public class TroopTrainer extends ProductionStructure {
    /**
     * Set all Attributes of the Structure to the values matching the given level
     *
     * @param level
     */
    @Override
    public void setLevel(int level) {

    }

    /**
     * returns true if minLevel of Player is reached and maxInstances not exceeded
     *
     * @param playerLevel
     * @return if Structure is buyable at the moment
     */
    @Override
    public boolean isBuyable(int playerLevel) {
        return false;
    }

    /**
     * The specific attribute which counts as InfoText is set in here SET IN CONSTRUCTOR
     *
     * @param info infoText to be displayed
     */
    @Override
    public void setInfoText(String info) {

    }

    /**
     * The name of the Structure, SET IN CONSTRUCTOR
     *
     * @param name name
     */
    @Override
    public void setName(String name) {

    }


}
