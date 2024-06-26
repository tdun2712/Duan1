/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class NhanVien {

    private int IdNV;
    private String MaNV;
    private String TenNV;
    private String SDT;
    private String Username;
    private String pass;
    private String ViTri;
    private String gioiTinh;
    private String ngaySinh;
    private String trangThai;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String TenNV) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
    }

    public NhanVien(int IdNV, String TenNV) {
        this.IdNV = IdNV;
        this.TenNV = TenNV;
    }

    public NhanVien(int IdNV, String MaNV, String TenNV, String SDT, String Username, String pass, String ViTri, String gioiTinh, String ngaySinh, String trangThai) {
        this.IdNV = IdNV;
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.SDT = SDT;
        this.Username = Username;
        this.pass = pass;
        this.ViTri = ViTri;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.trangThai = trangThai;
    }

    public int getIdNV() {
        return IdNV;
    }

    public void setIdNV(int IdNV) {
        this.IdNV = IdNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String ViTri) {
        this.ViTri = ViTri;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "IdNV=" + IdNV + ", MaNV=" + MaNV + ", TenNV=" + TenNV + ", SDT=" + SDT + ", Username=" + Username + ", pass=" + pass + ", ViTri=" + ViTri + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", trangThai=" + trangThai + '}';
    }
                            
                                    
}
