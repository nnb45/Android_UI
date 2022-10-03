package com.poly.asm.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.poly.asm.Adapter.Adapter_KhoanChi_All;
import com.poly.asm.R;

public class Fragment_KhoanChiAll extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_khoanchi_all, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.vpLoai);

        tabLayout.addTab(tabLayout.newTab().setText("Loại Chi"));
        tabLayout.addTab(tabLayout.newTab().setText("Khoản Chi"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        Adapter_KhoanChi_All adapter = new Adapter_KhoanChi_All(getActivity().getSupportFragmentManager(), 2);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        return view;

    }
}
