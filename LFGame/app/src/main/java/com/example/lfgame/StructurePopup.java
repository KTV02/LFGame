package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;

import java.util.LinkedList;

public class StructurePopup extends PopUp {
    private LinkedList<Structure> buyableStructures;
    private LinkedList<StructurePreviewContainer> containers;
    private Context context;
    private int[] backgroundSize;
    private int firstStructure;

    private Container nextArrow;

    private final int rowSpaces=5; //how many structures fit into one row

    public StructurePopup(Context context) {
        super(context);
        firstStructure=0; //first structure is on index 0
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
        super.draw(canvas);
       // canvas.drawText("Hier kommt BuyMenu für Structures hin",700,500,values.getTextPaint());
        drawContainers(canvas);
        if(nextArrow!=null){
            nextArrow.draw(canvas);
        }


    }

    /**
     * draws all containers to the screen
     * @param canvas
     */
    private void drawContainers(Canvas canvas) {
//            for (Container c : containers) {
//                c.draw(canvas);
//            }
        for(int i = 0; i<containers.size(); i++){
            containers.get(i).draw(canvas);
        }

    }

    /**
     * creates the container object with correct size depending on layout
     */
    private void createStructures() {
        createLayout();
        if(buyableStructures.size()>5){
         //create next Arrow
            int left=(int) values.getPopupExitButtonDimensions()[0]; //arrow width starts at the same point like exit button
            int right=backgroundSize[2];
            int top=backgroundSize[3]/2; //start at about half the screen height
            int bottom=top+backgroundSize[3]/10; //arrow is 1/10 of the popup window height
            nextArrow= new Container(context,left,right,top,bottom,values.getNextArrowBackground());
        }
    }

    public void nextPage(){
        firstStructure+=rowSpaces;
        if(firstStructure>=buyableStructures.size()){
            firstStructure=0;
        }
        createLayout();

    }



    /**
     * If up to 5 Structures have to be displayed fit them into one row
     */
    private void createLayout() {

        containers.clear(); //clear the previous 5 container out of the list that gets displayed
        int structureWidth=(int) ((backgroundSize[2]-backgroundSize[0])-values.getNavigationMargin())/rowSpaces;
        int left=backgroundSize[0];
        int right=left+structureWidth;
        int top=backgroundSize[1];
        int bottom=backgroundSize[3];

        for(int i=firstStructure;i<(firstStructure+rowSpaces)&&i<buyableStructures.size();i++){
            containers.add(new StructurePreviewContainer(context,left,right,top,bottom,values.getPreviewBackground(),buyableStructures.get(i)));
            left+=structureWidth;
            right+=structureWidth;
        }





//        for(Structure structure:buyableStructures){
//            containers.add(new StructurePreviewContainer(context,left,right,top,bottom,values.getPreviewBackground(),structure));
//            left+=structureWidth;
//            right+=structureWidth;
//
//        }
    }

    @Override
    public boolean touched(float x, float y) {
        if(nextArrow.isHere(x,y)){
            nextPage();
            return true;
        }
        return false;
    }
}
