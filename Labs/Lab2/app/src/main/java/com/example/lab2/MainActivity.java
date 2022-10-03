package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = findViewById(R.id.tv1);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"blazed.ttf");
        tv1.setTypeface(typeface);


    }
}