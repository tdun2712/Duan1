/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Responsitory.ChiTietSanPhamResponsitory;
import Responsitory.HoaDonChiTietResponsitory;
import Responsitory.HoaDonResponsitory;
import Responsitory.KhachHangResponsity;
import Responsitory.KhuyenMaiResponsitory;
import Responsitory.NhanVienResponsitory;
import Responsitory.ThanhToanResponsitory;
import Responsitory.ThuocTinhResponsitory;
import Responsitory_IPL.ThuocTinhIPL;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.print.Doc;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import model.ChatLieu;
import model.ChiTietSanPham;
import model.GioHang;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.KhachHang;
import model.KhuyenMai;
import model.KichThuoc;
import model.MauSac;
import model.NhanVien;
import model.SanPham;
import model.ThanhToan;
import model.ThuongHieu;

/**
 *
 * @author phamt
 */
public class ViewBanHang extends javax.swing.JFrame {

    DefaultTableModel modelDSHD = new DefaultTableModel();
    DefaultTableModel modelGioHang = new DefaultTableModel();
    DefaultTableModel modelDSSP = new DefaultTableModel();
     DefaultTableModel modelKH = new DefaultTableModel();
    private final ChiTietSanPhamResponsitory ctspRes = new ChiTietSanPhamResponsitory();
    private HoaDonResponsitory hdRes = new HoaDonResponsitory();
    private final HoaDonChiTietResponsitory hdctRes = new HoaDonChiTietResponsitory();
    private ArrayList<ChiTietSanPham> listCTSP = new ArrayList<>();
    private DefaultComboBoxModel modelCboNhanVien = new DefaultComboBoxModel<>();
    private List<NhanVien> listnv = new ArrayList<>();
    private final NhanVienResponsitory nvRes = new NhanVienResponsitory();
    private DefaultComboBoxModel modelCboTT = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelCboKH = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelCboKM = new DefaultComboBoxModel<>();
    private List<ThanhToan> listTT = new ArrayList<>();
    private List<KhachHang> listKH = new ArrayList<>();
    private final ThanhToanResponsitory ttRes = new ThanhToanResponsitory();
    private final KhachHangResponsity khRes = new KhachHangResponsity();
    private ArrayList<HoaDon> listHD = new ArrayList<>();
    private ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
    private HoaDon hd = new HoaDon();
    private HoaDonChiTiet hdct = new HoaDonChiTiet();
    private DefaultComboBoxModel modelSearchMS = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelSearchTH = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelSearchKT = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelSearchCL = new DefaultComboBoxModel<>();
    private String regexInt = "[0-9]+";
    private List<MauSac> listms = new ArrayList<>();
    private List<ThuongHieu> listth = new ArrayList<>();
    private List<ChatLieu> listcl = new ArrayList<>();
    private List<KichThuoc> listkt = new ArrayList<>();
    private List<KhuyenMai> listkm = new ArrayList<>();
    private ThuocTinhIPL ttIPL = new ThuocTinhResponsitory();
    private ArrayList<GioHang> listGioHang = new ArrayList<>();
    private final KhuyenMaiResponsitory kmRes = new KhuyenMaiResponsitory();

    public ViewBanHang() {
        initComponents();
        // setLocationRelativeTo(this);
        //  setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1550, 800);
        modelDSSP = (DefaultTableModel) tblDSSP.getModel();
        loadDataToTableSP();

        modelGioHang = (DefaultTableModel) tblGioHang.getModel();
        //  modelGioHang.setRowCount(0);
        //loadDatatoTableGioHang();

        modelDSHD = (DefaultTableModel) tblDSHD.getModel();
        loadTableToHoaDon();

        cboNV.setModel(modelCboNhanVien);
        listnv = nvRes.getALlNhanVien();
        loadComboNV(listnv);

        cboTT.setModel(modelCboTT);
        listTT = ttRes.getALlThanhToan();
        loadComboTT(listTT);

        cboKH.setModel(modelCboKH);
        listKH = khRes.getAllKhachHang();
        loadComboKH(listKH);

        cboKM.setModel(modelCboKM);
        listkm = kmRes.getAllKhuyenMaiDangHD();
        loadComboKM(listkm);

        colume();
    }

    private void resertHD() {
        txtMaHD.setText("");
        txtNgayTao.setText("");
        txtNgayTao.setText("");
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
        txtTongTien.setText("");
        txtTien.setText("");
        cboKM.setSelectedItem(0);

    }

    private void colume() {
        TableColumnModel column = tblGioHang.getColumnModel();
        column.getColumn(0).setPreferredWidth(1); // Đặt độ rộng cho cột 0 là 100 pixels
        column.getColumn(1).setPreferredWidth(20);
        column.getColumn(2).setPreferredWidth(20);
        column.getColumn(3).setPreferredWidth(20);
        column.getColumn(4).setPreferredWidth(8);
        column.getColumn(5).setPreferredWidth(5);
        column.getColumn(6).setPreferredWidth(15);
        column.getColumn(7).setPreferredWidth(15);
    }
//day 

