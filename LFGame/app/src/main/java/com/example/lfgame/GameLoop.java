package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameLoop extends Thread {
    private static final double MAX_UPS = 60.0;
    private static final double UPS_PERIOD = 1E+3 / MAX_UPS;

    private Game game;
    private boolean isRunning = false;
    private SurfaceHolder surfaceHolder;
    private double averageUPS;
    private double averageFPS;


    public GameLoop(Game game, SurfaceHolder surfaceHolder) {
        this.game = game;
        this.surfaceHolder = surfaceHolder;
    }

    /**
     * Getter for average Updates per Second
     * @return updates per second
     */
    public double getAverageUPS() {
        return averageUPS;
    }

    /**
     * Getter for average Fps
     * @return averageFPS
     */
    public double getAverageFPS() {
        return averageFPS;
    }

    /**
     * starts the game Loop
     */
    public void startLoop() {
        Log.d("GameLoop.java","startLoop");
        isRunning = true;
        start();
    }

    /**
     * This is the game loop
     */
    @Override
    public void run() {
        Log.d("GameLoop.java","run()");
        super.run();

        //Time and cycle count variables
        int updateCount = 0;
        int frameCount = 0;

        long startTime;
        long elapsedTime;
        long sleepTime;

        //THIS IS THE GAME LOOP
        Canvas canvas = null;
        startTime = System.currentTimeMillis();
        while (isRunning) {
            //Update and render Objects in game
            //get surface from layout baseview

            try {
                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    game.update();
                    updateCount++;
                    game.draw(canvas);
                }
                game.update();
                game.draw(canvas);

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                        frameCount++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            //Pause game loop for matching FPS/UPS
            elapsedTime = System.currentTimeMillis() - startTime;
            sleepTime = (long) (updateCount * UPS_PERIOD - elapsedTime);
            if (sleepTime > 0) {
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //skip frames to keep up with FPS -> too much load
            //prevent fps > MAX_UPS
            while (sleepTime < 0 && updateCount < MAX_UPS - 1) {
                game.update();
                updateCount++;
                elapsedTime = System.currentTimeMillis() - startTime;
                sleepTime = (long) (updateCount * UPS_PERIOD - elapsedTime);
            }

            //calculate UPS/FPS
            elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime >= 1000) {
                //Multiplication is the same as Dividing by 1000 to get time in seconds
                averageUPS = updateCount / (1E-3 * elapsedTime);
                averageFPS = frameCount / (1E-3 * elapsedTime);
                updateCount = 0;
                frameCount = 0;
                startTime = System.currentTimeMillis();

            }

        }
    }

    /**
     * stops the game loop and trys to join the Threads
     */
    public void stopLoop() {
        Log.d("GameLoop.java","stopLoop");
        isRunning=false;
        //Wait for gameLoop to return
        try{
            join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
