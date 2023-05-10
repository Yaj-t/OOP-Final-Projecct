/**
 * The EditExpense class represents a JFrame window for Editing expenses.
 */
package roomease.expenses;

import database.EmployeeLogs;
import database.ExpenseDAO;
import user.Session;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import util.Expense;
import util.WindowCloseHandler;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.EmployeeActionLog;

public class EditExpense extends javax.swing.JFrame {
    /** creates an Expense field for the Class*/
    private Expense expense;

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
    /**
     * Creates new form NewJFrame
     */
    public EditExpense() {
        System.out.println("EditExpense");
        initComponents();
        WindowCloseHandler.addWindowClosingListener(this);
    }

    public EditExpense(Expense expense) {
        System.out.println("EditExpense");
        this.expense = expense;
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
        amountLabel = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        descriptionLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(8, 99, 117));

        amountLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        amountLabel.setForeground(new java.awt.Color(247, 236, 89));
        amountLabel.setText("Amount:");

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

        jDateChooser.setDate(Date.from(expense.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        descriptionLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(247, 236, 89));
        descriptionLabel.setText("Description:");

        dateLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(247, 236, 89));
        dateLabel.setText("Date:");

        amountField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        descriptionField.setText(expense.getDescription());
        jScrollPane1.setViewportView(descriptionField);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backButton)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(dateLabel)
                                .addComponent(amountLabel)
                                .addComponent(descriptionLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(submit)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(32, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(backButton)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(amountLabel)
                                .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(dateLabel))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(94, 94, 94)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionLabel)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(submit)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        amountField.setValue(expense.getAmount());

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

    /**

This method is called when the "submit" button is clicked. It updates the complaint with the new status, description, and date.

If the update is successful, a message is displayed indicating that the complaint was updated successfully, an employee action log is created, and the current window is closed and a new ComplaintsPage window is opened.

If there is an error with updating the complaint, an error message is displayed.

@param evt the ActionEvent object representing the "submit" button being clicked
*/
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        Date selectedDate = jDateChooser.getDate();


        //Check if all fields are filled and valid
        if (amountField.getText().isEmpty() || descriptionField.getText().isEmpty() || selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        if (Float.parseFloat(amountField.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount!");
            return;
        }

        //Update expense

        expense.setAmount( Float.parseFloat( amountField.getText()));
        expense.setDescription(descriptionField.getText());
        Instant instant = selectedDate.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zone).toLocalDate();
        expense.setDate(localDate);
        System.out.println(expense.getAmount()+" "+ expense.getDate()+" "+ expense.getDescription());
        try {
            EmployeeActionLog log = new EmployeeActionLog(Session.getCurrentUserId(), "Updated Expense with ID: " + expense.getId());
            EmployeeLogs.createEmployeeActionLog(log);

            ExpenseDAO.updateExpense(expense);
            JOptionPane.showMessageDialog(this, "Expense Updated successfully!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Updating Expense: " + ex.getMessage());
        }
    }//GEN-LAST:event_submitActionPerformed

    /**Disposes current page and creates a new ExpensesPage then sets it to visisble*/
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new ExpensesPage().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EditExpense(ExpenseDAO.getExpenseById(1)).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(EditExpense.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField amountField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JLabel descriptionLabel;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
