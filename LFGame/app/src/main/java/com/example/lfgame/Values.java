package com.example.lfgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import androidx.core.content.ContextCompat;

/**
 * This class handles Data thats needed Globally
 */
public class Values {
    private int screenWidth;
    private int screenHeight;
    private Paint popupPaint;
    private Paint closePaint;
    private Paint componentPaint;
    private Paint textPaint;
    private Paint hudButtonPaint;
    private Paint hudTextPaint;
    private int guiSpace;

    //final values
    private final int containerRowNumber=7;
    private final int containerColumnNumber=3;



    public Values(){
        createPaint();
        getScreenSize();
    }

    /**
     * Gets Screen Size ONCE when Values Object is created
     */
    private void getScreenSize(){
        screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    /**
     * Defines Paint objects
     */
    private void createPaint(){
        popupPaint = new Paint();
        int niceGrey = Color.rgb(115,115,115);
        popupPaint.setColor(niceGrey);

        closePaint = new Paint();
        closePaint.setColor(Color.rgb(255,0,0));

        componentPaint = new Paint();
        componentPaint.setColor(Color.rgb(0,255,0));

        textPaint= new Paint();
        textPaint.setColor(Color.rgb(0,0,0));
       //textPaint.setTextSize(20);

        //Wanted a lighter grey for Hud Buttons
        hudButtonPaint = new Paint();
        hudButtonPaint.setColor(Color.rgb(160,160,160));

        hudTextPaint = new Paint();
        hudTextPaint.setColor(Color.rgb(10, 10, 10));


    }

    /**
     * Returns values needed for Container creation in BaseView
     * @return number of containers in a row[0] and number of containers in a column[1]
     */
    public int[] getContainerProperties(){
        int[] properties ={containerRowNumber,containerColumnNumber};
        return properties;
    }

    /**
     * Returns the Paint Object for Close Button
     * @return Paint for Close Button
     */
    public Paint getClosePaint(){
        return closePaint;
    }

    /**
     * Returns Paint Object for Popup
     * @return paint for Popup background
     */
    public Paint getPopupPaint(){
        return popupPaint;
    }

    /**
     * Returns Paint object for Hud Button
     * @return Hud Button Paint
     */
    public Paint getHudButtonPaint() {return hudButtonPaint;}

    /**
     * Returns Paint object for Hud text
     * @return hud text Paint
     */
    public Paint getHudTextPaint() {return hudTextPaint;}

    /**
     * Getter for Screenwidth in Pixels
     * @return screenwidth
     */
    public int getScreenWidth(){
        return screenWidth;
    }

    /**
     * Getter for Screenheight in Pixels
     * @return screenheigth
     */
    public int getScreenHeight(){
        return screenHeight;
    }


    /**
     * Returns Float array with dimensions of the Exit Button for Popups
     * @return left[0], right[1], top[2], bottom[3]
     */
    public float[] getPopupExitButtonDimensions() {
        float[] dimensions={1800,2020,200,300};
        return dimensions;
    }

    /**
     * Returns Paint Object for Components in the Buy Menu
     * @return buy Menu Paint
     */
    public Paint getComponentPaint() {
        return componentPaint;
    }

    /**
     * Returns Paint Object for Text
     * @return text Paint
     */
    public Paint getTextPaint() {
        return textPaint;
    }

    /**
     * set the GuiSpace, gets called in PopUpView when creating Containers
     * @param guiSpace Space in Pixels covered by the gui at top and bottom
     */
    public void setGuiSpace(int guiSpace) {
        this.guiSpace=guiSpace;
    }

    /**
     * Getter for the gui space
     * @return gui space in Pixels
     */
    public int getGuiSpace(){
        return guiSpace;
    }

    /**
     * Returns the Bitmap which functions as Background for the Containers in BaseView
     * @param context Context to access drawable ressource
     * @return background as Bitmap
     */
    public Bitmap getContainerBackground(Context context){
        Bitmap background=BitmapFactory.decodeResource(context.getResources(),R.drawable.container);
        return background;

    }
}
