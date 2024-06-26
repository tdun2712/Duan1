/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Responsitory.ChatLieuResponsitory;
import Responsitory.ChiTietSanPhamResponsitory;
import Responsitory.KichThuocResponsitory;
import Responsitory.MauSacResponsitory;
import Responsitory.SanPhamResponsitory;
import Responsitory.ThuocTinhResponsitory;
import Responsitory.ThuongHieuResponsitory;
import Responsitory_IPL.DBContext;
import Responsitory_IPL.ThuocTinhIPL;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CTSP;
import model.ChatLieu;
import model.ChiTietSanPham;
import model.KichThuoc;
import model.MauSac;
import model.NhanVien;
import model.SanPham;
import model.ThuongHieu;

/**
 *
 * @author phamt
 */
public class ViewCTSP extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel modeldstt = new DefaultTableModel();
    private final ChiTietSanPhamResponsitory ctspRes = new ChiTietSanPhamResponsitory();
    private final SanPhamResponsitory spRes = new SanPhamResponsitory();
    public int index = -1;
    private List<MauSac> listms = new ArrayList<>();
    private List<ThuongHieu> listth = new ArrayList<>();
    private List<ChatLieu> listcl = new ArrayList<>();
    private List<KichThuoc> listkt = new ArrayList<>();
    private DefaultComboBoxModel modelCboKichThuoc = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelCboMauSac = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelCboChatLieu = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelCboThuongHieu = new DefaultComboBoxModel<>();
    private ThuocTinhIPL ttIPL = new ThuocTinhResponsitory();
    private ArrayList<ChiTietSanPham> listCTSP = new ArrayList<>();
    private MauSacResponsitory msRes = new MauSacResponsitory();
    private ChatLieuResponsitory clRes = new ChatLieuResponsitory();
    private KichThuocResponsitory ktRes = new KichThuocResponsitory();
    private ThuongHieuResponsitory thRes = new ThuongHieuResponsitory();
    private ChiTietSanPham ctsp = new ChiTietSanPham();
    private List<SanPham> listsp = new ArrayList<>();
    private SanPham spData;
    private Integer currentPage = 1;
    private Integer rowCountPage = 5;
    private Integer totalPage;
    private DefaultComboBoxModel modelSearchMS = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelSearchTH = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelSearchKT = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelSearchCL = new DefaultComboBoxModel<>();

    public ViewCTSP(SanPham sp) {
        initComponents();

        setLocationRelativeTo(this);
        setSize(1300, 800);
        setTitle("Ứng dụng bán quần áo Bee Store");
        model = (DefaultTableModel) tblSanPham.getModel();
        loadDatatoTable();

        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
        spData = sp;

        cboMauSac.setModel(modelCboMauSac);
        listms = ttIPL.getAllMauSac();
        loadComboMauSac(listms);

        cboKichThuoc.setModel(modelCboKichThuoc);
        listkt = ttIPL.getAllKichThuoc();
        loadComboKichThuoc(listkt);

        cboThuongHieu.setModel(modelCboThuongHieu);
        listth = ttIPL.getAllThuongHieu();
        loadComboThuongHieu(listth);

        cboChatLieu.setModel(modelCboChatLieu);
        listcl = ttIPL.getAllChatLieu();
        loadComboChatLieu(listcl);

//       cboSearchMS.setModel(modelSearchMS);
//        listms = ttIPL.getAllMauSac();
//        loadCboSearchMS(listms);
//
//      cboSearchTH.setModel(modelSearchTH);
//        listth = ttIPL.getAllThuongHieu();
//        loadCboSearchTH(listth);
//
//        cbosearchKT.setModel(modelSearchKT);
//        listkt = ttIPL.getAllKichThuoc();
//        loadCboSearchKT(listkt);
//
//       cboSearchCL.setModel(modelSearchCL);
//        listcl = ttIPL.getAllChatLieu();
//        loadCboSearchCL(listcl);
    }

    private void loadDatatoTable() {
        ArrayList<ChiTietSanPham> listCTSP = ctspRes.getALlCTSP();
        model.setRowCount(0);
        for (ChiTietSanPham ctsp : listCTSP) {
            model.addRow(new Object[]{
                ctsp.getSp().getMaSP(),
                ctsp.getSp().getTenSP(),
                ctsp.getKt().getSize(),
                ctsp.getMs().getTenMauSac(),
                ctsp.getTh().getTenThuongHieu(),
                ctsp.getCl().getTenChatlieu(),
                ctsp.getSoLuong(),
                ctsp.getGia(),
                ctsp.getMoTa()
            });
        }
    }

    private void showDetail() {
        int index = tblSanPham.getSelectedRow();
        ChiTietSanPham ctsp = ctspRes.getALlCTSP().get(index);
        txtMaSP.setText(tblSanPham.getValueAt(index, 0) + "");
        txtTenSP.setText(tblSanPham.getValueAt(index, 1) + "");
        cboKichThuoc.setSelectedItem(tblSanPham.getValueAt(index, 2).toString());
        cboMauSac.setSelectedItem(tblSanPham.getValueAt(index, 3).toString());
        cboThuongHieu.setSelectedItem(tblSanPham.getValueAt(index, 4).toString());
        cboChatLieu.setSelectedItem(tblSanPham.getValueAt(index, 5) + "");
        txtSoLuong.setText(tblSanPham.getValueAt(index, 6) + "");
        txtGiaBan.setText(tblSanPham.getValueAt(index, 7) + "");
        txtMoTa.setText(tblSanPham.getValueAt(index, 8) + "");
    }

    private void clearForm() {
        cboChatLieu.setSelectedIndex(0);
        cboMauSac.setSelectedIndex(0);
        cboKichThuoc.setSelectedIndex(0);
        cboThuongHieu.setSelectedIndex(0);
        txtMoTa.setText("");
        txtSeach.setText("");
        txtSoLuong.setText("");
        txtGiaBan.setText("");
        txtMaSP.setEditable(true);
    }

    private ChiTietSanPham getCTSPfromChiTietSanPham() {
        ctsp.setTh(listth.get(this.cboThuongHieu.getSelectedIndex()));
        ctsp.setMs(listms.get(this.cboMauSac.getSelectedIndex()));
        ctsp.setCl(listcl.get(this.cboChatLieu.getSelectedIndex()));
        ctsp.setKt(listkt.get(this.cboKichThuoc.getSelectedIndex()));
        listsp = spRes.getALLSanPham();
        for (SanPham sp : listsp) {
            if (sp.getMaSP().equalsIgnoreCase(this.txtMaSP.getText())) {
                System.out.println(sp.getMaSP());
                ctsp.setSp(sp);
                break;
            }
        }
        for (SanPham sp : listsp) {
            if (sp.getTenSP().equalsIgnoreCase(this.txtTenSP.getText())) {
                System.out.println(sp.getTenSP());
                ctsp.setSp(sp);
                break;
            }
        }
        ctsp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        ctsp.setGia(this.txtGiaBan.getText());
        ctsp.setMoTa(this.txtMoTa.getText());
        return ctsp;
    }

    private void showDataMauSac(List<MauSac> listMauSac) {
        modeldstt.setRowCount(0);
        int i = 1;
        for (MauSac ms : listMauSac) {
            modeldstt.addRow(new Object[]{
                i, ms.getTenMauSac()
            });
            i++;
        }
    }

    private void showDataKichThuoc(List<KichThuoc> listKichThuoc) {
        modeldstt.setRowCount(0);
        int i = 1;
        for (KichThuoc kt : listKichThuoc) {
            modeldstt.addRow(new Object[]{
                i, kt.getSize()
            });
            i++;
        }
    }

    private void showDataChatLieu(List<ChatLieu> listChatLieu) {
        modeldstt.setRowCount(0);
        int i = 1;
        for (ChatLieu cl : listChatLieu) {
            modeldstt.addRow(new Object[]{
                i, cl.getTenChatlieu()
            });
            i++;
        }
    }

    private void showDataThuongHieu(List<ThuongHieu> listThuongHieu) {
        modeldstt.setRowCount(0);
        int i = 1;
        for (ThuongHieu th : listThuongHieu) {
            modeldstt.addRow(new Object[]{
                i, th.getTenThuongHieu()
            });
            i++;
        }
    }

