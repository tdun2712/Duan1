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
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;
import model.ThanhToan;
import Responsitory_IPL.HoaDonCTIPL;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import model.ChiTietSanPham;
import model.HoaDonChiTiet;

/**
 *
 * @author phamt
 */
public class HoaDonResponsitory {

    final String SELECT_BY_MAHD = "select * from hoaDonChiTiet where maHD = ?";
    private HoaDonChiTietResponsitory hdctRes = new HoaDonChiTietResponsitory();

    public ArrayList<HoaDon> getAllHDCho() {

        ArrayList<HoaDon> list = new ArrayList<>();
        try {

            String sql = "select HoaDon.Id,NhanVien.Ma as MaNV,NhanVien.HoTen as TenNV,HoaDon.TongTien,HoaDon.TrangThai,HoaDon.NgayTao as NgayTaoHD,ThanhToan.Phuongthuc as phuongThucTT,\n"
                    + "KhachHang.HoTen as TenKH,KhachHang.SDT as SDT\n"
                    + " from HoaDon join NhanVien on HoaDon.IdNV=NhanVien.Id\n"
                    + "join ThanhToan on HoaDon.IdThanhToan=ThanhToan.Id\n"
                    + "join KhachHang on HoaDon.IdKhachHang=KhachHang.Id where HoaDon.TrangThai=N'Chưa thanh toán'";
            //  + "where HoaDon.TrangThai=N'Chưa thanh toán'";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                String ID = (rs.getString("Id"));
                NhanVien nv = new NhanVien(rs.getString("MaNV"), rs.getString("TenNV"));
                ThanhToan tt = new ThanhToan(rs.getString("phuongThucTT"));
                KhachHang kh = new KhachHang(rs.getString("TenKH"), rs.getString("SDT"));
                String tongTien = (rs.getString("TongTien"));
                String ngayTao = (rs.getString("NgayTaoHD"));
                String trangThai = (rs.getString("TrangThai"));
                list.add(new HoaDon(ID, nv, kh, tt, ngayTao, tongTien, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi getALl HD");
        }
        return list;
    }

    public ArrayList<HoaDon> getAllHD() {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            String sql = "select HoaDon.Id,NhanVien.Ma as MaNV,NhanVien.HoTen as TenNV,HoaDon.TongTien,HoaDon.TrangThai,HoaDon.NgayTao as NgayTaoHD,ThanhToan.Phuongthuc as phuongThucTT,\n"
                    + "KhachHang.HoTen as TenKH,KhachHang.SDT as SDT\n"
                    + " from HoaDon join NhanVien on HoaDon.IdNV=NhanVien.Id\n"
                    + "join ThanhToan on HoaDon.IdThanhToan=ThanhToan.Id\n"
                    + "join KhachHang on HoaDon.IdKhachHang=KhachHang.Id order by id desc";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                String ID = (rs.getString("Id"));
                NhanVien nv = new NhanVien(rs.getString("MaNV"), rs.getString("TenNV"));
                ThanhToan tt = new ThanhToan(rs.getString("phuongThucTT"));
                KhachHang kh = new KhachHang(rs.getString("TenKH"), rs.getString("SDT"));
                String tongTien = (rs.getString("TongTien"));
                String ngayTao = (rs.getString("NgayTaoHD"));
                String trangThai = (rs.getString("TrangThai"));
                list.add(new HoaDon(ID, nv, kh, tt, ngayTao, tongTien, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi getALl HD");
        }
        return list;
    }

//    public Integer addHoaDon(HoaDon hd) {
//        Integer row = null;
//        Connection con = DBContext.getConnection();
//        String sql = "insert into  HoaDon(Ma,IdNV,IdThanhToan,TongTien,TrangThai) values(?,?,?,?,?)";
//
//        try {
//            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setString(1, hd.getMaHD());
//            pstm.setInt(2, hd.getNv().getIdNV());
//            pstm.setInt(3, hd.getTT().getId());
//            pstm.setString(4, hd.getTongTien());
//            pstm.setString(5, hd.getTrangThaiHD());
//            row = pstm.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("lỗi add ctsp");
//        }
//        return row;
//    }
    public Integer addHoaDon(HoaDon hd) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        String sql = "insert into HoaDon (IdNV,IdKhachHang,IdThanhToan,NgayTao,TongTien,TrangThai) values (?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            // pstm.setString(1, hd.getMaHD());
            pstm.setInt(1, hd.getNv().getIdNV());
            pstm.setInt(2, hd.getKh().getIdKH());
            pstm.setInt(3, hd.getTT().getId());
            pstm.setString(4, hd.getNgayTaoHD());
            pstm.setString(5, hd.getTongTien());
            pstm.setString(6, hd.getTrangThaiHD());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("lỗi add ctsp");
        }
        return row;
    }

    public Integer updateHoaDon(HoaDon hd, String ID) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        String sql = "update HoaDon set IdNV=?,IdThanhToan=?,TongTien=?,TrangThai=? where id=?";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            //   pstm.setString(1, hd.getMaHD());
            pstm.setInt(1, hd.getNv().getIdNV());
            pstm.setInt(2, hd.getTT().getId());
            pstm.setString(3, hd.getTongTien());
            pstm.setString(4, hd.getTrangThaiHD());
            pstm.setString(5, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("lỗi update ctsp");
        }
        return row;
    }

