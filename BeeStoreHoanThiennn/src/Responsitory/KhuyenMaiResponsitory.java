/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Responsitory_IPL.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.ChatLieu;
import model.ChiTietSanPham;
import model.KhuyenMai;
import model.KichThuoc;
import model.MauSac;
import model.SanPham;
import model.ThuongHieu;

/**
 *
 * @author VHC
 */
public class KhuyenMaiResponsitory {

    public ArrayList<KhuyenMai> getAllKhuyenMai() {
        ArrayList<KhuyenMai> List = new ArrayList<>();
        try {
            String sql = "select * from KhuyenMai";
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setID(rs.getInt("ID"));
                km.setMaKM(rs.getString("Ma"));
                km.setTenKM(rs.getString("Ten"));
                km.setNgayBatDau(rs.getString("NgayBatDau"));
                km.setNgayKetThuc(rs.getString("NgayKetThuc"));
                km.setMucGiamGiaKM(rs.getFloat("MucGiamGia"));
                km.setTrangThai(rs.getString("TrangThai"));
                List.add(km);

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi khuyen mai");
        }
        return List;
    }

      public ArrayList<KhuyenMai> getAllKhuyenMaiDangHD() {
        ArrayList<KhuyenMai> List = new ArrayList<>();
        try {
            String sql = "  select * from KhuyenMai where Trangthai=N'Đang diễn ra'";
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setID(rs.getInt("ID"));
                km.setMaKM(rs.getString("Ma"));
                km.setTenKM(rs.getString("Ten"));
                km.setNgayBatDau(rs.getString("NgayBatDau"));
                km.setNgayKetThuc(rs.getString("NgayKetThuc"));
                km.setMucGiamGiaKM(rs.getFloat("MucGiamGia"));
                km.setTrangThai(rs.getString("TrangThai"));
                List.add(km);

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi khuyen mai");
        }
        return List;
    }
    public ArrayList<SanPham> getALLSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            String sql = "select *from SanPham ";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getString("ID"));
                sp.setMaSP(rs.getString("Ma"));
                sp.setTenSP(rs.getString("Ten"));
               

                list.add(sp);
            }
        } catch (Exception e) {
            System.out.println("loi");
            e.printStackTrace();
        }
        return list;
    }

    public Integer addKM(KhuyenMai km) {
        Integer row = null;
        try {          
            String sql = "insert into KhuyenMai(Ma,Ten,NgayBatDau,NgayKetThuc,MucGiamGia,Trangthai) values (?,?,?,?,?,?) ";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
           pstm.setString(1, km.getMaKM());
           pstm.setString(2, km.getTenKM());
            pstm.setString(3, km.getNgayBatDau());
            pstm.setString(4, km.getNgayKetThuc());
            pstm.setFloat(5, km.getMucGiamGiaKM());
            pstm.setString(6, km.getTrangThai());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi add km");
        }
        return row;
    }

    public Integer updateKhuyenMai(KhuyenMai km, int ID) {
        Integer row = null;
        try {
            String sql = "update KhuyenMai set Ma=?,Ten=?,MucGiamGia=?,NgayBatDau=?,NgayKetThuc=?,TrangThai=? where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, km.getMaKM());
            pstm.setString(2, km.getTenKM());
            pstm.setFloat(3, km.getMucGiamGiaKM());
            pstm.setString(4, km.getNgayBatDau());
            pstm.setString(5, km.getNgayKetThuc());
            pstm.setString(6, km.getTrangThai());
            pstm.setInt(7, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi update km");
        }
        return row;
    }

    public Integer delKhuyenMai(int ID) {
        Integer row = null;
        try {
            String sql = "delete from Voucher where Id = ?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi del km");
        }
        return row;
    }
    
//   public KhuyenMai findByMaVoucher(String maVC) {
//        sql = "SELECT * FROM  vouchers where maVouchers =?";
//        try {
//            con = DBconnect.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, maVC);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Vouchers vc = new Vouchers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6), rs.getDouble(7), rs.getString(8));
//                return vc;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        return null;
//    }
    public KhuyenMai findByMaVoucher(String ID) {
      //  ArrayList<KhuyenMai> List = new ArrayList<>();
        try {
            String sql = "  select * from KhuyenMai where ma=?";
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setID(rs.getInt("ID"));
                km.setMaKM(rs.getString("Ma"));
                km.setTenKM(rs.getString("Ten"));
                km.setNgayBatDau(rs.getString("NgayBatDau"));
                km.setNgayKetThuc(rs.getString("NgayKetThuc"));
                km.setMucGiamGiaKM(rs.getFloat("MucGiamGia"));
                km.setTrangThai(rs.getString("TrangThai"));
//                List.add(km);


            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi khuyen mai");
        }
        return null;
    }
  
}
