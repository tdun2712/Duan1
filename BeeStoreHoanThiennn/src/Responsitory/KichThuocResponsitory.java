/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Responsitory_IPL.DBContext;
import Responsitory_IPL.KichThuocIPL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.KichThuoc;


/**
 *
 * @author phamt
 */
public class KichThuocResponsitory implements KichThuocIPL{

    
    @Override
    public ArrayList<KichThuoc> getALlKichThuoc() {
          ArrayList<KichThuoc> list = new ArrayList<>();
        try {
            String sql = "Select *from KichThuoc";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
               KichThuoc kt = new KichThuoc();
                kt.setId(rs.getInt("Id"));
                kt.setMa(rs.getString("Ma"));
                kt.setSize(rs.getString("size"));
                list.add(kt);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi,kich thuoc");
        }
        return list;
    }

  
    @Override
    public Integer addKichThuoc(KichThuoc kichThuoc) {
          Integer row = null;
        try {
            String sql = "insert into KichThuoc(Ma,size) values(?,?)";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, kichThuoc.getMa());
              pstm.setString(2, kichThuoc.getSize());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi add kichthuoc");
        }
        return row;
    }

   
    @Override
    public Integer updateKichThuoc(KichThuoc kichThuoc,int ID) {
        Integer row = null;
        try {
            String sql = "Update KichThuoc set Ma=?,size=? where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, kichThuoc.getMa());
             pstm.setString(2, kichThuoc.getSize());
            pstm.setInt(3, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi update KichThuoc");
        }
        return row;
    }

   
    @Override
    public Integer delKichThuoc(int ID) {
       Integer row = null;
        try {
            String sql = "delete KichThuoc where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi del kichthuoc");
        }
        return row;
    }
    }
   
