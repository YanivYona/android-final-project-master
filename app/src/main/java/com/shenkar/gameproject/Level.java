package com.shenkar.gameproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

import static android.graphics.Color.*;

public class Level {
    private ArrayList<musicBox> musicBoxes = new ArrayList<>();
    private Ball ball;
    private int numOfHits;
    private int backGround;
    private Context C ;

    public int getBackGround() {
        return backGround;
    }

    public int getNumOfHits() {
        return numOfHits;
    }

    public void setNumOfHits() {
        this.numOfHits++;
    }


    public Level(int levelNumber, Bitmap bitmap, int device_width, int device_height) {
        this.numOfHits = 0;

        switch (levelNumber){

            case 1:
                this.backGround = R.drawable.purplebg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff6b95aa, new Rect(0,converToDeviceHeight(300,device_height),converToDeviceWidth(100,device_width),converToDeviceHeight(500,device_height))));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff6b95aa, new Rect(converToDeviceWidth(300,device_width),0,converToDeviceWidth(700,device_width),converToDeviceHeight(50,device_height))));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff6b95aa, new Rect(converToDeviceWidth(900,device_width),converToDeviceHeight(300,device_height),converToDeviceWidth(1000,device_width),converToDeviceHeight(500,device_height))));
                break;
            case 2:
                this.backGround = R.drawable.greenbg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff111e21, new Rect(converToDeviceWidth(300,device_width),converToDeviceHeight(400,device_height),converToDeviceWidth(700,device_width),converToDeviceHeight(600,device_height))));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff111e21, new Rect(converToDeviceWidth(100,device_width),converToDeviceHeight(100,device_height),converToDeviceWidth(300,device_width),converToDeviceHeight(300,device_height))));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff111e21, new Rect(converToDeviceWidth(700,device_width),converToDeviceHeight(100,device_height),converToDeviceWidth(900,device_width),converToDeviceHeight(300,device_height))));
                break;
            case 3:
                this.backGround = R.drawable.graybg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff6b95aa, new Rect(0,converToDeviceHeight(50,device_height),converToDeviceWidth(50,device_width),converToDeviceHeight(50,device_height))));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff6b95aa, new Rect(200,converToDeviceHeight(500,device_height),converToDeviceWidth(50,device_width),converToDeviceHeight(50,device_height))));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff6b95aa, new Rect(0,converToDeviceHeight(900,device_height),converToDeviceWidth(50,device_width),converToDeviceHeight(50,device_height))));
                break;
            case 4:
                this.backGround = R.drawable.graybg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff6b95aa, new Rect(0,converToDeviceHeight(50,device_height),converToDeviceWidth(50,device_width),converToDeviceHeight(50,device_height))));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff6b95aa, new Rect(200,converToDeviceHeight(500,device_height),converToDeviceWidth(50,device_width),converToDeviceHeight(50,device_height))));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff6b95aa, new Rect(0,converToDeviceHeight(900,device_height),converToDeviceWidth(50,device_width),converToDeviceHeight(50,device_height))));
                break;
            case 5:
                this.backGround = R.drawable.graybg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff6b95aa, new Rect(0,converToDeviceHeight(50,device_height),converToDeviceWidth(50,device_width),converToDeviceHeight(50,device_height))));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff6b95aa, new Rect(200,converToDeviceHeight(500,device_height),converToDeviceWidth(50,device_width),converToDeviceHeight(50,device_height))));
                this.musicBoxes.add(new musicBox (R.raw.pushb,null,null, 0xff6b95aa, new Rect(0,converToDeviceHeight(900,device_height),converToDeviceWidth(50,device_width),converToDeviceHeight(50,device_height))));
                break;

        }

        this.musicBoxes = musicBoxes;
        this.ball = ball;
    }

    static int converToDeviceWidth(float x ,float width){
        return (int)((x/1000)*width);
    }

    static int converToDeviceHeight(float y,float height){
        return (int)((y/1000)*height);
    }


    public ArrayList<musicBox> getMusicBoxes() {
        return musicBoxes;
    }

    public void setMusicBoxes(ArrayList<musicBox> musicBoxes) {
        this.musicBoxes = musicBoxes;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
}
