package com.shenkar.gameproject;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.view.Display;
import android.view.WindowManager;

import java.util.ArrayList;

public class Ball {
    private Bitmap ball;
    private Position position;
    private Direction direction;

    public Ball(Bitmap ball, Position position, Direction direction) {
        this.ball = ball;
        this.position = position;
        this.direction = direction;
    }

    public Bitmap getBall() {
        return ball;
    }

    public void setBall(Bitmap ball) {
        this.ball = ball;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void checkBounds(Canvas canvas, ArrayList<musicBox> musicBoxes, Level level){

        if (position.getPos_X() > canvas.getWidth() - 75){
            this.direction.setDir_X(this.direction.getDir_X()* -1);
        }

        for(musicBox mb : musicBoxes){
            if((position.getPos_X() > mb.getRectangle().left - 89 && position.getPos_X() < mb.getRectangle().right + 14) && (position.getPos_Y() < mb.getRectangle().bottom && position.getPos_Y() > mb.getRectangle().top - 75)){
                if(!mb.isHit()){
                    mb.setHit();
                    mb.setColor(0xffe4e4e4);
                    switch (level.getNumOfHits()){
                        case 0:
                            MySFxRunnable.getSoundPoolins().play(0);
                            break;
                        case 1:
                            MySFxRunnable.getSoundPoolins().play(1);
                            break;
                        case 2:
                            MySFxRunnable.getSoundPoolins().play(2);
                            break;

                    }
                    level.setNumOfHits();
                }
                direction.setDir_X(direction.getDir_X() * -1);
            }

            if((position.getPos_X() > mb.getRectangle().left - 75 && position.getPos_X() < mb.getRectangle().right) && (position.getPos_Y() < mb.getRectangle().bottom + 15 && position.getPos_Y() > mb.getRectangle().top - 85)){
                if(!mb.isHit()){
                    mb.setColor(0xffe4e4e4);
                    mb.setHit();
                    switch (level.getNumOfHits()){
                        case 0:
                            MySFxRunnable.getSoundPoolins().play(0);
                            break;
                        case 1:
                            MySFxRunnable.getSoundPoolins().play(1);
                            break;
                        case 2:
                            MySFxRunnable.getSoundPoolins().play(2);
                            break;

                    }
                    level.setNumOfHits();
                }
                direction.setDir_Y(direction.getDir_Y() * -1);
            }
        }

            if (position.getPos_X() < 0){
            this.direction.setDir_X(this.direction.getDir_X()* -1);
        }

        if (position.getPos_Y() > canvas.getHeight() - 75){
            this.direction.setDir_Y(this.direction.getDir_Y()* -1);
        }

        if (position.getPos_Y() < 0){
            this.direction.setDir_Y(this.direction.getDir_Y()* -1);
        }

        position.setPos_X(position.getPos_X()+ direction.getDir_X());
        position.setPos_Y(position.getPos_Y()+ direction.getDir_Y());

    }

    public void draw (){

    }




}
