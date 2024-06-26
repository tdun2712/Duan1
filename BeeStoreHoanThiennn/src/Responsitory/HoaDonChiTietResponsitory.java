/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Responsitory_IPL.DBContext;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ChatLieu;
import model.ChiTietSanPham;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.KichThuoc;
import model.MauSac;
import model.SanPham;
import model.ThuongHieu;

/**
 *
 * @author phamt
 */
public class HoaDonChiTietResponsitory {

    public ArrayList<HoaDonChiTiet> getALlHDCT() {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try {
            String sql = "select HoaDonChiTiet.*,HoaDonChiTiet.DonGia*HoaDonChiTiet.SoLuong as ThanhTien,ChiTietSanPham.*,\n"
                    + "SanPham.*,thuongHieu.*,MauSac.*,KichThuoc.*,ChatLieu.* from HoaDonChiTiet\n"
                    + "join ChiTietSanPham on HoaDonChiTiet.IdSanphamCT=ChiTietSanPham.Id\n"
                    + "join SanPham on ChiTietSanPham.IdSP=SanPham.Id\n"
                    + "join thuongHieu on ChiTietSanPham.IdThuongHieu=thuongHieu.Id\n"
                    + "join MauSac on ChiTietSanPham.IdMauSac=MauSac.Id\n"
                    + "join KichThuoc on ChiTietSanPham.IdKichThuoc=KichThuoc.Id\n"
                    + "join ChatLieu on ChiTietSanPham.IdChatlieu=ChatLieu.Id";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String Id = (rs.getString("Id"));
                SanPham sp = new SanPham(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"));
                ThuongHieu th = new ThuongHieu(rs.getInt("Id"), rs.getString("tenThuongHieu"));
                MauSac ms = new MauSac(rs.getInt("Id"), rs.getString("Ten"));
                ChatLieu cl = new ChatLieu(rs.getInt("Id"), rs.getString("Ten"));
                KichThuoc kt = new KichThuoc(rs.getInt("Id"), rs.getString("Ma"), rs.getString("size"));
                int sl = (rs.getInt("SoLuong"));
                BigDecimal donGia = (rs.getBigDecimal("DonGia"));

                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString("Id"), th, ms, cl, sp, kt);
                // ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString("Id"), sp);
                list.add(new HoaDonChiTiet(Id, ctsp, sl, donGia));

            }
        } catch (Exception e) {
            System.out.println("loi,hoa don chi tiet");
            e.printStackTrace();
        }
        return list;
    }

     public ArrayList<HoaDonChiTiet> getALlHDCTTinhTien(int idHD) {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try {
            String sql = "select Hoadon.*,HoaDonChiTiet.*,HoaDonChiTiet.DonGia*HoaDonChiTiet.SoLuong as ThanhTien,ChiTietSanPham.*,\n" +
"                    SanPham.*,thuongHieu.*,MauSac.*,KichThuoc.*,ChatLieu.* from HoaDonChiTiet\n" +
"join HoaDon on HoaDonChiTiet.IdHoaDon=HoaDon.Id\n" +
"                    join ChiTietSanPham on HoaDonChiTiet.IdSanphamCT=ChiTietSanPham.Id\n" +
"                   join SanPham on ChiTietSanPham.IdSP=SanPham.Id\n" +
"                    join thuongHieu on ChiTietSanPham.IdThuongHieu=thuongHieu.Id\n" +
"                    join MauSac on ChiTietSanPham.IdMauSac=MauSac.Id\n" +
"                    join KichThuoc on ChiTietSanPham.IdKichThuoc=KichThuoc.Id\n" +
"                    join ChatLieu on ChiTietSanPham.IdChatlieu=ChatLieu.Id\n" +
"					where HoaDon.id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1,idHD);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String Id = (rs.getString("Id"));
                SanPham sp = new SanPham(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"));
                ThuongHieu th = new ThuongHieu(rs.getInt("Id"), rs.getString("tenThuongHieu"));
                MauSac ms = new MauSac(rs.getInt("Id"), rs.getString("Ten"));
                ChatLieu cl = new ChatLieu(rs.getInt("Id"), rs.getString("Ten"));
                KichThuoc kt = new KichThuoc(rs.getInt("Id"), rs.getString("Ma"), rs.getString("size"));
                int sl = (rs.getInt("SoLuong"));
                BigDecimal donGia = (rs.getBigDecimal("DonGia"));

                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString("Id"), th, ms, cl, sp, kt);
                // ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString("Id"), sp);
                list.add(new HoaDonChiTiet(Id, ctsp, sl, donGia));

            }
        } catch (Exception e) {
            System.out.println("loi,hoa don chi tiet");
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<HoaDonChiTiet> getALlHDCTID() {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try {
            String sql = "select HoaDonChiTiet.*,HoaDonChiTiet.DonGia*HoaDonChiTiet.SoLuong as ThanhTien,ChiTietSanPham.*,\n"
                    + "SanPham.*,thuongHieu.*,MauSac.*,KichThuoc.*,ChatLieu.* from HoaDonChiTiet\n"
                    + "join ChiTietSanPham on HoaDonChiTiet.IdSanphamCT=ChiTietSanPham.Id\n"
                    + "join SanPham on ChiTietSanPham.IdSP=SanPham.Id\n"
                    + "join thuongHieu on ChiTietSanPham.IdThuongHieu=thuongHieu.Id\n"
                    + "join MauSac on ChiTietSanPham.IdMauSac=MauSac.Id\n"
                    + "join KichThuoc on ChiTietSanPham.IdKichThuoc=KichThuoc.Id\n"
                    + "join ChatLieu on ChiTietSanPham.IdChatlieu=ChatLieu.Id";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String Id = (rs.getString("Id"));
                SanPham sp = new SanPham(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"));
                ThuongHieu th = new ThuongHieu(rs.getInt("Id"), rs.getString("tenThuongHieu"));
                MauSac ms = new MauSac(rs.getInt("Id"), rs.getString("Ten"));
                ChatLieu cl = new ChatLieu(rs.getInt("Id"), rs.getString("Ten"));
                KichThuoc kt = new KichThuoc(rs.getInt("Id"), rs.getString("Ma"), rs.getString("size"));
                int sl = (rs.getInt("SoLuong"));
                BigDecimal donGia = (rs.getBigDecimal("DonGia"));

                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString("Id"), th, ms, cl, sp, kt);
                // ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString("Id"), sp);
                list.add(new HoaDonChiTiet(Id, ctsp, sl, donGia));

            }
        } catch (Exception e) {
            System.out.println("loi,hoa don chi tiet");
            e.printStackTrace();
        }
        return list;
    }

    public Integer creatGiHang(String idHoaDon, String id, BigDecimal gia, int soluong) {
        try {
            String sql = "INSERT INTO HOADONCHITIET(IDHOADON,IDSanPhamCT,DonGia,SOLUONG) VALUES(?,?,?,?)";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setObject(1, idHoaDon);
            pstm.setObject(2, id);

            pstm.setObject(3, gia);
            pstm.setObject(4, soluong);

            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

//    public Integer creatGiHang(String id, BigDecimal gia, int soluong) {
//        try {
//            String sql = "INSERT INTO HOADONCHITIET(IDSanPhamCT,DonGia,SoLuong) VALUES(?,?,?)";
//            Connection con = DBContext.getConnection();
//            PreparedStatement pstm = con.prepareCall(sql);
//            pstm.setObject(1, id);
//            pstm.setObject(2, gia);
//            pstm.setObject(3, soluong);
//            return pstm.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi creat gio hang");
//            return 0;
//        }
//    }
//           public Integer updateSL(int ID,HoaDonChiTiet hdct) {
//        Integer row = null;
//        try {
//            String sql = "update HoaDonChiTiet set SoLuong=? where Id=?";
//            Connection con = DBContext.getConnection();
//            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setInt(1,hdct.getSoLuong());
//            pstm.setInt(2, ID);
//            row = pstm.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("loi delGioHang");
//        }
//        return row;
//    }
    public Integer updateGiHang(HoaDonChiTiet hdct,String ID) {
        try {
            String sql = "update HOADONCHITIET set SoLuong=? where id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareCall(sql);
            System.out.println("SoLuognUpdate ; " +  hdct.getSoLuong());
            System.out.println("ID update : " + ID);
           pstm.setInt(1, hdct.getSoLuong());
           pstm.setString(2, ID);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi creat gio hang");
            return 0;
        }
    }

    public Integer delGioHang(String ID) {
        Integer row = null;
        try {
            String sql = "delete from HoaDonChiTiet where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi delGioHang");
        }
        return row;
    }

    public Integer delALL() {
        Integer row = null;
        try {
            String sql = "delete from HoaDonChiTiet ";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            HoaDonChiTiet ht = new HoaDonChiTiet();

            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi delGioHang");
        }
        return row;
    }

    public ArrayList<HoaDonChiTiet> getListHDCT(String ID) {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try {
            String sql = """
                         select HoaDonChiTiet.*,HoaDonChiTiet.DonGia*HoaDonChiTiet.SoLuong as ThanhTien,ChiTietSanPham.*,
                          SanPham.*,thuongHieu.*,MauSac.*,KichThuoc.*,ChatLieu.*,HoaDon.* from HoaDonChiTiet \t
                           join ChiTietSanPham on HoaDonChiTiet.IdSanphamCT=ChiTietSanPham.Id
                          join SanPham on ChiTietSanPham.IdSP=SanPham.Id
                          join thuongHieu on ChiTietSanPham.IdThuongHieu=thuongHieu.Id
                          join MauSac on ChiTietSanPham.IdMauSac=MauSac.Id
                          join KichThuoc on ChiTietSanPham.IdKichThuoc=KichThuoc.Id
                         join ChatLieu on ChiTietSanPham.IdChatlieu=ChatLieu.Id 
                         join HoaDon on HoaDonChiTiet.IdHoaDon=HoaDon.Id
                         \t\twhere HoaDon.Id=?""";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, ID);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String Id = (rs.getString("Id"));
                SanPham sp = new SanPham(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"));
                ThuongHieu th = new ThuongHieu(rs.getInt("Id"), rs.getString("tenThuongHieu"));
                MauSac ms = new MauSac(rs.getInt("Id"), rs.getString("Ten"));
                ChatLieu cl = new ChatLieu(rs.getInt("Id"), rs.getString("Ten"));
                KichThuoc kt = new KichThuoc(rs.getInt("Id"), rs.getString("Ma"), rs.getString("size"));
                int sl = (rs.getInt("SoLuong"));
                BigDecimal donGia = (rs.getBigDecimal("DonGia"));

                // ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt("Id"), th, ms, cl, sp, kt,rs.getInt("SoLuong"),rs.getString("Gia"));
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString("Id"), sp);
                list.add(new HoaDonChiTiet(Id, ctsp, sl, donGia));
            }
        } catch (Exception e) {
            System.out.println("loi,hoa don chi tiet");
            e.printStackTrace();
        }
        return list;
    }
    //2 hàm này khác j nhau  b ? 1 cais where hdct 1c la where hd
    public List<HoaDonChiTiet> getAllHoaDonChiTietByHoaDonID(String id) {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try {
            String sql = "select HoaDonChiTiet.*,HoaDonChiTiet.DonGia*HoaDonChiTiet.SoLuong as ThanhTien,ChiTietSanPham.*,\n"
                    + " SanPham.*,thuongHieu.*,MauSac.*,KichThuoc.*,ChatLieu.*,HoaDon.* from HoaDonChiTiet 	\n"
                    + "  join ChiTietSanPham on HoaDonChiTiet.IdSanphamCT=ChiTietSanPham.Id\n"
                    + " join SanPham on ChiTietSanPham.IdSP=SanPham.Id\n"
                    + " join thuongHieu on ChiTietSanPham.IdThuongHieu=thuongHieu.Id\n"
                    + " join MauSac on ChiTietSanPham.IdMauSac=MauSac.Id\n"
                    + " join KichThuoc on ChiTietSanPham.IdKichThuoc=KichThuoc.Id\n"
                    + "join ChatLieu on ChiTietSanPham.IdChatlieu=ChatLieu.Id \n"
                    + "	join HoaDon on HoaDonChiTiet.IdHoaDon=HoaDon.Id\n"
                    + "		where HoaDonChiTiet.IdHoaDon=?";
           Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String Id = (rs.getString("Id"));
                SanPham sp = new SanPham(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"));
                ThuongHieu th = new ThuongHieu(rs.getInt("Id"), rs.getString("tenThuongHieu"));
                MauSac ms = new MauSac(rs.getInt("Id"), rs.getString("Ten"));
                ChatLieu cl = new ChatLieu(rs.getInt("Id"), rs.getString("Ten"));
                KichThuoc kt = new KichThuoc(rs.getInt("Id"), rs.getString("Ma"), rs.getString("size"));
                int sl = (rs.getInt("SoLuong"));
                BigDecimal donGia = (rs.getBigDecimal("DonGia"));

                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString("Id"), th, ms, cl, sp, kt);
                // ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString("Id"), sp);
                list.add(new HoaDonChiTiet(Id, ctsp, sl, donGia));

            }
        } catch (Exception e) {
            System.out.println("loi,hoa don chi tiet");
            e.printStackTrace();
        }
        return list;
    }

    public int selectSoLuongSanPham(int id) {
        String sql = "SELECT SOLUONG FROM ChiTietSanPham WHERE ID = ?";

        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("SOLUONG");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return 0;
    }

    public Integer updateSoLuong(int sl, String id) {
        String sql = "update HOADONCHITIET set SOLUONG = ? where IDSanphamCT =?;";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setObject(1, sl);
            pstm.setObject(2, id);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return 0;
        }
    }
    
       public Integer selectSoLuongGioHangGoc(String idHoaDon, String idGiayCt) {
        String sql = "SELECT SOLUONG FROM HOADONCHITIET WHERE IDHOADON = ? AND IDSAnphamCT = ?";
        int soLuong = 0;

        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, idHoaDon);
            ps.setString(2, idGiayCt);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                soLuong = resultSet.getInt("SOLUONG");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return soLuong;
    }
}
