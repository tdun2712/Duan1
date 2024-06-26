/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author VHC
 */
public class KhuyenMai {
   private int ID;
    private String MaKM;
    private String TenKM;
    private String NgayBatDau;
    private String NgayKetThuc;
    private float MucGiamGiaKM;
    private String TrangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(int ID, String MaKM, String TenKM, String NgayBatDau, String NgayKetThuc, float MucGiamGiaKM, String TrangThai) {
        this.ID = ID;
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.MucGiamGiaKM = MucGiamGiaKM;
        this.TrangThai = TrangThai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public String getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public float getMucGiamGiaKM() {
        return MucGiamGiaKM;
    }

    public void setMucGiamGiaKM(float MucGiamGiaKM) {
        this.MucGiamGiaKM = MucGiamGiaKM;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "ID=" + ID + ", MaKM=" + MaKM + ", TenKM=" + TenKM + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + ", MucGiamGiaKM=" + MucGiamGiaKM + ", TrangThai=" + TrangThai + '}';
    }

   
}
