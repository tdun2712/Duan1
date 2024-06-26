/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Responsitory.ChatLieuResponsitory;
import Responsitory.KichThuocResponsitory;
import Responsitory.MauSacResponsitory;
import Responsitory.ThuocTinhResponsitory;
import Responsitory.ThuongHieuResponsitory;
import Responsitory_IPL.ThuocTinhIPL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import model.ChiTietSanPham;
import model.KichThuoc;
import model.MauSac;
import model.ThuongHieu;

/**
 *
 * @author phamt
 */
public class ViewThuoctinhSP extends javax.swing.JFrame {

    private DefaultComboBoxModel modelCboKichThuoc = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelCboMauSac = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelCboChatLieu = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel modelCboThuongHieu = new DefaultComboBoxModel<>();
    private DefaultTableModel modeldstt = new DefaultTableModel();
    private List<MauSac> listms = new ArrayList<>();
    private List<ThuongHieu> listth = new ArrayList<>();
    private List<ChatLieu> listcl = new ArrayList<>();
    private List<KichThuoc> listkt = new ArrayList<>();
    private ThuocTinhIPL ttIPL = new ThuocTinhResponsitory();
      private MauSacResponsitory msRes = new MauSacResponsitory();
    private ChatLieuResponsitory clRes = new ChatLieuResponsitory();
    private KichThuocResponsitory ktRes = new KichThuocResponsitory();
    private ThuongHieuResponsitory thRes = new ThuongHieuResponsitory();

