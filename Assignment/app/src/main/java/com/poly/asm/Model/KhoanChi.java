package com.poly.asm.Model;

import java.util.Date;

public class KhoanChi {
    private int maKhoanChi;
    private String tenKhoanChi;
    private Date ngayChi;
    private double soTienChi;
    private String moTa;
    private int maLoaiChi;

    public KhoanChi(String tenKhoanChi, Date ngayChi, double soTienChi, String moTa, int maLoaiChi) {
        this.tenKhoanChi = tenKhoanChi;
        this.ngayChi = ngayChi;
        this.soTienChi = soTienChi;
        this.moTa = moTa;
        this.maLoaiChi = maLoaiChi;
    }

    public KhoanChi(int maKhoanChi, String tenKhoanChi, Date ngayChi, double soTienChi, String moTa, int maLoaiChi) {
        this.maKhoanChi = maKhoanChi;
        this.tenKhoanChi = tenKhoanChi;
        this.ngayChi = ngayChi;
        this.soTienChi = soTienChi;
        this.moTa = moTa;
        this.maLoaiChi = maLoaiChi;
    }

    public int getMaKhoanChi() {
        return maKhoanChi;
    }

    public void setMaKhoanChi(int maKhoanChi) {
        this.maKhoanChi = maKhoanChi;
    }

    public String getTenKhoanChi() {
        return tenKhoanChi;
    }

    public void setTenKhoanChi(String tenKhoanChi) {
        this.tenKhoanChi = tenKhoanChi;
    }

    public Date getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(Date ngayChi) {
        this.ngayChi = ngayChi;
    }

    public double getSoTienChi() {
        return soTienChi;
    }

    public void setSoTienChi(double soTienChi) {
        this.soTienChi = soTienChi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getMaLoaiChi() {
        return maLoaiChi;
    }

    public void setMaLoaiChi(int maLoaiChi) {
        this.maLoaiChi = maLoaiChi;
    }
}