    private void loadComboKM(List<KhuyenMai> list) {
        modelCboKM.removeAllElements();
        modelCboKM.addElement("");
        for (KhuyenMai km : list) {
            modelCboKM.addElement(km.getTenKM());

        }
    }

    private void loadComboNV(List<NhanVien> list) {
        modelCboNhanVien.removeAllElements();
        for (NhanVien nv : list) {
            modelCboNhanVien.addElement(nv.getTenNV());

        }
    }

    private void loadComboTT(List<ThanhToan> list) {
        modelCboTT.removeAllElements();
        for (ThanhToan tt : list) {
            modelCboTT.addElement(tt.getPhuongThucTT());

        }
    }

    private void loadComboKH(List<KhachHang> list) {
        modelCboKH.removeAllElements();
        for (KhachHang tt : list) {
            modelCboKH.addElement(tt.getTenKH());

        }
    }
  private void showDataKH(List<KhachHang> listKH) {
        modelKH.setRowCount(0);
        int i = 1;
        for (KhachHang kt : listKH) {
            modelKH.addRow(new Object[]{
                i, kt.getTenKH()
            });
            i++;
        }
    }
    private void loadDataToTableSP() {
        ArrayList<ChiTietSanPham> listCTSP = ctspRes.getALlCTSP();
        modelDSSP.setRowCount(0);
        for (ChiTietSanPham ctsp : listCTSP) {
            modelDSSP.addRow(new Object[]{
                ctsp.getSp().getMaSP(),
                ctsp.getSp().getTenSP(),
                ctsp.getTh().getTenThuongHieu(),
                ctsp.getMs().getTenMauSac(),
                ctsp.getKt().getSize(),
                ctsp.getSoLuong(),
                ctsp.getGia()

            });
        }
    }

    private void loadDatatoTableGioHang() {
        ArrayList<HoaDonChiTiet> listHDCT = hdctRes.getALlHDCT();

        modelGioHang.setRowCount(0);
        for (HoaDonChiTiet hdct : listHDCT) {
            modelGioHang.addRow(new Object[]{
                //    hdct.getHd().getIdHD(),
                hdct.getCtsp().getSp().getMaSP(),
                hdct.getCtsp().getSp().getTenSP(),
                hdct.getCtsp().getTh().getTenThuongHieu(),
                hdct.getCtsp().getMs().getTenMauSac(),
                hdct.getCtsp().getKt().getSize(),
                hdct.getSoLuong(),
                hdct.getGia(),
                hdct.TongTien()});
        }
    }
//    private void loadDatatoTableGioHangggg(String ID) {
//      ArrayList<HoaDonChiTiet> listHDCT = hdctRes.getALlHDCTTTT(ID);
//     
//        modelGioHang.setRowCount(0);
//        for (HoaDonChiTiet hdct : listHDCT) {
//            modelGioHang.addRow(new Object[]{
//                //    hdct.getHd().getIdHD(),
//                hdct.getCtsp().getSp().getMaSP(),
//                hdct.getCtsp().getSp().getTenSP(),
//                hdct.getCtsp().getTh().getTenThuongHieu(),
//               hdct.getCtsp().getMs().getTenMauSac(),
//                hdct.getCtsp().getKt().getSize(),
//                hdct.getSoLuong(),
//                hdct.getGia(),
//                hdct.TongTien()});
//        }
//    }

    private void loadTableToHoaDon() {
        ArrayList<HoaDon> listHD = hdRes.getAllHDCho();
        // ArrayList<HoaDon> listHD = hdRes.getAllHD();
        modelDSHD = (DefaultTableModel) tblDSHD.getModel();
        modelDSHD.setRowCount(0);
        for (HoaDon hd : listHD) {
            modelDSHD.addRow(new Object[]{
                hd.getIdHD(),
                hd.getNv().getMaNV(),
                hd.getNv().getTenNV(),
                hd.getKh().getTenKH(),
                hd.getTongTien(),
                hd.getKh().getSDT(),
                hd.getNgayTaoHD(),
                // hd.getTrangThaiHD(),
                hd.getTT().getPhuongThucTT()
            });
        }
    }

    public void getListHDCTtoGH(String Id) {
        modelGioHang = (DefaultTableModel) tblGioHang.getModel();
        modelGioHang.setRowCount(0);
        List<HoaDonChiTiet> list = hdctRes.getListHDCT(Id);
        if (list.isEmpty()) {
            return;
        }
        for (HoaDonChiTiet hdctiet : list) {
            GioHang gh = new GioHang();
            gh.setMaSP(hdctiet.getCtsp().getSp().getMaSP());
            gh.setTenSP(hdctiet.getCtsp().getSp().getTenSP());
            gh.setSoLuong(hdctiet.getSoLuong());
            gh.setGia(hdctiet.getGia());
            gh.getThanhTien();
            listGioHang.add(gh);
            showDataGioHang(Id);
            //loadDatatoTableGioHang();
        }
    }

