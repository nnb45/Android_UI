package com.poly.lab8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class TabFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager  viewPager;
    public static int int_items = 3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        } @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 : return new PrimaryFragment();
                case 1 : return new SocialFragment();
                case 2 : return new UpdatesFragment();
            }
            return null;
        }
        @Override public int getCount() {
            return int_items; }
        @Override public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 : return "Primary";
                case 1 : return "Social";
                case 2 : return "Updates";
            } return null;
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /* gan layout va anh xa */
        View x=inflater.inflate(R.layout.tab_layout,null);
        tabLayout=(TabLayout)x.findViewById(R.id.tabs);
        viewPager=(ViewPager)x.findViewById(R.id.viewpager);
        /* Set adapter cho viewpager */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        /* can cai nay chu khong se bi loi */
        tabLayout.post(new Runnable() {
            @Override public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return x;
    }
}
