package com.example.lfgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;

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
    private Paint invisiblePaint;
    private Paint nameBarPaint;
    private Paint infoBarPaint;
    private Paint costBarPaint;
    private int guiSpace;
    private Bitmap containerBackground;
    private Bitmap exitIcon;
    private Bitmap goldIcon;
    private Bitmap gearIcon;
    private Bitmap SettingsBox;
    private Bitmap previewBackground;
    private Bitmap nextArrowBackground;
    private int playerLevel;
    private Context context;

    //final values
    private final int containerRowNumber=7;
    private final int containerColumnNumber=3;



    public Values(MainActivity m){
        this.context= m.getApplicationContext();
        createPaint();
        getScreenSize();
        setImages(context);
        playerLevel=1;
    }

    private void setImages(Context context) {
        containerBackground=BitmapFactory.decodeResource(context.getResources(),R.drawable.container);
        exitIcon=BitmapFactory.decodeResource(context.getResources(),R.drawable.closeicon);
        goldIcon= BitmapFactory.decodeResource(context.getResources(),R.drawable.coinselfdrawn);
        gearIcon= BitmapFactory.decodeResource(context.getResources(),R.drawable.gear);
        SettingsBox= BitmapFactory.decodeResource(context.getResources(),R.drawable.settingsbox);
        previewBackground=BitmapFactory.decodeResource(context.getResources(),R.drawable.smallpopupbackground);
        nextArrowBackground=BitmapFactory.decodeResource(context.getResources(),R.drawable.nextarrow);
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
        componentPaint.setColor(Color.rgb(0,255,255));

        textPaint= new Paint();
        textPaint.setColor(Color.rgb(0,0,0));
       //textPaint.setTextSize(20);

        //Wanted a lighter grey for Hud Buttons
        hudButtonPaint = new Paint();
        hudButtonPaint.setColor(Color.rgb(160,160,160));

        hudTextPaint = new Paint();
        hudTextPaint.setColor(Color.rgb(10, 10, 10));

        invisiblePaint= new Paint();
        invisiblePaint.setColor(Color.TRANSPARENT);

        nameBarPaint = new Paint();
        nameBarPaint.setColor(Color.rgb(255,106,0));

        infoBarPaint= new Paint();
        infoBarPaint.setColor(Color.rgb(1,255,255));

        costBarPaint= new Paint();
        costBarPaint.setColor(Color.rgb(255,216,0));


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
        //scale to square
        int[] popupSize=getPopUpViewSize();
        int width=popupSize[1]-popupSize[0];

        int exitWidth=width/10; // Exit nimmt 1/10 der Breite des PopUp rectangles ein
        int right=popupSize[1];
        int left=right-exitWidth;

        int top=guiSpace;
        int bottom=guiSpace+exitWidth; // Icon is circular -> width=height
        float[] dimensions={left,right,top,bottom};
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
        return containerBackground;

    }

    /**
     * Returns the Bitmap which functions as Background for the close Icon on Popups
     * @param context context to access drawable ressource
     * @return close icon as Bitmap
     */
    public Bitmap getExitIcon(Context context){
        return exitIcon;
    }

    /**
     * Returns the Bitmap which functions as Coin Icon
     * @param context context to access drawable ressource
     * @return Gold icon as Bitmap
     */
    public Bitmap getGoldIcon(Context context){
        return goldIcon;
    }

    /**
     * Return the Bitmap which functions as Gear Icon
     * @param context context to access drawable ressource
     * @return Gear Icon as Bitmap
     */
    public Bitmap getGearIcon(Context context) { return gearIcon; }

    public Bitmap getSettingsBox(Context context) { return SettingsBox; }

    /**
     * Get Paint object with invisible paint
     * @return invisible paint
     */
    public Paint getInvisiblePaint() {
        return invisiblePaint;
    }

    /**
     * Returns the size of the grey PopUpView rectangle
     * @return left[0],right[1],top[2], bottom[3] in Pixels
     */
    public int[] getPopUpViewSize() {
        int horizontalMargin=screenWidth/10; //in total 2* 10% (sides of the PopupView) of the screen are not covered in the Popup rectangle
        int left=horizontalMargin;
        int top=guiSpace;
        int right=screenWidth-horizontalMargin; //10% margin on the right side ^^
        int bottom=screenHeight;
        int[] size={left,right,top,bottom};
        return size;
    }

    /**
     * Returns all Strucutres currently available in this version of the game
     * @return all structures
     */
    public Structure[] getStructures() {
        Structure[] structures ={new GoldMine(context), new GoldMine(context), new GoldMine(context),new GoldMine(context), new GoldMine(context), new GoldMine(context),new GoldMine(context), new GoldMine(context), new GoldMine(context),new GoldMine(context), new GoldMine(context), new GoldMine(context)};
        return structures;
    }

    /**
     * Returns the Player Level
     * @return player level
     */
    public int getPlayerLevel() {
        return playerLevel;
    }

    /**
     * Increases the Player Level by one
     * gets called when leveling up
     */
    public void increasePlayerLevel(){
        playerLevel+=1;
    }

    /**
     * Returns the Background of the Structure Preview in the Structure Popup
     * @return structure preview Bitmap background
     */
    public Bitmap getPreviewBackground() {
        return previewBackground;
    }

    public Paint getNameBarPaint() {
        return nameBarPaint;
    }

    public Paint getInfoBarPaint() {
        return infoBarPaint;
    }

    public Paint getCostBarPaint() {
        return costBarPaint;
    }

    public Bitmap getNextArrowBackground() {
        return nextArrowBackground;
    }

    /**
     * Returns the Margin at the right side of the StructurePopup where the navigation items are displayed
     * @return
     */
    public int getNavigationMargin() {
        return (int) (getPopupExitButtonDimensions()[1]-getPopupExitButtonDimensions()[0]);
    }

    public int[] getBuyButtonDimensions() {
        int popupWidth=getPopUpViewSize()[1]-getPopUpViewSize()[0];
        int popupHeight=getPopUpViewSize()[3]-getPopUpViewSize()[2];
        int left= getPopUpViewSize()[0]+popupWidth/3;
        int right=left+popupWidth/3;
        int top=popupHeight/2;
        int bottom=top+popupHeight/3;
        int[] dimensions= {left,right,top,bottom};
        return dimensions;

    }
}

