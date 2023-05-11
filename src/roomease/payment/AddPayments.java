package roomease.payment;

import roomease.complaints.*;
import roomease.homepage.EmployeeHome;
import database.EmployeeLogs;
import database.Payments;
import database.RentalDAO;
import database.RoomDAO;
import util.Session;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Complaint;
import util.EmployeeActionLog;
import util.Payment;
import util.Rental;
import util.WindowCloseHandler;

/**The AddPayments class represents a JFrame that displays fields and buttons for adding payments*/
public class AddPayments extends javax.swing.JFrame {
    /**Creates a Rental List for class*/
    List<Rental> rentalList;

    public AddPayments() {
        System.out.println("Add Payments");
        initComponents();
        /**Fills the table with data from the database*/
        try {
            rentalList = RentalDAO.getUnPainRentals();
            DefaultTableModel tableModel = (DefaultTableModel) rentalsTable.getModel();
            for (Rental rental : rentalList) {
                Object[] rowData = { rental.getRental_id() ,rental.getTenant_id(), RoomDAO.getRoomByID(rental.getRoom_id()).getRoomNumber(), rental.getCheck_in_date(), rental.getCheck_out_date(), rental.getTotal_amount()};
                tableModel.addRow(rowData);
            }
            rentalsTable.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(Complaint.class.getName()).log(Level.SEVERE, null, ex);

        }

        setResizable(false);
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
        add = new javax.swing.JButton();
        goBackButtom = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        rentalsTable = new javax.swing.JTable();
        amountField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(8, 99, 117));

        add.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        goBackButtom.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        goBackButtom.setText("Go back");
        goBackButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtomActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(247, 236, 89));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Payment Description");

        jScrollPane4.setViewportView(descriptionField);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(247, 236, 89));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Amount");

        rentalsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rental ID", "Tenant ID", "Room", "Check in", "Check out", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(rentalsTable);
        rentalsTable.setAutoCreateRowSorter(true);

        amountField.setForeground(new java.awt.Color(8, 99, 117));
        amountField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        amountField.setText("0.00");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(goBackButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(657, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addContainerGap(80, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(add))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(goBackButtom)
                    .addContainerGap(379, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
  /**Disposes current frame and creates a PaymentPage then sets it it visible*/
    private void goBackButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtomActionPerformed
        // TODO add your handling code here:
        dispose();
        new PaymentPage().setVisible(true);
    }//GEN-LAST:event_goBackButtomActionPerformed

    /**
     *
     * Adds a payment to the database for a selected rental. Validates the input
     * fields, checks if the amount entered is greater than or equal to the
     * amount due, and prompts the user for confirmation before adding the
     * payment. Adjusts the amount due for the rental and adds an entry to the
     * employee logs. Allows the user to add another payment or go back to the
     * employee page.
     *
     * @param evt the action event triggered by clicking the "Add" button
     */

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        int selectedRow = rentalsTable.getSelectedRow();
        if (selectedRow != -1) {

            // Check if the fields are empty
            if (descriptionField.getText().isEmpty() || amountField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a description.");
                return;
            }

            // Check if the amount is a number
            try {
                Double.parseDouble(amountField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                return;
            }

            // Rental ID
            int rentalID = (int) rentalsTable.getValueAt(selectedRow, 0);
            System.out.println(rentalID);


            // Get Rental Amount from the table
            double amountDue = (double) rentalsTable.getValueAt(selectedRow, 5);
            System.out.println(amountDue);
            

            if (Double.parseDouble(amountField.getText()) >= amountDue) { 
                
                if (Double.parseDouble(amountField.getText()) > amountDue) {
                    JOptionPane.showMessageDialog(null, "The amount entered is greater than the amount due.");
                    return;
                }

                if (Double.parseDouble(amountField.getText()) == amountDue) {
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, "The amount entered is equal to the amount due. Do you want to continue?", "Warning", dialogButton);
                    if (dialogResult == 1) {
                        return;
                    }
                }

            }

            try {
                // Create Payment
                Payment payment = new Payment( rentalID, Session.getCurrentUserId(), Double.parseDouble(amountField.getText()), descriptionField.getText());
                Payments.addPayment(payment);
                JOptionPane.showMessageDialog(this, "Payment added successfully!");

                // Adjust amount due
                RentalDAO.payRental(rentalID, Double.parseDouble(amountField.getText()));

                // Add to employee logs
                String description = "Added Payment for rental: " + rentalID + " and adjusted the amount due for rental: " + rentalID + " Due Amount: " + amountDue + " Payment Amount" + amountField.getText() + ".";
                EmployeeActionLog employeeActionLog = new EmployeeActionLog(Session.getCurrentUserId(), description);
                EmployeeLogs.createEmployeeActionLog(employeeActionLog);

                // Ask if the user wants to add another payment or go back to the Employee Page
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(this, "Do you want to add another payment?", "Warning", dialogButton);
                if (dialogResult == 0) {
                    dispose();
                    new AddPayments().setVisible(true);
                } else {
                    dispose();
                    new EmployeeHome().setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ComplaintsPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a rental.");
        }

    }//GEN-LAST:event_addActionPerformed

    private void refreshTable() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPayments().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JFormattedTextField amountField;
    private javax.swing.JPanel background;
    private javax.swing.JTextPane descriptionField;
    private javax.swing.JButton goBackButtom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable rentalsTable;
    // End of variables declaration//GEN-END:variables
}
