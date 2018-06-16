package com.shenkar.gameproject;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;


public class AnimationLayout extends View implements View.OnTouchListener {
    private Level level;
    private boolean can_play;
    private int numOfLevel;

    private static final String TAG = "AnimationLayout";

    static double first_X,first_Y;
    static double second_X,second_Y;
    private int device_width;
    private int device_height;


    public AnimationLayout(Context context) {
        super(context);
        can_play = true;
        numOfLevel = 1;


        setOnTouchListener(this);
    }

    public void setBackground (int bg){
        setBackgroundResource(bg);
    }




    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        device_width = getMeasuredWidth();
        device_height =  getMeasuredHeight();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(level == null)
            level = new Level(numOfLevel,BitmapFactory.decodeResource(getResources(),R.drawable.ball),device_width,device_height);
        if(level.getNumOfHits() == 3){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            numOfLevel ++;
            level = null;
            level = new Level(numOfLevel,BitmapFactory.decodeResource(getResources(),R.drawable.ball),device_width,device_height);
            can_play = true;
        }
        setBackground(level.getBackGround());
        Ball ball = level.getBall();
        ball.checkBounds(canvas,level.getMusicBoxes(),level);

        canvas.drawBitmap(ball.getBall(), ball.getPosition().getPos_X(), ball.getPosition().getPos_Y() ,null);
        for(musicBox mb : level.getMusicBoxes()){
            canvas.drawRect(mb.getRectangle(),mb.getColor());
        }
        if(ball.getPosition().getPos_Y() > device_height - 100){
            level = null;
            can_play = true;
            numOfLevel = 1;
            level = new Level(numOfLevel,BitmapFactory.decodeResource(getResources(),R.drawable.ball),device_width,device_height);

        }
        if(level.getNumOfHits() == 3) {
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.v), Level.converToDeviceWidth(300,device_width)   , Level.converToDeviceHeight(300,device_height),null);
        }
        postInvalidateOnAnimation();
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(Level.converToDeviceHeight(750,device_height) > event.getY())
            return false;

        if(can_play == false)
                return false;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                first_X = (double)event.getX();
                first_Y = (double)event.getY();
                Log.i(TAG,"X= " + String.valueOf(first_X) + " Y= " + String.valueOf(first_Y));
                return true;
            case MotionEvent.ACTION_UP:
                second_X = (int)event.getX();
                second_Y = (int)event.getY();
                Log.i(TAG,"X2= " + String.valueOf(second_X) + " Y2= " + String.valueOf(second_Y));
                Direction dir = new Direction((int)((level.getBall().getPosition().getPos_X()-second_X)*0.03),(int)((level.getBall().getPosition().getPos_Y()-second_Y)*0.03));
                level.getBall().setDirection(dir);
                can_play = false;
                break;
        }
        return false;
    }
}