    private void loadTableSearch(ChiTietSanPham spct) {
        modelDSSP.addRow(new Object[]{
            spct.getSp().getMaSP(),
            spct.getSp().getTenSP(),
            spct.getTh().getTenThuongHieu(),
            spct.getMs().getTenMauSac(),
            spct.getKt().getSize(),
            spct.getSoLuong(),
            spct.getGia()
        }
        );
    }

    private HoaDon getfromHoaDon() {
        hd.setNv(listnv.get(this.cboNV.getSelectedIndex()));
        hd.setKh(listKH.get(this.cboKH.getSelectedIndex()));
        hd.setTT(listTT.get(this.cboTT.getSelectedIndex()));
        hd.setNgayTaoHD(this.txtNgayTao.getText());
        hd.setTongTien(this.txtTongTien.getText());
        return hd;
    }

    private void showHoaDon() {
        int index = tblDSHD.getSelectedRow();
        txtMaHD.setText(tblDSHD.getValueAt(index, 0).toString());
        cboNV.setSelectedItem(tblDSHD.getValueAt(index, 2));
        cboKH.setSelectedItem(tblDSHD.getValueAt(index, 3));
        txtTongTien.setText((String) tblDSHD.getValueAt(index, 4));
        txtNgayTao.setText((String) tblDSHD.getValueAt(index, 6));
        cboTT.setSelectedItem(tblDSHD.getValueAt(index, 7));
    }

    private void updateSoLuongSP(int i, int soLuong) {
        int index = tblDSSP.getSelectedRow();
        int soLuongChon = Integer.parseInt(tblDSSP.getValueAt(index, 5).toString());
        int updateSoLuong = soLuongChon - soLuong;
        ctspRes.UpdateSo(listCTSP.get(index).getId(), updateSoLuong);

    }

    private void tinhVaTruTongTien() {
        List<HoaDonChiTiet> listHd = hdctRes.getALlHDCT();
        BigDecimal tongTienHoaDon = BigDecimal.ZERO;
        for (HoaDonChiTiet hdct : listHd) {
            tongTienHoaDon = tongTienHoaDon.subtract(hdct.ThanhTien());
        }
        txtTongTien.setText(tongTienHoaDon.toString());

    }

//    private BigDecimal tinhVaThemTongTien(int columnIndex) {
//        BigDecimal tongTien = BigDecimal.ZERO;
//        int rowCount = tblGioHang.getRowCount();
//
//        for (int i = 0; i < rowCount; i++) {
//            BigDecimal giaTien = new BigDecimal(tblGioHang.getValueAt(i, columnIndex).toString());
//            tongTien = tongTien.add(giaTien);
//            txtTongTien.setText(tongTien.toString());
//            //lblTongTien1.setText(tongTien.toString());
//        }
//        return tongTien;
//    }
    public void showGioHang() {
        int index = tblGioHang.getSelectedRow();
        txtTongTien.setText(tblGioHang.getValueAt(index, 4).toString());
    }

    private void tinhVaThemTongTienn(String idHD) {
        //    List<HoaDonChiTiet> listHDCT = hdctRes.getALlHDCT();
        int row = tblDSHD.getSelectedRow();
        List<HoaDonChiTiet> listHDCT = hdctRes.getALlHDCTTinhTien(row);
        BigDecimal tongTienHoaDon = BigDecimal.ZERO;
        for (HoaDonChiTiet hdct : listHDCT) {
            tongTienHoaDon = tongTienHoaDon.add(hdct.ThanhTien());
        }
        txtTongTien.setText(tongTienHoaDon.toString());
    }

    private void tinhVaThemTongTien() {
        List<HoaDonChiTiet> listHDCT = hdctRes.getALlHDCT();
        BigDecimal tongTienHoaDon = BigDecimal.ZERO;
        for (HoaDonChiTiet hdct : listHDCT) {
            tongTienHoaDon = tongTienHoaDon.add(hdct.ThanhTien());
        }
        txtTongTien.setText(tongTienHoaDon.toString());
    }

