/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package roomease.homepage;

import roomease.rents.TenantsPage;
import roomease.rents.RoomCheck;
import roomease.expenses.ExpensesPage;
import roomease.complaints.ComplaintsPage;
import enums.LogType;
import java.time.LocalDateTime;

import database.EmployeeLogs;
import database.RentalDAO;
import database.RoomDAO;
import database.TenantDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import roomease.LoginPage;
import user.Session;
import util.EmployeeLoginLogs;
import util.Rental;
import util.Tenant;

/**
 *
 * @author Predator
 */
public class EmployeeHome extends javax.swing.JFrame {
    List <Rental> rentalsList;
    /**
     * Creates new form EmployeeHome
     */
    public EmployeeHome() {
        initComponents();
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
        try {
            List <Rental> rentals = RentalDAO.getActiveRentals();
            for (Rental rental : rentals) {
                tenant = TenantDAO.getTenantById(rental.getTenant_id());
                Object[] rowData = {tenant.getId(), tenant.getFirstName(), tenant.getLastName(), tenant.getPhoneNumber(), tenant.getEmail()};
                model.addRow(rowData);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TenantsPage.class.getName()).log(Level.SEVERE, null, ex);
        }
   
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
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        complaints = new javax.swing.JButton();
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
        bookingsButton.setText("Renting");
        bookingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingsButtonActionPerformed(evt);
            }
        });

        expensesButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        expensesButton.setText("Expenses");
        expensesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expensesButtonActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(102, 102, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(247, 236, 89));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ROOMEASE");

        complaints.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        complaints.setText("Complaints");
        complaints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complaintsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(expensesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(bookingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(complaints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(bookingsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(expensesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(complaints)
                .addGap(98, 98, 98)
                .addComponent(jButton3)
                .addContainerGap(54, Short.MAX_VALUE))
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
        // Add a mouse listener to the table header to handle sorting
        tenantsTable.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = rentalsTable.columnAtPoint(e.getPoint());
                sortData(tenantsTable, column);
            }
        });

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 50, 308, 250));

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
            rentalsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            rentalsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        }
        // Add a mouse listener to the table header to handle sorting
        rentalsTable.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = rentalsTable.columnAtPoint(e.getPoint());
                sortData(rentalsTable, column);
            }
        });

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            //create a new employee login log
            EmployeeLoginLogs log = new EmployeeLoginLogs(0, Session.getCurrentUser().getUserID(), LogType.LOGOUT, LocalDateTime.now());
            //add the log to the database
            EmployeeLogs.createEmployeeLoginLog(log);
            Session.logout();

            dispose();
            new LoginPage().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void expensesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expensesButtonActionPerformed
        dispose();
        new ExpensesPage().setVisible(true);
    }//GEN-LAST:event_expensesButtonActionPerformed

    private void bookingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingsButtonActionPerformed
        try {
            dispose();
            new RoomCheck().setVisible(true);
            //new BookingPage().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bookingsButtonActionPerformed

    private void complaintsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complaintsActionPerformed

        new ComplaintsPage().setVisible(true);
        dispose();
        
        //new BookingPage().setVisible(true);
        
    }//GEN-LAST:event_complaintsActionPerformed
    
    
    
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
    private javax.swing.JButton bookingsButton;
    private javax.swing.JButton complaints;
    private javax.swing.JButton expensesButton;
    private javax.swing.JButton jButton3;
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
    
    
    private void sortData(JTable table, int column) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] rowData = new Object[model.getColumnCount()];

        // Get the current data from the table
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                rowData[j] = model.getValueAt(i, j);
            }
            data.add(rowData.clone());
        }

        // Sort the data based on the selected column
        Collections.sort(data, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                Object obj1 = o1[column];
                Object obj2 = o2[column];
                if (obj1 == null && obj2 == null) {
                    return 0;
                }
                if (obj1 == null) {
                    return -1;
                }
                if (obj2 == null) {
                    return 1;
                }
                if (obj1 instanceof Comparable) {
                    return ((Comparable) obj1).compareTo(obj2);
                } else {
                    return obj1.toString().compareTo(obj2.toString());
                }
            }
        });

        // Clear the table
        model.setRowCount(0);

        // Add the sorted data back to the table
        for (Object[] row : data) {
            model.addRow(row);
        }
    }
   


}
