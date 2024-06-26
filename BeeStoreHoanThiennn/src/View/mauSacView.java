/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Responsitory.ChatLieuResponsitory;
import Responsitory.KichThuocResponsitory;
import Responsitory.MauSacResponsitory;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import model.MauSac;

/**
 *
 * @author phamt
 */
public class mauSacView extends javax.swing.JFrame {

     DefaultTableModel model = new DefaultTableModel();
     private final MauSacResponsitory IPL = new MauSacResponsitory();
     private final ChatLieuResponsitory clIPL = new ChatLieuResponsitory();
    public mauSacView() {
        initComponents();
        model = (DefaultTableModel) tblBang.getModel();
        loadDatatoTable();
     //  loadDataCLtoTable();
         if (tblBang.getRowCount() > 0) {
            tblBang.setRowSelectionInterval(0, 0);
            showDetail();
        }


    }
 private void loadDatatoTable() {
        ArrayList<MauSac> listCD = IPL.getALlMauSac();
        model.setRowCount(0);
        for (MauSac cd : listCD) {
            model.addRow(new Object[]{
               // cd.getId(),
                cd.getTenMauSac()                            
            });
        }
    }
 
  private void showDetail() {
        int index = tblBang.getSelectedRow();
        txtTen.setText(tblBang.getValueAt(index, 0) + "");   

    }
    private MauSac getMauSacFRomInput() {
        MauSac ms = new MauSac();
        ms.setTenMauSac(txtTen.getText());
       
        return ms;
    }
    
     private ChatLieu getChatLieuFRomInput() {
        ChatLieu ms = new ChatLieu();
        ms.setTenChatlieu(txtTen.getText());
       
        return ms;
    }
     
      private void loadDataCLtoTable() {
        ArrayList<ChatLieu> listCD = clIPL.getALlChatLieu();
        model.setRowCount(0);
        for (ChatLieu cd : listCD) {
            model.addRow(new Object[]{
               // cd.getId(),
                cd.getTenChatlieu()
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndel = new javax.swing.JButton();
        txtTen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Ten"
            }
        ));
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        btnadd.setText("add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnupdate.setText("update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndel.setText("del");
        btndel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelActionPerformed(evt);
            }
        });

        jLabel1.setText("ten");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnadd)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btndel)
                                    .addComponent(btnupdate)
                                    .addComponent(jButton1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnadd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnupdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btndel)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        try {
                MauSac s = getMauSacFRomInput();
                if (IPL.addMauSac(s) != null) {
                    JOptionPane.showMessageDialog(this, "Thanh cong");
                    loadDatatoTable();
                } else {
                    JOptionPane.showMessageDialog(this, "that bai");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error");
            }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
       int index = tblBang.getSelectedRow();
         int ID = IPL.getALlMauSac().get(index).getId();
          MauSac s = getMauSacFRomInput();
            if (IPL.updateMauSac(s,ID)!=null) {
                JOptionPane.showMessageDialog(this, "Thanh cong");
                loadDatatoTable();  
            } else {
                JOptionPane.showMessageDialog(this, "that bai");
            }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
     int index = tblBang.getSelectedRow();
         int ID = IPL.getALlMauSac().get(index).getId();
            if (IPL.delMauSac(ID) > 0) {
                JOptionPane.showMessageDialog(this, "Thanh cong");
                loadDatatoTable();
                
            } else {
                JOptionPane.showMessageDialog(this, "that bai");
            }
    }//GEN-LAST:event_btndelActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        showDetail();
    }//GEN-LAST:event_tblBangMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      int index = tblBang.getSelectedRow();
         int ID = clIPL.getALlChatLieu().get(index).getId();
          ChatLieu s = getChatLieuFRomInput();
            if (clIPL.updateChatLieu(s,ID)!=null) {
                JOptionPane.showMessageDialog(this, "Thanh cong");
                loadDatatoTable();  
            } else {
                JOptionPane.showMessageDialog(this, "that bai");
            }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(mauSacView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mauSacView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mauSacView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mauSacView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mauSacView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndel;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
