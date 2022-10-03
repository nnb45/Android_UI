package com.poly.asm.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.poly.asm.Model.KhoanChi;
import com.poly.asm.MyHeper.MyHeper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class KhoanchiDao {
    Context context;
    SQLiteDatabase sqLiteDatabase;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public KhoanchiDao(Context context) {
        MyHeper heper = new MyHeper(context);
        sqLiteDatabase = heper.getWritableDatabase();
        this.context = context;
    }


    public void themKhoanChi(KhoanChi khoanChi) {
        ContentValues values = new ContentValues();
        values.put("TenKhoanChi", khoanChi.getTenKhoanChi());
        if (khoanChi.getNgayChi() != null) {
            values.put("NgayChi", simpleDateFormat.format(khoanChi.getNgayChi()));
        }
        values.put("SoTienChi", khoanChi.getSoTienChi());
        values.put("MoTa", khoanChi.getMoTa());
        values.put("id_loaichi", khoanChi.getMaLoaiChi());
        sqLiteDatabase.insert("khoanchi", null, values);
    }

    public ArrayList<KhoanChi> xemKhoanChi() {
        ArrayList<KhoanChi> dsKhoanChi = new ArrayList<KhoanChi>();
        String sql = "select * from khoanchi";
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
                int id_loaichi = c.getInt(5);
                KhoanChi khoanChi = new KhoanChi(id, ten, ngay, tien, moTa, id_loaichi);
                dsKhoanChi.add(khoanChi);
            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return dsKhoanChi;
    }

    public void suaKhoanChi(KhoanChi khoanChi) {
        ContentValues values = new ContentValues();
        values.put("TenKhoanChi", khoanChi.getTenKhoanChi());
        if (khoanChi.getNgayChi() != null) {
            values.put("NgayChi", simpleDateFormat.format(khoanChi.getNgayChi()));
        }
        values.put("SoTienChi", khoanChi.getSoTienChi());
        values.put("MoTa", khoanChi.getMoTa());
        values.put("id_loaichi", khoanChi.getMaLoaiChi());
        sqLiteDatabase.update("khoanchi", values, "_id=?", new String[]{khoanChi.getMaKhoanChi() + ""});
    }

    public void xoaKhoanChi(int id) {
        sqLiteDatabase.delete("khoanchi", "_id=?", new String[]{id + ""});
    }

//    public float[] getThongTinThuChi() {
//        SQLiteDatabase sqLiteDatabase = MyHeper.getReadableDatabase();
//        int thu = 0, chi = 0;
//        //select sum(tien)
//        //from giaodich
//        //where maloai in (select maloai from phanloai where thangthai = 'thu')
//        Cursor cursorThu = sqLiteDatabase.rawQuery("select sum(tien) from KHOANTHUCHI where maloai in (select maloai
//                from loai where trangthai = 'thu') ", null);
//        if (cursorThu.getCount() != 0) {
//            cursorThu.moveToFirst();
//            thu = cursorThu.getInt(0);
//        }
//        //select sum(tien)
//        //from giaodich
//        //where maloai in (select maloai from phanloai where thangthai = 'chi')
//        Cursor cursorChi = sqLiteDatabase.rawQuery("select sum(tien) from KHOANTHUCHI where maloai in (select maloai from
//                loai where trangthai = 'chi') ", null);
//
//        if (cursorChi.getCount() != 0) {
//            cursorChi.moveToFirst();
//            chi = cursorChi.getInt(0);
//        }
//        float[] ketQua = new float[]{thu, chi};
//        return ketQua;
//    }
}

