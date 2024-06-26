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
import model.MauSac;
import model.NhanVien;

/**
 *
 * @author phamt
 */
public class NhanVienResponsitory {
     public ArrayList<NhanVien> getALlNhanVien() {
          ArrayList<NhanVien> list = new ArrayList<>();
        try {
            String sql = "select * from NhanVien";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NhanVien kt = new NhanVien();
                kt.setIdNV(rs.getInt("ID"));
                kt.setMaNV(rs.getString("Ma"));
                kt.setTenNV(rs.getString("HoTen"));
                kt.setSDT(rs.getString("SDT"));
                kt.setUsername(rs.getString("username"));
                kt.setPass(rs.getString("password"));
                kt.setViTri(rs.getString("Vitri"));
                kt.setNgaySinh(rs.getString("NgaySinh"));
                kt.setGioiTinh(rs.getString("GioiTinh"));

                list.add(kt);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi,Nhan vien");
        }
        return list;
    }
     
       public Integer addNhanVien(NhanVien nhanVien) {
        Integer row = null;
        try {
            String sql = "insert into NhanVien(Ma,HoTen,SDT,username,password,ViTri,NgaySinh,GioiTinh) values (?,?,?,?,?,?,?,?)";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, nhanVien.getMaNV());
            pstm.setString(2, nhanVien.getTenNV());
            pstm.setString(3, nhanVien.getSDT());
            pstm.setString(4, nhanVien.getUsername());
            pstm.setString(5, nhanVien.getPass());
            pstm.setString(6, nhanVien.getViTri());
            pstm.setString(7, nhanVien.getNgaySinh());
            pstm.setString(8, nhanVien.getGioiTinh());

            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi add nv");
        }
        return row;
    }
       
         public Integer updateNhanVien(NhanVien nhanVien, int ID){
        Integer row = null;
        try {
            String sql = "update NhanVien set Ma=?,HoTen=?,SDT=?,username=?,[password]=?,ViTri=?,NgaySinh=?,GioiTinh=? where id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, nhanVien.getMaNV());
            pstm.setString(2, nhanVien.getTenNV());
            pstm.setString(3, nhanVien.getSDT());
            pstm.setString(4, nhanVien.getUsername());
            pstm.setString(5, nhanVien.getPass());
            pstm.setString(6, nhanVien.getViTri());
            pstm.setString(7, nhanVien.getNgaySinh());
            pstm.setString(8, nhanVien.getGioiTinh());
            pstm.setInt(9,ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi update NV");
        }
        return row;
    }
         
         public Integer delNhanVien(int ID) {
        Integer row = null;
        try {
            String sql = "delete from NhanVien where Id = ?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi delnv");
        }
        return row;
    }

}
