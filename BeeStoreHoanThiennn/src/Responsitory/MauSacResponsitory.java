/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Responsitory_IPL.DBContext;
import java.sql.*;
import java.util.ArrayList;
import model.MauSac;
import Responsitory_IPL.MauSacIPL;

/**
 *
 * @author phamt
 */
public class MauSacResponsitory implements MauSacIPL{

   
    @Override
    public ArrayList<MauSac> getALlMauSac() {
        ArrayList<MauSac> list = new ArrayList<>();
        try {
            String sql = "Select *from MauSac";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setId(rs.getInt("Id"));
                ms.setTenMauSac(rs.getString("Ten"));
                list.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi,mau sac");
        }
        return list;
    }

   
    @Override
    public Integer addMauSac(MauSac mauSac) {
        Integer row = null;
        try {
            String sql = "insert into MauSac(Ten) values(?)";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, mauSac.getTenMauSac());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi add mausac");
        }
        return row;
    }


    @Override
    public Integer updateMauSac(MauSac mauSac,int Id) {
        Integer row = null;
        try {
            String sql = "Update MauSac set Ten=? where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, mauSac.getTenMauSac());
           pstm.setInt(2,Id);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi update mausac");
        }
        return row;
      
    }


    public Integer delMauSac(int ID) {
        Integer row = null;

        try {
            String sql = "delete MauSac where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi del mausac");
        }
        return row;
    }

    @Override
    public MauSac getID(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
