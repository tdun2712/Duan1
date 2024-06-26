package View;

import Responsitory.ChiTietSanPhamResponsitory;
import Responsitory.HoaDonChiTietResponsitory;
import Responsitory.HoaDonResponsitory;
import Responsitory.ThanhToanResponsitory;
import Responsitory.XDate;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSanPham;
import model.GioHang;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.ThanhToan;

public class ViewHoaDon extends javax.swing.JFrame {

    DefaultTableModel modelHD = new DefaultTableModel();
    private final HoaDonResponsitory hdRes = new HoaDonResponsitory();
    private DefaultTableModel modelHDCT = new DefaultTableModel();
    private ArrayList<HoaDon> listHD = new ArrayList<>();
    private DefaultComboBoxModel modelCboTT = new DefaultComboBoxModel<>();
    private List<ThanhToan> listTT = new ArrayList<>();
    private final ThanhToanResponsitory ttRes = new ThanhToanResponsitory();
    private ArrayList<GioHang> listGioHang = new ArrayList<>();
    private ArrayList<HoaDonChiTiet> listHDCt = new ArrayList<>();
    private final HoaDonChiTietResponsitory hdctRes = new HoaDonChiTietResponsitory();
    private Integer currentPage = 1;
    private Integer rowCountPage = 5;
    private Integer totalPage;
    private HoaDon hd = new HoaDon();

    public ViewHoaDon() {
        initComponents();
        modelHD = (DefaultTableModel) tblHoaDon.getModel();
        loadDataToTable();
        setTitle("Ứng dụng bán quần áo Bee Store");
        setSize(1350, 600);
        setLocationRelativeTo(this);
        listTT = ttRes.getALlThanhToan();
        loadComboTT(listTT);
    }

    private void loadComboTT(List<ThanhToan> list) {
        modelCboTT.removeAllElements();
        for (ThanhToan tt : list) {
            modelCboTT.addElement(tt.getPhuongThucTT());
        }
    }

    private void loadDataToTable() {
        ArrayList<HoaDon> listHD = hdRes.getAllHD();
        modelHD.setRowCount(0);
        for (HoaDon hd : listHD) {
            modelHD.addRow(new Object[]{
                hd.getIdHD(),
                // hd.getMaHD(),
                hd.getNv().getMaNV(),
                hd.getNv().getTenNV(),
                //  hd.getKh().getMaKH(),
                hd.getKh().getTenKH(),
                hd.getTT().getPhuongThucTT(),
                hd.getNgayTaoHD(),
                hd.getKh().getSDT(),
                hd.getTongTien(),
                hd.getTrangThaiHD()
            });
        }
    }

    private void loadDataToSearch(HoaDon hd) {
        modelHD.addRow(new Object[]{
            hd.getIdHD(),
            hd.getNv().getMaNV(),
            hd.getNv().getTenNV(),
            hd.getKh().getTenKH(),
            hd.getTT().getPhuongThucTT(),
            hd.getNgayTaoHD(),
            hd.getKh().getSDT(),
            hd.getTongTien(),
            hd.getTrangThaiHD()
        });

    }

