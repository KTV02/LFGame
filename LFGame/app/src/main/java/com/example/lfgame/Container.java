package com.example.lfgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;


/**
 * This creates a rectangular Button filled with an image
 * Real Button is invisible so circular image get displayed correctly
 */
public class Container extends RectangleButton {
    private int left;
    private int top;
    private int right;
    private int bottom;

    Paint color;

    private Context context;
    private Rect scaledContainer;
    private Bitmap background;



    public Container(Context context,int left, int top, int right, int bottom,Bitmap background) {
        super(context,left,right,top,bottom);
        this.context = context;
        setPosition(left,top,right,bottom);

        //sets container into which the container image will be loaded
        this.background = background;
        scaledContainer = new Rect(left, top, right, bottom);
       // color = new Paint();
        //int white = ContextCompat.getColor(context, R.color.white);
        //color.setColor(white);

        //







    }


    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawBitmap(background,null,scaledContainer,null);
        //canvas.drawRect(left, top, right, bottom, color);


    }


    public void click(Game game){
        //SPAWN BUY MENU POPUP HERE
        StructurePopup popup= new StructurePopup(context);
        game.spawnPopup(popup);

    }
    public void setPosition(int left, int top, int right, int bottom){
        this.left=left;
        this.top=top;
        this.right=right;
        this.bottom=bottom;
    }



    @Override
    public boolean isHere(float x, float y) {
            if(x>right||x<left){
                return false;
            }else if(y>bottom||y<top){
                return false;
            }else{
                return true;
            }

    }

}