    private String tongTienHoaDon() {
        int row = this.tblDSHD.getSelectedRow();
        //Lại phải code theo thnawfg đần =))
        ArrayList<HoaDon> listHD = hdRes.getAllHDCho();
        HoaDon hoadon = listHD.get(row);
        Double tongTien = 0.00;
        listHDCT = (ArrayList<HoaDonChiTiet>) hdctRes.getAllHoaDonChiTietByHoaDonID(hoadon.getIdHD());

        for (HoaDonChiTiet hd : listHDCT) {
            System.out.println(hd.getGia());
            tongTien += Double.valueOf(String.valueOf(hd.getGia())) * hd.getSoLuong();
        }
        hoadon.setTongTien(tongTien.toString());
        System.out.println(hoadon.getTongTien());

        hdRes.updateTongTienHoaDon(hoadon);
        txtTongTien.setText(tongTien.toString());
        loadTableToHoaDon();
        return String.valueOf(tongTien);

    }

    private void loadCboSearchMS(List<MauSac> list) {
        modelSearchMS.removeAllElements();
        for (MauSac msac : list) {
            modelSearchMS.addElement(msac.getTenMauSac());

        }
    }

    private void loadCboSearchTH(List<ThuongHieu> list) {
        modelSearchTH.removeAllElements();
        for (ThuongHieu th : list) {
            modelSearchTH.addElement(th.getTenThuongHieu());

        }
    }

    private void loadCboSearchCL(List<ChatLieu> list) {
        modelSearchCL.removeAllElements();
        for (ChatLieu cl : list) {
            modelSearchCL.addElement(cl.getTenChatlieu());
        }
    }

    private void loadCboSearchKT(List<KichThuoc> list) {
        modelSearchKT.removeAllElements();
        for (KichThuoc kt : list) {
            modelSearchKT.addElement(kt.getSize());
        }
    }