    public void getListHDCTtoGH(String Id) {
        modelHDCT = (DefaultTableModel) tblHDCT.getModel();
        modelHDCT.setRowCount(0);
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
//            showDataGioHang(Id);
            loadDatatoTableGioHang();
        }
    }

    private void showDataGioHang(String id) {
        try {
            listHDCt = (ArrayList<HoaDonChiTiet>) hdctRes.getAllHoaDonChiTietByHoaDonID(id);
            DefaultTableModel dtm = (DefaultTableModel) this.tblHDCT.getModel();
            dtm.setRowCount(0);
            for (HoaDonChiTiet hdct : listHDCt) {
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

    private void loadDatatoTableGioHang() {
        ArrayList<HoaDonChiTiet> listHDCT = hdctRes.getALlHDCT();
        modelHDCT.setRowCount(0);
        for (HoaDonChiTiet hdct : listHDCT) {
            modelHDCT.addRow(new Object[]{
                //    hdct.getHd().getIdHD(),
                hdct.getCtsp().getSp().getMaSP(),
                hdct.getCtsp().getSp().getTenSP(),
                hdct.getCtsp().getTh().getTenThuongHieu(),
                hdct.getCtsp().getMs().getTenMauSac(),
                hdct.getCtsp().getKt().getSize(),
                hdct.getSoLuong(),
                hdct.getGia(),
                hdct.ThanhTien(),});
        }
    }

    private void loadDataToTimKiem(ArrayList<HoaDon> hdon) {
        modelHD = (DefaultTableModel) tblHoaDon.getModel();
        modelHD.setRowCount(0);
        for (HoaDon hd : listHD) {
            modelHD.addRow(new Object[]{
                hd.getIdHD(),
                hd.getNv().getMaNV(),
                hd.getNv().getTenNV(),
                hd.getKh().getTenKH(),
                hd.getTT().getPhuongThucTT(),
                hd.getNgayTaoHD(),
                hd.getKh().getSDT(),
                hd.getTongTien(),
                hd.getTrangThaiHD()
            });
        }
    }

    private void loadData(ArrayList<HoaDon> list, int page) {
        modelHD.setRowCount(0);
        int limit = page * rowCountPage;
        int totalItem = list.size();
        lblPage.setText("Trang " + currentPage + "/" + totalPage);
        for (int start = (page - 1) * rowCountPage; start < totalItem; start++) {
            HoaDon sp = list.get(start);
            modelHD.addRow(new Object[]{
                hd.getNv().getMaNV(),
                hd.getNv().getTenNV(),
                hd.getKh().getTenKH(),
                hd.getTT().getPhuongThucTT(),
                hd.getNgayTaoHD(),
                hd.getKh().getSDT(),
                hd.getTongTien(),
                hd.getTrangThaiHD()
            });
            if (start + 1 == limit) {
                return;
            }
        }
    }

    public boolean checkNgay() {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date1 = (Date) dau.getDate();
        Date date2 = (Date) cuoi.getDate();
        c1.setTime(date1);
        c2.setTime(date2);
        long a = (c1.getTime().getTime()) / (24 * 3600 * 1000);
        long b = (c2.getTime().getTime()) / (24 * 3600 * 1000);
        if (a < b) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc!");
            return false;
        }
    }

    private void Loc() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = (Date) dau.getDate();

            String tuNgay = XDate.toString(date1, "MM-dd-yyyy");
            System.out.println(tuNgay);
            Date date2 = (Date) cuoi.getDate();

            String denNgay = XDate.toString(date2, "MM-dd-yyyy");
            System.out.println(denNgay);
            listHD = hdRes.getListByDate(tuNgay, denNgay);
            System.out.println(hdRes.getListByDate(tuNgay, denNgay).get(0).getTongTien());
            loadDataToTimKiem(hdRes.getListByDate(tuNgay, denNgay));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không có hóa đơn nào trong khoảng thời gian này");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Prev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lblPage = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tìm kiếm hóa đơn");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã NV", "Ten NV", "Tên KH", "Phương thức TT", "Ngày tạo HĐ", "SDT", "Tổng tiền", "Trạng thái HĐ"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Hóa đơn");

        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Thuơng hiệu", "Màu sắc", "Kích thước", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tblHDCT);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Hóa đơn chi tiết");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel10.setText("Từ ngày:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel11.setText("Đến ngày:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Prev.setText("Prev ");
        Prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lblPage.setText("Trang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPage, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393)
                .addComponent(Prev, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addGap(121, 121, 121))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(133, 133, 133)
                        .addComponent(jLabel11)
                        .addGap(122, 122, 122)
                        .addComponent(jButton1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Prev)
                    .addComponent(btnNext)
                    .addComponent(lblPage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNhanVien2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLichSu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBanHang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThuocTinhSP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSanPham2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThongKe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDangXuat2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKH3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKM2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = tblHoaDon.getSelectedRow();
        if (row < 0) {
            return;
        }
        listGioHang.clear();
        String Id = tblHoaDon.getValueAt(row, 0).toString();
        try {
            // getListHDCTtoGH(Id);
            showDataGioHang(Id);

        } catch (Exception e) {
            e.printStackTrace();
        }
//   int selectedRow = tblHoaDon.getSelectedRow();
//        //    lblError.setText(null);
//        if (selectedRow != -1) {
//            if (tblHDCT.getRowCount() >= 0) {
//             //   txtMaHD.setText((String) tblDSHD.getValueAt(selectedRow, 0));
//
//                listHD = hdRes.getAllHD();
//                HoaDon h = listHD.get(selectedRow);
//
//                String idHoaDon = h.getIdHD();
//                showDataGioHang(idHoaDon);
//                BigDecimal tongTien = BigDecimal.ZERO;
//            }
//        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        String search = txtSearch.getText();
        modelHD.setRowCount(0);
        listHD = hdRes.getAllHD();
        for (HoaDon spct : listHD) {
            String regex = ".*" + Pattern.quote(search) + ".*";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(spct.getNv().getTenNV());
            Matcher tenKH = pattern.matcher(spct.getKh().getTenKH());
            Matcher TrangThai = pattern.matcher(spct.getTrangThaiHD());
            //Matcher maHD = pattern.matcher(spct.getMaHD());
            Matcher hinhThucTT = pattern.matcher(spct.getTT().getPhuongThucTT());
            if (matcher.matches()
                    || tenKH.matches()
                    || TrangThai.matches()
                    || hinhThucTT.matches()) {
                loadDataToSearch(spct);
            }
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        checkNgay();
        Loc();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void setTotalPage() {
        int totalItem = hdRes.getAllHD().size();
        if (totalItem % rowCountPage == 0) {
            totalPage = totalItem / rowCountPage;
        } else {
            totalPage = totalItem / rowCountPage + 1;
        }
    }
    private void PrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevActionPerformed
        setTotalPage();
        if (currentPage == 1) {
            currentPage = totalPage;
            loadData(listHD, currentPage);
            loadDataToTable();
        } else {
            currentPage--;
            loadData(listHD, currentPage);
            loadDataToTable();
        }
    }//GEN-LAST:event_PrevActionPerformed


    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        setTotalPage();
        if (currentPage == totalPage) {
            currentPage = 1;
            loadData(listHD, currentPage);
            loadDataToTable();
        } else {
            currentPage++;
            loadData(listHD, currentPage);
            loadDataToTable();
        }
    }//GEN-LAST:event_btnNextActionPerformed

//static 
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Prev;
    private javax.swing.JButton btnBanHang2;
    private javax.swing.JButton btnDangXuat2;
    private javax.swing.JButton btnKH3;
    private javax.swing.JButton btnKM2;
    private javax.swing.JButton btnLichSu3;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNhanVien2;
    private javax.swing.JButton btnSanPham2;
    private javax.swing.JButton btnThongKe1;
    private javax.swing.JButton btnThuocTinhSP2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPage;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
