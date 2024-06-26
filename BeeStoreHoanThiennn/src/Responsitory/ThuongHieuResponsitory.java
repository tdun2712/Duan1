/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Responsitory_IPL.DBContext;
import Responsitory_IPL.ThuongHieuIPL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.KichThuoc;
import model.ThuongHieu;

/**
 *
 * @author phamt
 */
public class ThuongHieuResponsitory implements ThuongHieuIPL{

  
    @Override
    public ArrayList<ThuongHieu> getALlThuongHieu() {
          ArrayList<ThuongHieu> list = new ArrayList<>();
        try {
            String sql = "Select *from ThuongHieu";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
               ThuongHieu th = new ThuongHieu();
                th.setId(rs.getInt("Id"));
                th.setTenThuongHieu(rs.getString("tenThuongHieu"));
                list.add(th);
            }
        } catch (Exception e) {
            System.out.println("loi,ThuongHie");
        }
        return list;
    }

 
    @Override
    public Integer addThuongHieu(ThuongHieu thuongHieu) {
         Integer row = null;
        try {
            String sql = "insert into thuongHieu(tenThuongHieu) values(?)";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, thuongHieu.getTenThuongHieu());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi add ThuongHieu");
        }
        return row;

    }


    @Override
    public Integer updateThuongHieu(ThuongHieu thuongHieu, int ID) {
         Integer row = null;
        try {
            String sql = "Update thuongHieu set tenThuongHieu=? where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, thuongHieu.getTenThuongHieu());
            pstm.setInt(2, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi update ThuongHieu");
        }
        return row;
    }


    @Override
    public Integer delThuongHieu(int ID) {
       Integer row = null;
        try {
            String sql = "delete ThuongHieu where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi del ThuongHieu");
        }
        return row;
    }
    
}
