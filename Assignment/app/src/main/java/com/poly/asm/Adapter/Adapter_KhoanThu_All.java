package com.poly.asm.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.poly.asm.Fragment.Fragment_KhoanChi;
import com.poly.asm.Fragment.Fragment_KhoanThu;
import com.poly.asm.Fragment.Fragment_LoaiChi;
import com.poly.asm.Fragment.Fragment_LoaiThu;

public class Adapter_KhoanThu_All extends FragmentStatePagerAdapter {
    int anInt;
    public Adapter_KhoanThu_All(@NonNull FragmentManager fm, int anInt) {
        super(fm);
        this.anInt = anInt;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            Fragment_LoaiThu fragment_loaiThu = new Fragment_LoaiThu();
            return fragment_loaiThu;
        }

        else{
            Fragment_KhoanThu fragment_khoanThu = new Fragment_KhoanThu();
            return fragment_khoanThu;
        }

    }

    @Override
    public int getCount() {
        return anInt;
    }
}
