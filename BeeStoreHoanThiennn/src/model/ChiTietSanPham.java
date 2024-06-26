/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class ChiTietSanPham {
    private String Id;
    private ThuongHieu th;
    private MauSac ms;
    private ChatLieu cl;   
    private SanPham sp;
    private KichThuoc kt;
    private int soLuong; 
    private String gia;
    private String moTa;

    public ChiTietSanPham(String Id, SanPham sp) {
        this.Id = Id;
        this.sp = sp;
    }

    
//    public ChiTietSanPham(String Id, ThuongHieu th, MauSac ms, ChatLieu cl, SanPham sp, KichThuoc kt, int soLuong, String gia) {
//        this.Id = Id;
//        this.th = th;
//        this.ms = ms;
//        this.cl = cl;
//        this.sp = sp;
//        this.kt = kt;
//        this.soLuong = soLuong;
//        this.gia = gia;
//    }

    public ChiTietSanPham(String Id, ThuongHieu th, MauSac ms, ChatLieu cl, SanPham sp, KichThuoc kt) {
        this.Id = Id;
        this.th = th;
        this.ms = ms;
        this.cl = cl;
        this.sp = sp;
        this.kt = kt;
    }

    public ChiTietSanPham(String Id, SanPham sp, int soLuong) {
        this.Id = Id;
        this.sp = sp;
        this.soLuong = soLuong;
    }


    public ChiTietSanPham() {
    }

    public ChiTietSanPham(SanPham sp) {
        this.sp = sp;
    }

    public ChiTietSanPham(ThuongHieu th, MauSac ms, ChatLieu cl, KichThuoc kt, int soLuong, String gia, String moTa) {
        this.th = th;
        this.ms = ms;
        this.cl = cl;
        this.kt = kt;
        this.soLuong = soLuong;
        this.gia = gia;
        this.moTa = moTa;
    }

    public ChiTietSanPham(String Id, ThuongHieu th, MauSac ms, ChatLieu cl, SanPham sp, KichThuoc kt, int soLuong, String gia, String moTa) {
        this.Id = Id;
        this.th = th;
        this.ms = ms;
        this.cl = cl;
        this.sp = sp;
        this.kt = kt;
        this.soLuong = soLuong;
        this.gia = gia;
        this.moTa = moTa;
    }

    public ChiTietSanPham(ThuongHieu th, MauSac ms, ChatLieu cl, SanPham sp, KichThuoc kt, int soLuong, String gia, String moTa) {
        this.th = th;
        this.ms = ms;
        this.cl = cl;
        this.sp = sp;
        this.kt = kt;
        this.soLuong = soLuong;
        this.gia = gia;
        this.moTa = moTa;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public ThuongHieu getTh() {
        return th;
    }

    public void setTh(ThuongHieu th) {
        this.th = th;
    }

    public MauSac getMs() {
        return ms;
    }

    public void setMs(MauSac ms) {
        this.ms = ms;
    }

    public ChatLieu getCl() {
        return cl;
    }

    public void setCl(ChatLieu cl) {
        this.cl = cl;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public KichThuoc getKt() {
        return kt;
    }

    public void setKt(KichThuoc kt) {
        this.kt = kt;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "ChiTietSanPham{" + "Id=" + Id + ", th=" + th + ", ms=" + ms + ", cl=" + cl + ", sp=" + sp + ", kt=" + kt + ", soLuong=" + soLuong + ", gia=" + gia + ", moTa=" + moTa + '}';
    }

   public Object[] toDataRowCTSP() {
        return new Object[]{sp.getMaSP(),sp.getTenSP(), ms.getTenMauSac(), th.getTenThuongHieu(), kt.getSize(), cl.getTenChatlieu(), soLuong, gia, gia, moTa};
    }
    
    public String convertChatLieutoString(int IdChatLieu){
        if (IdChatLieu==1) {
            return "Cotton";
        } else {
             return "Nhung tăm";
        }
    }
    
      public String convertThuongHieutoString(int IdThuongHieu){
        if (IdThuongHieu==1) {
            return "adidas";
        } else {
             return "routine";
        }
    }
      
       public String convertMauSactoString(int IdMauSac){
        if (IdMauSac==1) {
            return "Đen";
        }else if (IdMauSac==2) {
               return "Trắng";
           }
        else{
             return "Be";
        }
       }
        public String convertKichThuoctoString(int IdKichThuoc){
        if (IdKichThuoc==1) {
            return "S";
        }else if (IdKichThuoc==2) {
               return "M";
           }
        else{
             return "L";
        }
   }


}     

