package com.kingfisher;

import java.util.Random;

public class Game {

    private static final int LIMIT_TO_WIN=100;

    private int currentPosition;
    private boolean isWon;


    public Game(){
        this.currentPosition=1;
        this.isWon=false;
    }

    public void move(int spaces){
        setCurrentPosition(getCurrentPosition() + spaces);
        if(getCurrentPosition()>=LIMIT_TO_WIN) isWon=true;
    }


    public int rollsDice() {
        return new Random().nextInt(6)+1;
    }

    public int rollsAndMove() {
        int diceResult = rollsDice();
        move(diceResult);
        return diceResult;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
        if(this.currentPosition>=LIMIT_TO_WIN) setWon(true);
        else setWon(false);
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }
}
