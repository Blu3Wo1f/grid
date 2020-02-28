package com.example.grid;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
public class ImageActivity extends AppCompatActivity {

    private RadioButton wolf;
    private RadioButton bunny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changeimg);

        wolf = findViewById(R.id.wolf);
        bunny = findViewById(R.id.bunny);
    }


    @Override
    public void onBackPressed(){
            int image;
            if(wolf.isChecked())
               image=1;
            else if(bunny.isChecked())
                image=2;
            else
                image=3;
        Intent i=new Intent();
        i.putExtra("IMAGE",image);
        setResult(RESULT_OK,i);
        finish();
    }


}