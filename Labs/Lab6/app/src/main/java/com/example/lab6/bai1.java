package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class bai1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        Fragment_Right fragment_right = new Fragment_Right();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fragment, fragment_right)
                .commit();
    }
}