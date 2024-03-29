
package roomease.rooms;

import database.AdminLogs;
import database.RoomDAO;
import javax.swing.JOptionPane;
import util.Room;
import util.WindowCloseHandler;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Session;
import util.AdminActionLog;

/**
 * The AddRoom class represent a JFrame that displays field and buttons for
 * adding a room
 */
public class AddRoom extends javax.swing.JFrame {

    /**
     * Creates new form AddRoom
     */
    public AddRoom() {
        System.out.println("AddRoom constructor");
        initComponents();
        WindowCloseHandler.addWindowClosingListener(this);
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
        roomNumberLabel = new javax.swing.JLabel();
        priceNumberField = new javax.swing.JTextField();
        roomNumberField = new javax.swing.JTextField();
        maxGuestLable = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        descriptionField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AddRoom");

        jPanel1.setBackground(new java.awt.Color(8, 99, 117));

        roomNumberLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        roomNumberLabel.setForeground(new java.awt.Color(247, 236, 89));
        roomNumberLabel.setText("Room #:");

        priceNumberField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        priceNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceNumberFieldActionPerformed(evt);
            }
        });

        roomNumberField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        roomNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumberFieldActionPerformed(evt);
            }
        });

        maxGuestLable.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        maxGuestLable.setForeground(new java.awt.Color(247, 236, 89));
        maxGuestLable.setText("Description:");

        priceLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(247, 236, 89));
        priceLabel.setText("Price:");

        submit.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        descriptionField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        descriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionFieldActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        backButton.setText("Go back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backButton)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(priceLabel)
                                .addComponent(roomNumberLabel)
                                .addComponent(maxGuestLable))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(submit)
                                .addComponent(descriptionField)
                                .addComponent(priceNumberField)
                                .addComponent(roomNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(30, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(backButton)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(roomNumberLabel)
                        .addComponent(roomNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(priceLabel)
                        .addComponent(priceNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(maxGuestLable)
                        .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(submit)
                    .addContainerGap(26, Short.MAX_VALUE)))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void roomNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNumberFieldActionPerformed

    private void priceNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceNumberFieldActionPerformed
/*Checks if the values in the fields are valid then inserts a room into the database*/
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        //Check if the fields are empty and validate the data
        String roomNumber = roomNumberField.getText();
        String description = descriptionField.getText();

        // Check if price is a number and is positive
        if ( !priceNumberField.getText().matches("[0-9]+(\\.[0-9][0-9]?)?")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price!");
            return;
        }

        if (roomNumber.equals("") || priceNumberField.getText().equals("") || description.equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields!");
            return;
        }

        float price = Float.parseFloat(priceNumberField.getText());

        try {
            // Check if room number is unique
            if (RoomDAO.getRoomByNumber(roomNumber) != null) {
                JOptionPane.showMessageDialog(this, "Room number already exists!");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddRoom.class.getName()).log(Level.SEVERE, null, ex);
        }

        

        Room newRoom = new Room(roomNumber, price, description);
        try {
            RoomDAO.addRoom(newRoom);
            AdminActionLog log = new AdminActionLog(Session.getCurrentUserId(), "Added room " + '"' + roomNumber + '"');
            AdminLogs.createAdminActionLog(log);
            JOptionPane.showMessageDialog(this, "Room added successfully!");
            dispose();
            new RoomsPage().setVisible(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error adding Room: " + ex.getMessage());
        }
    }//GEN-LAST:event_submitActionPerformed
/**Disposes current frame and creates new RoomsPage*/ 
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new RoomsPage().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void descriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel maxGuestLable;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceNumberField;
    private javax.swing.JTextField roomNumberField;
    private javax.swing.JLabel roomNumberLabel;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
