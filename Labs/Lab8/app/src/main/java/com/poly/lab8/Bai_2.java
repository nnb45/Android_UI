package com.poly.lab8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Bai_2 extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<Logo> ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        rv=(RecyclerView)findViewById(R.id.recyclerView);

        ds=new ArrayList<Logo>();

        taodanhsach();

        MyAdapter adapter=new MyAdapter(Bai_2.this,ds);

        GridLayoutManager lmanager=new GridLayoutManager(Bai_2.this,2);

        rv.setLayoutManager(lmanager);

        rv.setAdapter(adapter);

    }
    public void taodanhsach()

    {

        ds.add(new Logo("Android",R.drawable.h));

        ds.add(new Logo("apple",R.drawable.i));

        ds.add(new Logo("chrome",R.drawable.k));

        ds.add(new Logo("dell",R.drawable.t));

    }
}