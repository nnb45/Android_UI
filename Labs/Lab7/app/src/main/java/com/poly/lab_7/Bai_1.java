package com.poly.lab_7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Bai_1 extends AppCompatActivity {
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.ll),"Chac chua", 5000).
                        setActionTextColor(Color.RED).
                        setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(Bai_1.this, "Da nhap nut", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }
}