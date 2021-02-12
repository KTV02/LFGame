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
    Container topleft;
    LinkedList<Container> containers;
    int containerRowNumber=7;
    int containerColumnNumber=4;


    public BaseView(Context  context){
        this.context=context;
        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.background);
        containers= new LinkedList<>();
        getScreen(context);
        //1 creates 1 container etc...
        createContainer(context,10);
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


    private void createContainer(Context context,int number){
        //How many Pixels in total of the Screens width are covered by containers
        int containerRowPixels=getWidthPixels()/5*4;
        //how many pixels in total of the Screens with are covered in margin space between containers
        int marginRowPixels=getWidthPixels()/5;
        //how many margin spaces are there
        int marginRowNumber= containerRowNumber+1;
        //Space per margin in pixels
        int marginRowSpace=marginRowPixels/marginRowNumber;
        //Space per container in pixels
        int containerRowSpace=containerRowPixels/containerRowNumber;

        //start coordinates of first container in row
        int left=0+marginRowSpace;
        int right=marginRowSpace+containerRowSpace;
        int top=0+marginRowSpace;
        int bottom=marginRowSpace+containerRowSpace;

        for(int i=0;i<number;i++){
            containers.add(new Container(context,left,top,right,bottom));
            //move coordinates to the right by one container and one margin
            left+= containerRowSpace+marginRowSpace;
            right+= marginRowSpace+ containerRowSpace;
        }
    }
public void setPosition(int left,int top){
}

}

