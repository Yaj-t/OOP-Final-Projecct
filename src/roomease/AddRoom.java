/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package roomease;

import database.RoomDAO;
import enums.RoomStatus;
import enums.RoomType;
import java.io.ObjectInputFilter.Status;
import javax.swing.JOptionPane;
import room.Room;
import java.sql.*;
/**
 *
 * @author Predator
 */
public class AddRoom extends javax.swing.JFrame {

    /**
     * Creates new form AddRoom
     */
    public AddRoom() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeLable = new javax.swing.JLabel();
        roomNumberLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        roomNumberField = new javax.swing.JTextField();
        priceNumberField = new javax.swing.JTextField();
        roomTypeComboBox = new javax.swing.JComboBox<>(RoomType.values());
        submit = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        statusComboBox = new javax.swing.JComboBox<>(RoomStatus.values());
        maxGuestLable = new javax.swing.JLabel();
        maxGuestField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        typeLable.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        typeLable.setText("Type:");

        roomNumberLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        roomNumberLabel.setText("Room #:");

        priceLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        priceLabel.setText("Price:");

        statusLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        statusLabel.setText("Status:");

        roomNumberField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        roomNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumberFieldActionPerformed(evt);
            }
        });

        priceNumberField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        priceNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceNumberFieldActionPerformed(evt);
            }
        });

        roomTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomTypeComboBoxActionPerformed(evt);
            }
        });

        submit.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        backButton.setText("Go back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        maxGuestLable.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        maxGuestLable.setText("Max Guest:");

        maxGuestField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        maxGuestField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxGuestFieldActionPerformed(evt);
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
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(statusLabel)
                            .addComponent(priceLabel)
                            .addComponent(roomNumberLabel)
                            .addComponent(typeLable)
                            .addComponent(maxGuestLable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(submit)
                            .addComponent(maxGuestField)
                            .addComponent(statusComboBox, 0, 148, Short.MAX_VALUE)
                            .addComponent(priceNumberField)
                            .addComponent(roomNumberField)
                            .addComponent(roomTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typeLable)
                            .addComponent(roomTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roomNumberLabel)
                            .addComponent(roomNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceLabel)
                            .addComponent(priceNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusLabel)
                            .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(maxGuestField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(maxGuestLable)))
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roomNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNumberFieldActionPerformed

    private void priceNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceNumberFieldActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        RoomType type = (RoomType) roomTypeComboBox.getSelectedItem();
        float price = Float.parseFloat( priceNumberField.getText());
        String roomNumber = roomNumberField.getText();
        RoomStatus status = (RoomStatus) statusComboBox.getSelectedItem();
        int maxGuest = Integer.parseInt(maxGuestField.getText());
        
        Room newRoom = new Room(roomNumber, type, price, maxGuest, status);

        try {
            RoomDAO.addRoom(newRoom);
            JOptionPane.showMessageDialog(this, "Room added successfully!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error adding Room: " + ex.getMessage());
        }
    }//GEN-LAST:event_submitActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new Rooms().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void maxGuestFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxGuestFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxGuestFieldActionPerformed

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void roomTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomTypeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomTypeComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(AddRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField maxGuestField;
    private javax.swing.JLabel maxGuestLable;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceNumberField;
    private javax.swing.JTextField roomNumberField;
    private javax.swing.JLabel roomNumberLabel;
    private javax.swing.JComboBox<RoomType> roomTypeComboBox;
    private javax.swing.JComboBox<RoomStatus> statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton submit;
    private javax.swing.JLabel typeLable;
    // End of variables declaration//GEN-END:variables
}
