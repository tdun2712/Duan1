/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Responsitory_IPL.DBContext;
import java.util.ArrayList;
import model.ThanhToan;
import java.sql.*;
/**
 *
 * @author phamt
 */
public class ThanhToanResponsitory {
     public ArrayList<ThanhToan> getALlThanhToan() {
        ArrayList<ThanhToan> list = new ArrayList<>();
        try {
            String sql = "Select *from ThanhToan";
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ThanhToan tt = new ThanhToan();
                tt.setId(rs.getInt("Id"));
                tt.setMa(rs.getString("Ma"));
                 tt.setPhuongThucTT(rs.getString("Phuongthuc"));
                list.add(tt);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi,ThanhToan");
        }
        return list;
    }
}