//    private void showDataTableCTSP(List<ChiTietSanPham> list) {
//        model.setRowCount(0);
//        for (ChiTietSanPham ctsp : list) {
//
//            model.addRow(ctsp.toDataRowCTSP());
//        }
//    }
    private void loadComboMauSac(List<MauSac> list) {
        modelCboMauSac.removeAllElements();
        for (MauSac msac : list) {
            modelCboMauSac.addElement(msac.getTenMauSac());

        }
    }

    private void loadComboMS(List<MauSac> list) {
        modelSearchMS.removeAllElements();
        for (MauSac msac : list) {
            modelSearchMS.addElement(msac.getTenMauSac());

        }
    }

    private void loadComboThuongHieu(List<ThuongHieu> list) {
        modelCboThuongHieu.removeAllElements();
        for (ThuongHieu th : list) {
            modelCboThuongHieu.addElement(th.getTenThuongHieu());

        }
    }

    private void loadComboChatLieu(List<ChatLieu> list) {
        modelCboChatLieu.removeAllElements();
        for (ChatLieu cl : list) {
            modelCboChatLieu.addElement(cl.getTenChatlieu());
        }
    }

    private void loadComboKichThuoc(List<KichThuoc> list) {
        modelCboKichThuoc.removeAllElements();
        for (KichThuoc kt : list) {
            modelCboKichThuoc.addElement(kt.getSize());
        }
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

    private void loadTableAdd(List<ChiTietSanPham> list) {
        model.setRowCount(0);
        for (ChiTietSanPham ctsp : list) {
            model.addRow(new Object[]{
                ctsp.getSp().getMaSP(),
                ctsp.getSp().getTenSP(),
                ctsp.getKt().getSize(),
                ctsp.getMs().getTenMauSac(),
                ctsp.getTh().getTenThuongHieu(),
                ctsp.getCl().getTenChatlieu(),
                ctsp.getSoLuong(),
                ctsp.getGia(),
                ctsp.getMoTa()}
            );
        }
    }

    private void loadTableSearch(ChiTietSanPham spct) {
        model.addRow(new Object[]{
            spct.getSp().getMaSP(),
            spct.getSp().getTenSP(),
            spct.getKt().getSize(),
            spct.getMs().getTenMauSac(),
            spct.getTh().getTenThuongHieu(),
            spct.getCl().getTenChatlieu(),
            spct.getSoLuong(),
            spct.getGia(),
            spct.getMoTa()}
        );
    }

    private void setTotalPage() {
        int totalItem = ctspRes.getALlCTSP().size();
        if (totalItem % rowCountPage == 0) {
            totalPage = totalItem / rowCountPage;
        } else {
            totalPage = totalItem / rowCountPage + 1;
        }
    }

    private void loadData(ArrayList<ChiTietSanPham> list, int page) {
        model.setRowCount(0);
        int limit = page * rowCountPage;
        int totalItem = list.size();
        lblPage.setText("Trang " + currentPage + "/" + totalPage);
        for (int start = (page - 1) * rowCountPage; start < totalItem; start++) {
            ChiTietSanPham sp = list.get(start);
            model.addRow(new Object[]{
                ctsp.getSp().getMaSP(),
                ctsp.getSp().getTenSP(),
                ctsp.getKt().getSize(),
                ctsp.getMs().getTenMauSac(),
                ctsp.getTh().getTenThuongHieu(),
                ctsp.getCl().getTenChatlieu(),
                ctsp.getSoLuong(),
                ctsp.getGia(),
                ctsp.getMoTa()
            });
            if (start + 1 == limit) {
                return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        PanelSP = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        cboMauSac = new javax.swing.JComboBox<>();
        cboThuongHieu = new javax.swing.JComboBox<>();
        cboKichThuoc = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        btnAddSanPham = new javax.swing.JButton();
        Sửa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cboChatLieu = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        btnMauSac = new javax.swing.JButton();
        btnChatLieu = new javax.swing.JButton();
        btnThuongHieu = new javax.swing.JButton();
        btnKichThuoc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        PanelDSSP = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtSeach = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblPage = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        Prev = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnThongKe = new javax.swing.JButton();
        btnSanPham1 = new javax.swing.JButton();
        btnNhanVien1 = new javax.swing.JButton();
        btnBanHang1 = new javax.swing.JButton();
        btnKH2 = new javax.swing.JButton();
        btnLichSu2 = new javax.swing.JButton();
        btnKM1 = new javax.swing.JButton();
        btnDangXuat1 = new javax.swing.JButton();
        btnThuocTinhSP1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(1086, 622));
        jPanel4.setMinimumSize(new java.awt.Dimension(1086, 622));

        PanelSP.setBackground(new java.awt.Color(255, 255, 255));
        PanelSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));
        PanelSP.setName("hbhjvhjvbj"); // NOI18N

        jLabel19.setText("Tên sản phẩm");

        jLabel21.setText("Giá bán*");

        jLabel22.setText("Màu sắc");

        jLabel23.setText("Thương hiệu");

        jLabel24.setText("Chất liệu");

        jLabel25.setText("Kích thước");

        jLabel26.setText("Số lượng*");

        cboKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKichThuocActionPerformed(evt);
            }
        });

        jLabel28.setText("Mã");

        txtMaSP.setEditable(false);
        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });

        txtTenSP.setEditable(false);
        txtTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPActionPerformed(evt);
            }
        });

        btnAddSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAddSanPham.setText("Thêm");
        btnAddSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSanPhamActionPerformed(evt);
            }
        });

        Sửa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        Sửa.setText("Update");
        Sửa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SửaActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));

        jLabel27.setText("Mô tả");

        btnMauSac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMauSac.setText("+");
        btnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauSacActionPerformed(evt);
            }
        });

        btnChatLieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChatLieu.setText("+");
        btnChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLieuActionPerformed(evt);
            }
        });

        btnThuongHieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThuongHieu.setText("+");
        btnThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuongHieuActionPerformed(evt);
            }
        });

        btnKichThuoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKichThuoc.setText("+");
        btnKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKichThuocActionPerformed(evt);
            }
        });

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        javax.swing.GroupLayout PanelSPLayout = new javax.swing.GroupLayout(PanelSP);
        PanelSP.setLayout(PanelSPLayout);
        PanelSPLayout.setHorizontalGroup(
            PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSPLayout.createSequentialGroup()
                .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSPLayout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKichThuoc))
                    .addGroup(PanelSPLayout.createSequentialGroup()
                        .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(PanelSPLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelSPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAddSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sửa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboThuongHieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMauSac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboChatLieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnMauSac)
                        .addComponent(btnThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );
        PanelSPLayout.setVerticalGroup(
            PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSPLayout.createSequentialGroup()
                        .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28)
                                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelSPLayout.createSequentialGroup()
                        .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26))
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(btnThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSPLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelSPLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(cboKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnKichThuoc)))
                            .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddSanPham)
                            .addGroup(PanelSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Sửa)
                                .addComponent(btnReset)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelSPLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))))
        );

        PanelDSSP.setBackground(new java.awt.Color(255, 255, 255));
        PanelDSSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên", "Kích thước", "Màu sắc", "Thương hiệu", "Chất liệu", "Số lượng", "Giá bán", "Mô tả"
            }
        ));
        tblSanPham.setGridColor(new java.awt.Color(0, 102, 102));
        tblSanPham.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(2).setResizable(false);
        }

        txtSeach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeachActionPerformed(evt);
            }
        });
        txtSeach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSeachKeyTyped(evt);
            }
        });

        jLabel1.setText("Tìm kiếm ");

        javax.swing.GroupLayout PanelDSSPLayout = new javax.swing.GroupLayout(PanelDSSP);
        PanelDSSP.setLayout(PanelDSSPLayout);
        PanelDSSPLayout.setHorizontalGroup(
            PanelDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDSSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
                    .addGroup(PanelDSSPLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSeach, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelDSSPLayout.setVerticalGroup(
            PanelDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDSSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSeach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblPage.setText("Trang");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        Prev.setText("Prev ");
        Prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Prev, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNext)
                .addGap(99, 99, 99))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(483, 483, 483)
                .addComponent(lblPage, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelDSSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 102, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(PanelSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPage)
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Prev, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNext, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 204, 102));
        jPanel7.setMaximumSize(new java.awt.Dimension(186, 652));
        jPanel7.setMinimumSize(new java.awt.Dimension(186, 652));

        btnThongKe.setBackground(new java.awt.Color(255, 255, 255));
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Statistics.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongKeMouseClicked(evt);
            }
        });
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnSanPham1.setBackground(new java.awt.Color(255, 255, 255));
        btnSanPham1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSanPham1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Basket.png"))); // NOI18N
        btnSanPham1.setText("Sản phẩm");
        btnSanPham1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPham1ActionPerformed(evt);
            }
        });

        btnNhanVien1.setBackground(new java.awt.Color(255, 255, 255));
        btnNhanVien1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhanVien1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User group.png"))); // NOI18N
        btnNhanVien1.setText("Nhân viên");
        btnNhanVien1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVien1ActionPerformed(evt);
            }
        });

        btnBanHang1.setBackground(new java.awt.Color(255, 255, 255));
        btnBanHang1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBanHang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Print.png"))); // NOI18N
        btnBanHang1.setText("Bán Hàng");
        btnBanHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHang1ActionPerformed(evt);
            }
        });

        btnKH2.setBackground(new java.awt.Color(255, 255, 255));
        btnKH2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKH2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clien list.png"))); // NOI18N
        btnKH2.setText("Khách hàng");
        btnKH2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKH2ActionPerformed(evt);
            }
        });

        btnLichSu2.setBackground(new java.awt.Color(255, 255, 255));
        btnLichSu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLichSu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Lists.png"))); // NOI18N
        btnLichSu2.setText("Hóa đơn");
        btnLichSu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichSu2ActionPerformed(evt);
            }
        });

        btnKM1.setBackground(new java.awt.Color(255, 255, 255));
        btnKM1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Coins.png"))); // NOI18N
        btnKM1.setText("Voucher");
        btnKM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKM1ActionPerformed(evt);
            }
        });

        btnDangXuat1.setBackground(new java.awt.Color(255, 255, 255));
        btnDangXuat1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangXuat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Log out.png"))); // NOI18N
        btnDangXuat1.setText("Đăng xuất");
        btnDangXuat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuat1ActionPerformed(evt);
            }
        });

        btnThuocTinhSP1.setBackground(new java.awt.Color(255, 255, 255));
        btnThuocTinhSP1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThuocTinhSP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Full basket.png"))); // NOI18N
        btnThuocTinhSP1.setText("Thuộc tính SP");
        btnThuocTinhSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuocTinhSP1ActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Goudy Old Style", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Bee store");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnKM1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThuocTinhSP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKH2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBanHang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNhanVien1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSanPham1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLichSu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDangXuat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThuocTinhSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLichSu2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKH2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKM1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDangXuat1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        setTotalPage();
        if (currentPage == totalPage) {
            currentPage = 1;
            loadData(listCTSP, currentPage);
            loadDatatoTable();
        } else {
            currentPage++;
            loadData(listCTSP, currentPage);
            loadDatatoTable();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void PrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevActionPerformed
        setTotalPage();
        if (currentPage == 1) {
            currentPage = totalPage;
            loadData(listCTSP, currentPage);
            loadDatatoTable();
        } else {
            currentPage--;
            loadData(listCTSP, currentPage);
            loadDatatoTable();
        }

    }//GEN-LAST:event_PrevActionPerformed

    private void txtSeachKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSeachKeyTyped
