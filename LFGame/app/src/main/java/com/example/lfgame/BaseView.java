package com.example.lfgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.media.Image;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;

/**
 * Handles how the screen looks if Home Base is viewed
 * Delegates drawing to its components
 */
public class BaseView extends Views{
    Context context;
    LinkedList<Container> containers;
    int containerRowNumber=7;
    int containerColumnNumber=3;
    private static int marginSpace;
    private Values values;
    private Rect scaledContainer;

    public BaseView(Context  context){
        this.context=context;

        values=((MainActivity)context).getValues();
        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.background);
        containers= new LinkedList<>();
        //1 creates 1 container etc...
        createContainer(context);

        scaledContainer = new Rect(0, 0, values.getScreenWidth(), values.getScreenHeight());



    }

    public void draw(Canvas canvas) {


      canvas.drawBitmap(background,null,scaledContainer,null);
      drawContainer(canvas);
    }

    @Override
    public boolean checkAllElements(MotionEvent event, Game game) {
        return checkContainers(event,game);

    }

    /**
     * Delegates Drawing of Containers to each container
     * @param canvas
     */
    private void drawContainer(Canvas canvas){
        //topleft = new Container(context,0,0,200,200);
        //topleft.draw(canvas);
        for(Container c:containers){
            c.draw(canvas);
        }
    }





    /**
     * Checks if Motion Down event on screen was aimed at a container
     * @param event The Motionevent
     * @param game game to set Coordinates of latest touch
     */
    private boolean checkContainers(MotionEvent event, Game game) {
        game.setLatestX("X: " + event.getX() + "Y: " + event.getY());
        for (Container c : containers) {
            if (c.isHere(event.getX(), event.getY())) {
                c.click(game);
                return true;
            }

        }
        return false;
    }
       public void update(){
    }

    
    // Not needed at the moment because of Refactoring, left it in anyways
    //public LinkedList<Container> getContainer(){
    //     return containers;
    //}

    //I know static methods aren't great, but you are not the only one who can write ugly code
    //GOD NO WHAT THE FUCK KILL ME -> LG KTV
    public static int getMarginSpace(){
        return marginSpace;
    }

    /**
     * Creates all Containers in correct distance to each other and the screen
     * @param context context idk
     */
    private void createContainer(Context context){
        //How many Pixels in total of the Screens width are covered by containers WIDTH
        int containerRowPixels=getWidthPixels()/5*4;
        //how many pixels in total of the Screens width are covered in margin space between containers WIDTH
        int marginRowPixels=getWidthPixels()/5;
        //how many margin spaces are there horizontally
        int marginRowNumber= containerRowNumber+1;
        //Space per margin in pixels, sorry i made this ugly with global variable
        marginSpace=marginRowPixels/marginRowNumber;
        //Space per container in pixels
        int containerRowSpace=containerRowPixels/containerRowNumber;
        //space that is occupied by the top icons like gold etc.
        int guiSpace=2*marginSpace;

        //how many margin spaces are there vertically
        int marginColumnNumber=containerColumnNumber+1;
        //how many pixels in total of the screen height are covered by containers
        int height = getHeightPixels();
        int containerColumnPixels=getHeightPixels()-(marginColumnNumber*marginSpace)-2*guiSpace;
        //how big is one container vertically
        int containerHeightSpace=containerColumnPixels/containerColumnNumber;




        //start coordinates of first container in row
        int left=marginSpace;
        int right=marginSpace+containerRowSpace;
        int top=marginSpace+guiSpace;
        int bottom=top+containerRowSpace;
        //set container Bitmap to correct image to be displayed in baseView
        Bitmap containerBackground=BitmapFactory.decodeResource(context.getResources(),R.drawable.container);
        for(int i=0;i<containerColumnNumber;i++) {
            for (int j = 0; j < containerRowNumber; j++) {
                containers.add(new Container(context, left, top, right, bottom,containerBackground));
                //move coordinates to the right by one container and one margin
                left += containerRowSpace + marginSpace;
                right += marginSpace + containerRowSpace;
            }
            left=marginSpace;
            right=marginSpace+containerRowSpace;
            //start next row of containers
            top+=containerHeightSpace+marginSpace;
            bottom+=marginSpace+containerHeightSpace;

        }
    }
public void setPosition(int left,int top){
}
//Hast du die Methode hier reingemacht Frederik? wenn ja was soll die machen?
}

