package com.example.lfgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

import androidx.core.content.ContextCompat;

/**
 * View that displays specific Popup passed in Constructor
 */
public class PopUpView extends Views {
    Context context;
    PopUp popup;
    Views backgroundview;
    RectangleButton exit;
    Container exitTest;
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
        Paint paint= new Paint();
        paint.setColor(Color.rgb(0,0,255));
        exit= new RectangleButton(context,dimensions[0],dimensions[1],dimensions[2],dimensions[3],values.getClosePaint(),paint);
        exit.setText("Back to game");

        exitTest= new Container(context,(int)dimensions[0],(int)dimensions[1],(int)dimensions[2],(int)dimensions[3],values.getExitIcon(context));

    }
    @Override
    public void draw(Canvas canvas) {
        //draw the last View in the Background
        backgroundview.draw(canvas);
        int screenWidth=values.getScreenWidth();
        int screenHeight=values.getScreenHeight();
        int horizontalMargin=screenWidth/10;
        //draw standard Popup background as rectangle
        //draws rectangle from below the HUD to bottom with 1/5 of the screen as margin at the sides -> here you can see last View
         canvas.drawRect(horizontalMargin, values.getGuiSpace(),screenWidth-horizontalMargin,screenHeight,values.getPopupPaint());
        //draw Specific Popup
        exit.draw(canvas);




        //exitTest.draw(canvas);
        //PROBABLY COMPONENT PAINT GREEN PROBLEM


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
