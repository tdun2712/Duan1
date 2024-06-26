/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class SanPham {

    private String Id;
    private String MaSP;
    private String TenSP;
    private String giaBan;
    private String TrangThai;

    public SanPham(String Id, String MaSP, String TenSP) {
        this.Id = Id;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
    }


    public SanPham(String MaSP, String TenSP) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
    }

 


    public SanPham(String Id, String MaSP, String TenSP, String giaBan, String TrangThai) {
        this.Id = Id;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.giaBan = giaBan;
        this.TrangThai = TrangThai;
    }

    public SanPham() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
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

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "Sanpham{" + "Id=" + Id + ", MaSP=" + MaSP + ", TenSP=" + TenSP + ", giaBan=" + giaBan + ", TrangThai=" + TrangThai + '}';
    }

    
}
