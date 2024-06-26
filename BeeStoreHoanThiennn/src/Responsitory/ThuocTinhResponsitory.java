/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Responsitory_IPL.ThuocTinhIPL;
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
public class ThuocTinhResponsitory implements ThuocTinhIPL {

    private MauSacResponsitory msRes = new MauSacResponsitory();
    private KichThuocResponsitory ktRes = new KichThuocResponsitory();
    private ThuongHieuResponsitory thRes = new ThuongHieuResponsitory();
    private ChatLieuResponsitory clRes = new ChatLieuResponsitory();

    @Override
    public List<MauSac> getAllMauSac() {
        return msRes.getALlMauSac();
    }

    @Override
    public List<ThuongHieu> getAllThuongHieu() {
        return thRes.getALlThuongHieu();
    }

    @Override
    public List<ChatLieu> getAllChatLieu() {
        return clRes.getALlChatLieu();
    }

    @Override
    public List<KichThuoc> getAllKichThuoc() {
        return ktRes.getALlKichThuoc();
    }

    @Override
    public String addMauSac(MauSac ms) {
        if (msRes.addMauSac(ms) != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String addKichThuoc(KichThuoc kt) {
        if (ktRes.addKichThuoc(kt) != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String addThuongHieu(ThuongHieu th) {
        if (thRes.addThuongHieu(th) != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String addChatLieu(ChatLieu cl) {
        if (clRes.addChatLieu(cl) != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

  

}
