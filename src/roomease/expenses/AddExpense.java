package roomease.expenses;

import database.EmployeeLogs;
import database.ExpenseDAO;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import util.EmployeeActionLog;
import util.Expense;
import util.WindowCloseHandler;
import java.sql.SQLException;
import user.Session;

/**
 * The AddExpense class represents a JFrame window for adding expenses.
 */
public class AddExpense extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public AddExpense() {
        System.out.println("AddExpense");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        amountField = new javax.swing.JFormattedTextField();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        descriptionLabel = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(8, 99, 117));

        amountLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        amountLabel.setForeground(new java.awt.Color(247, 236, 89));
        amountLabel.setText("Amount:");

        jScrollPane1.setForeground(new java.awt.Color(8, 99, 117));

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane1.setViewportView(descriptionField);

        backButton.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(8, 99, 117));
        backButton.setText("Go back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        amountField.setForeground(new java.awt.Color(8, 99, 117));
        amountField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        amountField.setText("0.00");
        amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFieldActionPerformed(evt);
            }
        });

        jDateChooser.setForeground(new java.awt.Color(8, 99, 117));
        jDateChooser.setDate(new Date());

        descriptionLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(247, 236, 89));
        descriptionLabel.setText("Description:");

        submit.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        submit.setForeground(new java.awt.Color(8, 99, 117));
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        dateLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(247, 236, 89));
        dateLabel.setText("Date:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backButton)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(dateLabel)
                                .addComponent(amountLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(descriptionLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(submit)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(24, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(backButton)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(amountLabel)
                                .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(dateLabel))
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionLabel)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(submit)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    /**
     *
     * This method is called when the "Submit" button is clicked on the Add
     * Expense page. It retrieves the values from the input fields and creates a
     * new Expense object with the provided information. It then adds the new
     * Expense to the database and logs the action. If any of the fields are
     * empty or invalid, an error message is displayed.
     *
     * @param evt the action event that triggered this method
     */
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
      
        float amount = Float.parseFloat( amountField.getText());
        String description = descriptionField.getText();
       
        Date selectedDate = jDateChooser.getDate();
        Instant instant = selectedDate.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zone).toLocalDate();


        //Check if the fields are empty and validate the input

        if(amountField.getText().isEmpty() || descriptionField.getText().isEmpty() || jDateChooser.getDate() == null ){
            JOptionPane.showMessageDialog(this, "Please fill in all the fields!");
            return;
        }

        if(amount <= 0){
            JOptionPane.showMessageDialog(this, "Please enter a valid amount!");
            return;
        }


        Expense newExpense = new Expense(Session.currentUser.getUserID(), amount, description, localDate);
        System.out.println(newExpense.getAmount()+" "+ newExpense.getDate()+" "+ newExpense.getDescription());
        try {
            ExpenseDAO.addExpense(newExpense);
            JOptionPane.showMessageDialog(this, "Expense added successfully!");

            EmployeeActionLog log = new EmployeeActionLog(Session.currentUser.getUserID(), "Added an expense");
            EmployeeLogs.createEmployeeActionLog(log);

            dispose();
            new ExpensesPage().setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error adding Expense: " + ex.getMessage());
        }
    }//GEN-LAST:event_submitActionPerformed
/**Disposes current frame and creates new ExpensesPage then sets it to visible */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new ExpensesPage().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddExpense().setVisible(true);
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
