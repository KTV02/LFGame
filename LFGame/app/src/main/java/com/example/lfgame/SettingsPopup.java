package com.example.lfgame;
/**
 * This Class is the Popup which pops up, when you press the Settings Icon
 * It also contains the Settings themselfes
 * If this bitch needs to have multiple pages (more than 5 Settings)
 * we need to make a parent class for this and StructurePopup
 * @since 20.02
 * @author The G himself
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.LinkedList;

public class SettingsPopup extends PopUp{
    private LinkedList<Container> settingsBoxes;
    private LinkedList<RectangleButton> textButtons;
    private int boxesOnScreen;
    private int[] popUpSize;
    private RectangleButton topText;
    Values values;

    public SettingsPopup(Context context) {
        super(context);
        MainActivity m = (MainActivity) context;
        settingsBoxes = new LinkedList<>();
        textButtons = new LinkedList<>();
        values = m.getValues();
        //left,top,right,bottom
        popUpSize = values.getPopUpViewSize();
        boxesOnScreen = 5;
        positionBoxes();
        topText();
    }

    /**
     * Fills the LinkedList with the containers, texts for and containers and on/off Buttons
     */
    public void positionBoxes(){
        float top = popUpSize[1]+values.getNavigationMargin();
        float width = popUpSize[2]-popUpSize[0];
        float containerHeight = (popUpSize[3]-top)/5;
        for(int i = 0; i<boxesOnScreen; i++){
            settingsBoxes.add(new Container(context, popUpSize[0],popUpSize[2],(int) top,(int) (top+containerHeight), values.getSettingsBox(context)));
            //left, right, top, bottom
            textButtons.add(new RectangleButton(context, popUpSize[0], popUpSize[2]*0.6f,top+containerHeight*0.15f,top+containerHeight*0.85f, values.getInvisiblePaint(), values.getClosePaint()));
            top = top+containerHeight;
        }
        texts();
    }

    /**
     * Sets the texts for the different Settings
     */
    public void texts(){
        textButtons.get(0).setText("Sound");
        textButtons.get(1).setText("FPS");
    }

    /**
     * Draws Button with Text on it, for the "Headline"
     */
    public void topText(){
        //was eine Zeile ey, left, right, top, bottom
        topText = new RectangleButton(context,popUpSize[0]+popUpSize[2]*0.05f, popUpSize[0]+popUpSize[2]*0.5f,popUpSize[1]+values.getNavigationMargin()*0.1f, popUpSize[1]+values.getNavigationMargin()*0.9f, values.getHudButtonPaint(), values.getClosePaint());
        topText.setText("Settings");
    }
    @Override
    /**
     * Draws the containers onto the conavas and texts and on/off Buttons
     */
    //maybe own method later, like StructurePopup
    public void draw(Canvas canvas) {
        for(int i = 0; i<settingsBoxes.size(); i++){
            settingsBoxes.get(i).draw(canvas);
            textButtons.get(i).draw(canvas);
        }
        topText.draw(canvas);
    }

    @Override
    public boolean touched(float x, float y) {
        return false;
    }
}