    public String selectiIdHoaDon() {

        String sql = "SELECT TOP 1 * FROM HOADON ORDER BY ID DESC";

        try (Connection con = DBContext.getConnection();
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            if (resultSet.next()) {
                resultSet.getString("ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("LỖI SELECTID HOA DON");

        }
        return null;

    }

    public ArrayList<HoaDon> getListByDate(String tuNgay, String denNgay) {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {

            String sql = "select HoaDon.Id,NhanVien.Ma as MaNV,NhanVien.HoTen as TenNV,HoaDon.TongTien,HoaDon.TrangThai as TrangThai,"
                    + "HoaDon.NgayTao as NgayTaoHD,ThanhToan.Phuongthuc as phuongThucTT,\n"
                    + " KhachHang.HoTen as TenKH,KhachHang.SDT as SDT\n"
                    + " from HoaDon join NhanVien on HoaDon.IdNV=NhanVien.Id\n"
                    + " join ThanhToan on HoaDon.IdThanhToan=ThanhToan.Id\n"
                    + " join KhachHang on HoaDon.IdKhachHang=KhachHang.Id where NgayTao between ?  and ?";
            //  + "where HoaDon.TrangThai=N'Chưa thanh toán'";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, tuNgay);
            pstm.setString(2, denNgay);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();

                hd.setIdHD(rs.getString("Id"));
                hd.setNv(new NhanVien(rs.getString("MaNV"), rs.getString("TenNV")));
                hd.setTT(new ThanhToan(rs.getString("phuongThucTT")));
                hd.setKh(new KhachHang(rs.getString("TenKH"), rs.getString("SDT")));
                hd.setTongTien(rs.getString("TongTien"));
                hd.setNgayTaoHD(XDate.toString(rs.getDate("NgayTaoHD"), "dd-MM-yyyy"));
                hd.setTrangThaiHD(rs.getString("TrangThai"));
                list.add(hd);
                
            }
             return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi getALl HD");
        }
       return null;
    }
    
    public Integer updateTongTienHoaDon(HoaDon hd) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        String sql = "update HoaDon set TongTien=? where id=?";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, hd.getTongTien());
            pstm.setString(2, hd.getIdHD());

            
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("lỗi update ctsp");
        }
        return row;
    }
    
    public int getSPCTID(String id){
        Connection con = DBContext.getConnection();
        String sql = "select IdSanphamCT from HoaDonChiTiet where Id = ?";
        int spctID = 0;
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);

            ResultSet rs  = pstm.executeQuery();
            while(rs.next()){
                spctID = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("lỗi update ctsp");
        }
        return spctID;
    }
    
}
