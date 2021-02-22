package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Mother class of all Popups
 * NEEDS to be expanded!
 */
public abstract class PopUp implements Clickable {
    protected Values values;
    Context context;
    int[] backgroundSize;

    /**
     * Use if creating a Popup with standard size
     * @param context context
     */
    public PopUp(Context context){
        this.context=context;
        // get Values object from MainActivity.java class
        MainActivity m =(MainActivity) context;
        this.values= m.getValues();
        backgroundSize=values.getPopUpViewSize();

    }

    /**
     * Use this if creating a Popup with custom Size
     * @param context context
     * @param dimensions left[0], right[1], top[2], bottom[3]
     */
    public PopUp(Context context,int[] dimensions){
        //yes this is not really efficient fuck off
        this(context);
        backgroundSize=dimensions;

    }

    /**
     * Returns size of the whole popup
     * @return left[0], right[1], top[2], bottom[3]
     */
    public int[] getSize(){
        return backgroundSize;
    }
    public abstract void draw(Canvas canvas);

}
