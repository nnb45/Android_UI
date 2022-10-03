package com.poly.asm.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.poly.asm.Model.KhoanThu;
import com.poly.asm.MyHeper.MyHeper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class KhoanthuDAO {
    Context context;
    SQLiteDatabase sqLiteDatabase;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public KhoanthuDAO(Context context) {
        MyHeper heper = new MyHeper(context);
        sqLiteDatabase = heper.getWritableDatabase();
        this.context = context;
    }


    public void themKhoanThu(KhoanThu khoanThu) {
        ContentValues values = new ContentValues();
        values.put("TenKhoanThu", khoanThu.getTenKhoanThu());
        if (khoanThu.getNgayThu() != null) {
            values.put("NgayThu", simpleDateFormat.format(khoanThu.getNgayThu()));
        }
        values.put("SoTienThu", khoanThu.getSoTienThu());
        values.put("MoTa", khoanThu.getMoTa());
        values.put("id_loaithu", khoanThu.getMaLoaiThu());
        sqLiteDatabase.insert("khoanthu", null, values);
    }

    public ArrayList<KhoanThu> xemKhoanThu() {
        ArrayList<KhoanThu> dsKhoanThu = new ArrayList<KhoanThu>();
        String sql = "select * from khoanthu";
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        Date ngay;
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(0);
                String ten = c.getString(1);
                try {
                    ngay = simpleDateFormat.parse(c.getString(2));
                } catch (Exception e) {
                    ngay = null;
                }
                double tien = c.getDouble(3);
                String moTa = c.getString(4);
                int id_loaithu = c.getInt(5);
                KhoanThu khoanThu = new KhoanThu(id, ten, ngay, tien, moTa, id_loaithu);
                dsKhoanThu.add(khoanThu);
            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return dsKhoanThu;
    }

    public void suaKhoanThu(KhoanThu khoanThu) {
        ContentValues values = new ContentValues();
        values.put("TenKhoanThu", khoanThu.getTenKhoanThu());
        if (khoanThu.getNgayThu() != null) {
            values.put("NgayThu", simpleDateFormat.format(khoanThu.getNgayThu()));
        }
        values.put("SoTienThu", khoanThu.getSoTienThu());
        values.put("MoTa", khoanThu.getMoTa());
        values.put("id_loaithu", khoanThu.getMaLoaiThu());
        sqLiteDatabase.update("khoanthu", values, "_id=?", new String[]{khoanThu.getMaKhoanThu() + ""});
    }

    public void xoaKhoanThu(int id) {
        sqLiteDatabase.delete("khoanthu", "_id=?", new String[]{id + ""});
    }

//    public float[] getThongTinThuChi() {
//    }
}