//        String search = txtSeach.getText();
//        model.setRowCount(0);
//        listCTSP = ctspRes.getALlCTSP();
//        for (ChiTietSanPham spct : listCTSP) {
//            String regex = ".*" + Pattern.quote(search) + ".*";
//            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//            Matcher matcher = pattern.matcher(spct.getSp().getTenSP());
//            Matcher match = pattern.matcher(spct.getSp().getMaSP());
//            if (matcher.matches()
//                    || match.matches()) {
//                loadTableSearch(spct);
//            }
//        }

  String search = txtSeach.getText();
        model.setRowCount(0);
        listCTSP = ctspRes.getALlCTSP();
        for (ChiTietSanPham spct : listCTSP) {
            String regex = ".*" + Pattern.quote(search) + ".*";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(spct.getSp().getTenSP());
            Matcher MS = pattern.matcher(spct.getMs().getTenMauSac());
            Matcher CL= pattern.matcher(spct.getCl().getTenChatlieu());
            Matcher KT = pattern.matcher(spct.getKt().getKichThuoc());
            if (matcher.matches()
                    || MS.matches()
                    ||CL.matches()
                    || KT.matches()) {
                loadTableSearch(spct);
            }
        }
    }//GEN-LAST:event_txtSeachKeyTyped

    private void txtSeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeachActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        try {
            showDetail();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKichThuocActionPerformed
        String tenThuocTinh = JOptionPane.showInputDialog("Mời nhập kích cỡ");
        JOptionPane.showMessageDialog(this, new ThuocTinhResponsitory().addKichThuoc(new KichThuoc(tenThuocTinh)));
        listkt = ttIPL.getAllKichThuoc();
        showDataKichThuoc(listkt);
        loadComboKichThuoc(listkt);
    }//GEN-LAST:event_btnKichThuocActionPerformed

    private void btnThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuongHieuActionPerformed
        String tenThuocTinh = JOptionPane.showInputDialog("Mời nhập tên thương hiệu");

        JOptionPane.showMessageDialog(this, new ThuocTinhResponsitory().addThuongHieu(new ThuongHieu(tenThuocTinh)));
        listth = ttIPL.getAllThuongHieu();
        showDataThuongHieu(listth);
        loadComboThuongHieu(listth);
    }//GEN-LAST:event_btnThuongHieuActionPerformed

    private void btnChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatLieuActionPerformed
        String tenThuocTinh = JOptionPane.showInputDialog("Mời nhập chất liẹu");
        JOptionPane.showMessageDialog(this, new ThuocTinhResponsitory().addChatLieu(new ChatLieu(tenThuocTinh)));
        listcl = ttIPL.getAllChatLieu();
        showDataChatLieu(listcl);
        loadComboChatLieu(listcl);
    }//GEN-LAST:event_btnChatLieuActionPerformed

    private void btnMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMauSacActionPerformed
        String tenThuocTinh = JOptionPane.showInputDialog("Mời nhập tên màu sắc");
        JOptionPane.showMessageDialog(this, new ThuocTinhResponsitory().addMauSac(new MauSac(tenThuocTinh)));
        listms = ttIPL.getAllMauSac();
        showDataMauSac(listms);;
        loadComboMauSac(listms);
    }//GEN-LAST:event_btnMauSacActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void SửaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SửaActionPerformed
        try {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa sản phẩm này");
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            if (txtMaSP.getText().isEmpty()
                    || txtTenSP.getText().isEmpty()
                    || txtSoLuong.getText().isEmpty()
                    || txtGiaBan.getText().isEmpty()
                    || txtMoTa.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            }
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                return;
            }
            float giaban = Float.parseFloat(txtGiaBan.getText());
            if (giaban <= 0) {
                JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn 0");
                return;
            }
            int index = tblSanPham.getSelectedRow();
            ChiTietSanPham ctsp = getCTSPfromChiTietSanPham();
            String ID = ctspRes.getALlCTSP().get(index).getId();
            if (ctspRes.updateCTSP(ctsp, ID) > 0) {
                JOptionPane.showMessageDialog(this, "Update sản phẩm thành công");
                loadDatatoTable();
                // loadTableAdd(listCTSP);
            } else {
                JOptionPane.showMessageDialog(this, "Không update được sản phẩm");
            }
        } catch (Exception e) {
            System.out.println("Lỗi ");
            e.printStackTrace();
        }
    }//GEN-LAST:event_SửaActionPerformed

    private void btnAddSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSanPhamActionPerformed
        try {

            int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm sản phẩm này");
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            if (txtMaSP.getText().isEmpty()
                    || txtTenSP.getText().isEmpty()
                    || txtSoLuong.getText().isEmpty()
                    || txtGiaBan.getText().isEmpty()
                    || txtMoTa.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            }
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                return;
            }
            float giaban = Float.parseFloat(txtGiaBan.getText());
            if (giaban <= 0) {
                JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn 0");
                return;
            }
            ChiTietSanPham ctsp = getCTSPfromChiTietSanPham();
            if (ctspRes.addCTSP(ctsp) != null) {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                loadTableAdd(listCTSP);
            } else {
                JOptionPane.showMessageDialog(this, "Không thêm được sản phẩm");
            }
            loadDatatoTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nút thêm");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddSanPhamActionPerformed

    private void txtTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPActionPerformed

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed

    }//GEN-LAST:event_txtMaSPActionPerformed

    private void cboKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKichThuocActionPerformed

    }//GEN-LAST:event_cboKichThuocActionPerformed

    private void btnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseClicked

    }//GEN-LAST:event_btnThongKeMouseClicked

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        new ViewThongKe().setVisible(true);
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnSanPham1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPham1ActionPerformed
        new ViewSanPham().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSanPham1ActionPerformed

    private void btnNhanVien1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVien1ActionPerformed
        new ViewNhanVien().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNhanVien1ActionPerformed

    private void btnBanHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHang1ActionPerformed
        new ViewBanHang().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBanHang1ActionPerformed

    private void btnKH2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKH2ActionPerformed
        new ViewKhachHang().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKH2ActionPerformed

    private void btnLichSu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichSu2ActionPerformed
        new ViewHoaDon().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLichSu2ActionPerformed

    private void btnKM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKM1ActionPerformed
        new ViewKhuyenMai().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKM1ActionPerformed

    private void btnDangXuat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuat1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnDangXuat1ActionPerformed

    private void btnThuocTinhSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuocTinhSP1ActionPerformed
        new ViewThuoctinhSP().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThuocTinhSP1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCTSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCTSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCTSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCTSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                SanPham sp = new SanPham();
                new ViewCTSP(sp).setVisible(true);
                // new ViewCTSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDSSP;
    private javax.swing.JPanel PanelSP;
    private javax.swing.JButton Prev;
    private javax.swing.JButton Sửa;
    private javax.swing.JButton btnAddSanPham;
    private javax.swing.JButton btnBanHang1;
    private javax.swing.JButton btnChatLieu;
    private javax.swing.JButton btnDangXuat1;
    private javax.swing.JButton btnKH2;
    private javax.swing.JButton btnKM1;
    private javax.swing.JButton btnKichThuoc;
    private javax.swing.JButton btnLichSu2;
    private javax.swing.JButton btnMauSac;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNhanVien1;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSanPham1;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnThuocTinhSP1;
    private javax.swing.JButton btnThuongHieu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboKichThuoc;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboThuongHieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblPage;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSeach;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
