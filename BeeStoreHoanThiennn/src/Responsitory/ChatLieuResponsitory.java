/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Responsitory_IPL.ChatLieuIPL;
import Responsitory_IPL.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ChatLieu;
import model.KichThuoc;

/**
 *
 * @author phamt
 */
public class ChatLieuResponsitory implements ChatLieuIPL{

  
    @Override
    public ArrayList<ChatLieu> getALlChatLieu() {
        ArrayList<ChatLieu> list = new ArrayList<>();
        try {
            String sql = "Select *from ChatLieu";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
               ChatLieu cl = new ChatLieu();
                cl.setId(rs.getInt("Id"));
                cl.setTenChatlieu(rs.getString("Ten"));             
                list.add(cl);
            }
        } catch (Exception e) {
            System.out.println("loi,ChatLieu");
        }
        return list;
    }

  
    @Override
    public Integer addChatLieu(ChatLieu chatLieu) {
          Integer row = null;
        try {
            String sql = "insert into ChatLieu(Ten) values(?)";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, chatLieu.getTenChatlieu());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi add ChatLieu");
        }
        return row;
    }

    
    @Override
    public Integer updateChatLieu(ChatLieu chatLieu, int ID) {
         Integer row = null;
        try {
            String sql = "Update ChatLieu set Ten=? where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, chatLieu.getTenChatlieu());
            pstm.setInt(2,ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi add ChatLieu");
        }
        return row;


    }

 
    @Override
    public Integer delChatLieu(int ID) {
        Integer row = null;
        try {
            String sql = "delete ChatLieu where Id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, ID);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi del Chat lieu");
        }
        return row;
    }
    
}
