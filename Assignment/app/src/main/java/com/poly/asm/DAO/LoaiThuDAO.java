package com.poly.asm.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.poly.asm.Model.LoaiThu;
import com.poly.asm.MyHeper.MyHeper;

import java.util.ArrayList;

public class LoaiThuDAO {
    Context context;
    SQLiteDatabase sqLiteDatabase;

    public LoaiThuDAO(Context context){
        MyHeper heper = new MyHeper(context);
        sqLiteDatabase = heper.getWritableDatabase();
        this.context = context;
    }

    public void themLoaiThu(LoaiThu loaiThu){
        ContentValues values = new ContentValues();
        values.put("TenLoaiThu", loaiThu.getTenLoaiThu());
        sqLiteDatabase.insert("loaithu", null, values);
    }

    public ArrayList<LoaiThu> xemLoaiThu(){
        ArrayList<LoaiThu> dsLoaiThu = new ArrayList<LoaiThu>();
        String sql = "select * from loaithu";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        if(c.moveToFirst()){
            do {
                int _id = c.getInt(0);
                String tenLoaiThu = c.getString(1);
                LoaiThu loaiThu = new LoaiThu(_id, tenLoaiThu);
                dsLoaiThu.add(loaiThu);
            }while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return dsLoaiThu;
    }

    public void suaLoaiThu(LoaiThu loaiThu){
        ContentValues values = new ContentValues();
        values.put("TenLoaiThu", loaiThu.getTenLoaiThu());
        sqLiteDatabase.update("loaithu", values, "_id=?",new String[]{loaiThu.getMaLoaiThu()+""});
    }

    public void xoaLoaiThu(int id){
        sqLiteDatabase.delete("loaithu","_id=?",new String[]{id+""});
        sqLiteDatabase.delete("khoanthu", "id_loaithu=?", new String[]{id + ""});
    }
}