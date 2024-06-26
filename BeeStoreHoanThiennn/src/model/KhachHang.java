/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class KhachHang {
    private int IdKH;
   // private String MaKH;
    private String TenKH;
    private String SDT;
    private String gioiTinh;
    private String diaChi;
  //  private String diemTichLuy;

    public KhachHang(String TenKH, String SDT) {
        this.TenKH = TenKH;
        this.SDT = SDT;
    }

    public KhachHang() {
    }

    public KhachHang(String TenKH) {
        this.TenKH = TenKH;
    }

    public int getIdKH() {
        return IdKH;
    }

    public void setIdKH(int IdKH) {
        this.IdKH = IdKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "IdKH=" + IdKH + ", TenKH=" + TenKH + ", SDT=" + SDT + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + '}';
    }

    
}
