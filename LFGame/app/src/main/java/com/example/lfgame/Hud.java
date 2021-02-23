package com.example.lfgame;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;


import androidx.core.content.ContextCompat;

import java.util.LinkedList;


public class Hud extends Views{

    private Paint color;
    private Context context;
    private Values values;
    private int height;
    private RectangleButton underAmount;
    private Container goldIcon;
    private Container gearIcon;
    /**
     * Assings Vales and starts the setGold "Constructor"
     * @param context Context
     */
    public Hud(Context context) {
        values=((MainActivity)context).getValues();
        height=values.getGuiSpace(); //the height of the HUD interface is 2* the margin between containers;
        color = new Paint();
        this.context = context;
        setGold(context, topSectionsFiller(), values);
        placeGear(context);
    }

    /**
     * Sets Color for the top Hud Bar and draws it on the canvas
     * @param canvas Canvas
     */
    public void topBar(Canvas canvas){
        int niceGrey = Color.rgb(115,115,115);
        //please use niceGrey for further HUD/Menu elements which are grey
        int left = values.getScreenWidth();
        color.setColor(niceGrey);
        canvas.drawRect(left, 0, 0, height, color);
    }

    /**
     * @return base float[], coordinates for topSections()
     */
    public float[] topSectionsFiller(){
        int screenWidth=values.getScreenWidth();
        float fullSectionSpace = screenWidth/2;
        float oneSection = fullSectionSpace/3;
        float[] base = {screenWidth-(oneSection-oneSection*0.02f), 0,screenWidth-oneSection, height, oneSection};
        return base;
    }

    /**
     * Draws three sections on the right side of the Hud
     * using white lines
     * @param canvas Canvas
     * @param base float[], coordinates for the white lines from topSectionsFiller()
     */
    //At the moment thought to be used for tabs: troops, gold, diamonds
    public void topSections(Canvas canvas, float base[]){
        int screenWidth=values.getScreenWidth();
        Paint color=new Paint();
        color.setColor(ContextCompat.getColor(context,R.color.white));
        for(int i = 0; i<3; i++) {
            for (int j = 0; j < 4; j++) {
                canvas.drawRect(base[0], base[1], base[2], base[3], color);
            }
            base[0] = screenWidth-((i+2)*base[4]-base[4]*0.02f);
            base[2] = screenWidth-((i+2)*base[4]);
        }
    }
    @Override
    /**
     * Draws elements of the Hud
     * @param canvas Canvas
     */
    public void draw(Canvas canvas) {
        topBar(canvas);
        topSections(canvas, topSectionsFiller());
        drawGold(canvas);
        gearIcon.draw(canvas);
    }

    /**
     * Draws the Gold Button with the amount on in and
     * the Coin Icon for Gold
     * @param canvas the canvas to draw on
     */
    private void drawGold(Canvas canvas){
        underAmount.setText(Integer.toString(Gold.getAmount()));
        underAmount.draw(canvas);
        goldIcon.draw(canvas);
    }

    /**
     * setGold acts somewhat like a constructor for Gold, which it doesn't have,
     * because everything is static
     * @param c Context, to make Buttons and Containers
     * @param base float, contains coordinates from the Hud sections, to be Used for the placement of the Gold stuff
     * @param v Values, to get standerdised Values
     */
    private void setGold(Context context, float base[], Values v){
        //for base[] values look in Hud class in topSectionsFiller()
        underAmount = new RectangleButton(context,base[2]-base[4]*0.65f, base[2],0, base[3], v.getHudButtonPaint(), v.getTextPaint());
        underAmount.setText(Integer.toString(Gold.getAmount()));
        //new Container for goldIcon
        goldIcon = new Container(context, (int) (base[0]-base[4]),(int) (base[2]-base[4]*0.65f),0,(int) base[3], values.getGoldIcon(context));
    }

    /**
     * Calculates, where the gearIcon for Settings should be placed on the Hud
     * @param context
     */
    private void placeGear(Context context){
        int left = (values.getScreenWidth())/80;
        int top = (int) (getHeight()*0.08f);
        int bottom = (int) (getHeight()*0.92f);
        //gearIcon = new Container(context, 20, 200, 100, 280, values.getGearIcon(context));
        gearIcon = new Container(context, left, left+(bottom-top), top, bottom, values.getGearIcon(context));
    }

    /**
     * @return the height of the Hud, so basically the topBar
     */
    public int getHeight(){
        return height;
    }

    @Override
    public void update() {

    }


    @Override
    /**
     * checks all Elements that are drawn on Hud for Click action
     * @param event MotionEvent
     * @param game Game, used to spawn PopUps
     */
    public boolean checkAllElements(MotionEvent event, Game game) {
        if(underAmount.isHere(event.getX(), event.getY())) {
            CollectablePopup popup= new CollectablePopup(context);
            game.spawnPopup(popup);
            return true;
        }
        if(gearIcon.isHere(event.getX(),event.getY())) {
            SettingsPopup popup = new SettingsPopup(context, game);
            game.spawnPopup(popup);
            return true;
        }
        else
            return false;
    }
}
