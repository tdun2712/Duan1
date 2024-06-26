/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory_IPL;

import model.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author VHC
 */
public interface KhachHangIPL {

    public ArrayList<KhachHang> getAllKhachHang();

    public Integer addKhachHang(KhachHang KH);

    public Integer updateKhachHang(KhachHang KH, int IdKH);

    public Integer delNhanVien(int IdKH);
}
