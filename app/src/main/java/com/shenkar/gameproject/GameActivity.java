package com.shenkar.gameproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    AnimationLayout AL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AL = new AnimationLayout(this);
        setContentView(AL);

    }
}
