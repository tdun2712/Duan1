/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class ThuongHieu {
    private int Id;
    private String tenThuongHieu;

    public ThuongHieu(int Id, String tenThuongHieu) {
        this.Id = Id;
        this.tenThuongHieu = tenThuongHieu;
    }

    public ThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public ThuongHieu() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    @Override
    public String toString() {
        return "ThuongHieu{" + "Id=" + Id + ", tenThuongHieu=" + tenThuongHieu + '}';
    }
    
}
