package com.poly.asm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.poly.asm.DAO.LoaiThuDAO;
import com.poly.asm.DAO.LoaichiDAO;
import com.poly.asm.Fragment.Fragment_GioiThieu;
import com.poly.asm.Fragment.Fragment_KhoanChiAll;
import com.poly.asm.Fragment.Fragment_KhoanThuAll;
import com.poly.asm.Fragment.Fragment_ThongKe;
import com.poly.asm.Model.LoaiChi;
import com.poly.asm.Model.LoaiThu;
import com.poly.asm.MyHeper.MyHeper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.nvView);
        drawerLayout = (DrawerLayout) findViewById(R.id.dr);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        actionBar.setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                xulychonmenu(item);
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }


        return super.onOptionsItemSelected(item);
    }

    public void  xulychonmenu(MenuItem menuItem){
        int id = menuItem.getItemId();
        Fragment fragment = null;
        Class classfragment = null;


        if(id == R.id.khoanchi){
            classfragment = Fragment_KhoanChiAll.class;
        }

        if(id == R.id.khoanthu){
            classfragment = Fragment_KhoanThuAll.class;
        }

        if(id == R.id.thongke){
            classfragment = Fragment_ThongKe.class;
        }

        if(id == R.id.gioithieu){
            classfragment = Fragment_GioiThieu.class;
        }

        if(id == R.id.thoat){
            finish();
        }

        try {
            fragment = (Fragment) classfragment.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.flContent,fragment)
                    .commit();
            menuItem.setChecked(true);
            setTitle(menuItem.getTitle());
            drawerLayout.closeDrawer(GravityCompat.START);
        }catch (Exception e){

        }
    }








}