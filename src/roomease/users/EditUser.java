package roomease.users;

import database.AdminLogs;
import database.UserDAO;
import enums.UserType;
import javax.swing.JOptionPane;
import util.Session;
import util.User;
import util.AdminActionLog;
import util.WindowCloseHandler;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**The EditUser Class represents a JFrame that shows fields and buttons for editing a user*/
public class EditUser extends javax.swing.JFrame {
    private User user;

    public User getUser() {
        System.out.println("EditUser");
        return user;
    }

    public boolean originalUsernamesMatch() {
        return user.getUsername().equals(usernameField.getText());
    } 

    public void setUser(User user) {
        this.user = user;
    }
    /**
     * Creates new form EditUser
     */
    public EditUser(User user) {
        this.user = user;
        initComponents();
        WindowCloseHandler.addWindowClosingListener(this);
    }
    
    public EditUser() {
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
        passwordField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        userType = new javax.swing.JComboBox<>(UserType.values());
        submit = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        userTypeLabel = new javax.swing.JLabel();
        userTypeLabel1 = new javax.swing.JLabel();
        userTypeLabel2 = new javax.swing.JLabel();
        userTypeLabel3 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit User");

        jPanel1.setBackground(new java.awt.Color(8, 99, 117));

        passwordField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        passwordField.setText(user.getPassword());
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        nameField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        nameField.setText(user.getName());
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        userType.setSelectedItem(user.getType());
        userType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTypeActionPerformed(evt);
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

        userTypeLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel.setText("User Type:");

        userTypeLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel1.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel1.setText("Username:");

        userTypeLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel2.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel2.setText("Password:");

        userTypeLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel3.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel3.setText("Name:");

        usernameField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        usernameField.setText(user.getUsername());
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(userTypeLabel3)
                            .addComponent(userTypeLabel2)
                            .addComponent(userTypeLabel1)
                            .addComponent(userTypeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submit)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(usernameField)
                                .addComponent(passwordField)
                                .addComponent(nameField)
                                .addComponent(userType, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTypeLabel)
                    .addComponent(userType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTypeLabel1)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTypeLabel2)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTypeLabel3)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed
/**validates fields and inserts changes to databse*/
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        
        // check if user is valid and if username doesn't already exist
        if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty() || nameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!");
            return;
        }

        try {
            if(!originalUsernamesMatch())
            {
                if (UserDAO.userExists(usernameField.getText())) {
                    JOptionPane.showMessageDialog(this, "Username already exists!");
                    return;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EditUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        user.setUsername(usernameField.getText());
        user.setPassword(passwordField.getText());
        user.setName(nameField.getText());
        user.setType((UserType) userType.getSelectedItem());

        try {
            UserDAO.updateUser(user);
            JOptionPane.showMessageDialog(this, "User updated successfully!");
            
            //Create another log
            AdminActionLog log = new AdminActionLog(Session.getCurrentUserId(), "Updated user: "+ '"'+ user.getUsername()+'"');
            AdminLogs.createAdminActionLog(log);

            dispose();
            UsersPage users = new UsersPage();
            users.setVisible(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating user: " + ex.getMessage());
        }
    }//GEN-LAST:event_submitActionPerformed
/**closes current frame and creates new UsersPage*/
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        UsersPage users = new UsersPage();
        users.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void userTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTypeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JButton submit;
    private javax.swing.JComboBox<UserType> userType;
    private javax.swing.JLabel userTypeLabel;
    private javax.swing.JLabel userTypeLabel1;
    private javax.swing.JLabel userTypeLabel2;
    private javax.swing.JLabel userTypeLabel3;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
