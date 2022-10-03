package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = findViewById(R.id.Framlayout);

        int[] arr = new int[]{R.mipmap.c1, R.mipmap.c2, R.mipmap.c3,
                R.mipmap.b1fv, R.mipmap.b2fv, R.mipmap.ace_of_spades2};

        int i =0;
        for(int item : arr ){
            ImageView iv = new ImageView(this);
            iv.setImageResource(item);

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(400, 400);
            params.leftMargin = i * 100;
            i++;

            iv.setLayoutParams(params);
            frameLayout.addView(iv);
        }

    }
}