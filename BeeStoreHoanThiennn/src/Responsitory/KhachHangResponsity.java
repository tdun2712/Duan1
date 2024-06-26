/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Responsitory_IPL.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author VHC
 */
public class KhachHangResponsity  {


    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            String sql = "select * from KhachHang";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                KhachHang kt = new KhachHang();
                kt.setIdKH(rs.getInt("ID"));
               // kt.setMaKH(rs.getString("Ma"));
                kt.setTenKH(rs.getString("HoTen"));
                kt.setSDT(rs.getString("SDT"));
                kt.setDiaChi(rs.getString("DiaChi"));
                kt.setGioiTinh(rs.getString("GioiTinh"));
                //kt.setDiemTichLuy(rs.getString("DiemTichLuy"));
                list.add(kt);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi,Khách hàng");
        }
        return list;
    }


    public Integer addKhachHang(KhachHang KH) {
        Integer row = null;
        try {
            String sql = "insert into KhachHang(HoTen,SDT,GioiTinh,DiaChi) values (?,?,?,?)";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setInt(1, KH.getIdKH());
          //  pstm.setString(1, KH.getMaKH());
            pstm.setString(1, KH.getTenKH());
            pstm.setString(2, KH.getSDT());
            pstm.setString(3, KH.getGioiTinh());
            pstm.setString(4, KH.getDiaChi());
           // pstm.setString(5, KH.getDiemTichLuy());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi add khach hang");
        }
        return row;
    }


    public Integer updateKhachHang(KhachHang KH, int IdKH) {
        Integer row = null;
        try {
            String sql = "update KhachHang set HoTen=?,SDT=?,GioiTinh=?,DiaChi=? where id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            
        //    pstm.setString(1, KH.getMaKH());
            pstm.setString(1, KH.getTenKH());
            pstm.setString(2, KH.getSDT());
            pstm.setString(3, KH.getGioiTinh());
            pstm.setString(4, KH.getDiaChi());
          //  pstm.setString(6, KH.getDiemTichLuy());
            pstm.setInt(5, IdKH);

            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi sua Khach hang");
        }
        return row;
    }

    public Integer delNhanVien(int IdKH) {
        Integer row = null;
        try {
            String sql = "delete from KhachHang where Id =?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, IdKH);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi xoa khach hang");
        }
        return row;
    }

}
