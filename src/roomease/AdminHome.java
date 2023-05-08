/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package roomease;

import user.Session;
import user.User;
import util.AdminLoginLogs;
import database.AdminLogs;
import database.UserDAO;
import enums.LogType;
import enums.UserType;
import util.*;
import java.time.LocalDate;
import database.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import user.Admin;

/**
 *
 * @author Predator
 */
public class AdminHome extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public AdminHome() {
        initComponents();
        setResizable(false);
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
        SidePanel = new javax.swing.JPanel();
        MainPanel = new javax.swing.JPanel();
        Users1 = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        rooms = new javax.swing.JButton();
        ROOMEASE = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        SidePanel.setBackground(new java.awt.Color(255, 255, 255));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(SidePanel);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));

        Users1.setBackground(new java.awt.Color(79, 117, 155));
        Users1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Users1.setForeground(new java.awt.Color(15, 15, 15));
        Users1.setText("Users");
        Users1.setToolTipText("");
        Users1.setBorderPainted(false);
        Users1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Users1.setFocusable(false);
        Users1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Users1.setPreferredSize(new java.awt.Dimension(50, 30));
        Users1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsersButton(evt);
            }
        });

        logout.setBackground(new java.awt.Color(79, 117, 155));
        logout.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(15, 15, 15));
        logout.setText("Logout");
        logout.setToolTipText("");
        logout.setBorderPainted(false);
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logout.setFocusable(false);
        logout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logout.setPreferredSize(new java.awt.Dimension(50, 30));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButton(evt);
            }
        });

        rooms.setBackground(new java.awt.Color(79, 117, 155));
        rooms.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        rooms.setForeground(new java.awt.Color(15, 15, 15));
        rooms.setText("Rooms");
        rooms.setToolTipText("");
        rooms.setBorderPainted(false);
        rooms.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rooms.setFocusable(false);
        rooms.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rooms.setPreferredSize(new java.awt.Dimension(50, 30));
        rooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomsButton(evt);
            }
        });

        ROOMEASE.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        ROOMEASE.setForeground(new java.awt.Color(0, 0, 255));
        ROOMEASE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ROOMEASE.setText("ROOMEASE");
        ROOMEASE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(ROOMEASE, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Users1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ROOMEASE)
                .addGap(29, 29, 29)
                .addComponent(Users1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(MainPanel);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RoomsButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomsButton
        // TODO add your handling code here:
        dispose();
        RoomsPage rooms = new RoomsPage();
        rooms.setVisible(true);
    }//GEN-LAST:event_RoomsButton

    private void LogOutButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutButton

        try {
            // TODO add your handling code here:
            System.out.println("Logged out");

            //Create new logout log entry
            AdminLoginLogs log = new AdminLoginLogs(0, Session.getCurrentUser().getUserID(), LogType.Logout, LocalDateTime.now());
             dispose();
            new LoginPage().setVisible(true);
            AdminLogs.createAdminLoginLog(log);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LogOutButton

    private void UsersButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsersButton
        // TODO add your handling code here:
    }//GEN-LAST:event_UsersButton

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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel ROOMEASE;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton Users1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logout;
    private javax.swing.JButton rooms;
    // End of variables declaration//GEN-END:variables
}
