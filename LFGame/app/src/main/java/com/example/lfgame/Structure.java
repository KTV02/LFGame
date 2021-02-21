package com.example.lfgame;

import android.graphics.Bitmap;

/**
 * mother class of all Structures
 */
public abstract class Structure {
    String name;
    boolean clickable;
    int minLevel;
    int level;
    int cost;
    // not static because may change depending on player level
    protected int maxInstances;
    //how many instances of this specific strucuture there are is independent of a Strucutre Object -> Static
    //I don't get that LG FS
    protected static int instances;
    // for big layout
    Bitmap icon;
    String infoText;


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
     * Set all Attributes of the Structure to the values matching the given level
     */
    public abstract void setLevel(int level);

    /**
     * returns the cost of the Structure
     * @return cost
     */
    public int getCost(){
        return cost;
    }

    /**
     * Returns the name of the structure
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * returns true if minLevel of Player is reached and maxInstances not exceeded
     * @return if Structure is buyable at the moment
     */
    public abstract boolean isBuyable(int playerLevel);

    /**
     * Returns true if Player has enough money to buy the specific structure that overrides this
     * @param playerMoney the Amount of money the player has in total
     * @return boolean if structure is affordable
     */
    public boolean isAffordable(){
       if(Gold.getAmount()>=cost){
           return true;
       }else{
           return false;
       }
    }

    /**
     * Returns the Structure icon
     * @return Bitmap bigBackground
     */
    public Bitmap getIcon(){
        return icon;
    }


    /**
     * Returns the Info Text String, for a Goldmine this would e.g. be the Production Rate per Hour
     * @return info text
     */
    public String getInfoText(){
        return infoText;
    }

    /**
     * The specific attribute which counts as InfoText is set in here SET IN CONSTRUCTOR
     * @param info infoText to be displayed
     */
    public abstract void setInfoText(String info);

    /**
     * The name of the Structure, SET IN CONSTRUCTOR
     * @param name name
     */
    public abstract void setName(String name);
}
