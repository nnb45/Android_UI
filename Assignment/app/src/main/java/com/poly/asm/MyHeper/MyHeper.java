package com.poly.asm.MyHeper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class MyHeper extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
    public static String name = "QuanLyThuChi";
    public static int version = 1;
    public MyHeper(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql1 = "create table loaithu " +
                "("     +
                "       _id integer primary key autoincrement," +
                "       TenLoaiThu text" +
                ")";
        sqLiteDatabase.execSQL(sql1);

        String sql2 = "create table khoanthu " +
                "("  +
                "   _id integer primary key autoincrement," +
                "   TenKhoanThu text," +
                "   NgayThu date," +
                "   SoTienThu double," +
                "   MoTa String," +
                "   id_loaithu integer references loaithu(_id)" +
                ") ";
        sqLiteDatabase.execSQL(sql2);

        String sql3 = "create table loaichi " +
                "("     +
                "       _id integer primary key autoincrement," +
                "       TenLoaiChi text" +
                ")";
        sqLiteDatabase.execSQL(sql3);

        String sql4 = "create table khoanchi " +
                "("  +
                "   _id integer primary key autoincrement," +
                "   TenKhoanChi text," +
                "   NgayChi date," +
                "   SoTienChi double," +
                "   MoTa String," +
                "   id_loaichi integer references loaichi(_id)" +
                ") ";
        sqLiteDatabase.execSQL(sql4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists loaithu");
        sqLiteDatabase.execSQL("drop table if exists khoanthu");
        sqLiteDatabase.execSQL("drop table if exists loaichi");
        sqLiteDatabase.execSQL("drop table if exists khoanchi");
        onCreate(sqLiteDatabase);
    }
}