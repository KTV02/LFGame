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

public class BaseView {
    Context context;
    Bitmap background;
    Container topleft;
    LinkedList<Container> containers;
    int containerRowNumber=7;
    int containerColumnNumber=4;
    private int widthPixels;
    private int heightPixels;

    public BaseView(Context  context){
        this.context=context;
        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.background);
        containers= new LinkedList<>();
        getScreen(context);
        //1 creates 1 container etc...
        createContainer(context,1);
    }
    public void getScreen(Context context){
        widthPixels=Resources.getSystem().getDisplayMetrics().widthPixels;
        heightPixels=Resources.getSystem().getDisplayMetrics().heightPixels;
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
    public void update(){


    }

   public LinkedList<Container> getContainer() {
        return containers;
   }


    private void createContainer(Context context,int number){
        int containerRowPixels=widthPixels/5*4;
        int marginRowPixels=widthPixels/5;
        int marginNumber= containerRowNumber+1;
        int marginSpace=marginRowPixels/marginNumber;
        for(int i=0;i<number;i++){
            containers.add(new Container(context,0,0,200,200));
        }
    }
public void setPosition(int left,int top){
}

}

