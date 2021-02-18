package com.example.lfgame;

import android.graphics.Bitmap;

/**
 * Reseach Lab is used for researching higher Levels for troops. And Machines?
 */
public class ResearchLab extends TrainingsStructure {
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
