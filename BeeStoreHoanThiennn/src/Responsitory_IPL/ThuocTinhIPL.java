/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory_IPL;

import java.util.ArrayList;
import java.util.List;
import model.ChatLieu;
import model.KichThuoc;
import model.MauSac;
import model.ThuongHieu;

/**
 *
 * @author phamt
 */
public interface ThuocTinhIPL {

    List<MauSac> getAllMauSac();

    List<ThuongHieu> getAllThuongHieu();

    List<ChatLieu> getAllChatLieu();

    List<KichThuoc> getAllKichThuoc();

    String addMauSac(MauSac ms);
    
    String addKichThuoc(KichThuoc kt);
    
    String addThuongHieu(ThuongHieu th);
    
    String addChatLieu(ChatLieu cl);
   
}