    public ViewThuoctinhSP() {
        initComponents();
        modeldstt = (DefaultTableModel) tblDSThuocTinh.getModel();
          setLocationRelativeTo(this);
        loadDataToTableThuocTinh();
        setSize(1200,650);
      //  setExtendedState(JFrame.MAXIMIZED_BOTH);
//
//        cboMauSac.setModel(modelCboMauSac);
//        listms = ttIPL.getAllMauSac();
//        loadComboMauSac(listms);
//
//        cboKichThuoc.setModel(modelCboKichThuoc);
//        listkt = ttIPL.getAllKichThuoc();
//        loadComboKichThuoc(listkt);
//
//        cboThuongHieu.setModel(modelCboThuongHieu);
//        listth = ttIPL.getAllThuongHieu();
//        loadComboThuongHieu(listth);
//
//        cboChatLieu.setModel(modelCboChatLieu);
//        listcl = ttIPL.getAllChatLieu();
//        loadComboChatLieu(listcl);
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

    private void loadDataToTableThuocTinh() {
        if (rdoChatLieu.isSelected() == true) {
            listcl = ttIPL.getAllChatLieu();
            showDataChatLieu(listcl);
        } else if (rdoKichThuoc.isSelected() == true) {
            listkt = ttIPL.getAllKichThuoc();
            showDataKichThuoc(listkt);
        } else if (rdoThuongHieu.isSelected() == true) {
            listth = ttIPL.getAllThuongHieu();
            showDataThuongHieu(listth);
        } else if (rdoMauSac.isSelected() == true) {
            listms = ttIPL.getAllMauSac();
            showDataMauSac(listms);
        }
    }

    private void ShowDetailThuocTinh() {
        int row = tblDSThuocTinh.getSelectedRow();
        if (rdoChatLieu.isSelected()) {
            txtTenThuocTinh.setText(listcl.get(row).getTenChatlieu());
        } else if (rdoKichThuoc.isSelected()) {
            txtTenThuocTinh.setText(listkt.get(row).getSize());
        } else if (rdoThuongHieu.isSelected()) {
            txtTenThuocTinh.setText(listth.get(row).getTenThuongHieu());
        } else {
            txtTenThuocTinh.setText(listms.get(row).getTenMauSac());
        }
    }
// private void showDataTableCTSP(List<ChiTietSanPham> list) {
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

    private MauSac getMauSacFRomInput() {
        MauSac ms = new MauSac();
        ms.setTenMauSac(txtTenThuocTinh.getText());
        return ms;
    }

    private KichThuoc getKichThuocFRomInput() {
        KichThuoc kt = new KichThuoc();
        kt.setSize(txtTenThuocTinh.getText());
        return kt;
    }

    private ChatLieu getChatLieuFRomInput() {
        ChatLieu cl = new ChatLieu();
        cl.setTenChatlieu(txtTenThuocTinh.getText());
        return cl;
    }

    private ThuongHieu getThuongHieuFRomInput() {
        ThuongHieu th = new ThuongHieu();
        th.setTenThuongHieu(txtTenThuocTinh.getText());
        return th;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDSThuocTinh = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenThuocTinh = new javax.swing.JTextField();
        rdoMauSac = new javax.swing.JRadioButton();
        rdoThuongHieu = new javax.swing.JRadioButton();
        rdoKichThuoc = new javax.swing.JRadioButton();
        rdoChatLieu = new javax.swing.JRadioButton();
        btnSuaThuocTinhSP = new javax.swing.JButton();
        btnThemThuocTinhSP = new javax.swing.JButton();
        btnLamMoiThuocTinh = new javax.swing.JButton();
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
        setTitle("ứng dụng bán quần áo Bee Store");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(1086, 622));
        jPanel2.setMinimumSize(new java.awt.Dimension(1086, 622));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách thuộc tính"));

        tblDSThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "STT", "Ten"
            }
        ));
        tblDSThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblDSThuocTinh);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin thuộc tính"));

        jLabel2.setText("Tên thuộc tính");

        buttonGroup1.add(rdoMauSac);
        rdoMauSac.setText("Màu sắc");
        rdoMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMauSacActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoThuongHieu);
        rdoThuongHieu.setText("Thương hiệu");
        rdoThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoThuongHieuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoKichThuoc);
        rdoKichThuoc.setText("Kích thước");
        rdoKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoKichThuocActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoChatLieu);
        rdoChatLieu.setText("Chất liệu");
        rdoChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChatLieuActionPerformed(evt);
            }
        });

        btnSuaThuocTinhSP.setBackground(new java.awt.Color(255, 255, 255));
        btnSuaThuocTinhSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaThuocTinhSP.setText("Sửa");
        btnSuaThuocTinhSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThuocTinhSPActionPerformed(evt);
            }
        });

        btnThemThuocTinhSP.setBackground(new java.awt.Color(255, 255, 255));
        btnThemThuocTinhSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemThuocTinhSP.setText("Thêm");
        btnThemThuocTinhSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuocTinhSPActionPerformed(evt);
            }
        });

        btnLamMoiThuocTinh.setBackground(new java.awt.Color(255, 255, 255));
        btnLamMoiThuocTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoiThuocTinh.setText("Làm mới");
        btnLamMoiThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiThuocTinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThemThuocTinhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaThuocTinhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnLamMoiThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoMauSac)
                    .addComponent(rdoThuongHieu)
                    .addComponent(rdoKichThuoc)
                    .addComponent(rdoChatLieu)
                    .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemThuocTinhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaThuocTinhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 204, 102));
        jPanel8.setMaximumSize(new java.awt.Dimension(186, 652));
        jPanel8.setMinimumSize(new java.awt.Dimension(186, 652));

        btnThongKe1.setBackground(new java.awt.Color(255, 255, 255));
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

        btnSanPham2.setBackground(new java.awt.Color(255, 255, 255));
        btnSanPham2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSanPham2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Basket.png"))); // NOI18N
        btnSanPham2.setText("Sản phẩm");
        btnSanPham2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPham2ActionPerformed(evt);
            }
        });

        btnNhanVien2.setBackground(new java.awt.Color(255, 255, 255));
        btnNhanVien2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhanVien2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User group.png"))); // NOI18N
        btnNhanVien2.setText("Nhân viên");
        btnNhanVien2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVien2ActionPerformed(evt);
            }
        });

        btnBanHang2.setBackground(new java.awt.Color(255, 255, 255));
        btnBanHang2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBanHang2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Print.png"))); // NOI18N
        btnBanHang2.setText("Bán Hàng");
        btnBanHang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHang2ActionPerformed(evt);
            }
        });

        btnKH3.setBackground(new java.awt.Color(255, 255, 255));
        btnKH3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKH3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clien list.png"))); // NOI18N
        btnKH3.setText("Khách hàng");
        btnKH3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKH3ActionPerformed(evt);
            }
        });

        btnLichSu3.setBackground(new java.awt.Color(255, 255, 255));
        btnLichSu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLichSu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Lists.png"))); // NOI18N
        btnLichSu3.setText("Hóa đơn");
        btnLichSu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichSu3ActionPerformed(evt);
            }
        });

        btnKM2.setBackground(new java.awt.Color(255, 255, 255));
        btnKM2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKM2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Coins.png"))); // NOI18N
        btnKM2.setText("Voucher");
        btnKM2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKM2ActionPerformed(evt);
            }
        });

        btnDangXuat2.setBackground(new java.awt.Color(255, 255, 255));
        btnDangXuat2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangXuat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Log out.png"))); // NOI18N
        btnDangXuat2.setText("Đăng xuất");
        btnDangXuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuat2ActionPerformed(evt);
            }
        });

        btnThuocTinhSP2.setBackground(new java.awt.Color(255, 255, 255));
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
                            .addComponent(btnNhanVien2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLichSu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBanHang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThuocTinhSP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSanPham2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThongKe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDangXuat2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKH3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKM2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGap(6, 6, 6)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSThuocTinhMouseClicked
        int row = tblDSThuocTinh.getSelectedRow();
        ShowDetailThuocTinh();
    }//GEN-LAST:event_tblDSThuocTinhMouseClicked

    private void rdoMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMauSacActionPerformed
        listms = ttIPL.getAllMauSac();
        showDataMauSac((List<MauSac>) listms);
    }//GEN-LAST:event_rdoMauSacActionPerformed

    private void rdoThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoThuongHieuActionPerformed
        listth = ttIPL.getAllThuongHieu();
        showDataThuongHieu(listth);
    }//GEN-LAST:event_rdoThuongHieuActionPerformed

    private void rdoKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoKichThuocActionPerformed
        listkt = ttIPL.getAllKichThuoc();
        showDataKichThuoc(listkt);
    }//GEN-LAST:event_rdoKichThuocActionPerformed

    private void rdoChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChatLieuActionPerformed
        listcl = ttIPL.getAllChatLieu();
        showDataChatLieu(listcl);
    }//GEN-LAST:event_rdoChatLieuActionPerformed

    private void btnSuaThuocTinhSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThuocTinhSPActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa thuộc tính này");
        if (hoi != JOptionPane.YES_OPTION) {
            return;
        }
        int index = tblDSThuocTinh.getSelectedRow();
        if (rdoMauSac.isSelected()) {
            int ID = msRes.getALlMauSac().get(index).getId();
            MauSac s = getMauSacFRomInput();
            if (msRes.updateMauSac(s, ID) != null) {
                JOptionPane.showMessageDialog(this, "Thành công");
                listms = ttIPL.getAllMauSac();
                showDataMauSac(listms);;
                loadComboMauSac(listms);
            } else {
                JOptionPane.showMessageDialog(this, "Thất bại");
            }
        } else if (rdoChatLieu.isSelected()) {
            int IDCL = clRes.getALlChatLieu().get(index).getId();
            ChatLieu cl = getChatLieuFRomInput();
            if (clRes.updateChatLieu(cl, IDCL) != null) {
                JOptionPane.showMessageDialog(this, "Thành công");
                listcl = ttIPL.getAllChatLieu();
                showDataChatLieu(listcl);
                loadComboChatLieu(listcl);
            } else {
                JOptionPane.showMessageDialog(this, "Thất bại");
            }
        } else if (rdoKichThuoc.isSelected()) {
            int IDkt = ktRes.getALlKichThuoc().get(index).getId();
            KichThuoc kt = getKichThuocFRomInput();
            if (ktRes.updateKichThuoc(kt, IDkt) != null) {
                JOptionPane.showMessageDialog(this, "Thành công");
                listkt = ttIPL.getAllKichThuoc();
                showDataKichThuoc(listkt);
                loadComboKichThuoc(listkt);
            } else {
                JOptionPane.showMessageDialog(this, "Thất bại");
            }
        } else {
            int IDth = thRes.getALlThuongHieu().get(index).getId();
            ThuongHieu th = getThuongHieuFRomInput();
            if (thRes.updateThuongHieu(th, IDth) != null) {
                JOptionPane.showMessageDialog(this, "Thành công");
                listth = ttIPL.getAllThuongHieu();
                showDataThuongHieu(listth);
                loadComboThuongHieu(listth);
            } else {
                JOptionPane.showMessageDialog(this, "Thất bại");
            }
        }
    }//GEN-LAST:event_btnSuaThuocTinhSPActionPerformed

    private void btnThemThuocTinhSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuocTinhSPActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm thuộc tính này");
        if (hoi != JOptionPane.YES_OPTION) {
            return;
        }
        String tenThuocTinh = txtTenThuocTinh.getText();
        if (rdoMauSac.isSelected()) {
            JOptionPane.showMessageDialog(this, new ThuocTinhResponsitory().addMauSac(new MauSac(tenThuocTinh)));
            listms = ttIPL.getAllMauSac();
            showDataMauSac(listms);
            loadComboMauSac(listms);
        } else if (rdoKichThuoc.isSelected()) {
            JOptionPane.showMessageDialog(this, new ThuocTinhResponsitory().addKichThuoc(new KichThuoc(tenThuocTinh)));
            listkt = ttIPL.getAllKichThuoc();
            showDataKichThuoc(listkt);
            loadComboKichThuoc(listkt);
        } else if (rdoChatLieu.isSelected()) {
            JOptionPane.showMessageDialog(this, new ThuocTinhResponsitory().addChatLieu(new ChatLieu(tenThuocTinh)));
            listcl = ttIPL.getAllChatLieu();
            showDataChatLieu(listcl);
            loadComboChatLieu(listcl);
        } else {
            JOptionPane.showMessageDialog(this, new ThuocTinhResponsitory().addThuongHieu(new ThuongHieu(tenThuocTinh)));
            listth = ttIPL.getAllThuongHieu();
            showDataThuongHieu(listth);
            loadComboThuongHieu(listth);
        }
    }//GEN-LAST:event_btnThemThuocTinhSPActionPerformed

    private void btnLamMoiThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiThuocTinhActionPerformed
        txtTenThuocTinh.setText("");
        txtTenThuocTinh.setEditable(true);
    }//GEN-LAST:event_btnLamMoiThuocTinhActionPerformed

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
            java.util.logging.Logger.getLogger(ViewThuoctinhSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewThuoctinhSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewThuoctinhSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewThuoctinhSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewThuoctinhSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang2;
    private javax.swing.JButton btnDangXuat2;
    private javax.swing.JButton btnKH3;
    private javax.swing.JButton btnKM2;
    private javax.swing.JButton btnLamMoiThuocTinh;
    private javax.swing.JButton btnLichSu3;
    private javax.swing.JButton btnNhanVien2;
    private javax.swing.JButton btnSanPham2;
    private javax.swing.JButton btnSuaThuocTinhSP;
    private javax.swing.JButton btnThemThuocTinhSP;
    private javax.swing.JButton btnThongKe1;
    private javax.swing.JButton btnThuocTinhSP2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JRadioButton rdoChatLieu;
    private javax.swing.JRadioButton rdoKichThuoc;
    private javax.swing.JRadioButton rdoMauSac;
    private javax.swing.JRadioButton rdoThuongHieu;
    private javax.swing.JTable tblDSThuocTinh;
    private javax.swing.JTextField txtTenThuocTinh;
    // End of variables declaration//GEN-END:variables
}
