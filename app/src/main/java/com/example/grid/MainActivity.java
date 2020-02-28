package com.example.grid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.gridlayout.widget.GridLayout;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

   private Button changemole;
    public Drawable change;
    private ConstraintLayout hi;
    private GridLayout grid;
    private Drawable moleImage;
    private Drawable wolfImage;
    private Drawable bunnyimage;
    private Drawable sky;
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
        changemole=findViewById(R.id.Changemole);
        grid = findViewById(R.id.gridLayout);
        sky =getDrawable(R.drawable.sky);
        hi = findViewById(R.id.hi);
        hi.setBackground(sky);
        moleImage = getDrawable(R.drawable.mole);
        wolfImage = getDrawable(R.drawable.wolf);
        bunnyimage=getDrawable(R.drawable.bunny);
        imageViews = new ImageView[16];
        handler = new Handler();
        on = false;
        Start = findViewById(R.id.Start);
        moving = new movingmole();
        rand = new Random();
        molelocation = rand.nextInt(15);
        count=0;
        Score = findViewById(R.id.Score);
        change = moleImage;
        for (int i = 0; i < 16; i++) {
            imageViews[i] = (ImageView) getLayoutInflater().inflate(R.layout.mole_view, null);
            imageViews[i].setMinimumHeight(270);
            imageViews[i].setMinimumWidth(270);
            if (i == molelocation) imageViews[i].setImageDrawable(change);
            grid.addView(imageViews[i]);
        }
    }
    public void ImagePress(View v){
        Intent i =new Intent(this,ImageActivity.class);
        startActivityForResult(i,1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        int image = data.getIntExtra("IMAGE", 1);
        if (image == 1) {
            change = wolfImage;
        } else if (image == 2) {
            change = bunnyimage;
        } else {
            change = moleImage;
        }

    }
    public void ChangeSpot(View v) {
        if(v.equals(imageViews[molelocation]))
            count+=100;
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
            imageViews[molelocation].setImageDrawable(change);
            imageViews[last].setImageDrawable(null);
            handler.postDelayed(moving, 2000);
            }
        }
    }


