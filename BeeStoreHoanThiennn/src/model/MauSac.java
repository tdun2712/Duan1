/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class MauSac {
     private int Id;
    private String tenMauSac;

    public MauSac(int Id, String tenMauSac) {
        this.Id = Id;
        this.tenMauSac = tenMauSac;
    }

    public MauSac() {
    }

    public MauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    @Override
    public String toString() {
        return "MauSac{" + "Id=" + Id + ", tenMauSac=" + tenMauSac + '}';
    }

    
    
}
