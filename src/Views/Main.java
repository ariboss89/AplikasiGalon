/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.Koneksi;
import Models.tb_admin;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Main extends javax.swing.JFrame {

    Selling selling = new Selling();
    Employee employee = new Employee();
    User user = new User();
    Pelanggan pelanggan = new Pelanggan();
    
    Koneksi con;
    Statement st;
    ResultSet rs;

    public Main() {
        initComponents();
        setLocationRelativeTo(this);
        Check();
        Dimension desktopSize = jDesktopPane1.getSize();
        
        Dimension jFrame = selling.getSize();
        employee.setLocation((desktopSize.width - jFrame.width) / 2,
                (desktopSize.height - jFrame.height) / 2);
        
        Dimension jInternalEmployee = employee.getSize();
        employee.setLocation((desktopSize.width - jInternalEmployee.width) / 2,
                (desktopSize.height - jInternalEmployee.height) / 2);

        Dimension jInternalUser = user.getSize();
        user.setLocation((desktopSize.width - jInternalUser.width) / 2,
                (desktopSize.height - jInternalUser.height) / 2);

        Dimension jInternalPelanggan = pelanggan.getSize();
        pelanggan.setLocation((desktopSize.width - jInternalPelanggan.width) / 2,
                (desktopSize.height - jInternalPelanggan.height) / 2);

    }

    private void Check() {
        if (!tb_admin.getRole().equals("admin")) {
            btnkaryawan.setText("Pengguna");
            btnPenjualan.setEnabled(false);
            btnLaporan.setEnabled(false);
        } else {
            btnkaryawan.setText("Karyawan");
            btnPenjualan.setEnabled(true);
            btnLaporan.setEnabled(true);
        }
    }

    private void CountPegawai() {
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT COUNT(Id) as jml from tb_karyawan");
            while (rs.next()) {
                lblPegawai.setText(rs.getString("jml"));
            }
        } catch (SQLException ex) {

        }
    }

    private void CountPenjualan() {
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT SUM(total) as jml from tb_penjualan");
            while (rs.next()) {
                lblPenjualan.setText(rs.getString("jml"));
            }
        } catch (SQLException ex) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnPenjualan = new javax.swing.JButton();
        btnkaryawan = new javax.swing.JButton();
        btnSetting = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();
        btnkaryawan1 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        background1 = new Images.Background();
        jPanel5 = new javax.swing.JPanel();
        lblPegawai = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblPenjualan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        btnPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/income.png"))); // NOI18N
        btnPenjualan.setText("Penjualan");
        btnPenjualan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPenjualan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenjualanActionPerformed(evt);
            }
        });

        btnkaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employee.png"))); // NOI18N
        btnkaryawan.setText("Karyawan");
        btnkaryawan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnkaryawan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkaryawanActionPerformed(evt);
            }
        });

        btnSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings.png"))); // NOI18N
        btnSetting.setText("Password");
        btnSetting.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSetting.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingActionPerformed(evt);
            }
        });

        btnLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/business-report.png"))); // NOI18N
        btnLaporan.setText("Laporan");
        btnLaporan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLaporan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanActionPerformed(evt);
            }
        });

        btnkaryawan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employee.png"))); // NOI18N
        btnkaryawan1.setText("Pelanggan");
        btnkaryawan1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnkaryawan1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnkaryawan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkaryawan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnkaryawan1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnkaryawan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSetting, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPenjualan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPenjualan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnkaryawan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnkaryawan1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnLaporan)
                .addGap(18, 18, 18)
                .addComponent(btnSetting))
        );

        jPanel5.setBackground(new java.awt.Color(51, 255, 51));

        lblPegawai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employee.png"))); // NOI18N
        lblPegawai.setText("-");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPegawai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPegawai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 0, 0));

        lblPenjualan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/income.png"))); // NOI18N
        lblPenjualan.setText("-");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPenjualan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("APLIKASI PENJUALAN GALON");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TOKO NUSAQUA TANJUNGPINANG");

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayer(background1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        btnLogout.setText("Keluar");
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLogout)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogout)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(null, "Konfirmasi", "Apakah Anda Ingin Keluar ?", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            JOptionPane.showMessageDialog(null, "Sampai Jumpa Lagi " + tb_admin.getUsername());
            dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenjualanActionPerformed
        // TODO add your handling code here:   
        //new Selling().show();
        new Selling().show();
    }//GEN-LAST:event_btnPenjualanActionPerformed

    private void btnkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkaryawanActionPerformed
        // TODO add your handling code here:
        if (btnkaryawan.getText().equals("Karyawan")) {
            jDesktopPane1.add(employee);
            employee.setVisible(true);
        } else {
            jDesktopPane1.add(user);
            user.setVisible(true);
        }

    }//GEN-LAST:event_btnkaryawanActionPerformed

    private void btnSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingActionPerformed
        // TODO add your handling code here:
//        if (tb_admin.getUsername()==null) {
//            JOptionPane.showMessageDialog(null, "Belum Login, Silahkan Login Dahulu !!");
//            new Login().show();
//            dispose();
//        } else {
        new Setting().show();
        //}

    }//GEN-LAST:event_btnSettingActionPerformed

    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed
        // TODO add your handling code here:
        new MainReport().show();
    }//GEN-LAST:event_btnLaporanActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        CountPegawai();
        CountPenjualan();
    }//GEN-LAST:event_formWindowActivated

    private void btnkaryawan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkaryawan1ActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.remove(employee);
        employee.setVisible(false);
        jDesktopPane1.add(pelanggan);
        pelanggan.setVisible(true);
    }//GEN-LAST:event_btnkaryawan1ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Images.Background background1;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPenjualan;
    private javax.swing.JButton btnSetting;
    private javax.swing.JButton btnkaryawan;
    private javax.swing.JButton btnkaryawan1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblPegawai;
    private javax.swing.JLabel lblPenjualan;
    // End of variables declaration//GEN-END:variables
}
