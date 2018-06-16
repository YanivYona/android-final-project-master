package com.shenkar.gameproject;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    MediaPlayer ring;
    MediaPlayer push;
    AudioManager am;
    int curv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySFxRunnable.getSoundPool(this);
        am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        push = MediaPlayer.create(MainActivity.this,R.raw.pushb);
        ring= MediaPlayer.create(MainActivity.this,R.raw.bkm);
        ring.setLooping(true);
        ring.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        curv = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        if(curv == 0)
            ring.pause();
        else ring.start();
    }

    public void goToSetting(View view) {
        push.start();
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);

    }

    public void moveToPlay(View view) {
        push.start();
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
