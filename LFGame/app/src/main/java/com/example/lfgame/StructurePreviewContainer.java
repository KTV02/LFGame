package com.example.lfgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * This class displays a Preview of a Structure in the Structure Popup to buy it
 */
public class StructurePreviewContainer extends Container {
    private Structure structure;
    private Container structureImage;
    private Rect scaledContainer;
    private RectangleButton name;
    private RectangleButton info;
    private RectangleButton cost;
    private int structureEnd;
    public StructurePreviewContainer(Context context, int left, int right, int top, int bottom,Bitmap background,Structure structure) {
        super(context, left, right, top, bottom, background);
        this.structure=structure;
        setPosition(left,top,right,bottom);

        //size of the Background image
        this.background=background;
        scaledContainer=new Rect(left,top,right,bottom);

        placeStructure();
        placeInformationBars();
        placeText();
    }

    /**
     * Sets correct Text to the Buttons/Information Rectangles
     */
    private void placeText() {
        name.setText(structure.getName()+" Level "+structure.getLevel());
        info.setText(structure.getInfoText());
        cost.setText("Cost: "+structure.getCost()+" Gold");
    }

    /**
     * Places the rectangle Bars with Information about cost,name, level etc on the image
     */
    private void placeInformationBars() {
        int backgroundWidth=this.right-this.left;
        int left=this.left+(backgroundWidth/15); // horizontal margin at the sides
        int right=this.right-(backgroundWidth/15);
        int availableHeight=bottom-structureEnd;
        int spaceAfterIcon=availableHeight/10;
        //margins after end of Structure icon and between each information Bar/Rectangle in TOTAL
        int margins=availableHeight/5;
        int margin=margins/3; // Three Margins: After first,second and third bar -> first margin already covered by spaceAfterIcon
        int rectangles=availableHeight-spaceAfterIcon-margins; //Space left over for rectangles
        int rectangleHeight=rectangles/3; //availabe height space for one information rectangle



        int nameTop=structureEnd+spaceAfterIcon;
        int nameBottom=nameTop+rectangleHeight;
        name= new RectangleButton(context,left,right,nameTop,nameBottom,values.getNameBarPaint(),values.getTextPaint());
        int infoTop=nameBottom+margin;
        int infoBottom=infoTop+rectangleHeight;
        info= new RectangleButton(context,left,right,infoTop,infoBottom,values.getInfoBarPaint(),values.getTextPaint());
        int costTop=infoBottom+margin;
        int costBottom=costTop+rectangleHeight;
        cost= new RectangleButton(context,left,right,costTop,costBottom,values.getCostBarPaint(),values.getTextPaint());
    }


    /**
     * Places a container with the Structure image onto the background
     */
    private void placeStructure() {
        int height=right-left; //width == height because image is 1:1
        structureEnd=top+height;
        structureImage= new Container(context,left,right,top,structureEnd,structure.getIcon());

    }



    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawBitmap(background,null,scaledContainer,null);
        structureImage.draw(canvas);
        name.draw(canvas);
        info.draw(canvas);
        cost.draw(canvas);
        //
    }
}
