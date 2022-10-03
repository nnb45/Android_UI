package com.example.lab6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStatePagerAdapter {
    int numberoftab;
    public MyAdapter(@NonNull FragmentManager fm, int numberoftab) {
        super(fm);
        this.numberoftab = numberoftab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment_Text fragment_text = new Fragment_Text();
        Bundle ds_doiso = new Bundle();
        ds_doiso.putString("text", position+"");
        fragment_text.setArguments(ds_doiso);
        return fragment_text;
    }

    @Override
    public int getCount() {
        return numberoftab;
    }
}
