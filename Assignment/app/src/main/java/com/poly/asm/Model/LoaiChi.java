package com.poly.asm.Model;

public class LoaiChi {
    private int maLoaiChi;
    private String tenLoaiChi;

    public LoaiChi(String tenLoaiChi) {
        this.tenLoaiChi = tenLoaiChi;
    }

    public LoaiChi(int maLoaiChi, String tenLoaiChi) {
        this.maLoaiChi = maLoaiChi;
        this.tenLoaiChi = tenLoaiChi;
    }

    public int getMaLoaiChi() {
        return maLoaiChi;
    }

    public void setMaLoaiChi(int maLoaiChi) {
        this.maLoaiChi = maLoaiChi;
    }

    public String getTenLoaiChi() {
        return tenLoaiChi;
    }

    public void setTenLoaiChi(String tenLoaiChi) {
        this.tenLoaiChi = tenLoaiChi;
    }
}
