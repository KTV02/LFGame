package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
//NOT FINISHED YET
public class InformationPopup extends PopUp {
    RectangleButton info;

    /**
     * Use this if creating a Popup with custom Size
     *
     * @param context    context
     * @param dimensions custom size
     */
    public InformationPopup(Context context, int[] dimensions,String infotext) {
        super(context,dimensions);
        this.context=context;
        setInfoBox(infotext,dimensions);
    }



    public InformationPopup(Context context,String infotext){
        super(context);
        setInfoBox(infotext,backgroundSize);
    }

    private void setInfoBox(String infotext,int[] dimensions) {
        info= new RectangleButton(context,dimensions[0],dimensions[1],dimensions[2],dimensions[3]);
        info.setText(infotext);
    }

    @Override
    public void draw(Canvas canvas) {
        info.draw(canvas);
    }

    @Override
    public boolean touched(float x, float y) {
        if(info.isHere(x,y)){
            return true;
        }
        return false;
    }


}
