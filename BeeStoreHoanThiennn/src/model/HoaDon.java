/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class HoaDon {
    private String IdHD;
    private NhanVien nv;
    private KhachHang kh;
    private ThanhToan TT;
  //  private HoaDonChiTiet hdct;
    private String MaHD;
    private String NgayTaoHD;
   // private String NgayNhan;
    private String SDT;
    private String TongTien;
    private String TrangThaiHD;
    //private String DiaChi;

    public HoaDon(String IdHD, NhanVien nv, KhachHang kh, ThanhToan TT, String NgayTaoHD, String TongTien, String TrangThaiHD) {
        this.IdHD = IdHD;
        this.nv = nv;
        this.kh = kh;
        this.TT = TT;
        this.NgayTaoHD = NgayTaoHD;
        this.TongTien = TongTien;
        this.TrangThaiHD = TrangThaiHD;
    }

    public HoaDon(String IdHD) {
        this.IdHD = IdHD;
    }



    public HoaDon(String IdHD, NhanVien nv, ThanhToan TT, String MaHD, String TongTien, String TrangThaiHD) {
        this.IdHD = IdHD;
        this.nv = nv;
        this.TT = TT;
        this.MaHD = MaHD;
        this.TongTien = TongTien;
        this.TrangThaiHD = TrangThaiHD;
    }

    public HoaDon(String IdHD, NhanVien nv, KhachHang kh, ThanhToan TT, String MaHD, String NgayTaoHD, String TongTien, String TrangThaiHD) {
        this.IdHD = IdHD;
        this.nv = nv;
        this.kh = kh;
        this.TT = TT;
        this.MaHD = MaHD;
        this.NgayTaoHD = NgayTaoHD;
        this.TongTien = TongTien;
        this.TrangThaiHD = TrangThaiHD;
    }

   

    public HoaDon() {
    }
  
//    public HoaDon(int IdHD, NhanVien nv, KhachHang kh, ThanhToan TT, String MaHD, String NgayTaoHD, String NgayNhan, String SDT, String TongTien, String TrangThaiHD, String DiaChi) {
//        this.IdHD = IdHD;
//        this.nv = nv;
//        this.kh = kh;
//        this.TT = TT;
//        this.MaHD = MaHD;
//        this.NgayTaoHD = NgayTaoHD;
//        this.NgayNhan = NgayNhan;
//        this.SDT = SDT;
//        this.TongTien = TongTien;
//        this.TrangThaiHD = TrangThaiHD;
//        this.DiaChi = DiaChi;
//    }

    public HoaDon(String IdHD, NhanVien nv, KhachHang kh, ThanhToan TT, String MaHD, String NgayTaoHD, String SDT, String TongTien, String TrangThaiHD) {
        this.IdHD = IdHD;
        this.nv = nv;
        this.kh = kh;
        this.TT = TT;
        this.MaHD = MaHD;
        this.NgayTaoHD = NgayTaoHD;
        this.SDT = SDT;
        this.TongTien = TongTien;
        this.TrangThaiHD = TrangThaiHD;
    }

    public String getIdHD() {
        return IdHD;
    }

    public void setIdHD(String IdHD) {
        this.IdHD = IdHD;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public ThanhToan getTT() {
        return TT;
    }

    public void setTT(ThanhToan TT) {
        this.TT = TT;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getNgayTaoHD() {
        return NgayTaoHD;
    }

    public void setNgayTaoHD(String NgayTaoHD) {
        this.NgayTaoHD = NgayTaoHD;
    }

//    public String getNgayNhan() {
//        return NgayNhan;
//    }
//
//    public void setNgayNhan(String NgayNhan) {
//        this.NgayNhan = NgayNhan;
//    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }

    public String getTrangThaiHD() {
      //  return TrangThaiHD;
       if (this.TrangThaiHD.equalsIgnoreCase("Đã thanh toán")) {
            return "Đã thanh toán";
        } else if(this.TrangThaiHD.equalsIgnoreCase("Chưa thanh toán")){
         return "Chưa thanh toán";
        }
       else {
            return "Hủy hóa đơn";
            
        }
    }

    public void setTrangThaiHD(String TrangThaiHD) {
        this.TrangThaiHD = TrangThaiHD;
    }

//    public String getDiaChi() {
//        return DiaChi;
//    }
//
//    public void setDiaChi(String DiaChi) {
//        this.DiaChi = DiaChi;
//    }

    @Override
    public String toString() {
        return "HoaDon{" + "IdHD=" + IdHD + ", nv=" + nv + ", kh=" + kh + ", TT=" + TT + ", MaHD=" + MaHD + ", NgayTaoHD=" + NgayTaoHD + ", SDT=" + SDT + ", TongTien=" + TongTien + ", TrangThaiHD=" + TrangThaiHD + '}';
    }

   
    

  
}
