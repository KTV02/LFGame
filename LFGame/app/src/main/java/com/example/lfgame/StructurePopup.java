package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;

import java.util.LinkedList;

public class StructurePopup extends PopUp {
    private LinkedList<Structure> buyableStructures;
    private LinkedList<StructurePreviewContainer> containers;
    private Context context;
    private int[] backgroundSize;

    private final int rowSpaces=5; //how many structures fit into one row

    public StructurePopup(Context context) {
        super(context);
        buyableStructures= new LinkedList<>();
        containers= new LinkedList<>();
        backgroundSize=values.getPopUpViewSize();
        this.context=context;
        fillStructures();
        createStructures();
        //test
        //createBigLayout();
    }

    /**
     * Gets all Structures and adds those who are currently buyable to List
     */
    private void fillStructures(){
        Structure[] structures= values.getStructures();
        for(Structure s:structures){
            if(s.isBuyable(values.getPlayerLevel())){
                buyableStructures.add(s);
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
       // canvas.drawText("Hier kommt BuyMenu für Structures hin",700,500,values.getTextPaint());
        drawContainers(canvas);
        super.draw(canvas);
    }

    /**
     * draws all containers to the screen
     * @param canvas
     */
    private void drawContainers(Canvas canvas) {
        for(Container c: containers){
            c.draw(canvas);
        }
    }

    /**
     * creates the container object with correct size depending on layout
     */
    private void createStructures() {
        if(buyableStructures.size()<=5){
            createBigLayout();
        }else if(buyableStructures.size()<=10){
            // create more pages
        }
    }



    /**
     * If up to 5 Structures have to be displayed fit them into one row
     */
    private void createBigLayout() {
        int structureWidth= (backgroundSize[2]-backgroundSize[0])/rowSpaces;
        int left=backgroundSize[0];
        int right=left+structureWidth;
        int top=backgroundSize[1];
        int bottom=backgroundSize[3];
        for(Structure structure:buyableStructures){
            containers.add(new StructurePreviewContainer(context,left,right,top,bottom,values.getPreviewBackground(),structure));
            left+=structureWidth;
            right+=structureWidth;

        }
    }

    @Override
    public boolean touched(float x, float y) {
        return false;
    }
}
