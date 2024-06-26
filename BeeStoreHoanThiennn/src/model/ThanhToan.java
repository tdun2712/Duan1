/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class ThanhToan {
    private int Id;
    private String phuongThucTT,Ma;

    public ThanhToan(String phuongThucTT) {
        this.phuongThucTT = phuongThucTT;
    }

    public ThanhToan() {
    }

    public ThanhToan(int Id, String phuongThucTT, String Ma) {
        this.Id = Id;
        this.phuongThucTT = phuongThucTT;
        this.Ma = Ma;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPhuongThucTT() {
        return phuongThucTT;
    }

    public void setPhuongThucTT(String phuongThucTT) {
        this.phuongThucTT = phuongThucTT;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    @Override
    public String toString() {
        return "ThanhToan{" + "Id=" + Id + ", phuongThucTT=" + phuongThucTT + ", Ma=" + Ma + '}';
    }

  
}
