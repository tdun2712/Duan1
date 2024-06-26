/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory_IPL;

import java.util.ArrayList;

import model.ThuongHieu;

/**
 *
 * @author phamt
 */
public interface ThuongHieuIPL {
     public ArrayList<ThuongHieu> getALlThuongHieu();

    public Integer addThuongHieu(ThuongHieu thuongHieu);

    public Integer updateThuongHieu(ThuongHieu thuongHieu,int ID);

    public Integer delThuongHieu(int ID);
}
