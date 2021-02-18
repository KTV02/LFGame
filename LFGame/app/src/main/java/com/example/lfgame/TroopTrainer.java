package com.example.lfgame;

import android.graphics.Bitmap;

/**
 * Mother Class? or Class of Structure which is used for Producing Troops
 */
public class TroopTrainer extends ProductionStructure {
    /**
     * Returns the Background for the Big Layout
     *
     * @return Bitmap bigBackground
     */
    @Override
    public Bitmap getBigBackground() {
        return null;
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
