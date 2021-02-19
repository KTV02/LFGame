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
public class BaseView extends Views {
    private LinkedList<Container> containers;
    private Values values;
    private Rect scaledContainer;

    public BaseView(Context context) {

        values = ((MainActivity) context).getValues();
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);
        containers = new LinkedList<>();
        //1 creates 1 container etc...
        createContainer(context);

        scaledContainer = new Rect(0, 0, values.getScreenWidth(), values.getScreenHeight());


    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(background, null, scaledContainer, null);


        drawContainer(canvas);


    }

    @Override
    public boolean checkAllElements(MotionEvent event, Game game) {
        return checkContainers(event, game);

    }

    /**
     * Delegates Drawing to each container
     *
     * @param canvas
     */
    private void drawContainer(Canvas canvas) {
        for (Container c : containers) {
            c.draw(canvas);
        }
    }


    /**
     * Checks if Motion Down event on screen was aimed at a container
     *
     * @param event The Motionevent
     * @param game  game to set Coordinates of latest touch
     */
    private boolean checkContainers(MotionEvent event, Game game) {
        for (Container c : containers) {
            if (c.isHere(event.getX(), event.getY())) {
                c.click(game);
                return true;
            }

        }
        return false;
    }

    public void update() {
    }


    // Not needed at the moment because of Refactoring, left it in anyways
    //public LinkedList<Container> getContainer(){
    //     return containers;
    //}


    /**
     * Creates all Containers in correct distance to each other and the screen
     *
     * @param context context idk
     */
    private void createContainer(Context context) {
        //get container Properties, screen Size and layout information from values
        int containerColumnNumber = values.getContainerProperties()[1];
        int containerRowNumber = values.getContainerProperties()[0];
        int screenWidth = values.getScreenWidth();
        int screenHeight = values.getScreenHeight();

        // get Margin Space (space between containers)
        int marginSpace = calculateMarginSpace(screenWidth, containerRowNumber);
        //space that is occupied by the top icons like gold etc. and in the future by bottom gui
        int guiSpace = 2 * marginSpace;
        values.setGuiSpace(guiSpace);


        //get Container Size
        int[] containerSize = calculateContainerSize(screenWidth, screenHeight, containerRowNumber, containerColumnNumber, marginSpace);
        int containerWidth = containerSize[0];
        int containerHeight = containerSize[1];


        //start coordinates of first container in row
        int left = marginSpace;
        int right = marginSpace + containerWidth;
        int top = marginSpace + guiSpace;
        int bottom = top + containerWidth;
        //set container Bitmap to correct image to be displayed in baseView
        Bitmap containerBackground = values.getContainerBackground(context);
        //actually creates containers
        for (int i = 0; i < containerColumnNumber; i++) {
            for (int j = 0; j < containerRowNumber; j++) {
                containers.add(new Container(context, left, right, top, bottom, containerBackground));
                //move coordinates to the right by one container and one margin
                left += containerWidth + marginSpace;
                right += marginSpace + containerWidth;
            }
            //after each row the horizontal coordinates get reset
            left = marginSpace;
            right = marginSpace + containerWidth;
            //start next row of containers
            top += containerHeight + marginSpace;
            bottom += marginSpace + containerHeight;

        }
    }

    /**
     * Calculates the correct number of Pixels between the Containers
     *
     * @param screenWidth        the screens width
     * @param containerRowNumber how many containers there are in one row
     * @return the number of pixels per margin
     */
    private int calculateMarginSpace(int screenWidth, int containerRowNumber) {

        //number of margin spaces horizontally
        int marginRowNumber = containerRowNumber + 1;
        //Total space of the screen covered by margins
        int marginRowPixels = screenWidth / 5;
        //space in pixels per margin
        int marginSpace = marginRowPixels / marginRowNumber;
        return marginSpace;
    }

    /**
     * Calculates the correct width and height of the containers and returns the values as an int Array
     *
     * @param screenWidth           the screens width
     * @param screenHeight          the screens height
     * @param containerRowNumber    number of containers in one row
     * @param containerColumnNumber numbers of containers per column
     * @param marginSpace           the space between the containers
     * @return int[] Array of container width[0] and height[1]
     */
    private int[] calculateContainerSize(int screenWidth, int screenHeight, int containerRowNumber, int containerColumnNumber, int marginSpace) {
        //CALCULATE CONTAINER WIDTH
        //how much space horizontally do the containers take up in total pixels
        int containerRowPixels = screenWidth / 5 * 4;
        //Width per container in pixels
        int containerWidth = containerRowPixels / containerRowNumber;

        //CALCULATE CONTAINER HEIGHT
        //how many margin spaces are there vertically
        int marginColumnNumber = containerColumnNumber + 1;
        //how many pixels in total of the screen height are covered by containers
        //4* margin Space because there is space for a gui on the top AND on the bottom
        int containerColumnPixels = screenHeight - (marginColumnNumber * marginSpace) - (4 * marginSpace);
        //Height per container in pixels
        int containerHeight = containerColumnPixels / containerColumnNumber;
        int[] size = {containerWidth, containerHeight};
        return size;

    }


}

