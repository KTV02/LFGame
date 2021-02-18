package com.example.lfgame;

import android.graphics.Bitmap;

/**
 * mother class of all Structures
 */
public abstract class Structure {
    protected boolean clickable;
    protected int minLevel;
    protected int level;
    protected int cost;
    // not static because may change depending on player level
    protected int maxInstances;
    //how many instances of this specific strucuture there are is independent of a Strucutre Object -> Static
    protected static int instances;
    // for big layout
    protected Bitmap bigBackground;
    protected Bitmap smallBackground;
    protected Bitmap fitBackground;

    /**
     * Gets called if another instance of the Structure is created
     */
    protected static void instanceCreated(){
        instances+=1;
    }

    /**
     * Returns how many instances of this specific structure are already created
     * @return structure count
     */
    protected static int getInstances(){
        return instances;
    }

    /**
     * Returns the level of the structure
     * @return structure level
     */
    public int getLevel(){
        return level;
    }

    /**
     * returns the cost of the Structure
     * @return cost
     */
    public int getCost(){
        return cost;
    }

    /**
     * returns true if minLevel of Player is reached and maxInstances not exceeded
     * @return if Structure is buyable at the moment
     */
    public boolean isBuyable(int playerLevel){
        if(playerLevel>=minLevel){
            if(instances<maxInstances){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the Background for the Big Layout
     * @return Bitmap bigBackground
     */
    public abstract Bitmap getBigBackground();

    /**
     * Returns the Background for the small Layout
     * @return Bitmap smallBackground
     */
    public abstract Bitmap getSmallBackground();
    public abstract Bitmap getFitBackground(int width, int height);
}
