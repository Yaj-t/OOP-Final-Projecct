
package roomease;

import roomease.homepage.EmployeeHome;
import roomease.homepage.AdminHome;
import util.Session;
import util.User;
import util.AdminLoginLogs;
import util.EmployeeLoginLogs;
import util.WindowCloseHandler;
import database.AdminLogs;
import database.EmployeeLogs;
import database.UserDAO;
import enums.LogType;
import enums.UserType;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**LoginPage represents a JFrame that display a login page*/
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public LoginPage() {
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

        background = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        loginBox = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(8, 99, 117));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(180, 149, 148));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(247, 236, 89));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ROOMEASE");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 534, -1));

        loginBox.setBackground(new java.awt.Color(213, 223, 229));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(loginBox);
        jLabel1.setText("LOGIN");

        usernameField.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setLabelFor(usernameField);
        jLabel2.setText("Username:");

        Password.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Password.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Password.setLabelFor(usernameField);
        Password.setText("Password:");

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordFieldKeyTyped(evt);
            }
        });

        loginButton.setLabel("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginBoxLayout = new javax.swing.GroupLayout(loginBox);
        loginBox.setLayout(loginBoxLayout);
        loginBoxLayout.setHorizontalGroup(
            loginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginBoxLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(loginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton)
                    .addGroup(loginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(usernameField)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        loginBoxLayout.setVerticalGroup(
            loginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginBoxLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(loginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(loginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(loginBoxLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Password))
                    .addGroup(loginBoxLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        background.add(loginBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 54, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**Represents a login button when clicked calls the login method*/
        private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        login();
    }
//GEN-LAST:event_loginButtonActionPerformed
/**Calls the login method when Enter key is pressed while on the passwordField*/
    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            // Enter key pressed
            passwordFieldActionPerformed(null);
            login();
        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_passwordFieldKeyTyped
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Password;
    private javax.swing.JPanel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel loginBox;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
/**

Authenticates user login by retrieving username and password entered by the user from text fields,
validating them against the database, and then launching the corresponding main application window for
the user type (admin or employee).
@throws IllegalArgumentException if an invalid user type is encountered
*/ 
    public void login(){
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            User user = UserDAO.getUserByUsername(username);

            if (user != null && user.getPassword().equals(password)) {
                UserType userType = user.getType();
                Session.currentUser = user;
                if (userType == UserType.ADMIN) {
                    // Open main application window for admin
                    AdminLoginLogs loginLogs = new AdminLoginLogs(0, user.getUserID(), LogType.LOGIN, LocalDateTime.now());
                    AdminLogs.createAdminLoginLog(loginLogs);
                    AdminHome home = new AdminHome();
                    home.setVisible(true);
                } else if (userType == UserType.EMPLOYEE) {
                    // Open main application window for employee
                    EmployeeLoginLogs loginLogs = new EmployeeLoginLogs(0, user.getUserID(), LogType.LOGIN, LocalDateTime.now());
                    EmployeeLogs.createEmployeeLoginLog(loginLogs);
                     EmployeeHome home = new EmployeeHome();
                    home.setVisible(true);
                } else {
                    throw new IllegalArgumentException("Invalid user type: " + userType);
                }

                // Create a login session           
                dispose();
            } else {
                // Invalid username or password
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "An error occurred while trying to log in", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
