package com.example.lfgame;

import android.content.Context;
import android.graphics.Canvas;

public class BuyPromptPopup extends PopUp {
    private RectangleButton buy;
    private Structure structure;
    private Container target;
    private Game game;
    public BuyPromptPopup(Context context, Structure structure,Container target,Game game) {
        super(context);
        this.target=target;
        this.structure=structure;
        this.game=game;
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
            buyStructure();
            return true;
        }
        return false;
    }

    private void buyStructure() {
        Gold.buy(structure.getCost());
        target.setStructure(structure);
        Views popupView=game.getView();
        while(popupView instanceof PopUpView) { 
            ((PopUpView) popupView).closePopup(game);
            popupView=game.getView();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        buy.draw(canvas);
    }
}
