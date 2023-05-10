/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package roomease.expenses;

import roomease.expenses.EditExpense;
import roomease.expenses.AddExpense;
import database.EmployeeLogs;
import database.ExpenseDAO;
import database.UserDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import roomease.homepage.EmployeeHome;
import user.Session;
import util.EmployeeActionLog;
import util.Expense;
import util.WindowCloseHandler;

/**
 *
 * @author Predator
 */
public class ExpensesPage extends javax.swing.JFrame {
    List <Expense>  expenseList;
    /**
     * Creates new form Rooms
     */
    
    public ExpensesPage() {
        System.out.println("ExpensesPage");
        initComponents();
        try {
            
            expenseList = ExpenseDAO.getAllExpenses();
            DefaultTableModel tableModel = (DefaultTableModel) expensesTable.getModel();
            for (Expense expense : expenseList) {
                Object[] rowData = {expense.getId(), expense.getAmount(), expense.getDate().toString(), expense.getDescription(), UserDAO.getUserByID(expense.getUser_id()).getName()};
                tableModel.addRow(rowData);
            }
            expensesTable.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(Expense.class.getName()).log(Level.SEVERE, null, ex);
        }

        WindowCloseHandler.addWindowClosingListener(this);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        expensesTable = new javax.swing.JTable();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        goBackButtom = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(8, 99, 117));

        expensesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Amount", "Date", "Description", "User"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        expensesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        expensesTable.setShowGrid(true);
        expensesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(expensesTable);

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

        goBackButtom.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        goBackButtom.setText("Go back");
        goBackButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtomActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(goBackButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(576, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(add)
                        .addGap(17, 17, 17)
                        .addComponent(edit)
                        .addGap(17, 17, 17)
                        .addComponent(delete))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(goBackButtom)
                    .addContainerGap(370, Short.MAX_VALUE)))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int row = expensesTable.getSelectedRow(); // get the selected row
        if (row != -1) { // check if a row is selected
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Expense?",
                "Confirm Deletion", JOptionPane.YES_NO_OPTION); // confirm deletion with user

            if (option == JOptionPane.YES_OPTION) { // user confirms deletion
                int expenseID =(int) expensesTable.getValueAt(row, 0); // get the username from the table
                try {
                        EmployeeActionLog employeeActionLog = new EmployeeActionLog(Session.getCurrentUserId(), "Deleted expense with ID: " + expenseID);
                        EmployeeLogs.createEmployeeActionLog(employeeActionLog);

                        ExpenseDAO.deleteExpense(expenseID);
                        dispose();
                        new ExpensesPage().setVisible(true);
                        JOptionPane.showMessageDialog(null, "Expense deleted successfully.");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error deleting expense: " + ex.getMessage());
                    }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        //TODO add your handling code here:
        dispose();
        new AddExpense().setVisible(true);
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int selectedRow = expensesTable.getSelectedRow();
        if(selectedRow !=-1){
            try {
                // TODO add your handling code here:

                int roomID = (int) expensesTable.getValueAt(selectedRow, 0);
                Expense expense = ExpenseDAO.getExpenseById(roomID);
                new EditExpense(expense).setVisible(true);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ExpensesPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row to be edited.");
        }
    }//GEN-LAST:event_editActionPerformed

    private void goBackButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtomActionPerformed
        // TODO add your handling code here:
        dispose();
       new EmployeeHome().setVisible(true);
    }//GEN-LAST:event_goBackButtomActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpensesPage().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTable expensesTable;
    private javax.swing.JButton goBackButtom;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
