/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Responsitory_IPL.DBContext;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author phamt
 */
public class ViewTrangChu extends javax.swing.JFrame {

    
    public ViewTrangChu() {
        initComponents();
         this.setLocationRelativeTo(null);
        setTitle("Ứng dụng bán quần áo Bee Store");
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Quần áo Giá đỡ Cửa hàng Thời trang Ảnh bìa Facebook.png"))); // NOI18N
        jLabel1.setText("jLabel1");

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
        btnKM2.setText("Khuyến mãi");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(ViewTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ViewTrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang2;
    private javax.swing.JButton btnDangXuat2;
    private javax.swing.JButton btnKH3;
    private javax.swing.JButton btnKM2;
    private javax.swing.JButton btnLichSu3;
    private javax.swing.JButton btnNhanVien2;
    private javax.swing.JButton btnSanPham2;
    private javax.swing.JButton btnThongKe1;
    private javax.swing.JButton btnThuocTinhSP2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
