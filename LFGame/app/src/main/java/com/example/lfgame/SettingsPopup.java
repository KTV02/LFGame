package com.example.lfgame;
/**
 * This Class is the Popup which pops up, when you press the Settings Icon
 * It also contains the Settings themselfes
 * @since 20.02
 * @author The G himself
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

import java.util.LinkedList;

public class SettingsPopup extends PopUp{
    private LinkedList<Container> settingsBoxes;
    private LinkedList<RectangleButton> textButtons;
    private int boxesOnScreen;
    private int actuallyFilled;
    private int[] popUpSize;
    private RectangleButton topText;
    private Game game;
    Values values;

    public SettingsPopup(Context context, Game game) {
        super(context);
        MainActivity m = (MainActivity) context;
        settingsBoxes = new LinkedList<>();
        textButtons = new LinkedList<>();
        values = m.getValues();
        //left,top,right,bottom -> LEFT;RIGHT;TOP;BOTTOM
        popUpSize = values.getPopUpViewSize();
        boxesOnScreen = 5;
        actuallyFilled = 2;
        this.game = game;
        positionBoxes();
        topText();
    }

    /**
     * Fills the LinkedList with the containers, texts for and containers and on/off Buttons
     */
    public void positionBoxes(){
        float top = popUpSize[2]+values.getNavigationMargin();
        //float width = popUpSize[1]-popUpSize[0];
        float containerHeight = (popUpSize[3]-top)/5;
        for(int i = 0; i<boxesOnScreen; i++){
            settingsBoxes.add(new Container(context, popUpSize[0],popUpSize[1],(int) top,(int) (top+containerHeight), values.getSettingsBox(context)));
            //Text color doesn't work?
            textButtons.add(new RectangleButton(context, popUpSize[0], popUpSize[1]*0.6f,top+containerHeight*0.15f,top+containerHeight*0.85f, values.getInvisiblePaint(), values.getClosePaint()));
            if(i<actuallyFilled) {
                textButtons.add(new RectangleButton(context, popUpSize[1] * 0.7f, popUpSize[1] * 0.9f, top + containerHeight * 0.25f, top + containerHeight * 0.75f, values.getClosePaint(), values.getTextPaint()));
            }
            top = top+containerHeight;
        }
        texts();
    }
    public void buttonChange(RectangleButton rb){
        if(rb.getText().equals("Off")){
            rb.setText("On");
            rb.setBackgroundColor(values.getGreen());
        }
        else{
            rb.setText("Off");
            rb.setBackgroundColor(values.getClosePaint());
        }
    }

    /**
     * Sets the texts for the different Settings
     */
    public void texts(){
        textButtons.get(0).setText("Sound");
        textButtons.get(2).setText("FPS");
        for(int i = 0; i<textButtons.size(); i++){
            if(i%2 == 1 && i<2*actuallyFilled){
                textButtons.get(i).setText("Off");
            }
        }
    }

    /**
     * Draws Button with Text on it, for the "Headline"
     */
    public void topText(){
        //was eine Zeile ey! Ja isses echt du larry @drlambogamer LG KTV
        topText = new RectangleButton(context,popUpSize[0]+popUpSize[1]*0.05f, popUpSize[0]+popUpSize[1]*0.5f,popUpSize[2]+values.getNavigationMargin()*0.1f, popUpSize[2]+values.getNavigationMargin()*0.9f, values.getHudButtonPaint(), values.getClosePaint());
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
        }
        for(int i = 0; i<textButtons.size(); i++){
            textButtons.get(i).draw(canvas);
        }
        topText.draw(canvas);
    }

    @Override
    public boolean touched(float x, float y) {
        for(int i = 0; i<textButtons.size(); i++){
            if(i%2 == 1 && i<2*actuallyFilled){
                if(textButtons.get(i).isHere(x,y)) {
                    buttonChange(textButtons.get(i));
                    if(textButtons.get(i-1).getText().equals("FPS")){
                        game.switchFps();
                    }
                }
            }
        }
        return true;
    }
}
