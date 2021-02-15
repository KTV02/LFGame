package com.example.lfgame;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import androidx.core.content.ContextCompat;

/**
 * View that displays specific Popup passed in Constructor
 */
public class PopUpView extends Views {
    Context context;
    PopUp popup;
    Views backgroundview;
    Button exit;
    public PopUpView(Views backgroundview, PopUp popup, Context context){
        //save last View
        this.backgroundview= backgroundview;
        this.popup=popup;
        this.context=context;
        addExitButton(context);


        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.popupbackground);
    }
    private void addExitButton(Context context){
        float[] dimensions=Values.getPopupExitButtonDimensions();
        exit= new Button(context,dimensions[0],dimensions[1],dimensions[2],dimensions[3]);
        exit.setText("Back to game");
    }
    @Override
    public void draw(Canvas canvas) {
        //draw the last View in the Background
        backgroundview.draw(canvas);
        //set Color and Size Variables for the background of a popup
        Paint popupBackground=new Paint();
        int backgroundColor= ContextCompat.getColor(context,R.color.poupbackground);
        popupBackground.setColor(backgroundColor);
        int horizontalMargin=getWidthPixels()/10;
        //draw standard Popup background as rectangle
        //draws rectangle from below the HUD to bottom with 1/5 of the screen as margin at the sides -> here you can see last View
        canvas.drawRect(horizontalMargin, Hud.getHeight(),getWidthPixels()-horizontalMargin,getHeightPixels(),popupBackground);
        //draw Specific Popup
        exit.draw(canvas,popupBackground);
        popup.draw(canvas);
        popupBackground.setColor(ContextCompat.getColor(context,R.color.blue));

        ;
    }

    @Override
    public boolean checkAllElements(MotionEvent event,Game game) {
        if(exit.touched(event.getX(),event.getY())){
            closePopup(game);
            return true;
        }else if(popup.touched(event.getX(),event.getY())){
            return true;
        }
        return false;
    }
    private void closePopup(Game game){
        game.setView(backgroundview);
    }

    @Override
    public void update() {

    }

}
