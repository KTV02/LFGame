package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;

public class BuyPromptPopup extends PopUp {
    private RectangleButton buy;
    private Structure structure;
    private Container target;
    public BuyPromptPopup(Context context, Structure structure,Container target) {
        super(context);
        this.target=target;
        this.structure=structure;
        setButtons();
    }

    private void setButtons() {
        int[] dimensions= values.getBuyButtonDimensions();
        buy=new RectangleButton(context,dimensions[0],dimensions[1],dimensions[2],dimensions[3]);
        buy.setText("Buy "+structure.getName()+" for "+structure.getCost()+" Gold");
    }

    @Override
    public boolean touched(float x, float y) {
        if(buy.isHere(x,y)){
            Gold.buy(structure.getCost());
            target.setStructure(structure);
            return true;
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        buy.draw(canvas);
    }
}
