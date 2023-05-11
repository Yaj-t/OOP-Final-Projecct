 package roomease.homepage;

import roomease.rents.RoomCheck;
import roomease.expenses.ExpensesPage;
import roomease.payment.PaymentPage;
import roomease.complaints.ComplaintsPage;
import enums.LogType;
import java.time.LocalDateTime;
import database.EmployeeLogs;
import database.RentalDAO;
import database.RoomDAO;
import database.TenantDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import roomease.LoginPage;
import util.Session;
import util.EmployeeLoginLogs;
import util.Rental;
import util.Tenant;
import util.WindowCloseHandler;

 /**
 * The EmployeeHome class represents a JFrame window that displays the homepage
 * of the Employees
 */
public class EmployeeHome extends javax.swing.JFrame {
    List <Rental> rentalsList;
    /**
     * Creates new form EmployeeHome
     */
    public EmployeeHome() {
        System.out.println("EmployeeHome");
        initComponents();
        /**Fills the table with data from the database*/
        try {
            rentalsList = RentalDAO.getActiveRentals();
            System.out.println("here");
            tableModel = (DefaultTableModel) rentalsTable.getModel();
            
            for (Rental rental : rentalsList) {
                Object[] rowData = {rental.getTenant_id(), RoomDAO.getRoomByID(rental.getRoom_id()).getRoomNumber(), rental.getCheck_in_date(), rental.getCheck_out_date(), rental.getTotal_amount()};
                tableModel.addRow(rowData);
            }
//            rentalsTable.setModel(tableModel);
            rentalsTable.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(Rental.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultTableModel model = (DefaultTableModel) tenantsTable.getModel();
        model.setRowCount(0);
        Tenant tenant;
        
        /**Fills the table with data from the database*/
        try {
            List <Rental> rentals = RentalDAO.getActiveRentals();
            for (Rental rental : rentals) {
                tenant = TenantDAO.getTenantById(rental.getTenant_id());
                Object[] rowData = {tenant.getId(), tenant.getFirstName(), tenant.getLastName(), tenant.getPhoneNumber(), tenant.getEmail()};
                model.addRow(rowData);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeHome.class.getName()).log(Level.SEVERE, null, ex);
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

        sidePanel = new javax.swing.JPanel();
        bookingsButton = new javax.swing.JButton();
        expensesButton = new javax.swing.JButton();
        LogOutButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        complaints = new javax.swing.JButton();
        PaymentBut = new javax.swing.JButton();
        RentalEdit = new javax.swing.JButton();
        TenantButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tenantsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rentalsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidePanel.setBackground(new java.awt.Color(142, 74, 73));

        bookingsButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bookingsButton.setText("New Rental");
        bookingsButton.setFocusPainted(false);
        bookingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingsButtonActionPerformed(evt);
            }
        });

        expensesButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        expensesButton.setText("Expenses");
        expensesButton.setFocusPainted(false);
        expensesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expensesButtonActionPerformed(evt);
            }
        });

        LogOutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LogOutButton.setText("Logout");
        LogOutButton.setFocusPainted(false);
        LogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutAction(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(102, 102, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(247, 236, 89));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ROOMEASE");

        complaints.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        complaints.setText("Complaints");
        complaints.setFocusPainted(false);
        complaints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complaintsActionPerformed(evt);
            }
        });

        PaymentBut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PaymentBut.setText("Payments");
        PaymentBut.setFocusPainted(false);
        PaymentBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentPerform(evt);
            }
        });

        RentalEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RentalEdit.setText("Rental Edit");
        RentalEdit.setFocusPainted(false);
        RentalEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RentalPage(evt);
            }
        });

        TenantButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TenantButton.setText("Tenant Edit");
        TenantButton.setFocusPainted(false);
        TenantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenantPage(evt);
            }
        });

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(complaints, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(LogOutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(expensesButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bookingsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PaymentBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(RentalEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TenantButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(bookingsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expensesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(complaints)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PaymentBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RentalEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TenantButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogOutButton)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(8, 99, 117));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(247, 236, 89));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Rentals");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 305, 33));

        tenantsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First name", "Last name", "Phone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tenantsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tenantsTable.setShowGrid(true);
        tenantsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tenantsTable);
        if (tenantsTable.getColumnModel().getColumnCount() > 0) {
            tenantsTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        }
        tenantsTable.setAutoCreateRowSorter(true);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 308, 250));

        jLabel1.setBackground(new java.awt.Color(8, 99, 117));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(247, 236, 89));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tenants");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 13, 308, 33));

        rentalsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tenant ID", "Room", "Check in", "Check out", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
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
        jScrollPane1.setViewportView(rentalsTable);
        if (rentalsTable.getColumnModel().getColumnCount() > 0) {
            rentalsTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            rentalsTable.getColumnModel().getColumn(0).setMaxWidth(70);
            rentalsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            rentalsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        }
        rentalsTable.setAutoCreateRowSorter(true);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 49, 308, 253));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/** Represent the Logout button when clicked will insert an employee log into the database. 
 * It disposes the current frame and creates a new LoginPage
 * @param evt 
 */
    private void LogOutAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutAction

        try {
            //create a new employee login log
            EmployeeLoginLogs log = new EmployeeLoginLogs(0, Session.getCurrentUserId(), LogType.LOGOUT, LocalDateTime.now());
            //add the log to the database
            EmployeeLogs.createEmployeeLoginLog(log);
            Session.logout();

            dispose();
            new LoginPage().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LogOutAction
  /**Disposes the current frame and creates a new ExpensesPage then sets it to visible*/
    private void expensesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expensesButtonActionPerformed
        dispose();
        new ExpensesPage().setVisible(true);
    }//GEN-LAST:event_expensesButtonActionPerformed
  /**Disposes the current frame and creates a new RoomCheck  then sets it to visible*/
    private void bookingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingsButtonActionPerformed
        try {
            dispose();
            new RoomCheck().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bookingsButtonActionPerformed
  /**Disposes the current frame and creates a new ComplaintsPage then sets it to visible*/
    private void complaintsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complaintsActionPerformed

        new ComplaintsPage().setVisible(true);
        dispose();
                
    }//GEN-LAST:event_complaintsActionPerformed
  /**Disposes the current frame and creates a new PaymentPage then sets it to visible*/
    private void PaymentPerform(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentPerform
        
        dispose();
        new PaymentPage().setVisible(true);
    }//GEN-LAST:event_PaymentPerform

    private void RentalPage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RentalPage
        
        dispose();
        new RentalsPage().setVisible(true);
        

    }//GEN-LAST:event_RentalPage

    private void TenantPage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenantPage
        // TODO add your handling code here:
    }//GEN-LAST:event_TenantPage
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeHome().setVisible(true);
            }
        });
    }
    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogOutButton;
    private javax.swing.JButton PaymentBut;
    private javax.swing.JButton RentalEdit;
    private javax.swing.JButton TenantButton;
    private javax.swing.JButton bookingsButton;
    private javax.swing.JButton complaints;
    private javax.swing.JButton expensesButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable rentalsTable;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JTable tenantsTable;
    // End of variables declaration//GEN-END:variables

}
