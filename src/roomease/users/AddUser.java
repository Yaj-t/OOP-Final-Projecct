package roomease.users;

import database.AdminLogs;
import database.UserDAO;
import enums.UserType;
import javax.swing.JOptionPane;
import util.Session;
import util.User;
import java.sql.*;
import util.AdminActionLog;
import util.WindowCloseHandler;

/**The AddUser Class represents a JFrame that shows fields and buttons for adding a user*/
public class AddUser extends javax.swing.JFrame {

    /**
     * Creates new form AddUser
     */
    public AddUser() {
        System.out.println("AddUser constructor");
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
        userTypeLabel = new javax.swing.JLabel();
        userTypeLabel3 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        userTypeLabel1 = new javax.swing.JLabel();
        userTypeLabel2 = new javax.swing.JLabel();
        userType = new javax.swing.JComboBox<>(UserType.values());
        backButton = new javax.swing.JButton();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        userTypeLabel4 = new javax.swing.JLabel();
        passwordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(8, 99, 117));

        userTypeLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel.setText("User Type:");

        userTypeLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel3.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel3.setText("Name:");

        nameField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        submit.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        userTypeLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel1.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel1.setText("Username:");

        userTypeLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel2.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel2.setText("Password:");

        userType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTypeActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        backButton.setText("Go back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        usernameField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        userTypeLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userTypeLabel4.setForeground(new java.awt.Color(247, 236, 89));
        userTypeLabel4.setText("Re-enter Pass:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(backButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(userTypeLabel)
                        .addGap(12, 12, 12)
                        .addComponent(userType, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(submit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userTypeLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(userTypeLabel2)
                                .addGap(13, 13, 13)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(userTypeLabel1)
                                    .addGap(12, 12, 12)
                                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(userTypeLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userTypeLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(userType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(userTypeLabel1))
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(userTypeLabel2))
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(userTypeLabel4))
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userTypeLabel3)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(submit))
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

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed
    /**validates fields and inserts them to database*/
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        String username = usernameField.getText();
        String password = passwordField.getText();
        String name = nameField.getText();
        UserType type = (UserType) userType.getSelectedItem();
        
        //Check if password is the same
        if(!passwordField1.getText().equals(password)){
            JOptionPane.showMessageDialog(this, "Re-entered password is not the same as password");
            return;
        }
        
        // check if fields are empty
        if (username.isEmpty() || password.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!");
            return;
        }
        
        //create an instance of User
        User newUser = new User(type, username, password, name);

        // check if username already exists
        try {
            if (UserDAO.getUserByUsername(username) != null) {
                JOptionPane.showMessageDialog(this, "Username already exists!");
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error checking username: " + ex.getMessage());
            return;
        }

        // add user to database
        try {
            UserDAO.addUser(newUser);

            // Adds an entry to the Admin Log when a new user is added
           
            AdminActionLog log = new AdminActionLog(Session.getCurrentUserId(), "Added a new user to the database: "+'"'+ newUser.getUsername()+'"');
            AdminLogs.createAdminActionLog(log);

            // show success message and go back to users page
            JOptionPane.showMessageDialog(this, "User added successfully!");
            dispose();
            UsersPage users = new UsersPage();
            users.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error adding user: " + ex.getMessage());
        }
    }//GEN-LAST:event_submitActionPerformed
/**disposes current frame and creates new UsersPage*/
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        UsersPage users = new UsersPage();
        users.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

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
                new AddUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JButton submit;
    private javax.swing.JComboBox<UserType> userType;
    private javax.swing.JLabel userTypeLabel;
    private javax.swing.JLabel userTypeLabel1;
    private javax.swing.JLabel userTypeLabel2;
    private javax.swing.JLabel userTypeLabel3;
    private javax.swing.JLabel userTypeLabel4;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
