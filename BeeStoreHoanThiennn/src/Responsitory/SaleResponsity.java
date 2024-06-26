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
public class SaleResponsity {

    public ArrayList<KhuyenMai> getAllKhuyenMai() {
        ArrayList<KhuyenMai> List = new ArrayList<>();
        try {
            String sql = "select * from Voucher";
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
            String sql = "select SanPham.Id,SanPham.Ma,SanPham.Ten ,SanPham.GiaBan from SanPham order by id desc ";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getString("ID"));
                sp.setMaSP(rs.getString("Ma"));
                sp.setTenSP(rs.getString("Ten"));
                sp.setGiaBan(rs.getString("GiaBan"));

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
            
            String sql = "insert into Voucher (Ma , Ten,NgayBatDau,NgayKetThuc,MucGiamGia,Trangthai) values (?,?,?,?,?,?) ";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, km.getMaKM());
            pstm.setString(2, km.getTenKM());
            pstm.setFloat(5, km.getMucGiamGiaKM());
            pstm.setString(3, km.getNgayBatDau());
            pstm.setString(4, km.getNgayKetThuc());
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
            String sql = "update Voucher set Ma=?,Ten=?,MucKhuyenMai=?,NgayBatDau=?,NgayKetThuc=?,TrangThai=? where Id=?";
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
}
