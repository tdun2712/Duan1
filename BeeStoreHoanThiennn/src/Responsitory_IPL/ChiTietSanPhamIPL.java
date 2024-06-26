/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory_IPL;

import java.util.ArrayList;
import java.util.List;
import model.CTSP;
import model.ChiTietSanPham;
import model.KichThuoc;
import model.SanPham;

/**
 *
 * @author phamt
 */
public interface ChiTietSanPhamIPL {
      public ArrayList<ChiTietSanPham> getALlCTSP();
     
      public Integer addCTSP(CTSP ctsp);
      
      //public Integer addCTSP(ChiTietSanPham ctsp);
      
      public Integer updateCTSP(ChiTietSanPham ctsp, int ID);

      public Integer delCTSP(int ID );

      public List<ChiTietSanPham> Search(List<ChiTietSanPham> listsearch, String ten);
      
       
    
}
