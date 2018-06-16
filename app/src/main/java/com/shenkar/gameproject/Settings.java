package com.shenkar.gameproject;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class Settings extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar sb;
    MediaPlayer mp;
    AudioManager am;
    TextView mv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mv = (TextView) findViewById(R.id.muteView);
        sb = (SeekBar) findViewById(R.id.seekBar);
        am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxv = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curv = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        sb.setMax(maxv);
        sb.setProgress(curv);
        sb.setOnSeekBarChangeListener(this);
        mv.setText(String.valueOf(curv));
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(progress == 0){
            mv.setText("MUTTED");
        }
        else
            mv.setText(String.valueOf(progress));
        am.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
