/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;


import Responsitory_IPL.DBContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SanPham;



/**
 *
 * @author phamt
 */
public class SanPhamResponsitory {

     public ArrayList<SanPham> getALLSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            String sql = "select SanPham.Id,SanPham.Ma,SanPham.Ten from SanPham order by id desc ";
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

    public Integer addSP(SanPham sp) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        String sql = "insert into SanPham(Ma,Ten) values (?,?) ";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, sp.getMaSP());
            pstm.setString(2, sp.getTenSP());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi add sp");
        }
        return row;
    }

 public Integer updateSP(SanPham sp, String ID) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        String sql = "update SanPham set Ma=?,Ten=?where id=? ";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, sp.getMaSP());
            pstm.setString(2, sp.getTenSP());

            pstm.setString(4, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi update sp");
        }
        return row;
    }
 
 public Integer delSP(String ID) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        String sql = "delete from SanPham where id like ? ";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1,ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi del sp");
        }
        return row;
    }
 
// public List<SanPham> timKiemSanPham(String maSP) {
//        List<SanPham> lstSanPham = new ArrayList<>();
//         try {
//            String sql = "select SanPham.Ma,SanPham.Ten,SanPham.GiaBan from SanPham where Ma=?";
//            Connection con = DBContext.getConnection();
//            PreparedStatement pstm = con.prepareStatement(sql);
//            ResultSet rs = pstm.executeQuery();
//            while (rs.next()) {
//                SanPham sp = new SanPham();
//               sp.setMaSP(rs.getString("Ma"));
//                sp.setTenSP(rs.getString("Ten"));
//               sp.setGiaBan(rs.getString("GiaBan"));
//                lstSanPham.add(new SanPham(maSP, maSP, maSP));
//            }
//        } catch (Exception e) {
//            System.out.println("loi tim");
//            e.printStackTrace();
//        }
//        return lstSanPham;
//    }
  public List<SanPham> timKiemSanPham(String maSP) throws SQLException {
        List<SanPham> lstSanPham = new ArrayList<>();
        String sql = "select SanPham.Ma,SanPham.Ten,SanPham.GiaBan from SanPham where Ma=?";
       Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
        try {
            while (rs.next()) {  
                
                String tenSP = rs.getString("tenSP");
                String giaBan = rs.getString("GiaBan");   
                lstSanPham.add(new SanPham(maSP, tenSP,giaBan));
            }
        } catch (SQLException ex) {
            System.out.println("e");
          //  Logger.getLogger(SanPhamRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstSanPham;
    }
}
