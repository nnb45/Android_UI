package com.poly.asm.Model;

public class LoaiThu {
    private int maLoaiThu;
    private String tenLoaiThu;

    public LoaiThu(String tenLoaiThu) {
        this.tenLoaiThu = tenLoaiThu;
    }

    public LoaiThu(int maLoaiThu, String tenLoaiThu) {
        this.maLoaiThu = maLoaiThu;
        this.tenLoaiThu = tenLoaiThu;
    }

    public int getMaLoaiThu() {
        return maLoaiThu;
    }

    public void setMaLoaiThu(int maLoaiThu) {
        this.maLoaiThu = maLoaiThu;
    }

    public String getTenLoaiThu() {
        return tenLoaiThu;
    }

    public void setTenLoaiThu(String tenLoaiThu) {
        this.tenLoaiThu = tenLoaiThu;
    }
}
