package com.example.lfgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.media.Image;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;

public class BaseView {
    Context context;
    Bitmap background;
    Container topleft;

    public BaseView(Context  context){
        this.context=context;
        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.background);
        createContainer(20);
    }
    public void draw(Canvas canvas) {
       canvas.drawBitmap(background,0,0,new Paint());
       drawContainer(canvas);
    }
    private void drawContainer(Canvas canvas){
        topleft = new Container(context,0,0,200,200);
        topleft.draw(canvas);
    }
    public void update(){


    }
   // public LinkedList<Container> getContainer(){

    //}
    private void createContainer(int number){
        for(int i=0;i<number;i++){
           // containers.add(new Container());
        }
    }
public void setPosition(int left,int top){
}

}
