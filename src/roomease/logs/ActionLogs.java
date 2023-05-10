/**
 * The ActionLogs class represents a JFrame window that displays all actions of either ADMIN or employee.
 */
package roomease.logs;

import database.AdminLogs;
import database.EmployeeLogs;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import roomease.homepage.AdminHome;
import util.AdminActionLog;
import util.EmployeeActionLog;
import util.Room;
import util.WindowCloseHandler;


public class ActionLogs extends javax.swing.JFrame {
    List <AdminActionLog> adminList;
    List <EmployeeActionLog> employeeList;
    /**
     * Creates new form Rooms
     */
    
    public ActionLogs() {
        System.out.println("ActionLogs");
        initComponents();
        /**fills the table with data from database*/
        try{
            adminList = AdminLogs.getAllAdminActionLogs();
            DefaultTableModel tableModel = (DefaultTableModel) ActionTable.getModel();

            for (AdminActionLog admin : adminList) {
                Object[] rowData = {admin.getLogId(), admin.getuser_id(), admin.getActionDescription(), admin.getActionTime()};
                tableModel.addRow(rowData);
            }

            ActionTable.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public ActionLogs(AdminActionLog use)
    {
        System.out.println("ActionLogs Admin");
        initComponents();
          /**fills the table with data from database*/
        try{
            adminList = AdminLogs.getAllAdminActionLogs();
            DefaultTableModel tableModel = (DefaultTableModel) ActionTable.getModel();

            for (AdminActionLog admin : adminList) {
                Object[] rowData = {admin.getLogId(), admin.getuser_id(), admin.getActionDescription(), admin.getActionTime()};
                tableModel.addRow(rowData);
            }

            ActionTable.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        WindowCloseHandler.addWindowClosingListener(this);
    }

    public ActionLogs(EmployeeActionLog use)
    {
        System.out.println("ActionLogs Employee");
        initComponents();
          /**fills the table with data from database*/
        try{
            employeeList = EmployeeLogs.getAllEmployeeActionLogs();
            DefaultTableModel tableModel = (DefaultTableModel) ActionTable.getModel();

            for (EmployeeActionLog employee : employeeList) {
                Object[] rowData = {employee.getLogId(), employee.getuser_id(), employee.getActionDescription(), employee.getActionTime()};
                tableModel.addRow(rowData);
            }

            ActionTable.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        background = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ActionTable = new javax.swing.JTable();
        goBackButtom = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(8, 99, 117));

        ActionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Log ID", "User ID", "Description", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
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
        ActionTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ActionTable.setShowGrid(true);
        ActionTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(ActionTable);
        if (ActionTable.getColumnModel().getColumnCount() > 0) {
            ActionTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            ActionTable.getColumnModel().getColumn(0).setMaxWidth(60);
            ActionTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            ActionTable.getColumnModel().getColumn(1).setMaxWidth(50);
            ActionTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            ActionTable.getColumnModel().getColumn(3).setMaxWidth(150);
        }
        ActionTable.setAutoCreateRowSorter(true);

        goBackButtom.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        goBackButtom.setText("Go back");
        goBackButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtomActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(247, 236, 89));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Action Logs");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap(570, Short.MAX_VALUE)
                .addComponent(goBackButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(504, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addGap(158, 158, 158)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                .addComponent(goBackButtom)
                .addGap(30, 30, 30))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /** Disposes current frame and creates a new AdminHome then sets it to visible*/
    private void goBackButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtomActionPerformed
        // TODO add your handling code here:
        dispose();
        new AdminHome().setVisible(true);
    }//GEN-LAST:event_goBackButtomActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActionLogs().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ActionTable;
    private javax.swing.JPanel background;
    private javax.swing.JButton goBackButtom;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
