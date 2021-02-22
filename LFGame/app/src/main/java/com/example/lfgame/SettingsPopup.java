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
    private int boxesOnScreen;
    private int[] popUpSize;
    private RectangleButton topText;
    Values values;

    public SettingsPopup(Context context) {
        super(context);
        MainActivity m = (MainActivity) context;
        settingsBoxes = new LinkedList<>();
        values = m.getValues();
        //left,top,right,bottom
        popUpSize = values.getPopUpViewSize();
        boxesOnScreen = 5;
        positionBoxes();
        topText();
    }

    /**
     * Fills the LinkedList with the containers
     * If there are any suggestions for the Box desing, please tell me,
     * because the grey and yellow looks a bit odd
     */
    public void positionBoxes(){
        float top = popUpSize[1]+values.getNavigationMargin();
        float containerHeight = (popUpSize[3]-top)/5;
        for(int i = 0; i<boxesOnScreen; i++){
            settingsBoxes.add(new Container(context, popUpSize[0],popUpSize[2],(int) top,(int) (top+containerHeight), values.getSettingsBox(context)));
            top = top+containerHeight;
        }
    }

    /**
     * Draws Button with Text on it, Text not yet drawn, colors not final
     * Textsize is 1.0, need to find out why
     */
    public void topText(){
        //was eine Zeile ey, left, right, top, bottom
        topText = new RectangleButton(context,popUpSize[0]+popUpSize[2]*0.05f, popUpSize[0]+popUpSize[2]*0.5f,popUpSize[1]+values.getNavigationMargin()*0.1f, popUpSize[1]+values.getNavigationMargin()*0.9f, values.getHudButtonPaint(), values.getClosePaint());
        topText.setText("Settings");
        //topText.size = 90;
    }
    @Override
    /**
     * Draws the containers onto the conavas
     */
    //maybe own method later, like StructurePopup
    public void draw(Canvas canvas) {
        for(int i = 0; i<settingsBoxes.size(); i++){
            settingsBoxes.get(i).draw(canvas);
        }
        topText.draw(canvas);
    }

    @Override
    public boolean touched(float x, float y) {
        return false;
    }
}
