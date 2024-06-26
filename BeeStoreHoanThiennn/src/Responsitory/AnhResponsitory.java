/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Responsitory_IPL.AnhIPL;
import Responsitory_IPL.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Anh;
import model.ThuongHieu;

/**
 *
 * @author phamt
 */
public class AnhResponsitory implements AnhIPL{

    @Override
    public ArrayList<Anh> getALlAnh() {
          ArrayList<Anh> list = new ArrayList<>();
        try {
            String sql = "Select *from Anh";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
               Anh anh = new Anh();
                anh.setId(rs.getInt("Id"));
                anh.setIdSPCT(rs.getInt("IdSPCT"));
                 anh.setUrl(rs.getString("[URL]"));
                list.add(anh);
            }
        } catch (Exception e) {
            System.out.println("loi,Anh");
        }
        return list;
    }

    @Override
    public Integer addAnh(Anh anh) {
         Integer row = null;
        try {
            String sql = "insert into Anh(IdSPCT,[URL]) values(?,?)";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, anh.getIdSPCT());
            pstm.setString(2, anh.getUrl());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi add ThuongHieu");
        }
        return row;
    }

    @Override
    public Integer updateAnh(Anh anh, int ID) {
         Integer row = null;
        try {
            String sql = "update Anh set IdSPCT=?,[URL]=? where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, anh.getIdSPCT());
            pstm.setString(2, anh.getUrl());
            pstm.setInt(3, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi add Anh");
        }
        return row;
    }
    @Override
    public Integer delAnh(int ID) {
        Integer row = null;
        try {
            String sql = "delete from Anh where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
          
            pstm.setInt(1, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi add Anh");
        }
        return row;
    }
    
}
