package com.shenkar.gameproject;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;

import static android.graphics.Color.GREEN;

public class musicBox {
    private int audio;
    private Bitmap icon;
    private Direction direction;
    private Paint color;
    private Rect rectangle;
    private boolean hit;

    public musicBox(int audio, Bitmap icon, Direction dir, int color, Rect rectangle) {
        this.hit = false;
        this.audio = audio;
        this.icon = icon ;
        this.direction = dir;
        this.setColor(color);
        this.rectangle = rectangle;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit() {
        this.hit = true;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = new Paint();
        this.color.setStyle(Paint.Style.FILL);
        this.color.setColor(color);

    }

    public Rect getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rect rectangle) {
        this.rectangle = rectangle;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public Bitmap getImg() {
        return icon;
    }

    public void setImg(Bitmap icon) {
        this.icon = icon;
    }

    public Direction getDir() {
        return direction;
    }

    public void setDir(Direction dir) {
        this.direction = dir;
    }

    public void checkBounds(){

    }

    public void playAudio () {

    }

    public void draw (){

    }

    public void  shine (){

    }


}
