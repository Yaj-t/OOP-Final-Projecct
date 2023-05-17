
package roomease.users;

import database.AdminLogs;
import database.UserDAO;
import enums.UserType;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import roomease.homepage.AdminHome;
import util.Session;
import util.User;
import util.AdminActionLog;
import util.WindowCloseHandler;

/**
 * The UsersPage Class represents a JFrame that shows Tables and buttons for CRUD
 * operations on users
 */
public class UsersPage extends javax.swing.JFrame {
    List <User> userList;
    /**
     * Creates new form Users
     */
    public UsersPage() {
        System.out.println("UsersPage");
        initComponents();
        
        try {
            userList = UserDAO.getAllUsers();
        } catch (SQLException ex) {
            Logger.getLogger(UsersPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel tableModel = (DefaultTableModel)usersTable.getModel();
        /**fills table with data from database*/
        for (User user : userList) {
            System.out.println(user.getUserID()+" "+ user.getType()+ user.getUsername()+ user.getName());
            Object[] rowData = {user.getUserID(), user.getType(), user.getUsername(), user.getName()};
            tableModel.addRow(rowData);
        }
        usersTable.setModel(tableModel);
        WindowCloseHandler.addWindowClosingListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        goBackButtom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(8, 99, 117));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Username", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        usersTable.setShowGrid(true);
        usersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(usersTable);

        add.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        edit.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        goBackButtom.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        goBackButtom.setText("Go back");
        goBackButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(510, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(goBackButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(140, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(add)
                .addGap(17, 17, 17)
                .addComponent(edit)
                .addGap(17, 17, 17)
                .addComponent(delete)
                .addContainerGap(241, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(goBackButtom)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**disposes current frame and creates new AdminHome*/
    private void goBackButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtomActionPerformed
        // TODO add your handling code here:
        dispose();
        new AdminHome().setVisible(true);
    }//GEN-LAST:event_goBackButtomActionPerformed
/**disposes current frame, check if there is a row selected, and creates new EditUser*/
    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int selectedRow = usersTable.getSelectedRow();
        if(selectedRow !=-1){
            try {
                // TODO add your handling code here:
                int userID = (int) usersTable.getValueAt(selectedRow, 0);
                User user = UserDAO.getUserByID(userID);
                new EditUser(user).setVisible(true);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(UsersPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row to edit.");
        }
    }//GEN-LAST:event_editActionPerformed
/**disposes current frame and creates newAddUser*/
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        //TODO add your handling code here:
        dispose();
        AddUser addUser = new AddUser();
        addUser.setVisible(true);
    }//GEN-LAST:event_addActionPerformed
   /**disposes current frame, check if there is a row selected, and deletes the row*/
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int row = usersTable.getSelectedRow(); // get the selected row
        if (row != -1) { // check if a row is selected
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?",
                "Confirm Deletion", JOptionPane.YES_NO_OPTION); // confirm deletion with user

            if (option == JOptionPane.YES_OPTION) { // user confirms deletion
                int userID =(int) usersTable.getValueAt(row, 0); // get the username from the table
                User user;
                try {
                    user = UserDAO.getUserByID(userID);
                    try {
                        //check if the user is an admin and if there are no other admin users
                        if(user.getType() == UserType.ADMIN && UserDAO.countAdminUsers()==1){
                            JOptionPane.showMessageDialog(this, "Cant delete last existing ADMIN");
                            return;
                        }
                        // delete the user from the database
                        UserDAO.deleteUser(user);
                        dispose();
                        new UsersPage().setVisible(true);
                        AdminActionLog log = new AdminActionLog( Session.getCurrentUserId() , "Deleted user: " +'"'+ user.getUsername()+'"');
                        AdminLogs.createAdminActionLog(log);

                        JOptionPane.showMessageDialog(null, "User deleted successfully.");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error deleting user: " + ex.getMessage());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UsersPage.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
        }
    }//GEN-LAST:event_deleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsersPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton goBackButtom;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
