package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

/**
 * Game manages all objects, renders and updates them
 */
public class Game extends SurfaceView implements SurfaceHolder.Callback{
    private GameLoop gameLoop;
    private Context context;
    private Views view;
    private DisplayMode mode;
    private String latestX="";




    public Game(Context context) {
        super(context);

        //get surface holder and add callback
        mode = DisplayMode.BASE_VIEW;
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        this.context= context;
        gameLoop= new GameLoop(this,surfaceHolder);

        view = new BaseView(context);
        setFocusable(true);
        System.out.println("Game started du penis");
    }

    @Override
    //This Method can now be used for every touch event in every view
    public boolean onTouchEvent(MotionEvent event) {
            view.touched(event, this);
            return true;
        }




    @Override
    //Manager Method for drawing -> decides what is drawn
    public void draw(Canvas canvas) {
        super.draw(canvas);
        view.draw(canvas);
        drawUPS(canvas);
        drawFPS(canvas);
        Paint paint= new Paint();
        paint.setColor(ContextCompat.getColor(context,R.color.magenta));
        paint.setTextSize(50);
        canvas.drawText(""+latestX,500,500,paint);


    }
    public void drawUPS(Canvas canvas){
        String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint= new Paint();
        int color = ContextCompat.getColor(context, R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("UPS: "+averageUPS,200,50,paint);
    }

    public void drawFPS(Canvas canvas){
        String averageFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint= new Paint();
        int color = ContextCompat.getColor(context, R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS: "+averageFPS,100,200,paint);
    }
    public void spawnPopup(PopUp popup){
        mode=DisplayMode.POPUP_VIEW;
        view= new PopUpView(popup,context);
        //view.draw();
    }

    // setter Method for use in BaseView
    public void setLatestX(String s) {
        latestX = s;
    }



    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        gameLoop.startLoop();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    public void update() {
        //Update game state
            view.update();
    }

    public void pause() {
        gameLoop.stopLoop();
    }
}
