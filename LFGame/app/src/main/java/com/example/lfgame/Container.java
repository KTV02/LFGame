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
    }


    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawBitmap(background,null,scaledContainer,null);
        //canvas.drawRect(left, top, right, bottom, color);


    }


    /**
     * Gets called when Container is clicked on
     * Spawns a Popup for Buying a Structure
     * @param game game to spawn Popup on
     */
    public void click(Game game){
        StructurePopup popup= new StructurePopup(context);
        game.spawnPopup(popup);

    }

    /**
     * Sets Position of the container to desired coordinates
     * @param left left side of container (x)
     * @param top top side of container (y)
     * @param right right side of container (x)
     * @param bottom bottom side of container (y)
     */
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
