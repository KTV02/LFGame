package com.example.lfgame;

public abstract class Resource {
    private int amount = 0;
    public void setAmount(int a) {
        amount = a;
    }
    public int getAmount(){
        return amount;
    }
}
