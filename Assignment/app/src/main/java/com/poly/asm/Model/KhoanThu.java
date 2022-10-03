package com.poly.asm.Model;
import java.util.Date;

public class KhoanThu {
    private int maKhoanThu;
    private String tenKhoanThu;
    private Date ngayThu;
    private double soTienThu;
    private String moTa;
    private int maLoaiThu;

    public KhoanThu(String tenKhoanThu, Date ngayThu, double soTienThu, String moTa, int maLoaiThu) {
        this.tenKhoanThu = tenKhoanThu;
        this.ngayThu = ngayThu;
        this.soTienThu = soTienThu;
        this.moTa = moTa;
        this.maLoaiThu = maLoaiThu;
    }

    public KhoanThu(int maKhoanThu, String tenKhoanThu, Date ngayThu, double soTienThu, String moTa, int maLoaiThu) {
        this.maKhoanThu = maKhoanThu;
        this.tenKhoanThu = tenKhoanThu;
        this.ngayThu = ngayThu;
        this.soTienThu = soTienThu;
        this.moTa = moTa;
        this.maLoaiThu = maLoaiThu;
    }

    public int getMaKhoanThu() {
        return maKhoanThu;
    }

    public void setMaKhoanThu(int maKhoanThu) {
        this.maKhoanThu = maKhoanThu;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public Date getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(Date ngayThu) {
        this.ngayThu = ngayThu;
    }

    public double getSoTienThu() {
        return soTienThu;
    }

    public void setSoTienThu(double soTienThu) {
        this.soTienThu = soTienThu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getMaLoaiThu() {
        return maLoaiThu;
    }

    public void setMaLoaiThu(int maLoaiThu) {
        this.maLoaiThu = maLoaiThu;
    }
}