package com.poly.lab_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bai_3 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        bottomNavigationView = findViewById(R.id.bottomnavi);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.left){
                    Toast.makeText(Bai_3.this, "Moi nhat", Toast.LENGTH_SHORT).show();
                }
                if (item.getItemId() == R.id.center){
                    Toast.makeText(Bai_3.this, "Yeu thich", Toast.LENGTH_SHORT).show();
                }
                if (item.getItemId() == R.id.right){
                    Toast.makeText(Bai_3.this, "Ngau nhien", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

    }
}