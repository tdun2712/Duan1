/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author phamt
 */
public class GioHang {
    private String MaSP;
    private String TenSP;
    private int soLuong;
    private BigDecimal gia;
    private Double ThanhTiennn;

    public GioHang() {
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public Double getThanhTien() {
        return ThanhTiennn;
    }

    public void setThanhTien(Double ThanhTien) {
        this.ThanhTiennn = ThanhTien;
    }

    public GioHang(String MaSP, String TenSP, int soLuong, BigDecimal gia, Double ThanhTien) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.soLuong = soLuong;
        this.gia = gia;
        this.ThanhTiennn = ThanhTien;
    }

    @Override
    public String toString() {
        return "GioHang{" + "MaSP=" + MaSP + ", TenSP=" + TenSP + ", soLuong=" + soLuong + ", gia=" + gia + ", ThanhTien=" + ThanhTiennn + '}';
    }

    public BigDecimal ThanhTien() {
        return gia.multiply(new BigDecimal(soLuong));
    }
}
