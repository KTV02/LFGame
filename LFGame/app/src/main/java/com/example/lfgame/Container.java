package com.example.lfgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;


/**
 * This creates a rectangular Button filled with an image
 * Real Button is invisible so circular image get displayed correctly
 */
public class Container extends RectangleButton {
    int left;
    int top;
    int right;
    int bottom;
    Context context;
    private Rect scaledContainer;
    Bitmap background;
    private boolean confirmed;
    private Structure structure;



    public Container(Context context,int left, int right, int top, int bottom,Bitmap background) {
        super(context,left,right,top,bottom);
        setBackgroundColor(values.getInvisiblePaint());
        this.context = context;
        setPosition(left,right,top,bottom);
        //sets container into which the container image will be loaded
        this.background = background;
        scaledContainer = new Rect(left, top, right, bottom);
    }


    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawBitmap(background,null,scaledContainer,null);
        //canvas.drawRect(left, top, right, bottom, color);


    }
    public void setStructure(Structure structure){
        this.structure = structure;
        background= BitmapFactory.decodeResource(context.getResources(), R.drawable.goldmine);
    }

    public Structure getStructure(){
        return structure;
    }

    /**
     * Gets called when Container is clicked on
     * Spawns a Popup for Buying a Structure
     * @param game game to spawn Popup on
     */
    public void click(Game game){
        StructurePopup popup= new StructurePopup(context,this,game);
        game.spawnPopup(popup);

    }
    public void setConfirmed(boolean b){
        confirmed = b;
    }
    public boolean confirmed(){
        return confirmed;
    }

    /**
     * Sets Position of the container to desired coordinates
     * @param left left side of container (x)
     * @param top top side of container (y)
     * @param right right side of container (x)
     * @param bottom bottom side of container (y)
     */
    public void setPosition(int left, int right, int top, int bottom){
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