    private void showDataGioHang(String id) {
        try {
            listHDCT = (ArrayList<HoaDonChiTiet>) hdctRes.getAllHoaDonChiTietByHoaDonID(id);
            DefaultTableModel dtm = (DefaultTableModel) this.tblGioHang.getModel();
            dtm.setRowCount(0);
            for (HoaDonChiTiet hdct : listHDCT) {
                Object[] rowData = {
                    hdct.getCtsp().getSp().getMaSP(),
                    hdct.getCtsp().getSp().getTenSP(),
                    hdct.getCtsp().getTh().getTenThuongHieu(),
                    hdct.getCtsp().getMs().getTenMauSac(),
                    hdct.getCtsp().getKt().getSize(),
                    hdct.getSoLuong(),
                    hdct.getGia(),
                    hdct.ThanhTien()
                };
                dtm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi showData");
        }
    }

    private void inHD() {
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        String MaHD = txtMaHD.getText();
        String NgayTao = txtNgayTao.getText();
        String TenNV = (String) cboNV.getSelectedItem();
        String TenKh = (String) cboKH.getSelectedItem();
        String TongTien = txtTongTien.getText();
        String tienthua = txtTienThua.getText();
        String hinhThucTT = (String) cboTT.getSelectedItem();
        String tienKhachDua = txtTienKhachDua.getText();
        String tienSauGiam = txtTien.getText();
        String Voucher = (String) cboKM.getSelectedItem();
        try (FileOutputStream fileOutputStream = new FileOutputStream(path + "hoadon.pdf")) {
            Document document = new Document();
            PdfWriter.getInstance(document, fileOutputStream);
            document.open();
            document.add(new Paragraph("                                             HOA DON                                "));
            document.add(new Paragraph("Ma HD:   " + MaHD));
            document.add(new Paragraph("Ngay tao:       " + NgayTao));
            document.add(new Paragraph("TenNV:      " + TenNV));
            document.add(new Paragraph("TenKH:      " + TenKh));
            document.add(new Paragraph("Tong tien:   " + TongTien));
            document.add(new Paragraph("Ten voucher:  " + Voucher));
            document.add(new Paragraph("Tien can tra:  " + tienSauGiam));
            document.add(new Paragraph("Tien khach dua:" + tienKhachDua));
            document.add(new Paragraph("Tien thua:        " + tienthua));
            document.add(new Paragraph("Hinh thuc TT:  " + hinhThucTT));
            document.add(new Paragraph("                              "));
            PdfPTable tbl = new PdfPTable(8);
            tbl.addCell("Ma SP");
            tbl.addCell("Ten SP");
            tbl.addCell("Thuong hieu");
            tbl.addCell("Mau sac");
            tbl.addCell("Kich thuoc");
            tbl.addCell("So luong");
            tbl.addCell("Don gia");
            tbl.addCell("Thanh tien");
            for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                String Ma = (String) tblGioHang.getValueAt(i, 0);
                String Ten = (String) tblGioHang.getValueAt(i, 1);
                String Thuonghieu = (String) tblGioHang.getValueAt(i, 2);
                String Mausac = (String) tblGioHang.getValueAt(i, 3);
                String Kichthuoc = (String) tblGioHang.getValueAt(i, 4);
                int SoLuong = (int) tblGioHang.getValueAt(i, 5);
                // String DonGia = (String) tblGioHang.getValueAt(i, 6);
                BigDecimal DonGia = (BigDecimal) tblGioHang.getValueAt(i, 6);
//                String ThanhTien = (String) tblGioHang.getValueAt(i, 7);
                BigDecimal ThanhTien = (BigDecimal) tblGioHang.getValueAt(i, 7);

                tbl.addCell(Ma);
                tbl.addCell(Ten);
                tbl.addCell(Thuonghieu);
                tbl.addCell(Mausac);
                tbl.addCell(Kichthuoc);
                tbl.addCell(String.valueOf(SoLuong));
                //tbl.addCell(DonGia);
                tbl.addCell(String.valueOf(DonGia));
                tbl.addCell(String.valueOf(ThanhTien));
            }
            document.add(tbl);

            document.close();
            JOptionPane.showMessageDialog(null, "In hóa đơn thành công.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi tạo PDF.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSHD = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSSP = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnDel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTong = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        cboTT = new javax.swing.JComboBox<>();
        btnThanhToan = new javax.swing.JButton();
        btnTaoHD = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cboNV = new javax.swing.JComboBox<>();
        btnHuy = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cboKH = new javax.swing.JComboBox<>();
        btnKH = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cboKM = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtTien = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnThongKe1 = new javax.swing.JButton();
        btnSanPham2 = new javax.swing.JButton();
        btnNhanVien2 = new javax.swing.JButton();
        btnBanHang2 = new javax.swing.JButton();
        btnKH3 = new javax.swing.JButton();
        btnLichSu3 = new javax.swing.JButton();
        btnKM2 = new javax.swing.JButton();
        btnDangXuat2 = new javax.swing.JButton();
        btnThuocTinhSP2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ứng dụng bán quần áo");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Danh sách sản phẩm");

        tblDSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã NV", "Tên NV", "Tên KH", "Tổng tiền", "SDT", "Ngày tạo", "Hình thức TT"
            }
        ));
        tblDSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSHD);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Danh sách hóa đơn chờ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Giỏ hàng");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Thương hiêu", "Màu sắc", "Kích thước", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGioHang);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Thương hiệu", "Màu sắc", "Kích cỡ", "Số lượng", "Đơn giá"
            }
        ));
        tblDSSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSSP);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Tìm kiếm:");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btnDel.setText("Xóa sản phẩm");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Hóa Đơn");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên nhân viên");

        lblTong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTong.setText("Tổng tiền");

        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tiền khách đưa");

        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tiền thừa");

        txtTienThua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienThuaActionPerformed(evt);
            }
        });

        cboTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Payment.png"))); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Database.png"))); // NOI18N
        btnTaoHD.setText("Tạo hóa đơn");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Hình thức TT");

        cboNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnHuy.setText("Hủy ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên KH");

        cboKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnKH.setText("+");
        btnKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKHActionPerformed(evt);
            }
        });

        jLabel13.setText("Ngày tạo");

        jLabel14.setText("Mã HD");

        txtMaHD.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Mã voucher");

        cboKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKMActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Tiền cần trả");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTong, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaHD)
                                    .addComponent(cboNV, 0, 123, Short.MAX_VALUE)
                                    .addComponent(txtTongTien)
                                    .addComponent(cboKM, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnKH)
                                        .addGap(1, 1, 1)
                                        .addComponent(cboKH, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel17))
                                .addGap(25, 25, 25)
                                .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(cboTT, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnTaoHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThanhToan))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cboKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 204, 102));
        jPanel8.setMaximumSize(new java.awt.Dimension(186, 652));
        jPanel8.setMinimumSize(new java.awt.Dimension(186, 652));

        btnThongKe1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThongKe1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Statistics.png"))); // NOI18N
        btnThongKe1.setText("Thống kê");
        btnThongKe1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongKe1MouseClicked(evt);
            }
        });
        btnThongKe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKe1ActionPerformed(evt);
            }
        });

        btnSanPham2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSanPham2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Basket.png"))); // NOI18N
        btnSanPham2.setText("Sản phẩm");
        btnSanPham2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPham2ActionPerformed(evt);
            }
        });

        btnNhanVien2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhanVien2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User group.png"))); // NOI18N
        btnNhanVien2.setText("Nhân viên");
        btnNhanVien2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVien2ActionPerformed(evt);
            }
        });

        btnBanHang2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBanHang2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Print.png"))); // NOI18N
        btnBanHang2.setText("Bán Hàng");
        btnBanHang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHang2ActionPerformed(evt);
            }
        });

        btnKH3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKH3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clien list.png"))); // NOI18N
        btnKH3.setText("Khách hàng");
        btnKH3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKH3ActionPerformed(evt);
            }
        });

        btnLichSu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLichSu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Lists.png"))); // NOI18N
        btnLichSu3.setText("Hóa đơn");
        btnLichSu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichSu3ActionPerformed(evt);
            }
        });

        btnKM2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKM2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Coins.png"))); // NOI18N
        btnKM2.setText("Voucher");
        btnKM2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKM2ActionPerformed(evt);
            }
        });

        btnDangXuat2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangXuat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Log out.png"))); // NOI18N
        btnDangXuat2.setText("Đăng xuất");
        btnDangXuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuat2ActionPerformed(evt);
            }
        });

        btnThuocTinhSP2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThuocTinhSP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Full basket.png"))); // NOI18N
        btnThuocTinhSP2.setText("Thuộc tính");
        btnThuocTinhSP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuocTinhSP2ActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Goudy Old Style", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("Bee store");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnKM2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKH3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDangXuat2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNhanVien2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLichSu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBanHang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThuocTinhSP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSanPham2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThongKe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSanPham2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThuocTinhSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLichSu3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKH3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKM2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDangXuat2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        String search = txtTimKiem.getText();
        modelDSSP.setRowCount(0);
        listCTSP = ctspRes.getALlCTSP();
        for (ChiTietSanPham spct : listCTSP) {
            String regex = ".*" + Pattern.quote(search) + ".*";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(spct.getSp().getTenSP());
            Matcher MS = pattern.matcher(spct.getMs().getTenMauSac());
            Matcher CL = pattern.matcher(spct.getCl().getTenChatlieu());
            Matcher KT = pattern.matcher(spct.getKt().getKichThuoc());
            if (matcher.matches()
                    || MS.matches()
                    || CL.matches()
                    || KT.matches()) {
                loadTableSearch(spct);
            }
        }
    }//GEN-LAST:event_txtTimKiemKeyTyped
    private Date getDate() {
        return new Date();
    }


    private void tblDSSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSPMouseClicked
