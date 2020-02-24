package com.example.grid;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
public class ImageActivity extends AppCompatActivity {

    private RadioButton wolf;
    private RadioButton bunny;
    private RadioButton mole;
    private Drawable moleimage;
    private Drawable wolfimage;
    private Drawable bunnyimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changeimg);

        wolf = findViewById(R.id.wolf);
        bunny = findViewById(R.id.bunny);
        mole = findViewById(R.id.mole);
        moleimage=getDrawable(R.drawable.mole);
        wolfimage=getDrawable(R.drawable.wolf;
        bunnyimage=getDrawable(R.drawable.how_much_is_a_pet_bunny);
    }

    @Override
    public void BackPressed(){
            int image;
            if(wolf.isChecked())
                image=wolfimage.getAlpha();
            else if(bunny.isChecked())
                image=bunnyimage.getAlpha();
            else
                image=moleimage.getAlpha();
        Intent i=new Intent();
            i.putExtra("IMAGE",image);
            setResult(RESULT_OK,i);
            finish();
    }


}