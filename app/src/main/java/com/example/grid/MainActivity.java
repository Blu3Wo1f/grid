package com.example.grid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private GridLayout grid;
    private Drawable moleImage;
    private ImageView[] imageViews;
    private int molelocation;
    private Random rand;
    public Handler handler;
    public Boolean on;
    public movingmole moving;
    public Button Start;
    public int count;
    public TextView Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.gridLayout);
        moleImage = getDrawable(R.drawable.mole);
        imageViews = new ImageView[16];
        handler = new Handler();
        on = false;
        Start = findViewById(R.id.Start);
        moving = new movingmole();
        rand = new Random();
        molelocation = rand.nextInt(16);
        count=0;
        Score = findViewById(R.id.Score);
        for (int i = 0; i < 16; i++) {
            imageViews[i] = (ImageView) getLayoutInflater().inflate(R.layout.mole_view, null);
            imageViews[i].setMinimumHeight(270);
            imageViews[i].setMinimumWidth(270);
            if (i == molelocation) imageViews[i].setImageDrawable(moleImage);
            grid.addView(imageViews[i]);
        }
    }
    public void ImagePress(View v){
        Intent i =new Intent(this,ImageActivity.class);
        startActivityForResult(i,1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        int image = data.getIntExtra("IMAGE",);

    }
    public void ChangeSpot(View v) {
        if(v.equals(imageViews[molelocation]))
            count+=10;
            Score.setText(count +"");
    }


    public void StartPressed(View v) {
        if (on) {
            on = false;
            handler.removeCallbacks(moving);
        } else {
            on = true;
            handler.postDelayed(moving, 2000);
        }
    }

    private class movingmole implements Runnable {
        @Override
        public void run() {
            int last;
            last = molelocation;
                molelocation = rand.nextInt(16);
                imageViews[molelocation].setImageDrawable(moleImage);
                imageViews[last].setImageDrawable(null);
                handler.postDelayed(moving, 2000);
            }
        }
    }