//        showHoaDon();
        int check = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm vào giỏ hàng");
        int row = tblDSSP.getSelectedRow();
        int rowHD = tblDSHD.getSelectedRow();
        listCTSP = ctspRes.getALlCTSP();
        listHD = hdRes.getAllHD();
        if (txtMaHD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn trước khi thêm sản phẩm vào giỏ");
            return;
        } else {
            if (check == JOptionPane.YES_OPTION) {
                Integer sp = Integer.valueOf(tblDSSP.getValueAt(row, 5).toString());
                if (sp > 0) {
                    if (row >= 0) {
                        String soLuong = JOptionPane.showInputDialog(null, "Nhập số lượng bạn muốn thêm");
                        int checkSL = 0;
                        try {
                            checkSL = Integer.parseInt(soLuong);

                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this, "Nhập số lượng ở dạng số");

                        }
                        if (soLuong.equals("")) {
                            JOptionPane.showMessageDialog(this, "Nhập số lượng muốn thêm");
                            return;
                        }
                        if (checkSL < 1) {
                            JOptionPane.showMessageDialog(this, "số lượng phải > 0");
                        } else if (checkSL > sp) {
                            JOptionPane.showMessageDialog(this, "Không đủ sản phẩm");
                        } else {
                            if (soLuong != null && !soLuong.isEmpty()) {
                                int selectedRow = tblDSHD.getSelectedRow();
                                String IdHoaDon = tblDSHD.getValueAt(selectedRow, 0).toString();
                                String donGia = tblDSSP.getValueAt(row, 6).toString();
                                System.out.println(IdHoaDon);
//                                
//                                HoaDon indexHoaDon = listHD.get(selectedRow);
//                                String idHoaDon = indexHoaDon.getIdHD();
//                                HoaDon hoaDon = listHD.get(rowHD);
                                ChiTietSanPham ctsp = listCTSP.get(row);
//
//                                HoaDon indexHD = listHD.get(selectedRow);
                                int soluongGioHang = Integer.parseInt(soLuong);
//                                hdctRes.creatGiHang(hoaDon.getIdHD(), ctsp.getId(), new BigDecimal(donGia), soluongGioHang);
                                hdctRes.creatGiHang(IdHoaDon, ctsp.getId(), new BigDecimal(donGia), soluongGioHang);
                                loadDatatoTableGioHang();
                                updateSoLuongSP(row, soluongGioHang);

                                //  tinhVaThemTongTienn(IdHoaDon);
//                                tinhVaThemTongTien();
                                tongTienHoaDon();

                                showDataGioHang(IdHoaDon);
//                                loadDatatoTableGioHang();
                                loadDataToTableSP();
                                JOptionPane.showMessageDialog(this, "Thêm Thành Công Vào Giỏ");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Chọn một sản phẩm trước khi thêm vào giỏ.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Hết Hàng");
                }
            }
        }

    }//GEN-LAST:event_tblDSSPMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked

    }//GEN-LAST:event_tblGioHangMouseClicked


    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int index = tblGioHang.getSelectedRow();
        int row = tblDSHD.getSelectedRow();
        int quantity = (int) tblGioHang.getValueAt(index, 5);
        String Id = tblDSHD.getValueAt(row, 0).toString();
        listHDCT = (ArrayList<HoaDonChiTiet>) hdctRes.getAllHoaDonChiTietByHoaDonID(Id);

        System.out.println("So luong: " + quantity);
        System.out.println("ID " + listHDCT.get(index).getId());
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa sản phẩm này khỏi giỏ hàng");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        listGioHang.clear();

        String IdHDCT = listHDCT.get(index).getId();
        System.out.println(IdHDCT);
        if (hdctRes.delGioHang(IdHDCT) > 0) {
            JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công");
            tongTienHoaDon();
            showDataGioHang(Id);
            loadDataToTableSP();
//            ctspRes.UpdateSo(listCTSP.get(index).getId(), listCTSP.get(index).getSoLuong());
        } else {
            JOptionPane.showMessageDialog(this, "Không xóa được sản phẩm");
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void tblDSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSHDMouseClicked
        showHoaDon();
//        int row = tblDSHD.getSelectedRow();
//        if (row < 0) {
//            return;
//        }
//        listGioHang.clear();
//        String Id = tblDSHD.getValueAt(row, 0).toString();
//        try {
//            getListHDCTtoGH(Id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        int row = tblDSHD.getSelectedRow();
        if (row < 0) {
            return;
        }
        listGioHang.clear();
        String Id = tblDSHD.getValueAt(row, 0).toString();
        try {
            System.out.println("ID hoadon: " + Id);
            showDataGioHang(Id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblDSHDMouseClicked


    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        try {
            String tienKh = txtTienKhachDua.getText();
            if (tienKh.startsWith("0")) {
                txtTienKhachDua.setText(tienKh.replace("0", ""));
            }
//            String tongTien = txtTongTien.getText();
            String tongTien = txtTien.getText();
            Float tienThua = Float.valueOf("0");
            if (!tienKh.isBlank()) {
                tienThua = Float.valueOf(tongTien) - Float.valueOf(tienKh);
            }
            txtTienThua.setText(tienThua + "");
        } catch (Exception e) {
            txtTienKhachDua.setText("0");
        }
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void txtTienThuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienThuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThuaActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int index = tblDSHD.getSelectedRow();
        HoaDon hd = getfromHoaDon();
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thanh toán hóa đơn này");
        if (hoi != JOptionPane.YES_OPTION) {
            return;
        }

                String tienkhachdua = txtTienKhachDua.getText();
                String tong = txtTien.getText();
                float chekTong = Float.parseFloat(tong);
                float chekTien = Float.parseFloat(tienkhachdua);
                if (chekTien < chekTong) {
                    JOptionPane.showMessageDialog(this, "Số tiền khách đưa không đủ");
                    return;
                }
        this.hd.setTrangThaiHD("Đã thanh toán");
        String ID = hdRes.getAllHDCho().get(index).getIdHD();
        if (hdRes.updateHoaDon(hd, ID) > 0) {
            JOptionPane.showMessageDialog(this, " Thanh toán thành công");
            loadTableToHoaDon();

            int inHD = JOptionPane.showConfirmDialog(this, "Bạn có muốn in hóa đơn?");
            if (inHD != JOptionPane.YES_OPTION) {
                return;
            }
            inHD();
            modelGioHang.setRowCount(0);
            resertHD();
        } else {
            JOptionPane.showMessageDialog(this, "Không thanh toán được");
        }
        loadTableToHoaDon();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        HoaDon hd = getfromHoaDon();
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn tạo hóa đơn mới không");
        if (hoi != JOptionPane.YES_OPTION) {
            return;
        }
        //        if (txtTienKhachDua.getText().isEmpty()) {
        //            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền khách đưa");
        //            return;
        //        }

        this.hd.setTrangThaiHD("Chưa thanh toán");
        if (hdRes.addHoaDon(hd) != null) {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn mới thành công");
            loadTableToHoaDon();
        } else {
            JOptionPane.showMessageDialog(this, "Không tạo được hóa đơn mới");
        }
        loadTableToHoaDon();
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        int index = tblDSHD.getSelectedRow();
        HoaDon hd = getfromHoaDon();
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn hủy hóa đơn này");
        if (hoi != JOptionPane.YES_OPTION) {
            return;
        }
        this.hd.setTrangThaiHD("Hủy hóa đơn");
        String ID = hdRes.getAllHD().get(index).getIdHD();
        if (hdRes.updateHoaDon(hd, ID) != null) {

            JOptionPane.showMessageDialog(this, " Hủy hóa đơn thành công");
            modelGioHang.setRowCount(0);
            loadTableToHoaDon();
        } else {
            JOptionPane.showMessageDialog(this, "Hủy hóa đơn thất bại");
        }
        loadTableToHoaDon();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKHActionPerformed
   String tenKH = JOptionPane.showInputDialog("Mời nhập tên khách hàng");
         JOptionPane.showMessageDialog(this, new KhachHangResponsity().addKhachHang(new KhachHang(tenKH)));
        //new ViewKhachHang().setVisible(true);
        listKH=khRes.getAllKhachHang();
        loadComboKH(listKH);
        showDataKH(listKH);
    }//GEN-LAST:event_btnKHActionPerformed

    private void btnThongKe1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKe1MouseClicked

    }//GEN-LAST:event_btnThongKe1MouseClicked

    private void btnThongKe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKe1ActionPerformed
        new ViewThongKe().setVisible(true);
    }//GEN-LAST:event_btnThongKe1ActionPerformed

    private void btnSanPham2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPham2ActionPerformed
        new ViewSanPham().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSanPham2ActionPerformed

    private void btnNhanVien2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVien2ActionPerformed
        new ViewNhanVien().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNhanVien2ActionPerformed

    private void btnBanHang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHang2ActionPerformed
        new ViewBanHang().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBanHang2ActionPerformed

    private void btnKH3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKH3ActionPerformed
        new ViewKhachHang().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKH3ActionPerformed

    private void btnLichSu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichSu3ActionPerformed
        new ViewHoaDon().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLichSu3ActionPerformed

    private void btnKM2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKM2ActionPerformed
        new ViewKhuyenMai().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKM2ActionPerformed

    private void btnDangXuat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuat2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnDangXuat2ActionPerformed

    private void btnThuocTinhSP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuocTinhSP2ActionPerformed
        new ViewThuoctinhSP().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThuocTinhSP2ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int index = tblGioHang.getSelectedRow();
        int row = tblDSHD.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm muốn cập nhật");
            return;
        }

        String Id = tblDSHD.getValueAt(row, 0).toString();
        listHDCT = (ArrayList<HoaDonChiTiet>) hdctRes.getAllHoaDonChiTietByHoaDonID(Id);
        System.out.println("ID " + listHDCT.get(index).getId());
        int spctId = hdRes.getSPCTID(listHDCT.get(index).getId());
        System.out.println("SPCTID : " + spctId);

        String soLuong = JOptionPane.showInputDialog(this, "Mời nhập số lượng");
        int soluongSP = hdctRes.selectSoLuongSanPham(spctId);
        System.out.println(soluongSP);

        if (Integer.parseInt(soLuong) > soluongSP) {
            JOptionPane.showMessageDialog(this, "Không đủ sản phẩm");
            return;
        }
        HoaDonChiTiet hdct = listHDCT.get(index);
        hdct.setSoLuong(hdct.getSoLuong() + Integer.parseInt(soLuong));
        hdctRes.updateGiHang(hdct, hdct.getId());
        ctspRes.UpdateSo(spctId + "", soluongSP - Integer.parseInt(soLuong));
        tongTienHoaDon();
        loadDataToTableSP();
        DefaultTableModel dtm = (DefaultTableModel) this.tblGioHang.getModel();
        dtm.setRowCount(0);
        this.tblDSHD.setRowSelectionInterval(row, row);
        showDataGioHang(Id);


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cboKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKMActionPerformed
        int index = this.cboKM.getSelectedIndex();
        if (index == 0) {
            return;
        }
        int row = tblDSHD.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn trước!");
        }
        KhuyenMai km = listkm.get(index - 1);
        listGioHang.clear();
        String Id = tblDSHD.getValueAt(row, 0).toString();
        ArrayList<HoaDon> listHD = hdRes.getAllHDCho();
        HoaDon hoadon = null;
        for (HoaDon hd : listHD) {
            if (hd.getIdHD().equalsIgnoreCase(Id)) {
                System.out.println(hd.getIdHD());
                hoadon = hd;
            }
        }
        if (hoadon.getTongTien() == null) {
            return;
        }

        float tienphaitra = Float.parseFloat(hoadon.getTongTien()) - km.getMucGiamGiaKM();
        this.txtTien.setText(tienphaitra + "");

    }//GEN-LAST:event_cboKMActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang2;
    private javax.swing.JButton btnDangXuat2;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnKH;
    private javax.swing.JButton btnKH3;
    private javax.swing.JButton btnKM2;
    private javax.swing.JButton btnLichSu3;
    private javax.swing.JButton btnNhanVien2;
    private javax.swing.JButton btnSanPham2;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThongKe1;
    private javax.swing.JButton btnThuocTinhSP2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboKH;
    private javax.swing.JComboBox<String> cboKM;
    private javax.swing.JComboBox<String> cboNV;
    private javax.swing.JComboBox<String> cboTT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTong;
    private javax.swing.JTable tblDSHD;
    private javax.swing.JTable tblDSSP;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTien;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
