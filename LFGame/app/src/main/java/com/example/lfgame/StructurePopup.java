package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;

import java.util.LinkedList;

public class StructurePopup extends PopUp {
    private LinkedList<Structure> buyableStructures;
    private LinkedList<StructurePreviewContainer> containers;
    private Context context;
    private int firstStructure;
    private RectangleButton pages;
    private Container target;
    private Container nextArrow;
    private Game game;

    private final int rowSpaces=5; //how many structures fit into one row

    public StructurePopup(Context context,Container target,Game game) {
        super(context);
        this.game=game;
        //save the container from which the popup was spawned to set bought structure on this container
        this.target=target;
        firstStructure=0; //first structure is on index 0
        buyableStructures= new LinkedList<>();
        containers= new LinkedList<>();

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
        if(nextArrow!=null){
            nextArrow.draw(canvas);
        }
        //draws the Pages Text at the bottom of the navigation margin
        pages.draw(canvas);
        //canvas.drawText(pages,textX,textY,values.getTextPaint());


    }

    /**
     * draws all containers to the screen
     * @param canvas
     */
    private void drawContainers(Canvas canvas) {
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
        //set invisible button that contains Pages text
        int buttonLeft=backgroundSize[2]-values.getNavigationMargin();
        int buttonTop=backgroundSize[3]-((backgroundSize[3]-backgroundSize[1])/10);
        pages= new RectangleButton(context,buttonLeft,backgroundSize[2],buttonTop,backgroundSize[3],values.getInvisiblePaint(),values.getClosePaint());
        //sets correct text to button
        setPageNumber();

    }

    //uff

    /**
     * Calculates how many pages there are and which is currently displayed
     */
    private void setPageNumber() {
        float pageNumber=(float) buyableStructures.size()/rowSpaces;
        int totalPages=1;
        if(pageNumber%1==0){
            totalPages=(int) pageNumber;
        }else{
            totalPages=(int) pageNumber+1;
        }
        int currentPage=(firstStructure/rowSpaces)+1;
        pages.setText(currentPage+"/"+totalPages);
    }

    /**
     * Gets called when the next Page arrow is pressed
     * calls createLayout to draw next Structure Previews to the screen (up to five)
     */
    public void nextPage(){
        firstStructure+=rowSpaces;
        if(firstStructure>=buyableStructures.size()){
            firstStructure=0;
        }
        createLayout();
        setPageNumber();
    }



    /**
     * Draw up to five Structure Previews on the Structure Popup
     */
    private void createLayout() {

        containers.clear(); //clear the previous 5 container out of the list that gets displayed
        int structureWidth=(int) ((backgroundSize[2]-backgroundSize[0])-values.getNavigationMargin())/rowSpaces;
        int left=backgroundSize[0];
        int right=left+structureWidth;
        int top=backgroundSize[1];
        int bottom=backgroundSize[3];

        for(int i=firstStructure;i<(firstStructure+rowSpaces)&&i<buyableStructures.size();i++){
            Structure currentStructure=buyableStructures.get(i);
            containers.add(new StructurePreviewContainer(context,left,right,top,bottom,values.getPreviewBackground(),currentStructure,currentStructure.isAffordable()));
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
        }else if(previewTouched(x,y)){
            return true;
        }
        return false;
    }

    private boolean previewTouched(float x, float y) {
        for(StructurePreviewContainer c:containers){
            if(c.isHere(x,y)){
                if(c.getStructure().isAffordable()) {
                    //spawns buy Prompt
                    game.spawnPopup(new BuyPromptPopup(context, c.getStructure(), target, game));
                }else{
                    //spawn Popup that informs about missing money
                    int[] parentDimensions=values.getPopUpViewSize();
                    //Popup will be half height and 1/3 of the Structure Popups width
                    int parentXCenter=(parentDimensions[2]-parentDimensions[0])/2;
                    int parentYCenter=(parentDimensions[3]-parentDimensions[1])/2;
                    int halfInfoWidth=(parentDimensions[2]-parentDimensions[0])/6;
                    int halfInfoHeight=(parentDimensions[3]-parentDimensions[1])/4;
                    int[] informationDimensions={parentXCenter-halfInfoWidth,parentXCenter+halfInfoWidth,parentYCenter-halfInfoHeight,parentYCenter+halfInfoHeight};
                    game.spawnPopup(new InformationPopup(context,informationDimensions,"This Item is too expensive!"));
                }
                return true;
            }
        }
        return false;
    }
}
