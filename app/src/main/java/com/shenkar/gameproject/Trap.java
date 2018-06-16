package com.shenkar.gameproject;

import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;

public class Trap {
    private Rect rectangle ;
    private Paint color;
    private int audio;

    public Trap(Rect rectangle, Paint color, int audio) {
        this.rectangle = rectangle;
        this.color = color;
        this.audio = audio;
    }

    public Rect getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rect rectangle) {
        this.rectangle = rectangle;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public void checkBounds(){

    }

    public void draw (){

    }

    public void playAudio(){

    }

    public void shine (){

    }

}
