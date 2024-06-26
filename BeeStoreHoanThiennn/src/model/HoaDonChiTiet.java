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
public class HoaDonChiTiet {
    private String Id;
     private HoaDon hd;
    private ChiTietSanPham ctsp;
    private int soLuong;
    private BigDecimal gia;
    

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String Id, HoaDon hd, ChiTietSanPham ctsp, int soLuong, BigDecimal gia) {
        this.Id = Id;
        this.hd = hd;
        this.ctsp = ctsp;
        this.soLuong = soLuong;
        this.gia = gia;
    }
 
    public HoaDonChiTiet(String Id, ChiTietSanPham ctsp, int soLuong, BigDecimal gia) {
        this.Id = Id;
        this.ctsp = ctsp;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    public ChiTietSanPham getCtsp() {
        return ctsp;
    }

    public void setCtsp(ChiTietSanPham ctsp) {
        this.ctsp = ctsp;
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

   
    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "Id=" + Id + ", hd=" + hd + ", ctsp=" + ctsp + ", soLuong=" + soLuong + ", gia=" + gia + '}';
    }

  public BigDecimal ThanhTien(){
         return gia.multiply(new BigDecimal(soLuong));
    }
    public BigDecimal TongTien(){
         return gia.multiply(new BigDecimal(soLuong));
    }
}
