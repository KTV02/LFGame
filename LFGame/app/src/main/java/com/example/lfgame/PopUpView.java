package com.example.lfgame;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * View that displays specific Popup passed in Constructor
 */
public class PopUpView extends Views {
    Context context;
    PopUp popup;
    Views backgroundview;
    Container exit;
    Values values;

    public PopUpView(Views backgroundview, PopUp popup, Context context){
        //get Values object from MainActivity.java class
        MainActivity m=(MainActivity) context;
        this.values= m.getValues();
        //save last View
        this.backgroundview= backgroundview;
        this.popup=popup;
        this.context=context;
        addExitButton(context);


        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.popupbackground);
    }
    private void addExitButton(Context context){
        float[] dimensions=values.getPopupExitButtonDimensions();
        exit= new Container(context,(int)dimensions[0],(int)dimensions[1],(int)dimensions[2],(int)dimensions[3],values.getExitIcon(context));

    }
    @Override
    public void draw(Canvas canvas) {
        //draw the last View in the Background
        backgroundview.draw(canvas);
        int[] size=values.getPopUpViewSize();
        //draw standard Popup background as rectangle
         canvas.drawRect(size[0], size[1],size[2],size[3],values.getPopupPaint());
        //draw the exit button
        exit.draw(canvas);
        //draw Specific Popup
        popup.draw(canvas);

    }

    @Override
    public boolean checkAllElements(MotionEvent event,Game game) {
        if(exit.isHere(event.getX(),event.getY())){
            closePopup(game);
            return true;
        }else if(popup.touched(event.getX(),event.getY())){
            return true;
        }
        return false;
    }
    public void closePopup(Game game){
        game.setView(backgroundview);
    }

    @Override
    public void update() {

    }

}
