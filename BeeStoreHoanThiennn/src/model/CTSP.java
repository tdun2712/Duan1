/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class CTSP {
      private int Id;
    private int th;
    private int ms;
    private int cl;
    private int sp;
    private int kt;
    private int soLuong; 
    private String gia;
    private String moTa;

    public CTSP() {
    }

    public CTSP(int Id, int th, int ms, int cl, int sp, int kt, int soLuong, String gia, String moTa) {
        this.Id = Id;
        this.th = th;
        this.ms = ms;
        this.cl = cl;
        this.sp = sp;
        this.kt = kt;
        this.soLuong = soLuong;
        this.gia = gia;
        this.moTa = moTa;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getTh() {
        return th;
    }

    public void setTh(int th) {
        this.th = th;
    }

    public int getMs() {
        return ms;
    }

    public void setMs(int ms) {
        this.ms = ms;
    }

    public int getCl() {
        return cl;
    }

    public void setCl(int cl) {
        this.cl = cl;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getKt() {
        return kt;
    }

    public void setKt(int kt) {
        this.kt = kt;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "CTSP{" + "Id=" + Id + ", th=" + th + ", ms=" + ms + ", cl=" + cl + ", sp=" + sp + ", kt=" + kt + ", soLuong=" + soLuong + ", gia=" + gia + ", moTa=" + moTa + '}';
    }

    public CTSP(int th, int ms, int cl, int sp, int kt, int soLuong, String gia, String moTa) {
        this.th = th;
        this.ms = ms;
        this.cl = cl;
        this.sp = sp;
        this.kt = kt;
        this.soLuong = soLuong;
        this.gia = gia;
        this.moTa = moTa;
    }

     
}
