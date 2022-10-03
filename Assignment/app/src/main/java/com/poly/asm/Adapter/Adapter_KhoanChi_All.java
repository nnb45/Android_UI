package com.poly.asm.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.poly.asm.Fragment.Fragment_KhoanChi;
import com.poly.asm.Fragment.Fragment_KhoanChiAll;
import com.poly.asm.Fragment.Fragment_LoaiChi;

public class Adapter_KhoanChi_All extends FragmentStatePagerAdapter {
    int anInt;
    public Adapter_KhoanChi_All(@NonNull FragmentManager fm, int anInt) {
        super(fm);
        this.anInt = anInt;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            Fragment_LoaiChi fragment_loaiChi = new Fragment_LoaiChi();
            return fragment_loaiChi;
        }

        else{
            Fragment_KhoanChi fragment_khoanChi = new Fragment_KhoanChi();
            return fragment_khoanChi;
        }

    }

    @Override
    public int getCount() {
        return anInt;
    }
}
