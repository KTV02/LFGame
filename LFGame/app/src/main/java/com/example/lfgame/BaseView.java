package com.example.lfgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.media.Image;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;

public class BaseView extends Views{
    Context context;
    LinkedList<Container> containers;
    int containerRowNumber=7;
    int containerColumnNumber=3;
    private static int marginSpace;

    public BaseView(Context  context){
        this.context=context;
        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.background);
        containers= new LinkedList<>();
        //1 creates 1 container etc...
        createContainer(context);
    }

    public void draw(Canvas canvas) {
       canvas.drawBitmap(background,0,0,new Paint());
       drawContainer(canvas);
    }
    private void drawContainer(Canvas canvas){
        //topleft = new Container(context,0,0,200,200);
        //topleft.draw(canvas);
        for(Container c:containers){
            c.draw(canvas);
        }
    }
    //gets called by onTouchEvent in Game via Views
    //contains what was previously in Game
    public void touched(MotionEvent event, Game g){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                g.setLatestX("X: "+event.getX()+"Y: "+event.getY());
                for(Container c:containers){
                    if(c.isHere(event.getX(),event.getY())){
                        c.changeColor();
                    }
                }
    }}
    public void update(){
    }
    
    // Not needed at the moment because of Refactoring, left it in anyways
    //public LinkedList<Container> getContainer(){
    //     return containers;
    //}

    //I know static methods aren't great, but you are not the only one who can write ugly code
    public static int getMarginSpace(){
        return marginSpace;
    }


    private void createContainer(Context context){
        //How many Pixels in total of the Screens width are covered by containers WIDTH
        int containerRowPixels=getWidthPixels()/5*4;
        //how many pixels in total of the Screens width are covered in margin space between containers WIDTH
        int marginRowPixels=getWidthPixels()/5;
        //how many margin spaces are there horizontally
        int marginRowNumber= containerRowNumber+1;
        //Space per margin in pixels, sorry i made this ugly with global variable
        marginSpace=marginRowPixels/marginRowNumber;
        Values.setMarginSpace(marginSpace);
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
        for(int i=0;i<containerColumnNumber;i++) {
            for (int j = 0; j < containerRowNumber; j++) {
                containers.add(new Container(context, left, top, right, bottom));
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

