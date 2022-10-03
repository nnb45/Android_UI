package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Spinner spin = findViewById(R.id.spin);

        ArrayList<HashMap<String,Object>> list = new ArrayList<>();
        HashMap<String,Object>hashMap1 = new HashMap<>();
        hashMap1.put("ten","Viet Nam");
        hashMap1.put("hinh", R.mipmap.img);
        list.add(hashMap1);

        HashMap<String,Object>hashMap2 = new HashMap<>();
        hashMap2.put("ten","Nhat");
        hashMap2.put("hinh", R.mipmap.img_1);
        list.add(hashMap1);


        HashMap<String,Object>hashMap3 = new HashMap<>();
        hashMap3.put("ten","Nga");
        hashMap3.put("hinh", R.mipmap.img_2);
        list.add(hashMap1);

        SimpleAdapter adapter = new SimpleAdapter(this,
                list,R.layout.item_spinner,
                new String[]{"ten","hinh",},
                new int[]{R.id.tv, R.id.ivHinh});
        spin.setAdapter(adapter);
    }
}