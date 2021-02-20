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
    Values values;

    public SettingsPopup(Context context) {
        super(context);
        MainActivity m = (MainActivity) context;
        settingsBoxes = new LinkedList<>();
        values = m.getValues();
        boxesOnScreen = 5;
    }
    public void positionBoxes(){
        //left,top,right,bottom
        int[] popUpSize = values.getPopUpViewSize();
        float containerHeight = (popUpSize[3]-popUpSize[1])/6;
        float top = 2*containerHeight;
        for(int i = 0; i<boxesOnScreen; i++){
            settingsBoxes.add(new Container(context, popUpSize[0],popUpSize[2],(int) top,(int) (top+containerHeight), values.getSettingsBox(context)));
        }
    }
    @Override
    public void draw(Canvas canvas) {
//        for(int i = 0; i<containers.size(); i++){
//            containers.get(i).draw(canvas);
//        }
    }

    @Override
    public boolean touched(float x, float y) {
        return false;
    }
}
