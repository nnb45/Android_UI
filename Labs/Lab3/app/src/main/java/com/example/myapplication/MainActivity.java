package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.lv);

        ArrayList<HashMap<String,Object>> list = new ArrayList<>();
        HashMap<String,Object> hashMap1 = new HashMap<>();
        hashMap1.put("ten","BoBai");
        hashMap1.put("tuoi","4");
        hashMap1.put("hinh", R.mipmap.c4);
        list.add(hashMap1);

        HashMap<String,Object> hashMap2 = new HashMap<>();
        hashMap2.put("ten","BaiTay");
        hashMap2.put("tuoi","52");
        hashMap2.put("hinh", R.mipmap.c5);
        list.add(hashMap2);

        SimpleAdapter adapter = new SimpleAdapter(this,
                list, R.layout.item_listview, new String[]{"ten","tuoi","hinh"},
                new int[]{R.id.tv, R.id.tv1, R.id.ivHinh});
        lv.setAdapter(adapter);
    }
}