/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Responsitory_IPL.ChiTietSanPhamIPL;
import Responsitory_IPL.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CTSP;
import model.ChatLieu;
import model.ChiTietSanPham;
import model.KichThuoc;
import model.MauSac;
import model.SanPham;
import model.ThuongHieu;

/**
 *
 * @author phamt
 */
public class ChiTietSanPhamResponsitory {

    private SanPhamResponsitory spRes = new SanPhamResponsitory();
    private KichThuocResponsitory ktRes = new KichThuocResponsitory();
    private MauSacResponsitory msRes = new MauSacResponsitory();
    private ThuongHieuResponsitory thRes = new ThuongHieuResponsitory();
    private ChatLieuResponsitory clRes = new ChatLieuResponsitory();

    public ArrayList<ChiTietSanPham> getALlCTSP() {
        ArrayList<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select ChiTietSanPham.Id,thuongHieu.tenThuongHieu as tenThuongHieu , MauSac.Ten as tenMauSac,KichThuoc.size as size,ChatLieu.Ten as tenChatlieu,\n"
                    + "SANPHAM.Ma as MaSP,SANPHAM.Ten as TenSP,ChiTietSanPham.SoLuong ,ChiTietSanPham.Gia ,ChiTietSanPham.MoTa\n"
                    + "from ChiTietSanPham join SANPHAM on ChiTietSanPham.IdSP=SANPHAM.Id\n"
                    + "join thuongHieu on ChiTietSanPham.IdThuongHieu = thuongHieu.Id\n"
                    + "join MauSac on ChiTietSanPham.IdMauSac =MauSac.Id\n"
                    + "join KichThuoc on ChiTietSanPham.IdKichThuoc = KichThuoc.Id\n"
                    + "join ChatLieu on ChiTietSanPham.IdChatlieu = ChatLieu.Id\n"
                    + "order by id desc";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                String ID = (rs.getString("Id"));
                SanPham sp = new SanPham(rs.getString("MaSP"), rs.getString("TenSP"));
                KichThuoc kt = new KichThuoc(rs.getString("size"));
                MauSac ms = new MauSac(rs.getString("tenMauSac"));
                ThuongHieu th = new ThuongHieu(rs.getString("tenThuongHieu"));
                ChatLieu cl = new ChatLieu(rs.getString("tenChatlieu"));
                Integer soLuong = (rs.getInt("SoLuong"));
                String gia = (rs.getString("Gia"));
                String moTa = (rs.getString("MoTa"));
                list.add(new ChiTietSanPham(ID, th, ms, cl, sp, kt, soLuong, gia, moTa));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi,CTSP");
        }
        return list;
    }
    
    public Integer addCTSP(ChiTietSanPham ctsp) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        String sql = "insert into ChiTietSanPham(IdSP,IdKichThuoc,IdMauSac,"
                + "IdThuongHieu,IdChatlieu,SoLuong,Gia,MoTa) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, ctsp.getSp().getId());
            pstm.setInt(2, ctsp.getKt().getId());
            pstm.setInt(3, ctsp.getMs().getId());
            pstm.setInt(4, ctsp.getTh().getId());
            pstm.setInt(5, ctsp.getCl().getId());
            pstm.setInt(6, ctsp.getSoLuong());
            pstm.setString(7, ctsp.getGia());
            pstm.setString(8, ctsp.getMoTa());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("lỗi add ctsp");
        }
        return row;

    }

    public Integer delCTSP(String ID) {
        Integer row = null;
        try {
            String sql = "delete from ChiTietSanPham where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("loi delete ctsp");
        }
        return row;
    }

    public List<ChiTietSanPham> Search(List<ChiTietSanPham> listsearch, String ten) {
        List<ChiTietSanPham> list = new ArrayList<>();
        for (ChiTietSanPham ctsp : listsearch) {
            if (ctsp.getSp().getTenSP().equalsIgnoreCase(ten)) {
                list.add(ctsp);
            }
        }
        return list;
    }

    public Integer updateCTSP(ChiTietSanPham ctsp, String ID) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        String sql = "update ChiTietSanPham set IdSP=?,IdKichThuoc=?,IdMauSac=?,"
                + "IdThuongHieu=?,IdChatlieu=?,SoLuong=?,Gia=?,MoTa=? where Id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            SanPham sp = new SanPham();
            pstm.setString(1, ctsp.getSp().getId());
            pstm.setInt(2, ctsp.getKt().getId());
            pstm.setInt(3, ctsp.getMs().getId());
            pstm.setInt(4, ctsp.getTh().getId());
            pstm.setInt(5, ctsp.getCl().getId());
            pstm.setInt(6, ctsp.getSoLuong());
            pstm.setString(7, ctsp.getGia());
            pstm.setString(8, ctsp.getMoTa());
            pstm.setString(9, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi update ctsp");
        }
        return row;
    }

    public Integer UpdateSo(String IdSanPhamCT, int soLuong) {
        try {
            String sql = "update ChiTietSanPham set SOLUONG = ? WHERE ID = ?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setObject(1, soLuong);
            pstm.setObject(2, IdSanPhamCT);
            //pstm.setObject(2, ID);    
            return pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("loi,updateSo");
            e.printStackTrace();
            return 0;
        }
    }
    


}
