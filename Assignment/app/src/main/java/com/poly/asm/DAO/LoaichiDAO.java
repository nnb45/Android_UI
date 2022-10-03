package com.poly.asm.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.poly.asm.Model.LoaiChi;
import com.poly.asm.Model.LoaiThu;
import com.poly.asm.MyHeper.MyHeper;

import java.util.ArrayList;


public class LoaichiDAO {
    Context context;
    SQLiteDatabase sqLiteDatabase;

    public LoaichiDAO(Context context){
        MyHeper heper = new MyHeper(context);
        sqLiteDatabase = heper.getWritableDatabase();
        this.context = context;
    }

    public void themLoaiChi(LoaiChi loaiChi){
        ContentValues values = new ContentValues();
        values.put("TenLoaiChi", loaiChi.getTenLoaiChi());
        sqLiteDatabase.insert("loaichi", null, values);
    }

    public ArrayList<LoaiChi> xemLoaiChi(){
        ArrayList<LoaiChi> dsLoaiChi = new ArrayList<LoaiChi>();
        String sql = "select * from loaichi";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if(c.moveToFirst()){
            do {
                int _id = c.getInt(0);
                String tenLoaiChi = c.getString(1);
                LoaiChi loaiChi = new LoaiChi(_id, tenLoaiChi);
                dsLoaiChi.add(loaiChi);
            }while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return dsLoaiChi;
    }

    public void suaLoaiChi(LoaiChi loaiChi){
        ContentValues values = new ContentValues();
        values.put("TenLoaiChi", loaiChi.getTenLoaiChi());
        sqLiteDatabase.update("loaichi", values, "_id=?",new String[]{loaiChi.getMaLoaiChi()+""});
    }

    public void xoaLoaiChi(int id){
        sqLiteDatabase.delete("loaichi","_id=?",new String[]{id+""});
        sqLiteDatabase.delete("khoanchi", "id_loaichi=?", new String[]{id + ""});
    }
}
